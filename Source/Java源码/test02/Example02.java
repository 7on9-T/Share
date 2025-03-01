package test02;

class Student2 {
    String name;
    int age;

    void read() {
        System.out.println("大家好，我是" + name + ",年龄" + age);
    }
}

public class Example02 {

    public static void main(String[] args) {
        Student2 stu1 = new Student2();
        Student2 stu2 = null;
        stu2 = stu1;
        stu1.name = "小明";
        stu1.age = 20;
        stu2.age = 50;
        stu1.read();
        stu2.read();

    }

}
