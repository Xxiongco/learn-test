import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


/**
 * 用于测试 -parameters 配置对反射获取参数的影响
 *
 * 有：
 * parameterOne
 * parameterTwo
 * parameterThree
 *
 * 无：
 * arg0
 * arg1
 * arg2
 * 相关文章：https://blog.csdn.net/u011821334/article/details/101763001
 *
 * 主要是用于测试mybatis中，为其传递参数的时候，可以传递多个参数，如果IDEA项目设置了参数，那么就可以不使用@Param设置参数绑定。
 *
 *
 */

public class TestReflectInParam {

    public static void main(String[] args) {
        Method[] methods = TestReflectInParam.class.getMethods();
        for (Method method : methods) {
            if ("parameterMethodTest".equals(method.getName())) {
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.getName());
                }
            }
        }
    }

    public static void parameterMethodTest(int parameterOne, String parameterTwo, Object parameterThree) {
        System.out.println("Hello World!");
    }


}
