package test01;
public class Example05 {
    public static void main(String[] args) {
        short s = 3;
        int i = 5;
        //+= java会自动完成类型转换
        s += i;
        System.out.println("s="+s);
    }
}
