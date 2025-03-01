package test02;

import Learn.homework01.Student;

class Student3 {
    String name;
    int age;

    void read() {
        System.out.println("大家好，我是" + name + "，年龄" + age);
    }
}

public class Example03 {
    public static void main(String[] args) {
        Student3 stu = new Student3();
        stu.name = "张三";
        stu.age = -18;
        stu.read();
    }
}
