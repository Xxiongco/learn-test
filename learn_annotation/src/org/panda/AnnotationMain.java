package org.panda;

import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Xiong
public class AnnotationMain {
    public static void main(String[] args) throws Exception {

        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //testOne();
        // testTwo();
        // 获取注解上的注解
        Annotation annotation = AnnotationMain.class.getAnnotation(Xiong.class);
        Class<? extends Annotation> xiongClass = annotation.annotationType();

        Hong hong = xiongClass.getAnnotation(Hong.class);

        System.out.println(hong.name());


        Hong mergedAnnotation = AnnotatedElementUtils.getMergedAnnotation(AnnotationMain.class, Hong.class);

        System.out.println(mergedAnnotation.name());


    }

    public static void testTwo() throws Exception{
        Class<AnnotationMain> mainClass = AnnotationMain.class;
        System.out.println(mainClass.getName());
        System.out.println(mainClass.isAnnotationPresent(Xiong.class));

        Xiong xiong = mainClass.getAnnotation(Xiong.class);

//        String name = xiong.name();
//        String age = xiong.age();
//        System.out.println(name);
//        System.out.println(age);

        InvocationHandler invocationHandler = Proxy.getInvocationHandler(xiong);

        Class<? extends InvocationHandler> aClass = invocationHandler.getClass();

        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(invocationHandler));
        }

        System.out.println("***********");

        Field type = aClass.getDeclaredField("type");
        type.setAccessible(true);
        Class o = (Class)type.get(invocationHandler);

        Hong hong =(Hong) o.getAnnotation(Hong.class);
        System.out.println(hong.name());
    }

    public static void testOne() throws Exception{
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {

            Class<? extends Annotation> annotationsClass = annotation.getClass();

            Field[] declaredFields = annotationsClass.getDeclaredFields();
            Method[] declaredMethods = annotationsClass.getDeclaredMethods();


            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                System.out.println(declaredField.getName() + " : " + declaredField.get(annotations));
            }

            for (Method declaredMethod : declaredMethods) {
                declaredMethod.setAccessible(true);
                System.out.println(declaredMethod.getName());
            }

            Field[] fields = annotationsClass.getFields();
            System.out.println(fields.length);


        }

    }
}
