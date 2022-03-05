package az.kapitalbank.e2e.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import az.kapitalbank.e2e.model.UserActor;
import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToEntityUtils {

	public static ConcurrentMap<Class, String> subPackageMap = new ConcurrentHashMap<>();
	public static String packageName = "entities";

	static {
		subPackageMap.put(UserActor.class, "/users/");
	}

	public static <T> T getEntityFromJsonFile(String entityName, Class<T> clazz) {
		String subPackageName = getSubPackageNameFromClass(clazz);
		String fileContent = getFileContent(EntityModifier.fetchEntityBaseName(entityName), subPackageName);


		T t = convertToObject(entityName, clazz, fileContent);
		t = EntityModifier.postProcess(entityName, t);
		return t;
	}

	private static <T> T convertToObject(String entityName, Class<T> clazz, String fileContent) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(fileContent, clazz);
		} catch (IOException e) {
			throw new IllegalArgumentException("IOException " + entityName + " " + clazz.getName(), e);
		}
	}

	private static String getFileContent(String entityName, String subPackageName) {

		String filePath = packageName + subPackageName + entityName + ".json";
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			System.out.println(filePath);
			URL resource = classLoader.getResource(filePath);
			File file = new File(resource.getFile());
			return FileUtils.readFileToString(file, Charset.forName("UTF-8"));
		} catch (IOException e) {
			throw new IllegalArgumentException("File cannot be read:" + filePath);
		}

	}

	private static String getSubPackageNameFromClass(Class clazz) {
		String packageName = subPackageMap.get(clazz);

		if (packageName == null) {
			throw new IllegalArgumentException("Wrong class name:" + clazz);
		}

		return packageName;
	}
}
