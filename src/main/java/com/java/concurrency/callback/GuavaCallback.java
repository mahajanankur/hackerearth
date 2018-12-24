/**
 * 
 */
package com.java.concurrency.callback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author ankur.mahajan
 * @written 20-Dec-2018
 */
public class GuavaCallback {

	private final Map<String, ListenableFutureTask<?>> tasks = new HashMap<String, ListenableFutureTask<?>>();

	public static void cancel(String tag) {
		//ListenableFuture<String> prev = ListenableFuture.execute();
	}

	public static ListenableFuture<String> execute() {
		String param = "a";
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
		ListenableFuture<String> response = service.submit(new Callable<String>() {
			public String call() throws Exception {
				return sampleMethod(param);
				// return null;
			}

		});

		response.cancel(true);

		Futures.addCallback(response, new FutureCallback<String>() {

			@Override
			public void onSuccess(String result) {
				System.out.println("Inside Success");
				// try {
				// sampleMethod("");
				// } catch (Exception e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }

			}

			public void onFailure(Throwable thrown) {
				if (response.isCancelled()) {
					System.out.println("Inside Failure But Canceled. " + thrown.getMessage());
				} else {

					System.out.println("Inside Failure " + thrown.getMessage());
				}
			}

		});

		service.shutdown();
		System.out.println("Out");
		return response;

	}

	private static String sampleMethod(String param) throws Exception {
		System.out.println("Inside sample Method.");
		switch (param) {
		case "a":
			System.out.println("Param A");
			break;

		default:
			System.out.println("Param Other");
			throw new Exception("Test Exception Thrown");
		}
		return "YO YO";
	}

	public static void main(String[] args) {
		GuavaCallback.execute();
	}
}
