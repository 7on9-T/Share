package test02;

class Student4 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("你输入的年龄有误");
        } else {
            this.age = age;
        }
    }

    public void read() {
        System.out.println("大家好，我是" + name + "，年龄" + age);
    }
}

public class Example04 {
    public static void main(String[] args) {
        Student4 stu = new Student4();
        stu.setName("张三");
        stu.setAge(18);
        stu.read();
    }
}
