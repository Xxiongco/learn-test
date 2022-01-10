package relearn.jdk.base;

public class SayHelloImpl implements SayHello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
