package az.kapitalbank.e2e.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonLogger {

	private static final Logger logger = LoggerFactory.getLogger(JsonLogger.class);
	
	public static void printAsJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			System.out.println(mapper.writeValueAsString(object));
			System.out.println("\n\n");
		} catch (JsonProcessingException e) {
			logger.error("Exception in printAsJson.", e);
		}
	}
}
