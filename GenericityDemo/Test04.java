class Message<T> {
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
        Message<String> m = new Message<String>();
        m.setMsg("菲菲");
        fun(m);
    }
    public static void fun(Message<? super String> temp) {
        System.out.println(temp.getMsg());
    }
}
