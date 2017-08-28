# xx-job 1.8中的所有表：
# xxl_job_qrtz_blob_triggers,xxl_job_qrtz_calendars,xxl_job_qrtz_cron_triggers,xxl_job_qrtz_fired_triggers,xxl_job_qrtz_job_details,xxl_job_qrtz_locks,xxl_job_qrtz_paused_trigger_grps,
# xxl_job_qrtz_scheduler_state,xxl_job_qrtz_simple_triggers,xxl_job_qrtz_simprop_triggers,xxl_job_qrtz_trigger_group,xxl_job_qrtz_trigger_info,xxl_job_qrtz_trigger_log
# xxl_job_qrtz_trigger_logglue,xxl_job_qrtz_trigger_registry,xxl_job_qrtz_triggers
#
# 其中有关联关系的如下：
# xxl_job_qrtz_job_details(SCHED_NAME,JOB_NAME,JOB_GROUP)->xxl_job_qrtz_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)->
# xxl_job_qrtz_simple_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)、
# xxl_job_qrtz_simprop_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)、
# xxl_job_qrtz_cron_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)、
# xxl_job_qrtz_blob_triggers(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
#
# 任务描述 helloworld
# Cron  0/3 * * * * ?
# 0 0/5 * * * ? *
# JobHandler* demoJobHandler
# 存在关联开始----------------------------------------
# 作业任务,新建一个任务对应一条记录
SELECT SCHED_NAME,
  JOB_NAME,
  JOB_GROUP
FROM xxl_job_qrtz_job_details;

SELECT
  SCHED_NAME,
  TRIGGER_NAME,
  TRIGGER_GROUP
FROM xxl_job_qrtz_triggers;

# 原TRIGGER_NAME
SELECT SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP FROM xxl_job_qrtz_simple_triggers;
# 记录编号,新建一个任务对应一条记录.触发器记录，sched_name,trigger_name,trigger_group,cron_expression,time_zone_id
SELECT SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP FROM xxl_job_qrtz_cron_triggers;
SELECT SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP FROM xxl_job_qrtz_simprop_triggers;
SELECT SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP FROM xxl_job_qrtz_blob_triggers;

# 关联删除，顺序执行
DELETE FROM xxl_job_qrtz_simple_triggers WHERE 1=1;
DELETE FROM xxl_job_qrtz_simprop_triggers WHERE 1=1;
DELETE FROM xxl_job_qrtz_cron_triggers WHERE 1=1;
DELETE FROM xxl_job_qrtz_blob_triggers WHERE 1=1;

DELETE FROM xxl_job_qrtz_triggers WHERE 1=1;

DELETE FROM xxl_job_qrtz_job_details WHERE 1=1;
COMMIT ;
# 存在关联结束----------------------------------------------------

