package relearn.interceptor;

public class InterceptorImpl implements Interceptor {
    @Override
    public void printInfo() {
        System.out.println("执行拦截器中的方法");
    }
}
