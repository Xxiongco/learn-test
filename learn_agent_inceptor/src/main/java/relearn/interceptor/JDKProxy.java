package relearn.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object target;
    /** 定义拦截器，使用全限定名 */
    private String interceptorClass;

    public JDKProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /** 绑定带有拦截器的代理对象 */
    public static Object bind(Object target, String interceptorClass) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new JDKProxy(target, interceptorClass));
    }

     /** 绑定不带有拦截器的代理对象 */
    public static Object bind(Object target) {
        return JDKProxy.bind(target, null);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 如果未设置拦截器，则直接返回原方法调用
        if (interceptorClass == null) {
            return method.invoke(target, args);
        }
        // 否则就是使用了拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        // 则先执行拦截器之中的处理逻辑
        interceptor.printInfo();
        // 然后执行原方法调用或者由拦截器决定不执行原方法的调用
        return method.invoke(target, args);
        // 原方法调用后也可以再次使用拦截器进行结果处理
    }
}
