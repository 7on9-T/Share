package test01;
public class Example19 {
    public static void main(String[] args) {
        //printRectangle(3, 5);
        printRectangle(2, 4);
        //printRectangle(6, 10);
    }

    public static void printRectangle(int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.print("内层循环完成");
        }
        System.out.print("退出for循环");
    }
}
