package org.example.springbatch_sb3.config;

import lombok.AllArgsConstructor;
import org.example.springbatch_sb3.entity.Customer;
import org.example.springbatch_sb3.repositry.CustomerRepo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
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
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor
public class SpringBatchConfig {
    private CustomerRepo customerRepo;


    //created reader
    @Bean
    public FlatFileItemReader<Customer> itemReader() {
        FlatFileItemReader<Customer> customerReader = new FlatFileItemReader<>();
        customerReader.setResource(new FileSystemResource("/home/dev1071/Downloads/customers.csv"));
        customerReader.setName("Csv-Reader");
        customerReader.setLinesToSkip(1);
        customerReader.setLineMapper(lineMapper());
        return customerReader;
    }

    public LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> defaultLineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

    //created processor
    @Bean
    public CustomerProcessor itemProcessor() {
        return new CustomerProcessor();
    }

    //created writer
    @Bean
    public RepositoryItemWriter<Customer> itemWriter() {
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerRepo);
        writer.setMethodName("save");
        return writer;
    }

    //created Step
    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("step1", jobRepository)
                .<Customer, Customer>chunk(10, platformTransactionManager)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .taskExecutor(taskExecutor())
                .build();
    }

    //created Job
    @Bean
    public Job job(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new JobBuilder("importCsv", jobRepository)
                .flow(step1(jobRepository, platformTransactionManager))
                .end()
                .build();
    }

    //created TaskExecutor for time management
    private TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);                  // how many you want to sync a single time
        return asyncTaskExecutor;
    }
}
