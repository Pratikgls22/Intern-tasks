package org.example.partition_springbatch.config;

import lombok.AllArgsConstructor;
import org.example.partition_springbatch.entity.Customer;
import org.example.partition_springbatch.partition.ColumnRangePartitioner;
import org.example.partition_springbatch.repositry.CustomerRepo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
//import org.springframework.batch.item.data.RepositoryItemWriter;
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
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

//    private CustomerRepo customerRepo;
    private StepBuilderFactory stepBuilderFactory;
    private JobBuilderFactory jobBuilderFactory;
    private final CustomerWriter customerWriter;

    // create Reader
    @Bean
    public FlatFileItemReader<Customer> customerReader(){
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("/home/dev1071/Downloads/customers.xlsx"));
        itemReader.setName("csv-reader");
        itemReader.setLinesToSkip(1);                                  // skin first row in csv file
        itemReader.setLineMapper(lineMapper());                       //csv data convert into java object
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

    // partition class
    @Bean
    public ColumnRangePartitioner partitioner(){
        return new ColumnRangePartitioner();
    }

    //create partition
    @Bean
    public PartitionHandler partitionHandler(){
        TaskExecutorPartitionHandler taskExecutorPartitionHandler = new TaskExecutorPartitionHandler();
        taskExecutorPartitionHandler.setGridSize(4);
        taskExecutorPartitionHandler.setTaskExecutor(taskExecutor());
        taskExecutorPartitionHandler.setStep(slaveStep());
        return taskExecutorPartitionHandler;
    }

//    //create writer
//    @Bean
//    public RepositoryItemWriter<Customer> customerWriter(){
//        RepositoryItemWriter<Customer> repositoryItemWriter = new RepositoryItemWriter<>();
//        repositoryItemWriter.setRepository(customerRepo);
//        repositoryItemWriter.setMethodName("save");
//        return repositoryItemWriter;
//    }

    //create slaveStep
    @Bean
    public Step slaveStep() {
        return stepBuilderFactory.get("slaveStep")
                .<Customer,Customer>chunk(250)
                .reader(customerReader())
                .processor(customerProcessor())
                .writer(customerWriter)
                .build();
    }

    //create masterStep
    @Bean
    public Step masterStep() {
        return stepBuilderFactory.get("masterStep")
                .partitioner(slaveStep().getName(),partitioner())
                .partitionHandler(partitionHandler())
                .build();
    }

    //create job
    @Bean
    public Job job(){
        return jobBuilderFactory.get("customers-import")
                .flow(masterStep())
                .end()
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(4);
        taskExecutor.setCorePoolSize(4);
        taskExecutor.setQueueCapacity(4);
        return taskExecutor;
    }

}
