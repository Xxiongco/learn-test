package com.panda.learn_spring_boot.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.*;

import java.lang.reflect.Method;

/**
 *
 *Advisor时不会直接实现Advisor的接口，而是实现Advisor接口的子接口，
 * PointcutAdvisor或IntroductionAdvisor，一般来说不用后则
 *
 *
 */

public class MyAdvisor implements PointcutAdvisor {

    @Override
    public Advice getAdvice() {
        return new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("BeforeAdvice实现，在目标方法被调用前调用，目标方法是：" + method.getDeclaringClass().getName() + "."
                        + method.getName());
            }
        };
    }

    @Override
    public boolean isPerInstance() {
        return true;
    }

    @Override
    public Pointcut getPointcut() {
        /**
         * 简单的Pointcut定义，匹配所有类的find方法调用。
         */
        return new Pointcut() {

            @Override
            public ClassFilter getClassFilter() {
                return ClassFilter.TRUE;
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {

                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        String methodName = method.getName();
                        if ("find".equals(methodName)) {
                            return true;
                        }
                        return false;
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> targetClass, Object[] args) {
                        return false;
                    }

                };
            }

        };
    }

}