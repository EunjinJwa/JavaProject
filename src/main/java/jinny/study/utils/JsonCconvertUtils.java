package jinny.study.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonCconvertUtils {

	private static final Gson gson = new Gson();

	public static <T> JsonArray convertJsonArray(final List<T> payoutEntryItems) {
		if (payoutEntryItems == null) {
			return new JsonArray();
		}
		return gson.toJsonTree(payoutEntryItems, new TypeToken<List<T>>(){}.getType()).getAsJsonArray();
	}
}