# 其它开始----------------------------------------------------
SELECT * from xxl_job_qrtz_calendars;
SELECT * from xxl_job_qrtz_fired_triggers;
SELECT * from xxl_job_qrtz_locks;
SELECT * from xxl_job_qrtz_paused_trigger_grps;
# 调度状态记录，包括电话主机名
SELECT * from xxl_job_qrtz_scheduler_state;
# 【重要，不能删除】执行器信息表，维护任务执行器信息；执行器分组。系统需要至少预留一个默认分组
SELECT * from xxl_job_qrtz_trigger_group;
# 执行器注册表，维护在线的执行器和调度中心机器地址信息.注册触发器记录
SELECT * from xxl_job_qrtz_trigger_registry;
# 调度扩展信息表： 用于保存XXL-JOB调度任务的扩展信息，如任务分组、任务名、机器地址、执行器、执行入参和报警邮件等等；
SELECT * from xxl_job_qrtz_trigger_info;
# 调度日志表： 用于保存XXL-JOB任务调度的历史信息，如调度结果、执行结果、调度入参、调度机器和执行器等等；
SELECT * from xxl_job_qrtz_trigger_log;
# 任务GLUE日志：用于保存GLUE更新历史，用于支持GLUE的版本回溯功能；
SELECT * from xxl_job_qrtz_trigger_logglue;
;
# 触发器
SELECT * from xxl_job_qrtz_triggers;
# 其它结束----------------------------------------------------
# ------------------------------------
# 查看执行器
SELECT * FROM XXL_JOB_QRTZ_TRIGGER_GROUP AS t ORDER BY t.order ASC;
# 新建任务
SELECT * from xxl_job_qrtz_trigger_info;
UPDATE xxl_job_qrtz_trigger_info SET executor_param='{"task_name":"完成数据分发","datasource_name":"mysql_JIADP","recipient_lists":"jiadp@cenrise.com,zahngwe@qq.com,qiyi@qq.com","cc_lists":"jiadp@cenrise.com,zahngwe@qq.com,qiyi@qq.com","subtasks":[{"subtask_name":"查询SQL列表","sql":"select * from T_SQL_TASK_LIST;"},{"subtask_name":"查询数据源表","sql":"select * from T_DATASOURCE;"}]}' WHERE id=1;
#SQL任务
SELECT * from T_SQL_TASK_LIST;
# ------------------------------
commit;
# 查看数据源
select * from T_DATASOURCE;
UPDATE T_DATASOURCE SET  password = 'hr+Jw/HlVu/aYoIWmpPw4pICoHTJHt2ZT7HzQfhFcazbzd0HmaMeTQTAnqJx3sJVAC2AsbPk0rUeUXW4dgiJZRbzdA4IkjAoNYtuFnP4lcXMtJxV1YykpGozMgvTvUPGee+uFfIQM+i1lPkoEFZ1GGEh1/nkRFcEfpEwjdbJuoI=' WHERE password='root';
UPDATE T_DATASOURCE SET  password = 'Vv98NEFYOsf07eFyTEJfIxaXWCv05cRxubQwdbR+0QrMzVdBkVnpjsagotU7WQC/lycJctMZypTiJ2vQF/DO0Xrf2uSE9bcoyWuAPZYxKpzxyBHhgWmb3fPVjbEg2HeD48S2AML0RMhxUfEAtVR2YSvzZ05u3yreL8aV5B6WqTY=' WHERE password='123456';
UPDATE T_DATASOURCE SET  password = 'P7F0ytB3dpaIBcmH2812zN6r/4HwJqn7NEz+HqvWEFAaT2qPmFJjKGJgcEoDcdsuAurK3l+uga4TosDtwghqlEymASH0ekWBTf6P4RUhEkvh+bJC5cBYxasdsAWv83OMTFVuQrliCIGSlIMG0ugnoKO/D2e1nJHgaBKjf7zQ2E8=' WHERE password='query_on';

INSERT INTO T_DATASOURCE (connectionName, type, hostName, dbName, code, username, password)
VALUES ("test_101", "mysql", "localhost", "xxl_job", "3306", "root", "root");

UPDATE T_DATASOURCE SET type="mysql" WHERE id=1;




# 变更的表
drop TABLE xxl_job_vbill_sql_task_list;
drop TABLE xxl_job_vbill_datasource;

drop TABLE T_SQL_TASK_LIST;
drop TABLE T_DATASOURCE;

CREATE DATABASE IF NOT EXISTS dmp DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
--  SQL执行器列表
CREATE TABLE T_SQL_TASK_LIST
(
  id      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  sqllist TEXT
);


SELECT  * from XXL_JOB_QRTZ_TRIGGER_GROUP;

SELECT * from T_SQL_TASK_LIST;

CREATE DATABASE IF NOT EXISTS xxl_job DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

# 查看执行日志
SELECT id,job_group,job_id,executor_handler,executor_param,handle_msg from xxl_job_qrtz_trigger_log ORDER BY trigger_time DESC ;

SELECT id,job_group,job_id,executor_handler,executor_param,handle_msg
		FROM XXL_JOB_QRTZ_TRIGGER_LOG AS t
		WHERE t.id = 89610;

select * from T_DATASOURCE;

select * from DMP.T_DATASOURCE where connectionName="mysql_JIADP";

select * from T_SQL_TASK_LIST;
select * from T_DATASOURCE where connectionName='querydb_132';


SELECT * from T_DATASOURCE;
