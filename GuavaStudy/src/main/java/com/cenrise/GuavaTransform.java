package com.cenrise;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;

/**
 * Created by liushanping on 2017/6/1.
 */
public class GuavaTransform {

    @Test
    public void testListTransform() {
        //将数组中的所有元素映射为另一种元素的列表
        List<Student> studentList = Lists.newArrayList(new Student("lsp", 34, 67)
                , new Student("sym", 30, 77)
                , new Student("srk", 24, 97)
                , new Student("ljx", 25, 84));

        List<String> nameList = new ArrayList<String>();
        for (Student student : studentList) {
            nameList.add(student.getName());
        }
        System.out.println(nameList.size());


        List<String> nameList2 = new ArrayList(transform(studentList, transNameString()));
        System.out.println(nameList2);

    }

    private static Function<Student, String> transNameString() {
        return new Function<Student, String>() {
            public String apply(Student student) {
                return student.getName();
            }
        };
    }

    @Test
    public void testNatural() {
        //将数组中的所有元素映射为另一种元素的列表
        List<Student> studentList = Lists.newArrayList(new Student("lsp", 34, 87)
                , new Student("sym", 30, 77)
                , new Student("srk", 24, 97)
                , new Student("ljx", 25, 84));

        Ordering<Student> ordering = Ordering.natural().onResultOf(new Function<Student, Comparable>() {
            @Override
            public Comparable apply(Student student) {
                return student.getScore();
            }
        });
        List<Student> studentList1 = ordering.reverse().sortedCopy(studentList);
        System.out.println(studentList1);
    }




}
