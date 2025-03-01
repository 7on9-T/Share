package test01;

public class Example29 {
    public static void main(String[] args) {
        int[] arr = {9, 8, 3, 5, 2};
        System.out.println("冒泡排序前：");
        printArray(arr);
        bubbleSort(arr);
        System.out.println("冒泡排序后：");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("\n");
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "轮排序后：");
            printArray(arr);
        }
    }
}
