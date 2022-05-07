package com.panda.learn_spring_boot;

import com.panda.learn_spring_boot.base.config.ValidationUtil;
import com.panda.learn_spring_boot.base.config.Xiong;
import com.panda.learn_spring_boot.base.domain.Account;
import com.panda.learn_spring_boot.base.domain.Student;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JunitTest {
    @Test
    public void test5() throws IOException {
        Account account = new Account();
        //account.setUserName("wo");
        account.setPassWord("test");
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(account, Xiong.class);
        if (validResult.hasErrors()) {
            String errors = validResult.getErrors();
            System.out.println(errors);
        }
    }

    @Test
    public void test3() {
        Student a = new Student();
        Student b = new Student();
        Student c = new Student();

        //test4(a,b,c);
//        test4(a,b,null);
//        test4(null,null,c);
        test4(null, b, c);
    }

    public void test4(Student a, Student b, Student c) {
        if (ObjectUtils.allNull(a, b, c) ||
                ObjectUtils.allNotNull(a, b, c)) {
            System.out.println("不互斥");
        }

    }

    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        // 7

        List<List<String>> lists = averageList(list, 2);

        for (List<String> strings : lists) {
            System.out.println(strings);
        }

    }

    public static <T> List<List<T>> averageList(List<T> list, int n) {
        List<List<T>> result = new ArrayList<>();
        int number = list.size() / n;
        for (int i = 0; i <= number; i++) {
            List<T> tem = null;
            if (i != number) {
                tem = list.subList(i * n, (i + 1) * n);
                result.add(tem);
            } else if (i * n != list.size()) {
                tem = list.subList(i * n, list.size());
                result.add(tem);
            }
        }
        return result;
    }

}
