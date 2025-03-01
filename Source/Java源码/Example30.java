package test01;

public class Example30 {
    public static void main(String[] args) {
        //二维数组

        //第一种方式
        //数据类型[][] 数组名 = new 数据类型[行的个数][列的个数];
        int[][] xx = new int[3][4];

        //第二种方式
        //数据类型[][] 数组名 = new 数据类型[行的个数][];
        int[][] xx1 = new int[3][];

        //第三种方式
        //数据类型[][] 数组名 = {{第0行初始值}，{第1行初始值},...,{第n行初始值}}
        int[][] xx2={{1,2},{3,4,5,6},{7,8,9}};
    }
}
