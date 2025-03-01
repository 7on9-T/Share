package Learn.homework03;

public class Test03 {
    public static void main(String[] args) {
        int pencil = 1, rubber = 2, cola = 3, book = 12, snacks = 5;
        System.out.println("书本的价格为" + book + "元，您总共有20元");
        System.out.println("1.铅笔的价格为：" + pencil + "元");
        System.out.println("2.橡皮的价格为：" + rubber + "元");
        System.out.println("3.可乐的价格为：" + cola + "元");
        System.out.println("4.零食的价格为：" + snacks + "元");
        int leftmoney = 20 - book;
        int pencilsum = leftmoney / pencil;
        int pencilsurplus = leftmoney % pencil;
        System.out.println("购买完书本后还可以购买铅笔" + pencilsum + "个，还剩" + pencilsurplus + "元");
        int rubbersum = leftmoney / rubber;
        int rubbersurplus = leftmoney % rubber;
        System.out.println("购买完书本后还可以购买橡皮" + rubbersum + "个，还剩" + rubbersurplus + "元");
        int colasum = leftmoney / cola;
        int colasurplus = leftmoney % cola;
        System.out.println("购买完书本后还可以购买可乐" + colasum + "个，还剩" + colasurplus + "元");
        int snackssum = leftmoney / snacks;
        int snackssurplus = leftmoney % snacks;
        System.out.println("购买完书本后还可以购买零食" + snackssum + "个，还剩" + snackssurplus + "元");
    }
}