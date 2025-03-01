package Learn.homework02;

public class Test03 {
    public static void main(String[] args) {
        int x= 0;
        int y=0;
        int z=0;
        boolean a,b;
        a = x > 0 & y++ > 1;
        //x>0为false
        //所以a为false
        System.out.println("y=" + y);
        //&&左面为false，右面不进行计算
        b = x > 0 && z++ > 1;
        System.out.println("z=" + z);
    }
}
