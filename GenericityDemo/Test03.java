class Message<T extends Number> {
    private T msg;

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}

public class Test02 {
    public static void main(String[] args) {
        Message<Integer> m = new Message<Integer>();
        m.setMsg(200);
        fun(m);
    }
    public static void fun(Message<? extends Number> temp) {
        System.out.println(temp.getMsg());
    }
}
