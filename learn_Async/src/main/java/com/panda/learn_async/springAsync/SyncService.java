package com.panda.learn_async.springAsync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SyncService {

    @Autowired
    private TestAsync testAsync;

    @GetMapping
    public void test(){
        testAsync.test();
        System.out.println("*******************");
        System.out.println("*******************");
        System.out.println("*******************");
        System.out.println("*******************");
    }
}
