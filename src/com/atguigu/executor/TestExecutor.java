package com.atguigu.executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TestExecutor {
	public static void main(String[] args) {
		//ExecutorService threadPool = Executors.newCachedThreadPool();缓存线程池，创建线程池中的线程数量不固定，会根据需求的大小进行改变
		//ExecutorService threadPool = Executors.newFixedThreadPool(5);创建固定个数的线程，线程池中线程的数量是固定的，不会改变
		//ExecutorService threadPool = Executors.newSingleThreadExecutor();单一线程池，线程池中只有一个线程
		
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        try {
        	
        	for (int i = 1; i < 10; i++) {
				
        		ScheduledFuture<Integer> schedule = scheduledThreadPool.schedule(new Callable<Integer>() {
        			
        			@Override
        			public Integer call() throws Exception {
        				System.out.print(Thread.currentThread().getName()+"-->");
        				return new Random().nextInt(50);
        			}
        		}, 1,TimeUnit.SECONDS);
        		
        		System.out.println(schedule.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			scheduledThreadPool.shutdown();
		}

	}
}
