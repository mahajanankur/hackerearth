/**
 * 
 */
package com.java.json;

import java.io.IOException;
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

		// String foo = "blue";
		// String bar = foo;
		// foo = "green";
		// System.out.println(bar);
		// List<Person> list = new ArrayList<>();
		// list.add(new Person("ankur", "mahajan", "1213223"));
		// list.add(new Person("amar", "vaish", "1213223"));
		// list.add(new Person("gurminder", "multani", "1213223"));
		// convertObjectToJson(list);

//		String complexJson = "{\"id\":\"28e440a0-3bbb-11e7-a7ef-2dd530f57334\",\"arn\":\"testarn\",\"notifig\":\"Homes1\",\"deviceToken\":[\"eg0dc69nQi8:APA91bFFrmpc3Bp9_6DbQEz_yZIQZvMkrxmgELRPLcQlTYaMPDbn9yzU4IgIwxhArKqzc9CYIk5mo_RYBUopEgC25pdRvRXP9aDmDIonJveML2keVDBFrZWjsFeHBU5pUs9OiT7ZNkhM\"],\"data\":{\"name\":\"Sherlock Homes\",\"payload\":{\"url\":\"atcost.com\",\"pushId\":10}}}";
//		convertComplexJSON(complexJson);
		
	}

	private static void convertComplexJSON(String complexJson)
			throws com.fasterxml.jackson.core.JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PushPojo1 readValue = mapper.readValue(complexJson, PushPojo1.class);
		System.out.println(readValue);

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
