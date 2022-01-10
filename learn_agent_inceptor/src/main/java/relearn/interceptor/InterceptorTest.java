package relearn.interceptor;

import relearn.jdk.base.SayHello;
import relearn.jdk.base.SayHelloImpl;

public class InterceptorTest {
    public static void main(String[] args) {
        System.out.println("设置拦截器的代理执行结果：");
        // 生成指定拦截器的代理对象
        SayHello proxy = (SayHello) JDKProxy.bind(new SayHelloImpl(), "relearn.interceptor.InterceptorImpl");
        proxy.sayHello("Eric");
        System.out.println("\n不设置拦截器的执行结果：");
        // 生成未设置拦截器的代理对象
        proxy = (SayHello) JDKProxy.bind(new SayHelloImpl());
        proxy.sayHello("Jack");
    }
}
