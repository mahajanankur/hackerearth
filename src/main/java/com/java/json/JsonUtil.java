/**
 * 
 */
package com.java.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;
import com.java.collection.comparator.Person;

/**
 * @author amahajan
 *
 * @written 06-Mar-2017
 */
public class JsonUtil {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 */
	public static void main(String[] args) throws JsonMappingException, JsonParseException, IOException {
		// String json = "{\r\n\"name\" : \"abc\" ,\r\n\"email id \" :
		// [\"abc@gmail.com\",\"def@gmail.com\",\"ghi@gmail.com\"]\r\n}";
		// Map<String, Object> map = convertJsonToMap(json);
		// System.out.println(map);

		String foo = "blue";
		String bar = foo;
		foo = "green";
		System.out.println(bar);
		// List<Person> list = new ArrayList<>();
		// list.add(new Person("ankur", "mahajan", "1213223"));
		// list.add(new Person("amar", "vaish", "1213223"));
		// list.add(new Person("gurminder", "multani", "1213223"));
		// convertObjectToJson(list);

	}

	public static Map<String, Object> convertJsonToMap(String json)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		// convert JSON string to Map
		map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
		});
		return map;
	}

	public static String convertObjectToJson(List<Person> list)
			throws JsonParseException, JsonMappingException, IOException {
		// String json = new ObjectMapper().writeValueAsString(list);
		JSONArray arrayObject = new JSONArray(list);
		JSONObject response = new JSONObject();
		response.put("list", arrayObject);
		System.out.println(response);
		return response.toString();
	}

}
