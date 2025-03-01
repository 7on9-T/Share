package Learn.homework03;

//判断变量是为奇数还是偶数
public class Test02 {
    public static void main(String[] args) {
        int num = 19;
        if (num % 2 == 0) {
            // 判断条件成立，num被2整除
            System.out.println("num是一个偶数");
        } else {
            System.out.println("num是一个奇数");
        }
    }
}
