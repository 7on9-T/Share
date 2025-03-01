package test01;

public class Example26 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        //double[] arr1 = new double[8];
        arr[0] = 5;
        System.out.println("arr[0]=" + arr[0]);
        //空指针异常
        arr = null;
        System.out.println("arr[0]=" + arr[0]);

    }
}
