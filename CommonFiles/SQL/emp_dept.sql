
# 测试数据建立
CREATE TABLE tmp_dept_hiloo
(
  deptno   LONG COMMENT '部门号',
  dname    VARCHAR(50) COMMENT '部门名称',
  location VARCHAR(50) COMMENT '位置(地区)'
);
ALTER TABLE tmp_dept_hiloo
  COMMENT ='部门信息';

INSERT INTO tmp_dept_hiloo VALUES (10, 'developer', 'beijing');
INSERT INTO tmp_dept_hiloo VALUES (20, 'account', 'shanghai');
INSERT INTO tmp_dept_hiloo VALUES (30, 'sales', 'guangzhou');
INSERT INTO tmp_dept_hiloo VALUES (40, 'operations', 'tianjin');
COMMIT;

CREATE TABLE tmp_emp_hiloo
(
  empno    LONG COMMENT '员工编号',
  ename    VARCHAR(50) COMMENT '员工姓名',
  job      VARCHAR(50) COMMENT '职位
',
  salary   NUMERIC COMMENT '工资',
  bonus    NUMERIC COMMENT '奖金',
  hiredate DATE COMMENT '入职日期',
  mgr      NUMERIC COMMENT '管理者',
  deptno   NUMERIC COMMENT '部门号'
);
ALTER TABLE tmp_emp_hiloo
  COMMENT = '员工信息表';

INSERT INTO tmp_emp_hiloo VALUES (1001, 'zhangwuji', 'Manager', 10000, 2000, '2012-05-10', 1005, 10);
INSERT INTO tmp_emp_hiloo VALUES (1001, 'zhangwuji', 'Manager', 10000, 2000, '2012-05-10', 1005, 10);
INSERT INTO tmp_emp_hiloo VALUES (1002, 'liucangsong', 'Analyst', 8000, 1000, '2010-03-01', 1001, 10);
INSERT INTO tmp_emp_hiloo VALUES (1003, 'liyi', 'Analyst', 9000, 1000, '2011-03-10', 1001, 10);
INSERT INTO tmp_emp_hiloo VALUES (1004, 'guofurong', 'Programmer', 5000, NULL, '2011-01-03', 1001, 10);
INSERT INTO tmp_emp_hiloo VALUES (1005, 'zhangsanfeng', 'President', 15000, NULL, '2015-08-03', NULL, 20);
INSERT INTO tmp_emp_hiloo VALUES (1006, 'yanxiaoliu', 'Manager', 5000, 400, '2001-09-08', 1005, 20);
INSERT INTO tmp_emp_hiloo VALUES (1007, 'luwushuang', 'clerk', 3000, 500, '2006-08-01', 1006, 20);
INSERT INTO tmp_emp_hiloo VALUES (1008, 'huangrong', 'Manager', 5000, 500, '2009-06-11', 1005, 30);
INSERT INTO tmp_emp_hiloo VALUES (1009, 'weixiaobao', 'salesman', 4000, NULL, '2010-03-20', 1008, 30);
INSERT INTO tmp_emp_hiloo VALUES (1010, 'guojing', 'salesman', 4500, 500, '2009-06-01', 1008, 30);
COMMIT;

# 求10部门的平均工资,显示部门号,平均工资
SELECT round(avg(salary))
FROM tmp_emp_hiloo
WHERE deptno = 10
GROUP BY deptno;

# 各个部门不同职位的平均工资
SELECT
  deptno,
  job,
  round(avg(salary))
FROM tmp_emp_hiloo
GROUP BY deptno, job;

# 每种奖金有多少人?
SELECT
  bonus,
  count(empno)
FROM tmp_emp_hiloo
GROUP BY bonus;

# 列出平均工资大于5000的部门的平均工资
SELECT
  deptno,
  round(avg(salary))
FROM tmp_emp_hiloo
GROUP BY deptno
HAVING round(avg(salary)) > 5000;

# 查看部门名称，员工好得多，部门编号
SELECT
  tdh.dname  部门名称,
  teh.ename  员工姓名,
  tdh.deptno 部门编号,
  teh.job    职位
FROM tmp_emp_hiloo teh INNER JOIN tmp_dept_hiloo tdh ON teh.deptno = tdh.deptno;

# 每个部门的工资总和
SELECT
  deptno      部门编号,
  sum(salary) 工资总和
FROM tmp_emp_hiloo
GROUP BY deptno;

# 各个职位的工资总和
SELECT
  deptno      部门编号,
  job         职位,
  sum(salary) 工资总和
FROM tmp_emp_hiloo
GROUP BY deptno, job;

# 查看部门名称，员工好得多，部门编号
SELECT
  tdh.dname  部门名称,
  teh.ename  员工姓名,
  tdh.deptno 部门编号,
  teh.job    职位
FROM tmp_emp_hiloo teh INNER JOIN tmp_dept_hiloo tdh ON teh.deptno = tdh.deptno
UNION ALL
SELECT
  deptno,
  sum(salary),
  NULL,
  NULL
FROM tmp_emp_hiloo
GROUP BY deptno;

#  每个部门的工资总和与明细汇总
SELECT
  a.*,
  b.*
FROM (SELECT
        tdh.dname  部门名称,
        teh.ename  员工姓名,
        tdh.deptno 部门编号,
        teh.job    职位
      FROM tmp_emp_hiloo teh INNER JOIN tmp_dept_hiloo tdh ON teh.deptno = tdh.deptno) a INNER JOIN (SELECT
                                                                                                       deptno      部门编号,
                                                                                                       sum(salary) 总资总和
                                                                                                     FROM tmp_emp_hiloo
                                                                                                     GROUP BY deptno) b
    ON a.部门编号 = b.部门编号;

#  各个职位的工资总和与明细汇总之和
SELECT
  a.*,
  b.*
FROM (SELECT
        tdh.dname  部门名称,
        teh.ename  员工姓名,
        tdh.deptno 部门编号,
        teh.job    职位
      FROM tmp_emp_hiloo teh INNER JOIN tmp_dept_hiloo tdh ON teh.deptno = tdh.deptno) a INNER JOIN (SELECT
                                                                                                       deptno      部门编号,
                                                                                                       job         职位,
                                                                                                       sum(salary) 工资总和
                                                                                                     FROM tmp_emp_hiloo
                                                                                                     GROUP BY deptno,
                                                                                                       job) b
    ON a.部门编号 = b.部门编号 AND a.职位 = b.职位;
