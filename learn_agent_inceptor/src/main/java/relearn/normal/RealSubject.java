package relearn.normal;

public class RealSubject implements Subject {
    @Override
    public void request(){
        System.out.println("真实对象中的方法");
    }
}
