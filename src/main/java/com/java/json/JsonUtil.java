/**
 * 
 */
package com.java.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;

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
		String json = "{\r\n\"name\" : \"abc\" ,\r\n\"email id \" : [\"abc@gmail.com\",\"def@gmail.com\",\"ghi@gmail.com\"]\r\n}";
		Map<String, Object> map = convertJsonToMap(json);
		System.out.println(map);

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

}
