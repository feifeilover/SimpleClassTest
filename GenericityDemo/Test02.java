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
        Point<Integer> p = new Point<Integer>();
        p.setX(10);  //设置数据
        p.setY(80);
        int x = p.getX();  //取出数据
        int y = p.getY();
        System.out.println("x的坐标为:" + x + ";y的坐标为:" + y );
    }
}
