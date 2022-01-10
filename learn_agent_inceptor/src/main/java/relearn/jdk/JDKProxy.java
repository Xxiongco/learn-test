package relearn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    Object target = null;

    /** 为真实对象绑定一个代理对象 */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }
   
    /** 实现代理逻辑 */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行真实对象方法前执行代理逻辑");
        // 执行真实对象方法
        Object obj = method.invoke(target, args);
        System.out.println("执行真实对象方法后执行的逻辑");
        return obj;
    }
}
