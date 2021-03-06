package org.panda.learn_lua.controller;

import com.alibaba.fastjson.JSON;
import org.panda.learn_lua.domian.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.ResponseEntity;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Gjing
 **/
@RestController
public class LockController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/lua")
    public ResponseEntity lua() {

        DefaultRedisScript<Void> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/test.lua")));
        redisScript.setResultType(Void.class);

        Student student1 = new Student("panda");
        Student student2 = new Student("xian bei");
        Student student3 = new Student("he");
        Student student4 = new Student("feng");

        ArrayList<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Student student : list) {
            mapList.add(student.buildHashValue());
        }


        stringRedisTemplate.execute(redisScript, Collections.emptyList(), JSON.toJSONString(mapList));
        System.out.println("yes");

        return ResponseEntity.ok(null);
    }
}