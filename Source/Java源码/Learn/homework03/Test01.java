package Learn.homework03;

public class Test01 {
    public static void main(String[] args) {
        int x = 0;
        int y = 1;
        int max;
        if (x > y) {
            max = x;
        } else {
            max = y;
        }
        System.out.println(max);

        //转换为三元运算符
        int max1 = x > y ? x : y;
        System.out.println(max1);
    }
}
