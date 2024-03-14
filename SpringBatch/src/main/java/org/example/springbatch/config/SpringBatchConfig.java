package org.example.springbatch.config;

import lombok.AllArgsConstructor;
import org.example.springbatch.entity.Customer;
import org.example.springbatch.repositry.CustomerRepo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

    private CustomerRepo customerRepo;
    private StepBuilderFactory stepBuilderFactory;
    private JobBuilderFactory jobBuilderFactory;

    // create Reader
    @Bean
    public FlatFileItemReader<Customer> customerReader(){
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("/home/dev1071/Downloads/customers.csv"));
        itemReader.setName("csv-reader");
        itemReader.setLinesToSkip(1);                                  // skin first row in csv file
        itemReader.setLineMapper(lineMapper());                       //csv data convert into java object
//        itemReader.setStrict(false);
        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);                               //It means if value is not present give us null !
        lineTokenizer.setNames("id","firstName","lastName","email","gender","contactNo","country","dob");        //set according csv table

        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();          //convert data into java Object
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    // create Processor

    @Bean
    public CustomerProcessor customerProcessor(){
        return new CustomerProcessor();
    }

    //create writer
    @Bean
    public RepositoryItemWriter<Customer> customerWriter(){
        RepositoryItemWriter<Customer> repositoryItemWriter = new RepositoryItemWriter<>();
        repositoryItemWriter.setRepository(customerRepo);
        repositoryItemWriter.setMethodName("save");
        return repositoryItemWriter;
    }

    //create step
    @Bean
    public Step step() {
        return stepBuilderFactory.get("step-1")
                .<Customer,Customer>chunk(10)
                .reader(customerReader())
                .processor(customerProcessor())
                .writer(customerWriter())
                .taskExecutor(taskExecutor())
                .build();
    }
//    @Bean   {if neede many of steps}
//    public Step step2() {
//        return stepBuilderFactory.get("step-1")
//                .<Customer,Customer>chunk(10)
//                .reader(customerReader())
//                .processor(customerProcessor())
//                .writer(customerWriter())
//                .build();
//    }



    //create job
    @Bean
    public Job job(){
        return jobBuilderFactory.get("customers-import")
                .flow(step())
                .end()
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(10);
        return taskExecutor;
    }

}
