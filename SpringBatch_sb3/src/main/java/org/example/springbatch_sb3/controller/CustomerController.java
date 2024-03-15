package org.example.springbatch_sb3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final JobLauncher jobLauncher;
    private final Job job;

    @PostMapping("/get")
    public String importCsvToDb() throws Exception{
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("StartTime",System.currentTimeMillis()).toJobParameters();

        jobLauncher.run(job,jobParameters);
        return "Data Get Successfully !!";
    }
}
