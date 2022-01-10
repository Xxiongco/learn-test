package relearn.interceptor.chain;

import relearn.interceptor.Interceptor;

public class InterceptorImpl2 implements Interceptor {
    @Override
    public void printInfo() {
        System.out.println("执行拦截器2");
    }
}
