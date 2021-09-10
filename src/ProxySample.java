import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySample {
    public static void main(String[] args) {
        // custom implementation
        Reader reader = new ProxyReader();
        reader.read("hi");
        System.out.println("********");

        // JDK implementation
        InvocationHandler handler = new ReaderInvocationHandler();
        Object proxy = Proxy.newProxyInstance(ProxySample.class.getClassLoader(), new Class[]{Reader.class}, handler);
        ((Reader) proxy).read("hiii");
    }
}

interface Reader{
    String read(String str);
}

class MyReader implements Reader{

    @Override
    public String read(String str) {
        return str + " read";
    }
}

// custom implementation
class ProxyReader extends MyReader{
    @Override
    public String read(String str) {
        System.out.println("proxy, input string: " + str);
        String res = super.read(str);
        System.out.println("proxy, result string: " + res);
        return res;
    }
}

// JDK implementation
class ReaderInvocationHandler implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy args: " + args[0]);
        Object result = method.invoke(new MyReader(), args);
        System.out.println("Proxy result: " + result);
        return result;
    }
}
