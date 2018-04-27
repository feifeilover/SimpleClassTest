class Point<T> {   //泛型Demo测试
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}

public class Test02 {
    public static void main(String[] args) {
        Point<String> p = new Point<String>();
        p.setX("东经10度");  //设置数据
        p.setY("东经80度");
        String x = p.getX();  //取出数据
        String y = p.getY();
        System.out.println("x的坐标为:" + x + ";y的坐标为:" + y );
    }
}
