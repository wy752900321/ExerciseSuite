package com.cenrise;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
    static String mappingJson = "{\"datasource\":\"sakilawide\",\"table\":\"t_wide_country\",\"alias\":\"twa\",\"mapping\":[{\"master\":\"country_id\",\"slave\":\"country_id\"},{\"master\":\"postal_code\",\"slave\":\"postal_code\"},{\"master\":\"phone\",\"slave\":\"phone\"}]}";

    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject(mappingJson);
        JSONArray mappingJSONArray = jsonObject.getJSONArray("mapping");
        for (int i = 0; i < mappingJSONArray.size(); i++) {
            JSONObject mappingInnerJsonOjbect = mappingJSONArray.getJSONObject(i);
            String master = mappingInnerJsonOjbect.getString("master");
            System.out.println(master);
        }
    }
}
