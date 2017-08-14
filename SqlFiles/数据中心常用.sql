select * from t_pts_trandata;
select * from t_pts_trandata_extend;
select * from T_PTS_CUP_Z_TRANDATA;
select * from T_PTS_CUPOCBJ_TRANDATA;
select * from T_PTS_CITIC_QR_TRANDATA;
select * from T_PTS_WECHAT_TRANDATA;
select * from T_PTS_XYDDBC_TRANDATA;
select * from T_PTS_CMBCXM_TRANDATA;
select * from T_PTS_SPDB_QR_TRANDATA;
select * from T_SES_SET_ORD_INF;

select count(*),sum(TRAN_AMT) from t_pts_trandata a 
where a.tran_sts = 'S'
and a.tran_dt = '20170405';

select to_date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') from dual;
select to_char(sysdate-1,'yyyymmdd') from dual;


select count(*),sum(TRAN_AMT) from t_pts_trandata a 
where a.tran_sts = 'S'
and a.tran_dt = to_char(sysdate-1,'yyyymmdd');


select count(*) as count164,sum(TRAN_AMT) as sum164 from t_pts_trandata a 
where a.tran_sts = 'S'
and a.tran_dt = to_char(sysdate-1,'yyyymmdd');

select count(*) as count2 from t_pts_trandata


select * from t_pts_trandata_extend;


select 't_pts_trandata_extend' as tablename164,count(*) count164,sum(MEC_FEE_RATE) as sum164 
from t_pts_trandata_extend
where tran_dt = to_char(sysdate-1,'yyyymmdd')

select count(1),sum(MEC_FEE_RATE) from  t_pts_trandata_extend ex where ex.tran_dt = to_char(sysdate-1,'yyyymmdd')

select 't_pts_trandata_extend' as tablename164,count(*) count164,sum(MEC_FEE_RATE) as sum164 
from t_pts_trandata_extend
where tran_dt = to_char(sysdate-1,'yyyymmdd')

--
select count(1),sum(MEC_FEE_RATE) from  pts.t_pts_trandata_extend ex where ex.tran_dt = '20170405'
select count(1),sum(FEE_AMT) from  pts.T_PTS_CUP_Z_TRANDATA a where a.tran_dt = '20170405'
select count(1),sum(FEE_AMT) from  pts.T_PTS_CITIC_QR_TRANDATA a where a.tran_dt = '20170405'
select count(1),sum(a.SET_AMT) from ses.T_SES_SET_ORD_INF a where ARG_PAY_DT = '20170405'

select count(1),sum(TRAN_AMT) from T_PTS_CMBCXM_TRANDATA a where a.tran_dt = '20170405'
select count(1),sum(FEE_AMT) from T_PTS_XYDDBC_TRANDATA a where a.tran_dt = '20170405'


--
select 'T_PTS_CUP_Z_TRANDATA' as tablename164,count(*) count164,sum(FEE_AMT) as sum164 
from T_PTS_CUP_Z_TRANDATA
where tran_dt = to_char(sysdate-1,'yyyymmdd')

select 'T_PTS_CITIC_QR_TRANDATA' as tablename164,count(*) count164,sum(FEE_AMT) as sum164 
from T_PTS_CITIC_QR_TRANDATA
where tran_dt = to_char(sysdate-1,'yyyymmdd')


select count(*) count164,sum(TRAN_AMT) as sum164 
from T_PTS_CMBCXM_TRANDATA
where tran_dt = to_char(sysdate-1,'yyyymmdd')

select count(*) count164,sum(FEE_AMT) as sum164 
from T_PTS_XYDDBC_TRANDATA
where tran_dt = to_char(sysdate-1,'yyyymmdd')

select /*+parallel(a 6)*/  't_pts_trandata_extend' as tablename,count(*) as count132
from pts.t_pts_trandata_extend a
where a.tran_dt = to_char(sysdate-1,'yyyymmdd')

select /*+parallel(a 6)*/  't_pts_trandata_extend' as tablename,count(*) as count132
from t_pts_trandata_extend a
where a.tran_dt = to_char(sysdate-1,'yyyymmdd')



select /*+parallel(a 4)*/ sum(MEC_FEE_RATE) as sum132 
from t_pts_trandata_extend a 
where a.tran_dt = to_char(sysdate-1,'yyyymmdd')



select  sum(MEC_FEE_RATE) as sum132 
from t_pts_trandata_extend a 
where a.tran_dt = to_char(sysdate-1,'yyyymmdd')

