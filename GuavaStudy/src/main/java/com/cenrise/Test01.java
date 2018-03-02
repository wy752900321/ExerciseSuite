package com.cenrise;

import com.google.common.base.Optional;

class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

public class Test01 {
    public static void main(String[] args) {
        Person p = null;
        /*在上面的代码中我们去构造一个Optional对象，fromNullable（）该方法可以将一个T类型的对象转化为Optional对象，
        并且允许该对象为空。那么我们可以调用isPresent（）来判断该对象是否为null ，如果为null 该方法返回true，反之为false。*/

        Optional<Person> op = Optional.fromNullable(p);
        if (op.isPresent()) {
            System.out.println("name:" + op.get().getName());
        }

        Person p2 = null;
//        Optional<Person> op2 = Optional.of(p2);//java.lang.NullPointerException

//        Optional<Person> op3 = Optional.absent();

//        get（）方法，该方法表示从Optional中取出一个非null的T的实例。没有非空时报错
        Person p4 = null;
//        Optional<Person> op4 = Optional.fromNullable(p4);
//        System.out.println(op4.get());//java.lang.IllegalStateException: Optional.get() cannot be called on an absent value

//        or(T) 方法则表示若Optional实例中包含了传入的T的相同实例，返回Optional包含的该T实例，否则返回输入的T实例作为默认值。
        Person p5 = null;
        Optional<Person> op5 = Optional.fromNullable(p5);
        Person p6 = new Person();
        p5.setName("zhaotong1");
        System.out.println(op5.or(p6).getName());


    }
}