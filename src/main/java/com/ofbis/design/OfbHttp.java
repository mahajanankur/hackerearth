/**
 * 
 */
package com.ofbis.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author ankur.mahajan
 * @written 19-Dec-2018
 */
public class OfbHttp {

	private static final String GET = "GET";

	private static final String POST = "POST";

	private static final String JSON_TYPE = "application/json";

	private static ListeningExecutorService EXECUTOR_SERVICE = MoreExecutors
			.listeningDecorator(Executors.newCachedThreadPool());

	private final static Map<String, List<ListenableFutureTask<OfbResponse>>> TASK_MAP = new HashMap<>();

	/**
	 * This method is used to perform the
	 * 
	 * @param request
	 * @return ListenableFuture<OfbResponse>
	 */
	public static ListenableFuture<OfbResponse> execute(OfbRequest request) {
		// ListeningExecutorService service =
		// MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		ListenableFuture<OfbResponse> response = EXECUTOR_SERVICE.submit(new Callable<OfbResponse>() {
			public OfbResponse call() throws Exception {
				return httpCall(request);
			}
		});

		addTaskToMap(request.getTag(), response);
		return response;

	}

	/**
	 * @param tag
	 */
	public static void cancel(String tag) {
		synchronized (tag) {
			List<ListenableFutureTask<OfbResponse>> futureTasks = null != TASK_MAP && !TASK_MAP.isEmpty()
					? TASK_MAP.get(tag) : null;
			if (null != futureTasks)
				for (ListenableFutureTask<OfbResponse> task : futureTasks) {
					task.cancel(true);
				}
		}

		// EXECUTOR_SERVICE.shutdown();
	}

	/**
	 * This method is used to send the actual Http or Https requests.
	 * 
	 * @param request
	 * @return OfbResponse
	 * @throws IOException
	 */
	private static OfbResponse httpCall(OfbRequest request) throws Exception {
		URL url = new URL(request.getUrl());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		// Set Request headers
		if (null != request.getHeaders()) {
			for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
				connection.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
		if (request.getMethodType().equalsIgnoreCase(GET)) {
			connection.setRequestMethod(GET);
			// TODO - Make sure to uncomment this line so we get proper time to
			// test cancel task functionality.
			// Thread.sleep(10000);
			if (null != request.getTag() && !request.getTag().isEmpty())
				connection.setRequestProperty("ETag", request.getTag());
		} else {
			connection.setRequestMethod(POST);

			connection.setRequestProperty("Content-Type", JSON_TYPE);
			connection.setRequestProperty("Accept", JSON_TYPE);

			// Set Body - Null check
			OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
			osw.write(request.getBody());
			osw.flush();
		}

		int responseCode = connection.getResponseCode();
		System.out.println("GET Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		// Print the content
		System.out.println(null != content ? content.toString() : null);
		OfbResponse response = new OfbResponse.Builder().setResponseCode(responseCode)
				.setContent(null != content ? content.toString() : null).build();

		return response;
	}

	/**
	 * This method is used to build a listenable future map based on the tag
	 * provided.
	 * 
	 * @param tag
	 * @param listenableFuture
	 */
	private static void addTaskToMap(String tag, ListenableFuture<OfbResponse> listenableFuture) {
		List<ListenableFutureTask<OfbResponse>> taskList = TASK_MAP.get(tag);
		if (null == taskList) {
			taskList = new ArrayList<>();
			taskList.add((ListenableFutureTask<OfbResponse>) listenableFuture);
			TASK_MAP.put(tag, taskList);
		} else {
			taskList.add((ListenableFutureTask<OfbResponse>) listenableFuture);
			TASK_MAP.put(tag, taskList);
		}

	}

}
