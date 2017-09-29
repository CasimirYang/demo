package com.demo;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.Properties;

/**
 * jdk7 WatchService,监控某个目录下的文件变化
 * 一般是开启异步线程去监听文件的变化，还需要在jvm停止时关闭线程
 *
 *  watchThread.setDaemon(true);
    Runtime.getRuntime().addShutdownHook(new Thread(()->{
    watchService.close();
 }));
 */
public class WatchServiceDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService
                = FileSystems.getDefault().newWatchService();

        Path path = Paths.get("D:/");

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        //take 阻塞
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");

                if ("myFile.txt".endsWith(event.context().toString())) {
                    //过滤自己需要的文件
                    Properties properties = loadProperties("file:"+path+"myFile.txt");
                    System.out.println("My file has changed");
                }
            }
            key.reset();
        }
    }

    /**
     1. File system
        Resource resource = appContext.getResource("file:c:\\testing.txt");
     2. URL path
        Resource resource = appContext.getResource("url:http://www.yourdomain.com/testing.txt");
     3. Class path
        Resource resource = appContext.getResource("classpath:com/mkyong/common/testing.txt");
     */
    private static Properties loadProperties(String... resourcesPaths) {
        //jdk 根据流获取属性
        Properties props = new Properties();
        //spring 的 resourceLoader,获取流
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        for (String location : resourcesPaths) {
            InputStream is = null;
            try {
                Resource resource = resourceLoader.getResource(location);
                is = resource.getInputStream();
                props.load(is);
            } catch (IOException ex) {
                //todo
            } finally {
                IOUtils.closeQuietly(is);
            }
        }
        return props;
    }
}
