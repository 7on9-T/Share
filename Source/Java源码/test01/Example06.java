package test01;
public class Example06 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int z = 0;
        boolean a, b;
        //&两边都会计算
        a = x > 0 & y++ > 1;
        //x>0为false
        //所以a为false
        System.out.println(a);
        System.out.println("y=" + y);
        //&&左面为false，右面不进行计算
        b = x > 0 && z++ > 1;
        System.out.println(b);
        System.out.println("z=" + z);
    }
}
