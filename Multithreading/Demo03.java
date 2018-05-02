class MyThread extends Thread {
    private int ticket = 10;

    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            if(this.ticket > 0) {
                System.out.println("卖票，ticket" + this.ticket --);
            }
        }
    }
}

public class Test03 {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        mt1.start();
        mt2.start();
        mt3.start();
    }
}

---------------------------------

class MyThread implements Runnable{
    private int ticket = 10;

    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            if(this.ticket > 0) {
                System.out.println("卖票，ticket" + this.ticket --);
            }
        }
    }
}

public class Test03 {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        new Thread(mt1).start();
        new Thread(mt2).start();
        new Thread(mt3).start();
    }
}
