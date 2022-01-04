package jdk;

import jdk.domian.LiuDeHua;
import jdk.domian.Star;
import jdk.domian.StarProxy;

public class JdkMain {
    public static void main(String[] args) {
        Star ldh = new LiuDeHua();
        StarProxy proxy = new StarProxy();
        proxy.setTarget(ldh);
        Object obj = proxy.CreatProxyObj();
        Star star = (Star)obj;
        star.dance();
        star.sing();
    }
}
