package com.oleksiy.runner;

import com.oleksiy.annotation.MyLoggingAnnotation;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
    @Override
  //  @MyLoggingAnnotation
    public void run(ApplicationArguments args) throws Exception {
        printSomething("Hello 123!");
    }

    @MyLoggingAnnotation
    private void printSomething(String s) {
        System.out.println(s);
    }
}
