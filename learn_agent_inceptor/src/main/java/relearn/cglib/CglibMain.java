package relearn.cglib;

/**
 *
 * cglib学习：通过设置Enhancer增强器的CallBack和superclass，然后调用enhancer.create方法，创建代理类的对象。
 *
 * 往enhancer.create中走下去，会根据我们传入的信息构建keyFactory对象(EnhancerKey接口的实现对象)，通过它生成一个key
 * 将key设置到当前对象中去，根据当前对象获取代理对象，在此方法里面，会根据我们之前设置的key获取到对象，有就返回，没有就创建。
 *
 *
 */

public class CglibMain {
    public static void main(String[] args) {
        CglibProxy cp = new CglibProxy();
        SayHello obj = (SayHello) cp.getProxy(SayHello.class);
        obj.sayHello("Eric");
        SayHello obj2 =(SayHello) cp.getProxy(SayHello.class);
        obj2.sayHello("Eric2");
    }
}
