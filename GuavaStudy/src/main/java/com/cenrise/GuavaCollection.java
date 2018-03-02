package com.cenrise;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class GuavaCollection {
    public static void main(String[] args) {

        //JDK
       /* List<String> strList = new ArrayList<String>();
        strList.add("aaa");
        strList.add("bbb");
        strList.add(null);
        strList.add("ccc");

        List<String> strList3 = new ArrayList<String>() {{
            add("a");
            add("b");
        }};*/

        //guava
        List strList2 = Lists.newArrayList("aaa", "bbb", "cc");
        System.out.println(strList2.toString());


    }
}
