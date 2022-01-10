package relearn.normal;

public class Proxy implements Subject {
    private RealSubject realSubject;
    
    @Override
    public void request(){
        if (realSubject == null) {
            // 创建真实的对象实例
            realSubject = new RealSubject();
        }
        // 代理对象实际调用的为真实对象中的方法
        realSubject.request();
    }
}
