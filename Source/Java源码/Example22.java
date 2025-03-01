package test01;

public class Example22 {
    //在java中，声明数组的方式有以下两种
    //第一种
    //数据类型[] 数组名 = null;
    //第二种
    //数据类型[] 数组名;
    //数组名 = new 数据类型[长度];
    public static void main(String[] args) {
        int[] arr;
        //数组空间为3，只有0-2
        arr = new int[3];
        System.out.println("arr[0]" + arr[0]);
        System.out.println("arr[1]" + arr[1]);
        System.out.println("arr[2]" + arr[2]);
        System.out.println("数组的长度是:"+arr.length);
        //会报错
        //System.out.println("arr[3]" + arr[3]);
    }
}
