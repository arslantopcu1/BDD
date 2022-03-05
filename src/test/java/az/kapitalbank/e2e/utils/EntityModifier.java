package az.kapitalbank.e2e.utils;

import java.lang.reflect.Field;

@SuppressWarnings("rawtypes")
public class EntityModifier {

	public static String fetchEntityBaseName(String entityName) {
		return entityName.split("--")[0];
	}

	public static <T> T postProcess(String entityName, T t) {
		t = postWithouts(entityName, t);
		t = postNegatives(entityName, t);
		return t;
	}

	private static <T> T postWithouts(String entityName, T t) {
		String[] withoutFields = fetchFields("wt", entityName);
		Class clazz = t.getClass();

		for (String field : withoutFields) {
			try {
				Field declaredField = clazz.getDeclaredField(field);
				declaredField.setAccessible(true);
				declaredField.set(t, null);
			} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
				throw new IllegalArgumentException(e);
			}
		}

		return t;
	}

	private static <T> T postNegatives(String entityName, T t) {
		String[] negativeFields = fetchFields("ng", entityName);
		Class clazz = t.getClass();

		for (String field : negativeFields) {
			try {
				System.out.println("negative before:" + field);
				Field declaredField = clazz.getDeclaredField(field);
				declaredField.setAccessible(true);
				Object negative = convertToNegative(declaredField.get(t));
				System.out.println("negative after:" + negative);
				declaredField.set(t, negative);
			} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
				throw new IllegalArgumentException(e);
			}
		}

		return t;
	}

	private static Object convertToNegative(Object object) {
		if (object.getClass().equals(int.class)) {
			return -1 * ((int) object);
		}
		if (object instanceof Integer) {
			return -1 * ((Integer) object);
		} else if (object instanceof Long) {
			return -1 * ((Long) object);
		}

		throw new IllegalArgumentException("cannot make negative" + object);
	}

	@SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
	private static String[] fetchFields(String prefix, String entityName) {
		String[] fields = entityName.split("--");

		if (fields.length > 1) {
			for (int i = 1; i < fields.length; ++i) {
				if (fields[i].startsWith(prefix + "-")) {
					return splitFields(fields[i].substring(prefix.length() + 1));
				}
			}
		}

		return new String[0];
	}

	private static String[] splitFields(String fields) {
		return fields.split("-");
	}

}
