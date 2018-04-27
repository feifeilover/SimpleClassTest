interface IMessage<T> {  //定义一个接口
    public void print(T t) ;  //一个输出方法
}
class MessageImpl<T> implements IMessage<T> {

    @Override
    public void print(T t) {
        System.out.println(t);
    }
}
public class Test02 {
    public static void main(String[] args) {
        IMessage<String> msg = new MessageImpl<String>();
        msg.print("你好啊");
    }
}
