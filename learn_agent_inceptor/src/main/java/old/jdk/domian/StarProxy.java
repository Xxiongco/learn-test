package old.jdk.domian;
 
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
 
public class StarProxy implements InvocationHandler
{
    private Object target;
    
    public void setTarget(Object target)
    {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("代理人收钱，刘德华开始表演");
        
        Object result = method.invoke(target, args);

        System.out.println("刘德华表演结束");

        return result;
    }
    public Object CreatProxyObj()
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }  
   
}