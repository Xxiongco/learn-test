package com.panda;

import com.panda.domian.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * 通过反射获取某个变量的值
 * 两种方式
 * 1. 直接field.get()
 * 2. 通过对象类的get方法获取
 */
public class LearnReflectMain {

    public static String GET = "get";


    public static void main(String[] args) throws Exception{

        Class<Student> studentClass = Student.class;

        // 获取类名
        String name = studentClass.getName();
        String simpleName = studentClass.getSimpleName();
        System.out.println(name);
        System.out.println(simpleName);
        System.out.println("**********************");

        // 获取类修饰符
        int modifiers = studentClass.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.isPublic(modifiers));

        // 获取包信息
        System.out.println(studentClass.getPackage());

        //获取父类的Class对象
        System.out.println(studentClass.getSuperclass());
        System.out.println(studentClass.getSuperclass().getName());

        // 获取接口信息
        Class<?>[] interfaces = studentClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
        //获取构造函数Constructor
        Constructor<?>[] constructors = studentClass.getConstructors();
        Constructor<Student> constructor = studentClass.getConstructor();

        // 如果已经知道了某个构造的参数，可以通过下面的方法获取到回应的构造函数对象
        // Constructor constructors = studentClass.getConstructor(new Class[]{String.class});

        // 获取构造函数的参数
        Parameter[] parameters = constructor.getParameters();
        // 构造对象
        Student student = constructor.newInstance();

        // 获取到所有public修饰的方法    获取到所有的方法
        Method[] methods = studentClass.getMethods();
        Method[] declaredMethods = studentClass.getDeclaredMethods();

        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.println(method.getReturnType() + " " + method.getName() + "(" + Arrays.toString(parameters) + ")" );
        }

    }
}
