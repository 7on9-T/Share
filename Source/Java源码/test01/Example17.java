package test01;
public class Example17 {
    public static void main(String[] args) {
        int i, j;
        for (i = 1; i <= 4; i++) {
            if (i > 4) {
                break;
            }
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }
}
