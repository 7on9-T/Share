package test01;
import java.util.Scanner;

public class Example09 {
    public static void main(String[] args) {
        System.out.println("请输入成绩。");
        Scanner sc1 = new Scanner(System.in);
        int grade = sc1.nextInt();
        if (grade > 80) {
            System.out.println("该成绩的等级为优");
        } else if (grade > 70) {
            System.out.println("该成绩的等级为良");
        } else if (grade > 60) {
            System.out.println("该成绩的等级为中");
        } else if (grade > 0) {
            System.out.println("该成绩的等级为差");
        } else {
            System.out.println("输入的成绩不合法");
        }
    }
}
