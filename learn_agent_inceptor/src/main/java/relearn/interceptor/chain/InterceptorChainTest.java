package relearn.interceptor.chain;

import relearn.interceptor.JDKProxy;
import relearn.jdk.base.SayHello;
import relearn.jdk.base.SayHelloImpl;

public class InterceptorChainTest {
    public static void main(String[] args) {
        System.out.println("设置拦截器链，执行结果：");
        // 设计具有拦截器链的代理，注意每个bind方法中的真实对象的改变
        SayHello proxy = (SayHello) JDKProxy.bind(new SayHelloImpl(),
                "relearn.interceptor.InterceptorImpl");
        SayHello proxy2 = (SayHello) JDKProxy.bind(proxy,
                "relearn.interceptor.chain.InterceptorImpl2");
        SayHello proxy3 = (SayHello) JDKProxy.bind(proxy2,
                "relearn.interceptor.chain.InterceptorImpl3");
        // 由最终的代理进行调用方法
        proxy3.sayHello("Eric");
    }
}
