
-- 查询每个通道总数量 / 成功数量 / 失败数量 / 成功率 【排除因手机号码错误\测试账号不符\ip不符等因素】
select decode(t1.channel, 8, '天汉', 9, '亿美', 10, '百悟', 11, '朗宇行业', 12, '朗宇营销', 13, '朗宇语音', 14, 'welink-hy', 15, 'welink-yx')||'-'||t1.channel as 通道名称, 
(t1.successNum + nvl(t2.FAILNUM,0)) as 总提交数, 
t1.successNum as 提交成功数, 
t1.delivrdNum as 已到达数, 
t1.delivrdAmount as 已到达计费条数,
nvl(t2.FAILNUM,0) as 提交失败数 from 
(select t.channel, count(1) as successNum,sum(decode(DESCRIPTION,'DELIVRD',1,'True',1,0)) as delivrdNum, sum(decode(DESCRIPTION,'DELIVRD',z.times,'True',z.times,0)) as delivrdAmount from sms.SMS_SUCCESSED_SEND t, sms.SMS_BATCH_MANAGE z where t.BATCHID = z.BATCHID and 
t.CREATETIME BETWEEN to_date('2016-08-01','yyyy-mm-dd') and to_date('2016-09-01','yyyy-mm-dd') group by t.CHANNEL) t1
 left join
(select channel, count(1) as failNum from sms.SMS_FAILURE_SEND t where 
t.CREATETIME BETWEEN to_date('2016-08-01','yyyy-mm-dd') and to_date('2016-09-01','yyyy-mm-dd') and t.failuretype not in (30004, -16, 116, 117, -4, -18,-19) group by t.CHANNEL ) t2
on t1.channel = t2.channel;




-- 查询每个通道总数量 / 成功数量 / 失败数量 / 成功率 【排除因手机号码错误\测试账号不符\ip不符等因素】
select decode(t1.channel, 8, '天汉', 9, '亿美', 10, '百悟', 11, '朗宇行业', 12, '朗宇营销', 13, '朗宇语音', 14, 'welink-hy', 15, 'welink-yx')||'-'||t1.channel as 通道名称, 
(t1.successNum + nvl(t2.FAILNUM,0)) as 总提交数, 
t1.successNum as 提交成功数, 
t1.delivrdNum as 已到达数, 
t1.delivrdAmount as 已到达计费条数,
nvl(t2.FAILNUM,0) as 提交失败数 from 
(select t.channel, count(1) as successNum,sum(decode(DESCRIPTION,'DELIVRD',1,'True',1,0)) as delivrdNum, sum(decode(DESCRIPTION,'DELIVRD',z.times,'True',z.times,0)) as delivrdAmount from sms.SMS_SUCCESSED_SEND t, sms.SMS_BATCH_MANAGE z where t.BATCHID = z.BATCHID and 
t.CREATETIME BETWEEN to_date('2016-10-01','yyyy-mm-dd') and to_date('2016-11-01','yyyy-mm-dd') group by t.CHANNEL) t1
 left join
(select channel, count(1) as failNum from sms.SMS_FAILURE_SEND t where 
t.CREATETIME BETWEEN to_date('2016-10-01','yyyy-mm-dd') and to_date('2016-11-01','yyyy-mm-dd') and t.failuretype not in (30004, -16, 116, 117, -4, -18,-19) group by t.CHANNEL ) t2
on t1.channel = t2.channel;



-- 5秒到达率的算法
-- select 1 / 24/60/60 * 5 from dual == 0.00005787037037037037037037037037037037037040

-- 查询每个通道总数量 / 成功数量 / 失败数量 / 成功率 【排除因手机号码错误\测试账号不符\ip不符等因素】
select decode(t1.channel, 8, '天汉', 9, '亿美', 10, '百悟', 11, '朗宇行业', 12, '朗宇营销', 13, '朗宇语音', 14, 'welink-hy', 15, 'welink-yx')||'-'||t1.channel as 通道名称, 
(t1.successNum + nvl(t2.FAILNUM,0)) as 总提交数, 
t1.successNum as 提交成功数, 
t1.delivrdNum as 已到达数, 
t1.delivrdNum4Sec5 as 已到达数forSec5, 
round(t1.delivrdNum4Sec5 / t1.delivrdNum * 100, 2) as sec5到达率,
t1.delivrdAmount as 已到达计费条数,
nvl(t2.FAILNUM,0) as 提交失败数 from 
(
select t.channel, count(1) as successNum,
sum(decode(DESCRIPTION,'DELIVRD',1,'True',1,0)) as delivrdNum, 
sum(case when decode(DESCRIPTION,'DELIVRD',1,'True',1,0) = 1 and t.SUCCESSTIME is not null and t.SUCCESSTIME - t.CREATETIME <= 0.00005787037037037037037037037037037037037040 then 1 else 0 end ) as delivrdNum4Sec5, 
sum(decode(DESCRIPTION,'DELIVRD',z.times,'True',z.times,0)) as delivrdAmount 
from sms.SMS_SUCCESSED_SEND t, sms.SMS_BATCH_MANAGE z where t.BATCHID = z.BATCHID and 
t.CREATETIME BETWEEN to_date('2016-10-01','yyyy-mm-dd') and to_date('2016-11-01','yyyy-mm-dd') group by t.CHANNEL) t1
 left join
(select channel, count(1) as failNum from sms.SMS_FAILURE_SEND t where 
t.CREATETIME BETWEEN to_date('2016-10-01','yyyy-mm-dd') and to_date('2016-11-01','yyyy-mm-dd') and t.failuretype not in (30004, -16, 116, 117, -4, -18,-19) group by t.CHANNEL ) t2
on t1.channel = t2.channel

