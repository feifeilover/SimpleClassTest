class MyThread1 implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            try {
                Thread.sleep(100);
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
        Thread t1 = new Thread(mt,"线程A");
        Thread t2 = new Thread(mt,"线程B");
        Thread t3 = new Thread(mt,"线程C");
        t1.setPriority(Thread.MAX_PRIORITY);  //设置最高优先级
        t1.start();
        t2.start();
        t3.start();
    }
}
