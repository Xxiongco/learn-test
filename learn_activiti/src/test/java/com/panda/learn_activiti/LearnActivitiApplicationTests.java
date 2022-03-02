package com.panda.learn_activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LearnActivitiApplicationTests {


    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    LearnActivitiApplicationTests() {
    }

    @Test
    void contextLoads() {

    }


    // 部署流程定义
    @Test
    void test() {
        // 部署流程定义
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/first.bpmn20.xml").deploy();
        System.out.println(deployment.getId());

        //获取流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        //启动流程定义，返回流程实例
        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());
        String processId = pi.getId();
        System.out.println("流程创建成功，当前流程实例ID：" + processId);
        // 查询任务
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第一次执行前，任务名称：" + task.getName());
        // 完成这个任务
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第二次执行前，任务名称：" + task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("task为null，任务执行完毕：" + task);

        /**
         *
         * 流程创建成功，当前流程实例ID：2505
         * 第一次执行前，任务名称：??
         * 第二次执行前，任务名称：??
         * task为null，任务执行完毕：null
         *
         */
    }

    // 启动流程实例
    @Test
    void testOpenTask() {
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/second.bpmn20.xml").deploy();
        //获取流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        //启动流程定义，返回流程实例
        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());
        String processId = pi.getId();
        System.out.println("流程创建成功，当前流程实例ID：" + processId);

        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第一次执行前，任务名称：" + task.getName());
        // 完成任务
        taskService.complete(task.getId());


        /**
         * 流程创建成功，当前流程实例ID：5005
         * 第一次执行前，任务名称：one
         * 第二次执行前，任务名称：two
         * task为null，任务执行完毕：null
         */
    }

    // 完成我的任务

    @Test
    void testCompleteMyTask() {
        Long taskId = 5011L;
        taskService.complete(taskId.toString());

    }

    @Test
    void test3(){

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/third.bpmn20.xml").deploy();
        //获取流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        //启动流程定义，返回流程实例
        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());
        String processId = pi.getId();
        System.out.println("流程创建成功，当前流程实例ID：" + processId);
        /**
         *流程创建成功，当前流程实例ID：7505
         */
    }

    // 查询我的任务

    @Test
    void getMyTask(){
        List<Task> list = taskService.createTaskQuery().taskAssignee("xiong").list();
        System.out.println(list.size());
        for (Task task : list) {
            System.out.println(task);
        }

    }

    // 查询状态
    @Test
    void getStatus(){
        Long  processInstanceId = 10005L;
        ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
        ProcessInstance pi = processInstanceQuery.processInstanceId(processInstanceId.toString()).singleResult();

        System.out.println(pi.getName());

    }




}
