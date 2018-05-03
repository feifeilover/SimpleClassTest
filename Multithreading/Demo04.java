class MyThreat1 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());  //取得当前线程对象的名字
    }
}

public class Test04 {
    public static void main(String[] args) {
        MyThreat1 mt = new MyThreat1();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
    }

}
