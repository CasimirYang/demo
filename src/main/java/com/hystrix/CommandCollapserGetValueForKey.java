package com.hystrix;

import com.netflix.hystrix.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Lenovo on 2017/9/12.
 */
public class CommandCollapserGetValueForKey extends HystrixCollapser<List<String>, String, Integer> {

    private final Integer key;

    public CommandCollapserGetValueForKey(Integer key) {
        this.key = key;
    }

    @Override
    public Integer getRequestArgument() {
        return key;
    }

    @Override
    protected HystrixCommand<List<String>> createCommand(final Collection<CollapsedRequest<String, Integer>> requests) {
        System.out.println("create command");
        return new BatchCommand(requests);
    }

    @Override
    protected void mapResponseToRequests(List<String> batchResponse, Collection<CollapsedRequest<String, Integer>> requests) {
        int count = 0;
        for (CollapsedRequest<String, Integer> request : requests) {
            request.setResponse(batchResponse.get(count++));
        }
    }

    private static final class BatchCommand extends HystrixCommand<List<String>> {

        private final Collection<CollapsedRequest<String, Integer>> requests;

        private BatchCommand(Collection<CollapsedRequest<String, Integer>> requests) {
            super(setter());
            this.requests = requests;
        }

        private static Setter setter() {
            //服务组id，命令id（默认类名），线程id（默认组名）
            HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("ExampleGroup");
            HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("getStock");
            HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("stockPool");

            //服务的设置
            HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.defaultSetter().
                    withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);

            //服务线程池的设置
            HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.defaultSetter().withCoreSize(2);

            return Setter.withGroupKey(groupKey)
                    .andCommandKey(commandKey)
                    .andThreadPoolKey(threadPoolKey)
                    .andThreadPoolPropertiesDefaults(threadPoolProperties)
                    .andCommandPropertiesDefaults(commandProperties);
        }

        @Override
        protected List<String> run() {
            System.out.println("run--");
            ArrayList<String> response = new ArrayList<>();
            for (CollapsedRequest<String, Integer> request : requests) {
                // artificial response for each argument received in the batch
                response.add("ValueForKey: " + request.getArgument());
            }
            return response;
        }
    }
}