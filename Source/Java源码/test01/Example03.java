package test01;
public class Example03 {
    public static void main(String[] args) {
        byte b1 = 3;
        byte b2 = 4;
        //不能这样写
        //byte b3 = b1 + b2;

        //要这样写
        byte b3 = (byte) (b1 + b2);
        System.out.println(b3);
    }
}
