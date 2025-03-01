package test01;
public class Example14 {
    public static void main(String[] args) {
        //for(初始化表达式;循环条件;操作表达式){
        // 执行语句
        // ...
        // }

        //简要表达下
        //for(1,2,3){
        // 4
        // }

        //第一步：执行1
        //第二步：执行2，如果判断为true，则执行第三步；如果判断结果为false，执行第五步
        //第三步：执行4
        //第四步：执行3，然后重复执行第二步
        //第五步: 退出循环

        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            sum += i;
            System.out.println("sum=" + sum);
        }
    }
}
