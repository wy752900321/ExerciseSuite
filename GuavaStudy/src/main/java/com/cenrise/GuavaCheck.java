package com.cenrise;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkPositionIndex;
import static com.google.common.base.Strings.emptyToNull;

/**
 * guava中的一些检查及空值判断
 */
public class GuavaCheck {

    public static void main(String[] args) {

        System.out.println("===========判空=============");
//        checkArgument(id!=0,"任务ID不能为空");
//        checkArgument(current_id!=null,"当前子任务名称不能为空");
//        checkArgument(exchange_id!=null,"任务名称不能为空");
        //Strings.isNullOrEmpty(current_id);

        List<String> list = new ArrayList<String>();
        Optional<String> possible;
        for (int i = 0; i < list.size(); i++) {
            possible = Optional.fromNullable(emptyToNull(list.get(i)));
            System.out.println("index:" + i + "-value:" + possible.or("novalue"));
        }


        System.out.println("===========Guava中的前置条件=============");
        //checkArgument()方法，用来检查传入的值是否为true.如果为false报错
        boolean flag = false;
//        checkArgument(flag, "字段flag不能为空！");//Exception in thread "main" java.lang.IllegalArgumentException


        //为false时，IllegalArgumentException
        int max = 1, min = 2;//我们期待max是大于min的
//        checkArgument(max > min, "max的值小于min的值");

        // checkState(boolean) 检查对象的状态。
        String str = null;
//        checkState(str.isEmpty());//java.lang.NullPointerException

//        checkElementIndex(int index, int size),检查列表，字符串，或者数组的索引值是否合法。
        int[] arr = new int[5];
        checkElementIndex(4, arr.length);//java.lang.IndexOutOfBoundsException

//        checkPositionIndex(int index, int size),检查该位置是否有效，下面的例子中使用的仍然是上例中定义的数组。
        checkPositionIndex(5, arr.length); //5位置存在，运行正常。
//        checkPositionIndex(6, arr.length); //6位置不存在，抛出异常。

//        checkPositionIndexes(int start, int end, int size),检查某个范围是否有效。
//        checkPositionIndexes(3, 6, arr.length);// java.lang.IndexOutOfBoundsException

        System.out.println("===========equals方法和hashcode方法=============");
//        guava给我提供的equals方法和hashcode方法，代码比较简单这里就不详细说明了。
        System.out.println(Objects.equal(null, 'a'));
        System.out.println(Objects.equal(null, null));
        System.out.println(Objects.equal('a', null));
        System.out.println(Objects.equal('a', 'a'));

        String str1 = "zhaotong1";
        System.out.println(Objects.hashCode(str1));

    }
}
