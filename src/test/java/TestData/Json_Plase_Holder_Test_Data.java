package TestData;

import java.util.HashMap;
import java.util.Map;

public class Json_Plase_Holder_Test_Data {

    public static Map<String, Object> jsonPlaseHolderMapper(Integer userId, String title, Boolean completed) {

        Map<String, Object> payLoad = new HashMap<>();

        if (userId != null) {
            payLoad.put("userId", userId);
        }
        if (title != null) {
            payLoad.put("title", title);
        }
        if (completed != null) {
            payLoad.put("completed", completed);
        }


        return payLoad;
    }
}
