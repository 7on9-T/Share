package test01;
public class Example01 {
    public static void main(String[] args) {
        int num = 4;
        //java: 不兼容的类型: 从int转换到byte可能会有损失
        //byte b = num;

        //强制类型转换
        //目标类型 变量 = （目标类型） 值
        byte b = (byte) num;
        System.out.println(b);
    }
}
