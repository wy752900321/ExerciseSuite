package com.cenrise;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {
    static String jsonData = "[{\"求和_结算金额\":16941320050.43,\"扩展分公司编号\":\"2029000000\",\"扩展分公司\":\"陕西分公司\"},{\"求和_结算金额\":1883232,\"扩展分公司编号\":\"3232\",\"扩展分公司\":\"广西分公司\"}]";
    static String jsonFormat = "扩展分公司,求和_结算金额,扩展分公司编号";

    public static void main(String[] args) {
        //System.out.println(transformationStr("'陕西分公司'"));
        System.out.println(orderJSONArray(jsonData, jsonFormat));
    }

    private static String orderJSONArray(String jsonArrayResultTmp, String frontOrderText) {
        JSONArray jsonArrayResult = new JSONArray();

        String[] orderArray = frontOrderText.split(",");
        JSONArray jsonArrayData = JSONArray.parseArray(jsonArrayResultTmp);
        for (int i = 0; i < jsonArrayData.size(); i++) {
            JSONObject jsonObjectResult = new JSONObject(16, true);
            JSONObject jsonObject = (JSONObject) jsonArrayData.get(i);

            for (String orderStr : orderArray) {
                jsonObjectResult.put(orderStr, jsonObject.get(orderStr));
            }
            jsonArrayResult.add(jsonObjectResult);
        }
        return jsonArrayResult.toJSONString();
    }

    /**
     * 给获取过来的字符串添加引号
     */
    public static String transformationStr(String str) {
        if (str == null) {
            return "''";
        }
        StringBuilder sb = new StringBuilder();
        //转义中文引号，去掉单引号，中文或英雄的单引
        str = str.replace("，", ",").replace("'", "").replace("‘", "").replace("\"", "").replace("“", "");
        String[] splits = str.split(",");
        int i = 0;
        for (String strTmp : splits) {
            ++i;
            if (i == splits.length) {
                strTmp = "'" + strTmp + "'";
            } else {
                strTmp = "'" + strTmp + "'" + ",";
            }

            sb.append(strTmp);
        }
        return sb.toString();
    }

    public static void main5(String[] args) {
        String jsonStr = "{\"returnMsg\":{\"title\":\"kylin返回异常\",\"exception\":\"java.io.FileNotFoundException: /data/applogs/xxl-job/xxl-job-admin.log (No such file or directory)\",\"exceptionDesc\":\"在查询kylin数据库时出现错误。\"}}";
        System.out.println(getPromptMsg("kylin返回异常", "在查询kylin数据库时出现错误。", null));
    }

    public static void main4(String[] args) {
        String jsonStr = "{\"sqls\":[{\"ip\":\"10.1.101.1\",\"schema\":\"query\",\"sql\":\"select * form dual\"},{\"ip\":\"10.1.101.1\",\"schema\":\"query\",\"sql\":\"select * form dual\"}]}";
        JSONObject jsonObjectLogSql = new JSONObject();
        JSONArray jsonArrayLogSql = new JSONArray();

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("ip", "10.1.101.1");
        jsonObject2.put("schema", "query");
        jsonObject2.put("sql", "SELECT first_name, last_name FROM employees WHERE salary > 100000");
        jsonArrayLogSql.add(jsonObject2);

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("ip", "10.1.101.1");
        jsonObject3.put("schema", "query");
        jsonObject3.put("sql", "SELECT first_name, last_name FROM employees WHERE salary > 100000");
        jsonArrayLogSql.add(jsonObject3);

        jsonObjectLogSql.put("sqls", jsonArrayLogSql);
        System.out.println(jsonObjectLogSql.toJSONString());
    }

    public static void main2(String[] args) {
        String jsonstr = "[{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"李四\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观1运行\"},{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"赵三\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观2运行\"},{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"王二\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观3运行\"},{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"傻b\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观4运行\"},{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"李四\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观5运行\"}]";
        String jsonRelationStr = "{\"mater_table_ip\":\"10.1.11.163\",\"master_table_dbname\":\"BD\",\"master_table_name\":\"T_MEC_IF\",\"slave_table_ip\":\"10.1.30.101\",\"slave_table_dbname\":\"DEFAULT\",\"slave_table_name\":\"T_RPTADM_SES_SC_D\",\"relation_type\":\"inner join\",\"relation\":[[\"cola1\",\"cola2\",\"=\"],[\"colb1\",\"colb2\",\"<=\"],[\"colc1\",\"colc2\",\"<>\"],[\"cold1\",\"cold2\",\">=\"]]}";

        List<String> lists = new ArrayList<String>();
        JSONArray jsonArray = JSONArray.parseArray(jsonstr);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Set<String> keySet = jsonObject.keySet();
            for (String keyValue : keySet) {
                if (keyValue.equals("属性_结算用户名")) {
                    String o = (String) jsonObject.get(keyValue);
                    lists.add(o);
//                    System.out.println(jsonObject.get(keyValue));
                }
            }
        }

        StringBuilder csvBuilder = new StringBuilder();
        int i = 0;
        for (String city : lists) {
            i++;
            csvBuilder.append(city);
            if (i != lists.size()) {
                csvBuilder.append(",");
            }
        }
        String csv = csvBuilder.toString();
        System.out.println(csv);
    }

    public static void main3(String[] args) {
        String jsonstr = "[{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"李四\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观1运行\"},{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"赵三\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观2运行\"},{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"王二\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观3运行\"},{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"傻b\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观4运行\"},{\"属性_终端号\":\"zd2341431\",\"分组_序列号\":\"323131313\",\"属性_终端状态\":\"成功\",\"属性_结算用户名\":\"李四\",\"去重_结算用户名\":\"张三\",\"最大值_成绩\":\"100\",\"总和_成绩\":\"698\",\"计数_成绩\":\"7\",\"去重_开户支行\":\"回龙观5运行\"}]";
        String jsonRelationStr = "{\"mater_table_ip\":\"10.1.11.163\",\"master_table_dbname\":\"BD\",\"master_table_name\":\"T_MEC_IF\",\"slave_table_ip\":\"10.1.30.101\",\"slave_table_dbname\":\"DEFAULT\",\"slave_table_name\":\"T_RPTADM_SES_SC_D\",\"relation_type\":\"inner join\",\"relation\":[[\"cola1\",\"cola2\",\"=\"],[\"colb1\",\"colb2\",\"<=\"],[\"colc1\",\"colc2\",\"<>\"],[\"cold1\",\"cold2\",\">=\"]]}";
        JSONArray jsonArray = JSONArray.parseArray(jsonstr);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Set<String> keySet = jsonObject.keySet();
            for (String keyValue : keySet) {
                System.out.print(jsonObject.get(keyValue));
            }
            System.out.println();
        }

        JSONObject jsonObject = JSONObject.parseObject(jsonRelationStr);
        JSONArray jsonRelationArray = (JSONArray) jsonObject.get("relation");
        for (int i = 0; i < jsonRelationArray.size(); i++) {
            JSONArray relation = (JSONArray) jsonRelationArray.get(0);
            System.out.println(relation.get(0));
            System.out.println(relation.get(1));
            System.out.println(relation.get(2));
        }
        System.out.println();
    }

    /**
     * 获取提示对话框信息
     *
     * @param title         标题
     * @param exception     异常
     * @param execptionDesc 异常描述
     * @return
     */
    public static String getPromptMsg(String title, String execptionDesc, String exception) {
        JSONObject jsonObjectLogSql = new JSONObject();

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("title", title);
        jsonObject2.put("exception", exception);
        jsonObject2.put("exceptionDesc", execptionDesc);

        jsonObjectLogSql.put("promptMsg", jsonObject2);
        return jsonObjectLogSql.toJSONString();
    }
}
