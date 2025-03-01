package test02;

public class Test02 {
    //默认访问权限，能在本包中使用
    void cc() {
        //错误，局部变量没有访问控制权限
        //public int aa;
        //错误，局部变量没有访问控制权限
        //protected boolean bb;
        System.out.println("包访问权限");
    }

    //private权限的内部类，即私有的类，只能在奔雷中访问
    private class InnerClass {

    }
}
