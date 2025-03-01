package test01;
import java.util.Scanner;

public class Example20_1 {
    public static void main(String[] args) {
        getArea();
    }

    public static void getArea (){
        System.out.println("请输入一边长度");
        Scanner sc=new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("请输入另一边长度");
        Scanner sc1=new Scanner(System.in);
        int y = sc1.nextInt();
        int temp = x * y;
        System.out.println("面积为"+temp);
    }
}
