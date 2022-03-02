package com.panda.learn_spring_boot;

import com.panda.learn_spring_boot.config.ValidationUtil;
import com.panda.learn_spring_boot.config.Xiong;
import com.panda.learn_spring_boot.domain.Account;
import org.junit.Test;

import java.io.IOException;

public class JunitTest {
    @Test
    public void test5() throws IOException {
        Account account = new Account();
        //account.setUserName("wo");
        account.setPassWord("test");
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(account, Xiong.class);
        if(validResult.hasErrors()){
            String errors = validResult.getErrors();
            System.out.println(errors);
        }
    }

}
