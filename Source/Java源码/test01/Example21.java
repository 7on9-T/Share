package test01;
public class Example21 {
    public static void main(String[] args) {
        //方法重载
        //调用方法
        int sum1 = add(1, 2);
        int sum2 = add(1, 2, 3);
        double sum3 = add(1.2, 2.3);
        //打印求和结果
        System.out.println("sum1=" + sum1);
        System.out.println("sum2=" + sum2);
        System.out.println("sum3=" + sum3);
    }

    //两个整数相加
    public static int add(int x, int y) {
        return x + y;
    }

    //三个整数相加
    public static int add(int x, int y, int z) {
        return x + y + z;
    }

    //两个小数相加
    public static double add(double x, double y) {
        return x + y;
    }
}
