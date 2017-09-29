package com.designpattern.decorator;

import java.io.*;

/**
 * Created by casimiryang on 2015/7/13.
 */
public class DecoratorTest {

    public static void main(String[] args){
       IConponent conponent =  new Decorator_3(new Decorator_2(new Decorator_1(new ConcreteConponent())));
        conponent.fun();

        //IO 流中装饰模式  组合了缓冲和文件输入的两个功能
      //  BufferedInputStream b = new BufferedInputStream(new FileInputStream(new File("test.txt")));
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(new File("a.test")));
            Writer writer2 =new BufferedWriter(new FileWriter(new File("a.ext")));
           Writer writer3 =new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(new File("a.test"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
