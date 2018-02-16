/**
 * 
 */
package com.questions.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ankur.mahajan
 * @written 16-Feb-2018
 */
public class MarsRovers {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		MarsRovers rovers = new MarsRovers();
		rovers.firstApproach();

	}

	private void firstApproach() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String startPosition = reader.readLine().trim();
		String commandSet = reader.readLine().trim();
		char[] commands = commandSet.toCharArray();
		Map<String, String> coordinates = getCoordinatesMap(startPosition);
		Map<String, String> currentPostion = coordinates;

		for (char command : commands) {
			if (command == 'L') {
				currentPostion = processCommandL(currentPostion);
			}
			else if (command == 'R') {
				currentPostion = processCommandR(currentPostion);
			}
			else if (command == 'M') {
				currentPostion = processCommandM(currentPostion);
			}
		}

		System.out.println("Current Co-ordinates of the roveres are : " + currentPostion.get("X") + " " + currentPostion.get("Y")
				+ " " + currentPostion.get("D"));
	}

	private Map<String, String> processCommandM(Map<String, String> coordinates) {
		int x = Integer.parseInt(coordinates.get("X"));
		int y = Integer.parseInt(coordinates.get("Y"));
		String direction = coordinates.get("D");
		switch (direction) {
		case "N":
			y = y + 1;
			break;

		case "S":
			y = y - 1;
			break;

		case "E":
			x = x + 1;
			break;

		case "W":
			x = x - 1;
			break;

		}
		coordinates.put("X", x + "");
		coordinates.put("Y", y + "");
		return coordinates;

	}

	private Map<String, String> processCommandR(Map<String, String> coordinates) {
		String direction = coordinates.get("D");

		switch (direction) {
		case "N":
			direction = "E";
			break;

		case "S":
			direction = "W";
			break;

		case "E":
			direction = "S";
			break;

		case "W":
			direction = "N";
			break;

		}
		coordinates.put("D", direction);
		return coordinates;
	}

	private Map<String, String> processCommandL(Map<String, String> coordinates) {
		String direction = coordinates.get("D");

		switch (direction) {
		case "N":
			direction = "W";
			break;

		case "S":
			direction = "E";
			break;

		case "E":
			direction = "N";
			break;

		case "W":
			direction = "S";
			break;

		}
		coordinates.put("D", direction);
		return coordinates;

	}

	private Map<String, String> getCoordinatesMap(String currentPostion) {
		String[] split = currentPostion.split(" ");
		Map<String, String> map = new HashMap<>();
		map.put("X", split[0].trim());
		map.put("Y", split[1].trim());
		map.put("D", split[2].trim());
		return map;
	}
}
