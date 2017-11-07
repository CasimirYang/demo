package com.hystrix;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Lenovo on 2017/9/12.
 */
public class CommandCollapserGetValueForKey extends HystrixCollapser<List<String>, String, Integer> {


    private final Integer key;

    private static Setter setter(){
        //默认key null, 延时10ms，数量 Integer.MAX_VALUE
        return HystrixCollapser.Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("private"))
                .andCollapserPropertiesDefaults(
                        HystrixCollapserProperties.Setter()
                                .withMaxRequestsInBatch(2).withMetricsRollingStatisticalWindowInMilliseconds(20)
                );
    }

    public CommandCollapserGetValueForKey(Integer key) {
        super(setter());
        this.key = key;
    }

    @Override
    public Integer getRequestArgument() {
        return key;
    }

    @Override
    protected HystrixCommand<List<String>> createCommand(final Collection<CollapsedRequest<String, Integer>> requests) {
        System.out.println("create command"+requests.size());
        return new BatchCommand(requests);
    }

    @Override
    protected void mapResponseToRequests(List<String> batchResponse, Collection<CollapsedRequest<String, Integer>> requests) {
        int count = 0;
        for (CollapsedRequest<String, Integer> request : requests) {
            request.setResponse(batchResponse.get(count++));
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext.initializeContext();
        CommandCollapserGetValueForKey k1 = new CommandCollapserGetValueForKey(1);
        CommandCollapserGetValueForKey k2 = new CommandCollapserGetValueForKey(2);
        CommandCollapserGetValueForKey k3 = new CommandCollapserGetValueForKey(3);
        Future<String> future = k1.queue();
        System.out.println("before k2 call");
        Thread.sleep(2000L);
        System.out.println("----sleep------");
        Future<String> future2 = k2.queue();
        Thread.sleep(2000L);
        System.out.println("----sleep------");
        Future<String> future3 = k3.queue();
        Thread.sleep(2000L);
        System.out.println("----sleep------");
        future.get();
        future2.get();
        future3.get();
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
                System.out.println("ValueForKey: " + request.getArgument());
                // artificial response for each argument received in the batch
                response.add("ValueForKey: " + request.getArgument());
            }
            return response;
        }
    }
}