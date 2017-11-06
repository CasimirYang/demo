package com.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s + " world").join();

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(()->{}); //Runnable
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->"value1"); //Supplier
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(()->"value2"); //Supplier
        String result2 = CompletableFuture
                .allOf(future1,future2)                 //CompletableFuture<?>... cfs;所有都执行完才执行下一步
                .thenAcceptAsync(System.out::println)   //Consumer   void accept(T t); 异步执行这一步
                .thenRunAsync(()->{})                   //Runnable  //异步执行这一步
                .runAfterEither(future3,()-> System.out.println("")) //Function 快的结果
                .thenApply((param)->"param"+1)          //Function   R apply(T t); 同步执行这一步
                .applyToEither(future3,(param)->param+1)//谁计算的快，我就用那个CompletionStage的结果进行下一步的转化操作
                .acceptEitherAsync(future3,(param)-> System.out.println(param))//Consumer 快的结果
                .thenCombine(future3,(param1,param2)->{
                    System.out.println(param1+param2);
                    return "bili";
                })
                .handle((s,t)->{
                    if (t != null) {  //出现异常
                        return "hello world"; //handle exception
                    }
                    return s;        //正常
                })
                .join();  //block wait complete

    }
}
