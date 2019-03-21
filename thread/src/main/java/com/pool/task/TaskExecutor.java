
package com.pool.task;



import pojo.DateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池+定时器封装
 * 
 * @author kome.Jiangmy
 * @version 1.0
 * @date 2012-9-28 下午1:43:06
 */
public class TaskExecutor {
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(TaskExecutor::shutdown));
	}
	/**
	 * 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。
	 */
	public static final ThreadPoolExecutor cachedPool = new ThreadPoolExecutor(50, 1000, 60, TimeUnit.SECONDS,
			new LinkedBlockingQueue<>(), new ThreadFactory() {
				private AtomicInteger counter = new AtomicInteger();
				
				@Override
				public Thread newThread(Runnable paramRunnable) {
					Thread t = new Thread(paramRunnable);
					t.setDaemon(true);
					return t;
				}
			});
	/**
	 * 定时任务
	 */
	private static final ScheduledThreadPoolExecutor scheduledPool = (ScheduledThreadPoolExecutor) Executors
			.newScheduledThreadPool(1000);
	
	private static Runnable taskToRunnable(final Task task, final ExecutorService cachedPool) {
		return () -> {
			try {
				if (cachedPool.isShutdown() || cachedPool.isTerminated()) {
					return;
				}
				task.execute();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
	
	/**
	 * 执行一次
	 * 
	 * @param task
	 */
	public static Future<?> addTask(final Task task) {
		Runnable runnable = taskToRunnable(task, cachedPool);
		return cachedPool.submit(runnable);
	}
	
	public static Future<?> addTask(final Task task, final long repeatIntervalTimeMillis) {
		return addTask(task, TimeUnit.MILLISECONDS, repeatIntervalTimeMillis);
	}
	
	public static Future<?> addTask(final Task task, TimeUnit timeUnit, final long timeValue) {
		Runnable runnable = taskToRunnable(task, scheduledPool);
		return scheduledPool.scheduleAtFixedRate(runnable, 0, timeValue, timeUnit);
	}
	
	public static boolean cancelTask(Future<?> future, boolean mayInterruptIfRunning) {
		return future.cancel(mayInterruptIfRunning);
	}
	
	/**
	 * 定时执行
	 * 
	 * @param task
	 * @param executeTime
	 */
	public static ScheduledFuture<?> addTask(final Task task, Date executeTime) {
		if (executeTime == null || executeTime.before(new Date())) {
			throw new IllegalArgumentException();
		}
		Runnable runnable = taskToRunnable(task, scheduledPool);
		long delay = executeTime.getTime() - System.currentTimeMillis();
		return scheduledPool.schedule(runnable, delay, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * 定时执行
	 * 
	 * @param task
	 * @param firstTime 第一次执行的时间
	 * @param repeatIntervalTimeMillis 重复执行的间隔时间
	 */
	public static void addTask(final Task task, Date firstTime, final TimeUnit timeUnit, final long timeValue) {
		if (firstTime == null) {
			throw new IllegalArgumentException();
		}
		while (firstTime.before(new Date())) {
		}
		Runnable runnable = taskToRunnable(task, scheduledPool);
		long delay = firstTime.getTime() - System.currentTimeMillis();
		scheduledPool.scheduleAtFixedRate(runnable, delay, timeUnit.toMillis(timeValue), TimeUnit.MILLISECONDS);
	}
	
	/**
	 * shutdown taskExecutor
	 */
	public static void shutdown() {
		try {
			cachedPool.shutdown();
			scheduledPool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		List<Future<?>> list = new ArrayList<Future<?>>();
		for (int i = 0; i < 3; i++) {
			Future<?> future = TaskExecutor.addTask(new Task() {
				@Override
				public void execute() throws Exception {
					System.out.println("schedule task thread:" + Thread.currentThread().getId());
				}
			}, 100);
			list.add(future);
		}
		Future<?> future2 = TaskExecutor.addTask(new Task() {
			@Override
			public void execute() throws Exception {
				while (true) {
					Thread.sleep(1000);
					System.out.println("common task thread:" + Thread.currentThread().getId());
				}
			}
		});
		list.add(future2);
		Thread.sleep(3000);
		for (Future<?> future : list) {
			System.out.println("stop ...");
			TaskExecutor.cancelTask(future, true);
		}
		TaskExecutor.addTask(() -> System.out.println("at fix time:" + new Timestamp(System.currentTimeMillis())), DateUtil.str2DateTime("2013-03-04 17:41:00"));
	}
	
}
