package com.study.config;

import com.study.exceptions.MyAsyncUncaughtExceptionHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池 (java的异步，常用于<strong>多线程开发</strong>)
 * 异步线程池配置
 * @Async注解无效的可能点：
 * 1、异步方法使用static修饰
 * 2、异步类没有使用@Component注解（或其他注解）导致spring无法扫描到异步类
 * 3、测试异步方法不能与异步方法在同一个类中
 * 4、测试类中需要使用@Autowired或@Resource等注解自动注入，不能自己手动new对象
 * 5、如果使用SpringBoot框架必须在启动类中增加@EnableAsync注解
 */
@Configuration
@Log4j2
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);// 最小线程数为10(核心线程池大小)
        executor.setMaxPoolSize(100);// 最大线程数为100
        executor.setQueueCapacity(100);// 队列最大数量为100
        executor.setKeepAliveSeconds(20);// 当线程空闲20秒(活跃时间,默认情况下是60秒)时回收线程时
        executor.setThreadNamePrefix("cloudrises-async-schedule-");// 线程的前置名称
        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //如果不初始化，导致找到不到执行器
        executor.initialize();
        return executor;
    }

    /**
     * 异步任务中处理异常
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncUncaughtExceptionHandler();
    }

}