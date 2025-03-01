package test01;
public class Example04 {
    public static void main(String[] args) {
        //变量的作用域
        int x = 12;
        {
            int y = 96;
            System.out.println("x=" + x);
            System.out.println("y=" + y);
        }
        //y只在5-9行起作用
        //y = x;
        System.out.println("x=" + x);
    }
}
