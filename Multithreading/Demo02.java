class MyThread implements Runnable { //MyThread类实现Runnable接口
    private String name;
    public MyThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {  //重写run方法
        for(int i=0;i<200;i++) {
            System.out.println(this.name + "--->" + i);
        }
    }
}

public class Test03 {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("线程A");
        MyThread mt2 = new MyThread("线程B");
        MyThread mt3 = new MyThread("线程C");
        new Thread(mt1).start();  //每一个线程对象必须通过start启动
        new Thread(mt2).start();
        new Thread(mt3).start();
    }
}
