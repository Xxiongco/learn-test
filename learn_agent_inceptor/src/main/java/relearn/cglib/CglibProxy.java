package relearn.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    /**
     * 生成CGLIB代理对象
     *
     * @param cls 需要代理的Class类
     * @return Class类的CGLIB代理对象
     */
    public Object getProxy(Class cls) {
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"d:\\code");
        // CGLIB Enhancer 增强类对象
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(cls);
        // 定义代理对象，要求代理对象必须实现 MethodInterceptor 方法，这里定义为当前对象
        enhancer.setCallback(this);
        // 生成并返回代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实方法前");
        // 利用CGLIB调用真实对象的方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用真实方法后");
        return result;
    }
}
