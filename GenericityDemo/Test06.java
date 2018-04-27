interface IMessage<T> {
    public void print(T t);
}

class MessageImpl implements IMessage<String> {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}

public class Test02 {
    public static void main(String[] args) {
        IMessage<String> msg = new MessageImpl();
        msg.print("菲菲你好");
    }
}
