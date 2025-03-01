package test01;
import java.util.Scanner;

public class Example19_1 {
    public static void main(String[] args) {
        printRectangle1();
    }

    public static void printRectangle1() {
        System.out.println("请输入长");
        Scanner width1 = new Scanner(System.in);
        int width = width1.nextInt();
        System.out.println("请输入宽");
        Scanner height1 = new Scanner(System.in);
        int height = height1.nextInt();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.println("输出完成");
    }
}
