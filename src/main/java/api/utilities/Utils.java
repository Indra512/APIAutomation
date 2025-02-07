package api.utilities;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static ThreadLocal<Map<String, String>> stringData = ThreadLocal.withInitial(HashMap::new);

	public static void setDataInCollection(String key, String testData) {
		stringData.get().put(key, testData);
	}

	public static String getDataFromCollection(String key) {
		return stringData.get().get(key);
	}

	public static void clearDataFromCollection() {
		stringData.get().clear();
	}
}
