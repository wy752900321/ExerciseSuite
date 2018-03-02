package cn.itcast.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * 流程任务想着测试
 */
public class ActTaskServiceTest {

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 测试是否能获取到工作流引擎对象
     */
    @Test
    public void getProcessEngine() {
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")    //
                .buildProcessEngine();
        System.out.println("processEngine:" + processEngine);

    }

    // 查询流程定义
    @Test
    public void findProcessDifinitionList() {
        List<ProcessDefinition> list = processEngine.getRepositoryService()
                .createProcessDefinitionQuery()
                // 查询条件
                .processDefinitionKey("DataExtractProcess")// 按照流程定义的key
//                 .processDefinitionId("DataextractProcess:2:77504")//按照流程定义的ID
                .orderByProcessDefinitionVersion().desc()// 排序
                // 返回结果
                // .singleResult()//返回惟一结果集
                // .count()//返回结果集数量
                // .listPage(firstResult, maxResults)
                .list();// 多个结果集

        if (list != null && list.size() > 0) {
            for (ProcessDefinition pd : list) {
                System.out.println("流程定义的ID：" + pd.getId());
                System.out.println("流程定义的名称：" + pd.getName());
                System.out.println("流程定义的Key：" + pd.getKey());
                System.out.println("流程定义的部署ID：" + pd.getDeploymentId());
                System.out.println("流程定义的资源名称：" + pd.getResourceName());
                System.out.println("流程定义的版本：" + pd.getVersion());
                System.out.println("########################################################");
            }
        }

    }

    /**
     * 查询当前人的个人任务
     */
    @Test
    public void findMyPersonalTask() {
        //指定办理人id
        String assignee = "1";
        List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询对象
                /**查询条件（where部分）*/
                .taskAssignee(assignee)//指定个人任务查询，指定办理人
//						.taskCandidateUser(candidateUser)//组任务的办理人查询
//						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
//						.processInstanceId(processInstanceId)//使用流程实例ID查询
//						.executionId(executionId)//使用执行对象ID查询
                /**排序*/
                .orderByTaskCreateTime().asc()//使用创建时间的升序排列
                /**返回结果集*/
//						.singleResult()//返回惟一结果集
//						.count()//返回结果集的数量
//						.listPage(firstResult, maxResults);//分页查询
                .list();//返回列表
        if (list != null && list.size() > 0) {
            for (Task task : list) {
                System.out.println("任务ID:" + task.getId());
                System.out.println("任务名称:" + task.getName());
                System.out.println("任务的创建时间:" + task.getCreateTime());
                System.out.println("任务的办理人:" + task.getAssignee());
                System.out.println("流程实例ID：" + task.getProcessInstanceId());
                System.out.println("执行对象ID:" + task.getExecutionId());
                System.out.println("流程定义ID:" + task.getProcessDefinitionId());
                System.out.println("########################################################");
            }
        }
    }

    /**
     * 完成我的任务
     */
    @Test
    public void completeMyPersonalTask() {
        //任务ID
        String taskId = "1202";
        processEngine.getTaskService()//与正在执行的任务管理相关的Service
                .complete(taskId);
        System.out.println("完成任务：任务ID：" + taskId);
    }

    /**
     * 查询流程状态（判断流程正在执行，还是结束）
     */
    @Test
    public void isProcessEnd() {
        String processInstanceId = "1001";
        ProcessInstance pi = processEngine.getRuntimeService()//表示正在执行的流程实例和执行对象
                .createProcessInstanceQuery()//创建流程实例查询
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();
        if (pi == null) {
            System.out.println("流程已经结束");
        } else {
            System.out.println("流程没有结束");
        }
    }


    /**
     * 启动流程实例+设置流程变量+获取流程变量+向后执行一步
     */
    @Test
    public void startProcessInstance() {
        //流程定义的key
        String processDefinitionKey = "receiveTask";
        ProcessInstance pi = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
                .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
        System.out.println("流程实例ID:" + pi.getId());//流程实例ID    101
        System.out.println("流程定义ID:" + pi.getProcessDefinitionId());//流程定义ID   helloworld:1:4

        /**查询执行对象ID*/
        Execution execution1 = processEngine.getRuntimeService()//
                .createExecutionQuery()//创建执行对象查询
                .processInstanceId(pi.getId())//使用流程实例ID查询
                .activityId("receivetask1")//当前活动的id，对应receiveTask.bpmn文件中的活动节点id的属性值
                .singleResult();

        /**判断流程是否结束，查询正在执行的执行对象表*/
        ProcessInstance rpi = processEngine.getRuntimeService()//
                .createProcessInstanceQuery()//创建流程实例查询对象
                .processInstanceId(pi.getId())
                .singleResult();
        //说明流程实例结束了
        if (rpi == null) {
            /**查询历史，获取流程的相关信息*/
            HistoricProcessInstance hpi = processEngine.getHistoryService()//
                    .createHistoricProcessInstanceQuery()//
                    .processInstanceId(pi.getId())//使用流程实例ID查询
                    .singleResult();
            System.out.println(hpi.getId() + "    " + hpi.getStartTime() + "   " + hpi.getEndTime() + "   " + hpi.getDurationInMillis());
        }

        /**使用流程变量设置当日销售额，用来传递业务参数*/
        processEngine.getRuntimeService()//
                .setVariable(execution1.getId(), "汇总当日销售额", 21000);

        /**向后执行一步，如果流程处于等待状态，使得流程继续执行*/
        processEngine.getRuntimeService()
                .signal(execution1.getId());

        /**查询执行对象ID*/
        Execution execution2 = processEngine.getRuntimeService()//
                .createExecutionQuery()//创建执行对象查询
                .processInstanceId(pi.getId())//使用流程实例ID查询
                .activityId("receivetask2")//当前活动的id，对应receiveTask.bpmn文件中的活动节点id的属性值
                .singleResult();

        /**从流程变量中获取汇总当日销售额的值*/
        Integer value = (Integer) processEngine.getRuntimeService()//
                .getVariable(execution2.getId(), "汇总当日销售额");
        System.out.println("给老板发送短信：金额是：" + value);
        /**向后执行一步，如果流程处于等待状态，使得流程继续执行*/
        processEngine.getRuntimeService()
                .signal(execution2.getId());

    }

    /**
     * 拾取任务，将组任务分给个人任务，指定任务的办理人字段
     */
    @Test
    public void claim() {
        //将组任务分配给个人任务
        //任务ID
        String taskId = "7504";
        //分配的个人任务（可以是组任务中的成员，也可以是非组任务的成员）
        String userId = "张三";
        processEngine.getTaskService()//
                .claim(taskId, userId);
    }


    /**
     * 将个人任务回退到组任务，前提，之前一定是个组任务
     */
    @Test
    public void setAssigee() {
        //任务ID
        String taskId = "6204";
        processEngine.getTaskService()//
                .setAssignee(taskId, null);
    }


}
