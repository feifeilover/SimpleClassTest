class MyThread extends Thread {  //MyThread继承Thread类
    private String name;
    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {  //重写run方法
        for(int i=0;i<200;i++) {
            System.out.println(this.name + "---->" + i);
        }
    }
}

public class Test03 {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("线程A");
        MyThread mt2 = new MyThread("线程B");
        MyThread mt3 = new MyThread("线程C");
        mt1.start();  //启动Thread类中的start方法
        mt2.start();
        mt3.start();

    }
}
