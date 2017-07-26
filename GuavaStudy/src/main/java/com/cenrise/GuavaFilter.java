package com.cenrise;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.and;
import static com.google.common.collect.Collections2.filter;

/**
 * Created by liushanping on 2017/6/1.
 */
public class GuavaFilter {

    @Test
    public void testList() {
        List<Student> studentList = Lists.newArrayList(new Student("lsp", 34, 67)
                , new Student("sym", 30, 77)
                , new Student("srk", 24, 97)
                , new Student("ljx", 25, 84));

        //年龄大于30
        List<Student> oldStudent = new ArrayList<Student>();
        for (Student student : studentList) {
            if (student.getAge() >= 30) {
                oldStudent.add(student);
            }
        }
        System.out.println(oldStudent.toString());


//        //年龄大于30
//        List<Student> oldStudent2 = Lists.newArrayList(filter(studentList, new Predicate<Student>() {
//            public boolean apply(Student student) {
//                return student.getAge() >= 30;
//            }
//        }));
//        System.out.println(oldStudent2.toString());
//
//        //年龄大于30并且包含a
//        List<Student> oldStudent3 = Lists.newArrayList(filter(studentList, new Predicate<Student>() {
//            public boolean apply(Student student) {
//                return student.getName().contains("l") && student.getAge() >= 30;
//            }
//        }));
//        System.out.println(oldStudent3.toString());
//
//
//        //函数式编程
//        List<Student> filterStudent = new ArrayList(filter(studentList, and(ageBiggerThan(30), nameContains("l"))));
//        System.out.println(filterStudent);
    }


//    private Predicate<Student> ageBiggerThan(final int age) {
//        return new Predicate<Student>() {
//            public boolean apply(Student student) {
//                return student.getAge() >= age;
//            }
//        };
//    }
//
//    private Predicate<Student> nameContains(final String str) {
//        return new Predicate<Student>() {
//            public boolean apply(Student student) {
//                return student.getName().contains(str);
//            }
//        };
//    }


}
