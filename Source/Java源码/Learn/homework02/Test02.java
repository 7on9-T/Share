package Learn.homework02;

public class Test02 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int x = a + b++;//a=1,b=3,b++=2
        //x=3
        int y = ++a + b;//a=2,++a=2,b=3
        //y=5
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("x=" + x);
        System.out.println("y=" + y);
    }
}
