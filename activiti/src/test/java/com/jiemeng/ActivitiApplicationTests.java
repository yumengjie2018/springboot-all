package com.jiemeng;

import com.jiemeng.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ActivitiApplicationTests {

    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private SecurityUtil securityUtil;
    /**
     * 查看流程定义内容
     * activiti7可以自动部署流程
     */
    @Test
    public void findProcess() throws Exception {
        securityUtil.logInAs("jack");
        Page<ProcessDefinition> definitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        log.info("可用的流程定义总数:{}",definitionPage.getTotalItems());
        for (ProcessDefinition processDefinition : definitionPage.getContent()) {
            System.out.println("================================");
            log.info("流程定义内容：{}",processDefinition);
            System.out.println("================================");
        }

    }

    /**
     * 启动流程
     */
    @Test
    public void startProcess() throws Exception {
        //设置登录用户
        securityUtil.logInAs("system");
        ProcessInstance processInstance = processRuntime.
                start(ProcessPayloadBuilder.
                start().
                withProcessDefinitionKey("mydemo").
                build());
        log.info("流程实例的内容，{}",processInstance);
    }

    /**
     * 执行任务
     */
    @Test
    public void doTask() throws Exception {
        //设置登录用户
        securityUtil.logInAs("jerry");
        //查询任务
        Page<Task> taskPage = taskRuntime.tasks(Pageable.of(0, 10));
        if(taskPage!=null&&taskPage.getTotalItems()>0){
            for (Task task : taskPage.getContent()) {
                //拾取任务
                taskRuntime.claim(TaskPayloadBuilder.
                        claim().
                        withTaskId(task.getId()).
                        build());
                log.info("任务内容，{}",task);
                //完成任务
                taskRuntime.complete(TaskPayloadBuilder.
                        complete().
                        withTaskId(task.getId()).
                        build());
            }

        }



    }
}
