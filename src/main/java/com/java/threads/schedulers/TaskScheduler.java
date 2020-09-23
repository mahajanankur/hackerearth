/**
 * 
 */
package com.java.threads.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ankur
 * 
 *         ScheduledExecutorService
 * 
 *         An ExecutorService that can schedule commands to run after a given
 *         delay, or to execute periodically.
 * 
 *         The schedule methods create tasks with various delays and return a
 *         task object that can be used to cancel or check execution. The
 *         scheduleAtFixedRate and scheduleWithFixedDelay methods create and
 *         execute tasks that run periodically until cancelled.
 *
 */
public class TaskScheduler implements Runnable {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

	public static void main(String[] args) {
		TaskScheduler ts = new TaskScheduler();
		ts.scheduleTask();
	}

	private void scheduleTask() {
		TaskScheduler runable = new TaskScheduler();
		int loop = 0;
		while (loop < 10) {
			scheduler.scheduleAtFixedRate(runable, 8, 8, TimeUnit.SECONDS);
			loop++;
		}
	}

	@Override
	public void run() {
		System.out.println(
				"An ExecutorService that can schedule commands to run after a given delay, or to execute periodically.");

	}

}
