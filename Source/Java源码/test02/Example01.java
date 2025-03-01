package test02;

class Student1 {
	String name;

	void read() {
		System.out.println("大家好，我是" + name);
	}
}

public class Example01 {

	public static void main(String[] args) {
		Student1 stu1 = new Student1();
		Student1 stu2 = new Student1();
		stu1.name = "小明";
		stu1.read();
		stu2.name = "小华";
		stu2.read();
	}

}
