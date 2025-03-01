package test02;

public class Test01 {
    public int aa;
    protected boolean bb;

    void cc() {
        System.out.println("包访问权限");
    }

    //private权限的内部类，即这是私有的内部类，只能在本类中使用
    private class InnerClass {
        
    }
}
