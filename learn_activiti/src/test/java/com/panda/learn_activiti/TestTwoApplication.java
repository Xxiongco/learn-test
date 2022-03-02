package com.panda.learn_activiti;


import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestTwoApplication {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private IdentityService identityService;

    void creatUser(String id, String name) {
        // 使用newUser方法创建User实例
        User user = identityService.newUser(id);
        // 设置用户的各个属性
        user.setFirstName(name);
        user.setLastName("last-" + name);
        user.setEmail(name + "@qq.com");
        user.setPassword(name);
        // 使用saveUser方法保存用户
        identityService.saveUser(user);
    }

    @Test
    void createUser(){

        creatUser("1","xiong");
        creatUser("2","hong");
        creatUser("3","ding");

    }



    /**
     * 定义完整的一个流程。
     */

    /**
     * 部署定义   `ACT_RE_DEPLOYMENT`
     */
    @Test
    void deploy(){
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/third.bpmn20.xml").
                name("请假流程").deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());

    }
    /**
     * 启动一个流程
     */
    @Test
    void start(){

        Long id = 37501L;

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(id.toString()).singleResult();

        System.out.println(processDefinition.getId());
        System.out.println(processDefinition.getName());

        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());


        System.out.println(pi.getId());
        System.out.println(pi.getName());


    }
    // 查看我的任务
    @Test
    void getMyTask(){
        String assignee = "hong";

        List<Task> list = taskService.createTaskQuery().taskAssignee(assignee).list();

        for (Task task : list) {
            System.out.println(task);
        }

    }
    // 完成节点的工作
    @Test
    void completeMyTask(){
        Long taskId = Long.valueOf(50002);
        taskService.complete(taskId.toString());

    }


}
