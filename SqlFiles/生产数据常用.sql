select * from pts.t_pts_trandata;
select * from pts.t_pts_trandata_extend;
select * from pts.T_PTS_CUP_Z_TRANDATA;
select * from pts.T_PTS_CUPOCBJ_TRANDATA;
select * from pts.T_PTS_CITIC_QR_TRANDATA;
select * from pts.T_PTS_WECHAT_TRANDATA;
select * from pts.T_PTS_XYDDBC_TRANDATA;
select * from pts.T_PTS_CMBCXM_TRANDATA;
select * from pts.T_PTS_SPDB_QR_TRANDATA;
select * from ses.T_SES_SET_ORD_INF;

select count(*),sum(TRAN_AMT) from pts.t_pts_trandata a 
where a.tran_sts = 'S'
and a.tran_dt = '20170405';

--
select count(1),sum(MEC_FEE_RATE) from  pts.t_pts_trandata_extend ex where ex.tran_dt = '20170405'
select count(1),sum(FEE_AMT) from  pts.T_PTS_CUP_Z_TRANDATA a where a.tran_dt = '20170405'
select count(1),sum(FEE_AMT) from  pts.T_PTS_CITIC_QR_TRANDATA a where a.tran_dt = '20170405'
select count(1),sum(a.SET_AMT) from ses.T_SES_SET_ORD_INF a where ARG_PAY_DT = '20170405'

select count(1),sum(TRAN_AMT) from T_PTS_CMBCXM_TRANDATA a where a.tran_dt = '20170405'
select count(1),sum(FEE_AMT) from T_PTS_XYDDBC_TRANDATA a where a.tran_dt = '20170405'

select 'pts.t_pts_trandata_extend' as tablename132,count(*) as count132,sum(MEC_FEE_RATE) as sum132 
from pts.t_pts_trandata_extend a 
where a.tran_dt = to_char(sysdate-1,'yyyymmdd')


select 'pts.T_PTS_CUP_Z_TRANDATA' as tablename132,count(*) as count132,sum(FEE_AMT) as sum132 
from pts.T_PTS_CUP_Z_TRANDATA a 
where a.tran_dt = to_char(sysdate-1,'yyyymmdd')

select 'T_PTS_CITIC_QR_TRANDATA' as tablename132,count(*) as count132,sum(FEE_AMT) as sum132 
from pts.T_PTS_CITIC_QR_TRANDATA a 
where a.tran_dt = to_char(sysdate-1,'yyyymmdd')

select 'T_SES_SET_ORD_INF' as tablename132,count(*) as count132,sum(SET_AMT) as sum132 
from ses.T_SES_SET_ORD_INF
where ARG_PAY_DT = to_char(sysdate-1,'yyyymmdd')

select 'T_PTS_CMBCXM_TRANDATA' as tablename132,count(*) as count132,sum(TRAN_AMT) as sum132 
from pts.T_PTS_CMBCXM_TRANDATA
where tran_dt = to_char(sysdate-1,'yyyymmdd')

select 'T_PTS_XYDDBC_TRANDATA' as tablename,count(*) as count132,sum(FEE_AMT) as sum132 
from pts.T_PTS_XYDDBC_TRANDATA
where tran_dt = to_char(sysdate-1,'yyyymmdd')
