package com.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * Created by Lenovo on 2017/9/12.
 */
public class CommandUsingRequestCache extends HystrixCommand<Boolean> {

    private final int value;

    public CommandUsingRequestCache(int value) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(600)));
        this.value = value;
    }

    @Override
    public Boolean run() {
        System.out.println("run"+value);
        return value == 0 || value % 2 == 0;
    }

    @Override
    public String getCacheKey() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        HystrixRequestContext.initializeContext();
        CommandUsingRequestCache command1 = new CommandUsingRequestCache(1);
        CommandUsingRequestCache command2 = new CommandUsingRequestCache(1);

        Boolean result = command1.execute();
        System.out.println("result=" + result);

        Boolean result2 = command2.execute();
        System.out.println("result=" + result2);
    }
}