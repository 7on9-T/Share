package test01;
public class Example20 {
    public static void main(String[] args) {
        int area = getArea_1(3, 5);
        System.out.println("面积为" + area);
    }

    public static int getArea_1(int x, int y) {
        int temp = x * y;
        return temp;
    }
}
