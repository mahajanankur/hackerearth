/**
 * 
 */
package com.ofbis.design;

import java.util.HashMap;
import java.util.Map;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author ankur.mahajan
 * @written 21-Dec-2018
 */
public class TestOfBiz {

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				addCallbacks(getRequest("Tag1"));
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				addCallbacks(postRequest("Tag2"));
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				addCallbacks(getRequest("Tag1"));
			}
		});

		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				OfbHttp.cancel("Tag1");
			}
		});

		t1.setName("T1");
		t2.setName("T2");
		t3.setName("T3");
		t4.setName("T4");
		t4.setPriority(7);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public static void main(String[] args) throws InterruptedException {
		addCallbacks(getRequest("Tag1"));
		addCallbacks(postRequest("Tag2"));
		addCallbacks(getRequest("Tag1"));

		Thread.sleep(5000);
		OfbHttp.cancel("Tag1");
	}

	public static void addCallbacks(OfbRequest request) {
		ListenableFuture<OfbResponse> execute = OfbHttp.execute(request);
		Futures.addCallback(execute, new FutureCallback<OfbResponse>() {
			public void onSuccess(OfbResponse ofbResponse) {
				System.out.println("Inside onSuccess: " + ofbResponse.getResponseCode());
			}

			public void onFailure(Throwable thrown) {
				if (execute.isCancelled()) {
					System.out.println("Inside Failure But Cancelled. " + thrown.getMessage());
				} else {

					System.out.println("Inside onFailure and the Error : " + thrown.getStackTrace());
					throw new RuntimeException(thrown);
				}
			}

		});
	}

	public static OfbRequest getRequest(String tag) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		headers.put("Authorization", "Y2hhbmNoYWwuc3RlbGxlbmluZm90ZWNoQGdtYWlsLmNvbToxNTQ1MzMzNDUwMzY3");
		OfbRequest request = new OfbRequest("GET", "http://127.0.0.1:8080/customer/profile", headers, tag);
		return request;
	}

	public static OfbRequest postRequest(String tag) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		headers.put("Authorization", "Y2hhbmNoYWwuc3RlbGxlbmluZm90ZWNoQGdtYWlsLmNvbToxNTQ1MzMzNDUwMzY3");
		OfbRequest request = new OfbRequest("POST", "{\r\n \"mobile\":\"0100\",\r\n \"password\": \"asd\"\r\n}",
				"http://127.0.0.1:8080/auth/token", headers, tag);
		return request;
	}

}
