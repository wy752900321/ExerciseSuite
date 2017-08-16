-- 使用时请替换时间和目标channel
select decode(t1.channel, 8, '天汉', 9, '亿美', 10, '百悟', 11, '朗宇行业', 12, '朗宇营销', 13, '朗宇语音', 14, 'welink-hy', 15, 'welink-yx')||'-'||t1.channel as 通道名称, 
t1.days,
(t1.successNum + nvl(t2.FAILNUM,0)) as 总提交数, 
t1.successNum as 提交成功数, 
t1.delivrdNum as 已到达数, 
t1.delivrdAmount as 已到达计费条数,
nvl(t2.FAILNUM,0) as 提交失败数 from 
(select t.channel,
to_char(t.createtime, 'yyyymmdd') as days,
 count(1) as successNum,sum(decode(DESCRIPTION,'DELIVRD',1,'True',1,0)) as delivrdNum, sum(decode(DESCRIPTION,'DELIVRD', z.times,'True',z.times)) as delivrdAmount from sms.SMS_SUCCESSED_SEND t, sms.SMS_BATCH_MANAGE z where t.BATCHID = z.BATCHID and 
t.CREATETIME BETWEEN to_date('2016-10-01','yyyy-mm-dd') and to_date('2016-11-01','yyyy-mm-dd') and t.channel in('10','11','12','14') group by t.CHANNEL,
to_char(t.createtime, 'yyyymmdd') ) t1
 left join
(select channel, 
to_char(t.createtime, 'yyyymmdd') as days,
count(1) as failNum from sms.SMS_FAILURE_SEND t where 
t.CREATETIME BETWEEN to_date('2016-10-01','yyyy-mm-dd') and to_date('2016-11-01','yyyy-mm-dd') and t.failuretype not in (30004, -16, 116, 117, -4, -18,-19) group by t.CHANNEL,
to_char(t.createtime, 'yyyymmdd')  ) t2
on t1.channel = t2.channel and t1.days = t2.days order by t1.channel , t1.days;
