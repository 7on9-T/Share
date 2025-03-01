package test01;
public class Example02 {
    public static void main(String[] args) {
        byte a;
        int b = 298;
        //精度丢失警告！
        a = (byte) b;
        System.out.println("b="+b);
        System.out.println("a="+a);
    }
}
