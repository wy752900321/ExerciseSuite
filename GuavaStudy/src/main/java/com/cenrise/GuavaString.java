package com.cenrise;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.emptyToNull;

//import org.springframework.util.StringUtils;

public class GuavaString {
    public static void main(String[] args) {
        //Harry, null, Ron, Hermione
        List<String> strList = Lists.newArrayList("Harry", null, "Ron", "Hermione");
        List<Student> studentList = Lists.newArrayList(new Student("lsp", 3, 34), new Student("", 2, 3));
        Map<String, Object> map = Maps.newTreeMap();
        Joiner joiner = Joiner.on(";").skipNulls();
        String str1 = joiner.join(strList);
        System.out.println(str1);

        Joiner joiner2 = Joiner.on(" & ").useForNull("lsp");
        String str2 = joiner2.join(strList);
        System.out.println(str2);


//        Map<String, String> map = new HashMap<String, String>();
//        map.put("test1", "aaa");
//        map.put("test2", "bbb");
//        Joiner.MapJoiner joiner3 = Joiner.on(",").withKeyValueSeparator("=");
//        String str3 = joiner3.join(map);
//        System.out.println(str3);
//        System.out.println(map.toString());



    }

    /**
     * 2.字符串拆分
     */
    @Test
    public void testSplitter() {
        //JDK
        String splitterStr = ",a,,b,";
        String[] strArray = splitterStr.split(",");
        System.out.println("length:" + strArray.length);

        //GUAVA
        List<String> listStr = Splitter.on(',').trimResults().omitEmptyStrings().splitToList(splitterStr);
        System.out.println("length:" + listStr);


        String str = "xiaoming=11,xiaohong=23";
        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(str);
        System.out.println(map);
    }


    /**
     * 3. 字符匹配
     */
    @Test
    public void testCharMatcher() {
        // 移除字符串中的数字
        String str = CharMatcher.DIGIT.removeFrom("ac2dgc45dbg4");
        System.out.println(str);
        // 只保留字符串中的数字
        String str1 = CharMatcher.DIGIT.retainFrom("ac2dgc45dbg4");
        System.out.println(str1);
        //使用＊替换字符串中的数字
        String str2 = CharMatcher.DIGIT.replaceFrom("ac2dgc45dbg4", "*");
        System.out.println(str2);
        // 移除字符串中a－z的所有小写字母
        String str3 = CharMatcher.inRange('1', 'z').removeFrom("0a0bcz8xy5mDgilBpoDyegA");
        System.out.println(str3);
    }

    @Test
    public void testPerformance() {
        final String numberList = "One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten";

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
//            StringUtils.split(numberList, ",");
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Splitter.on(',').split(numberList);
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        Splitter splitter = Splitter.on(',');
        for (int i = 0; i < 1000000; i++) {
            splitter.split(numberList);
        }
        System.out.println(System.currentTimeMillis() - start);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    }

}
