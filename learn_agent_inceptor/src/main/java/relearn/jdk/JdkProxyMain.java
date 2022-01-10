package relearn.jdk;

import relearn.jdk.base.SayHello;
import relearn.jdk.base.SayHelloImpl;

public class JdkProxyMain {
    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        SayHello proxy = (SayHello) jdkProxy.bind(new SayHelloImpl());
        proxy.sayHello("Eric");
    }
}