class MyThread1 implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            try {
                Thread.sleep(100);   //休眠
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",x = " + i);
        }
    }
}

public class Test04 {
    public static void main(String[] args) {
        MyThread1 mt = new MyThread1();
        new Thread(mt,"线程对象A").start();
    }
}
