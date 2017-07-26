package com.cenrise;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;


/**
 * Created by liushanping on 2017/6/1.
 */
public class GuavaFunctions {
    private static Function<Student, String> indexStusdenByName() {
        return new Function<Student, String>() {
            @Override
            public String apply(Student input) {
                return input.getName();
            }
        };
    }

    public static void main(String[] args) {

        List<Student> studentList = Lists.newArrayList();
        studentList.add(new Student("lsp", 23, 94));
        studentList.add(new Student("wjq", 26, 99));
        studentList.add(new Student("la", 21, 87));
        studentList.add(new Student("ljx", 32, 89));


        Map map = Maps.uniqueIndex(studentList, indexStusdenByName());
        System.out.println(map);


    }


}

