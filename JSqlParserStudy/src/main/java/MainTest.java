import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.util.AddAliasesVisitor;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.io.StringReader;
import java.util.List;

/**
 * Created by ThinkPad on 2017/7/26.
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            //Simple SQL parsing
            Statement stmt = CCJSqlParserUtil.parse("SELECT * FROM tab1");
//        SQL script parsing
            Statements stmt2 = CCJSqlParserUtil.parseStatements("SELECT * FROM tab1; SELECT * FROM tab2");
//        Simple Expression parsing
            Expression expr = CCJSqlParserUtil.parseExpression("a*(5+mycolumn)");

//            Extract table names from SQL

            Statement statement = CCJSqlParserUtil.parse("SELECT * FROM MY_TABLE1");
            Select selectStatement = (Select) statement;
            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            List<String> tableList = tablesNamesFinder.getTableList(selectStatement);

//            Apply aliases to all expressions

            Select select = (Select) CCJSqlParserUtil.parse("select a,b,c from test");
            final AddAliasesVisitor instance = new AddAliasesVisitor();
            select.getSelectBody().accept(instance);

            System.out.println("开始！");

            String sqlparsStr = "WITH T AS\n" +
                    "(\n" +
                    "SELECT\n" +
                    "SUBSTR(T.字段,1,3) AS 交易卡类型,\n" +
                    "SUBSTR(T.字段,5) AS 交易卡号\n" +
                    "FROM(\n" +
                    "SELECT\n" +
                    "(CASE \n" +
                    "WHEN RU=1 THEN '交易卡*/giv+/XLX8M35fG+5w407A=='\n" +
                    "WHEN RU=2 THEN '结算卡*/LXy9KDUIDOgAF4TUhg=='\n" +
                    "WHEN RU=3 THEN '结算卡*/om7FMl/JfZ2KpK0g51jcg=='\n" +
                    "WHEN RU=4 THEN '结算卡*/pk/SsxprWtGcG/dpo/GmA=='\n" +
                    "WHEN RU=5 THEN '交易卡*+1wvpLx/Wwc35fG+5w407A=='\n" +
                    "WHEN RU=6 THEN '交易卡*1JoygcOQReQ35fG+5w407A=='\n" +
                    "WHEN RU=7 THEN '交易卡*2zg+7PWosG835fG+5w407A=='\n" +
                    "WHEN RU=8 THEN '结算卡*3yPXkdlRjVdfybYk3a0nhQ=='\n" +
                    "WHEN RU=9 THEN '交易卡*6iy17xXmsu035fG+5w407A=='\n" +
                    "WHEN RU=10 THEN '结算卡*6JeVGFViNIii5wphqDnlPw=='\n" +
                    "WHEN RU=11 THEN '交易卡*6XqC3OojCY435fG+5w407A=='\n" +
                    "WHEN RU=12 THEN '交易卡*77baRI1R2Zw35fG+5w407A=='\n" +
                    "WHEN RU=13 THEN '交易卡*7ACb8sd2f/Y35fG+5w407A=='\n" +
                    "WHEN RU=14 THEN '结算卡*7ct5Zi57E+9dUZ246n/Yfg=='\n" +
                    "WHEN RU=15 THEN '结算卡*7ntO0yfzXlyJehW+kRLQrA=='\n" +
                    "WHEN RU=16 THEN '交易卡*81/V1Z6V+hU35fG+5w407A=='\n" +
                    "WHEN RU=17 THEN '结算卡*8iMCYvXpEMY35fG+5w407A=='\n" +
                    "WHEN RU=18 THEN '交易卡*8pXWh24CQXI35fG+5w407A=='\n" +
                    "WHEN RU=19 THEN '结算卡*9tO1IYJh0Yiz1gMvnMetJw=='\n" +
                    "WHEN RU=20 THEN '交易卡*Ag4bDR7HHxs35fG+5w407A=='\n" +
                    "WHEN RU=21 THEN '交易卡*azgggUrc0YM35fG+5w407A=='\n" +
                    "WHEN RU=22 THEN '结算卡*BBZag1dxuNfUefKSk5ffPg=='\n" +
                    "WHEN RU=23 THEN '交易卡*BcslkK2X1cE35fG+5w407A=='\n" +
                    "WHEN RU=24 THEN '交易卡*bgiM0tRttwo35fG+5w407A=='\n" +
                    "WHEN RU=25 THEN '交易卡*bY7XI7ujVP435fG+5w407A=='\n" +
                    "WHEN RU=26 THEN '交易卡*cDCDIRekveHrxbA3HONwyA=='\n" +
                    "WHEN RU=27 THEN '交易卡*Ceny5ZwI5xA35fG+5w407A=='\n" +
                    "WHEN RU=28 THEN '交易卡*cocZ34IfvsptlM59Iyf7gQ=='\n" +
                    "WHEN RU=29 THEN '交易卡*e2bptN0uI4U35fG+5w407A=='\n" +
                    "WHEN RU=30 THEN '交易卡*eipSkR5dRAQ35fG+5w407A=='\n" +
                    "WHEN RU=31 THEN '结算卡*f00AB/Ugu70Bl+48tlFCTg=='\n" +
                    "WHEN RU=32 THEN '交易卡*fhM5VbdIeL835fG+5w407A=='\n" +
                    "WHEN RU=33 THEN '交易卡*G/nW+ZI6M6s35fG+5w407A=='\n" +
                    "WHEN RU=34 THEN '交易卡*GkKjw3JFpEI35fG+5w407A=='\n" +
                    "WHEN RU=35 THEN '交易卡*h1lgPaHqDbA35fG+5w407A=='\n" +
                    "WHEN RU=36 THEN '结算卡*hHAnHlZncg9YA5aWmlzoNw=='\n" +
                    "WHEN RU=37 THEN '交易卡*ID4WderfR5035fG+5w407A=='\n" +
                    "WHEN RU=38 THEN '交易卡*IGjF1THLTAc35fG+5w407A=='\n" +
                    "WHEN RU=39 THEN '交易卡*iJdaRS0bl2c35fG+5w407A=='\n" +
                    "WHEN RU=40 THEN '交易卡*ikRYrEjixhs35fG+5w407A=='\n" +
                    "WHEN RU=41 THEN '交易卡*iuH0AYkc3NE35fG+5w407A=='\n" +
                    "WHEN RU=42 THEN '交易卡*jEdXesC70Gk35fG+5w407A=='\n" +
                    "WHEN RU=43 THEN '交易卡*kbnOq+vxVfg35fG+5w407A=='\n" +
                    "WHEN RU=44 THEN '交易卡*LDHnvMTwqIQ35fG+5w407A=='\n" +
                    "WHEN RU=45 THEN '结算卡*Ls4GJgrXdtAy/kNMU6cZsg=='\n" +
                    "WHEN RU=46 THEN '结算卡*LY0QW+fj6qEjx7BpQkNSCw=='\n" +
                    "WHEN RU=47 THEN '交易卡*lZyrrMTyZ6835fG+5w407A=='\n" +
                    "WHEN RU=48 THEN '交易卡*mlXyPiYBCUk35fG+5w407A=='\n" +
                    "WHEN RU=49 THEN '交易卡*MOuG0Zx0ntw35fG+5w407A=='\n" +
                    "WHEN RU=50 THEN '交易卡*MRWzfe9nIIY35fG+5w407A=='\n" +
                    "WHEN RU=51 THEN '交易卡*mSx9quRV6Yc35fG+5w407A=='\n" +
                    "WHEN RU=52 THEN '结算卡*nCVoMhuDsjTnmts2tcFhbg=='\n" +
                    "WHEN RU=53 THEN '交易卡*nlyomyqKR6c35fG+5w407A=='\n" +
                    "WHEN RU=54 THEN '结算卡*ok5s7SVzSoVH67GDzi2prA=='\n" +
                    "WHEN RU=55 THEN '交易卡*PB1mkHsCOX035fG+5w407A=='\n" +
                    "WHEN RU=56 THEN '交易卡*PlvD1GEf8FE35fG+5w407A=='\n" +
                    "WHEN RU=57 THEN '结算卡*pr4aUeBBNQH8RDBw2H5ijA=='\n" +
                    "WHEN RU=58 THEN '交易卡*ptD23yY4u0A35fG+5w407A=='\n" +
                    "WHEN RU=59 THEN '交易卡*PyTbLgcvXmA35fG+5w407A=='\n" +
                    "WHEN RU=60 THEN '结算卡*q5RDCteTvk2pbzq3hfcjZw=='\n" +
                    "WHEN RU=61 THEN '结算卡*QDT/7criodXpFtqsaMQibQ=='\n" +
                    "WHEN RU=62 THEN '交易卡*Rm0hL+Tu4z835fG+5w407A=='\n" +
                    "WHEN RU=63 THEN '交易卡*s45/ynohmQw35fG+5w407A=='\n" +
                    "WHEN RU=64 THEN '交易卡*SlI+G/4qnQg35fG+5w407A=='\n" +
                    "WHEN RU=65 THEN '结算卡*tDuunHVsYTsv54/cfZzT6g=='\n" +
                    "WHEN RU=66 THEN '结算卡*tDuunHVsYTvTJ4ysiJ09Fg=='\n" +
                    "WHEN RU=67 THEN '结算卡*TEB0L87BrtCXOEpiarC5Uw=='\n" +
                    "WHEN RU=68 THEN '交易卡*tmxhuWuKfAc35fG+5w407A=='\n" +
                    "WHEN RU=69 THEN '结算卡*tRAQ84rjh5IUT3ZM10ETjA=='\n" +
                    "WHEN RU=70 THEN '结算卡*tRmqKjg27mRzfGz/XbHrzQ=='\n" +
                    "WHEN RU=71 THEN '交易卡*Ud9yhjObdFqLEu1agxBgOg=='\n" +
                    "WHEN RU=72 THEN '交易卡*uK2PkOHROgk35fG+5w407A=='\n" +
                    "WHEN RU=73 THEN '结算卡*uyE3MuQ/HEk35fG+5w407A=='\n" +
                    "WHEN RU=74 THEN '结算卡*VbvgvNdUHpBAxUIFdCEuZQ=='\n" +
                    "WHEN RU=75 THEN '结算卡*wFxBIAV3bEyBIh4YtMI5Xg=='\n" +
                    "WHEN RU=76 THEN '交易卡*X7+e932EiJHH5Dwcs1kkwA=='\n" +
                    "WHEN RU=77 THEN '交易卡*xemPP3eq3XA35fG+5w407A=='\n" +
                    "WHEN RU=78 THEN '结算卡*y9/TunfSOAXnG0x4NdAh1Q=='\n" +
                    "WHEN RU=79 THEN '结算卡*yIV5Nry3y9BzKl/7o6B7mA=='\n" +
                    "WHEN RU=80 THEN '交易卡*YRAhQDIEEQ435fG+5w407A=='\n" +
                    "WHEN RU=81 THEN '结算卡*YxZ68Ks/s+/XSkesq0vVvA=='\n" +
                    "WHEN RU=82 THEN '结算卡*zBaB1+H3yjG7NG8Xk+OI1A=='\n" +
                    "WHEN RU=83 THEN '结算卡*zFf4LuqQ//A/8VgHS/72hQ=='\n" +
                    "WHEN RU=84 THEN '交易卡*zFhjKTXjfXk35fG+5w407A=='\n" +
                    "WHEN RU=85 THEN '交易卡*znjffWjkWAg35fG+5w407A=='\n" +
                    "WHEN RU=86 THEN '结算卡*ZVSlNQww7n+cJ3MVTMzFEA=='\n" +
                    "WHEN RU=87 THEN '交易卡*iA/k13O2d5k35fG+5w407A=='\n" +
                    "WHEN RU=88 THEN '交易卡*7gx4G49keqE35fG+5w407A=='\n" +
                    "WHEN RU=89 THEN '交易卡*Rm0hL+Tu4z835fG+5w407A=='\n" +
                    "WHEN RU=90 THEN '交易卡*J7sw771X5e035fG+5w407A=='\n" +
                    "WHEN RU=91 THEN '交易卡*nkpddjTY86Y35fG+5w407A=='\n" +
                    "WHEN RU=92 THEN '交易卡*nE/UBiAwTxk35fG+5w407A=='\n" +
                    "WHEN RU=93 THEN '交易卡*bZQINO7Bh5w35fG+5w407A=='\n" +
                    "WHEN RU=94 THEN '结算卡*66IoLAx6nxc35fG+5w407A=='\n" +
                    "WHEN RU=95 THEN '交易卡*8bXfUm90I6k35fG+5w407A=='\t\n" +
                    "WHEN RU=96 THEN '交易卡*+5slpoyUweY35fG+5w407A=='\n" +
                    "WHEN RU=97 THEN '交易卡*WcimpO2UrPA35fG+5w407A=='\n" +
                    "WHEN RU=98 THEN '交易卡*MN3pu872ckA35fG+5w407A=='\n" +
                    "WHEN RU=99 THEN '交易卡*HFdLIxXBoZQ35fG+5w407A=='\n" +
                    "WHEN RU=100 THEN '交易卡*mSx9quRV6Yc35fG+5w407A=='\n" +
                    "WHEN RU=101 THEN '交易卡*vfw19h5ijt435fG+5w407A=='\n" +
                    "WHEN RU=102 THEN '交易卡*mSx9quRV6Yc35fG+5w407A=='\n" +
                    "WHEN RU=103 THEN '交易卡*PiCHr4SdBD835fG+5w407A=='\n" +
                    "WHEN RU=104 THEN '交易卡*epVOxRUo4Pry03aL1gc5lg=='\n" +
                    "WHEN RU=105 THEN '结算卡*sA3vkxHOsBeRjLa6XQjonw=='\n" +
                    "WHEN RU=106 THEN '结算卡*E4JiH9fWkOK0dKHc+fVBcw=='\n" +
                    "WHEN RU=107 THEN '交易卡*HFdLIxXBoZQ35fG+5w407A=='\n" +
                    "ELSE '其它'\n" +
                    "END) AS 字段\n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT \n" +
                    "MEC.MNO,ROWNUM AS RU\n" +
                    "FROM BAP.T_BAP_MEC_IF MEC\n" +
                    "WHERE  ROWNUM<=107\n" +
                    ") T\n" +
                    ") T\n" +
                    ")\n" +
                    "\n" +
                    "SELECT MEC.MNO AS 外部商编,\n" +
                    "JY.IN_MNO AS 内部商编,MEC.DT_CTE AS 进件日期,JY.TRAN_DT AS 交易日期,JY.TRAN_TM AS 交易时间,JY.TRAN_AMT AS 交易金额,JY.TRAN_CD,JY.TRAN_STS,JY.TRAN_FLG,MWB.ENCRY_CRD_NO AS 卡密,T.交易卡类型 AS 来自于问题商户结算卡或交易卡,\n" +
                    "(CASE WHEN JY.IC_CRD_FLG='0' THEN '非IC卡' ELSE 'IC卡' END) AS 卡片类型,\n" +
                    "(CASE WHEN JY.CRD_TYP='00' THEN '借记卡' WHEN JY.CRD_TYP='01' THEN '贷记卡' WHEN JY.CRD_TYP='02' THEN '准贷记卡' ELSE '其它' END) AS 卡种,\n" +
                    "T8.LONG_ADDRESS||T7.LONG_ADDRESS AS 登录地址,T8.CREATE_TIME||T7.CREATE_TIME AS 登陆时间,\n" +
                    "ORG1.ORG_NM AS 拓展分公司,\n" +
                    "ORGR.ORG_NM AS 一级代理, \n" +
                    "MEC.CPR_REG_NM_CN AS 注册中文名,\n" +
                    "MECIF.MEC_ADMIN_TEL AS 商户手机号,\n" +
                    "MECIF.CPR_REG_ADDR AS 注册地址,\n" +
                    "(\n" +
                    "CASE WHEN MECIF.MEC_ADMIN_TEL='01' THEN '补全资料' \n" +
                    "  WHEN MECIF.MEC_ADMIN_TEL='02' THEN '未补全资料'\n" +
                    "    ELSE '其它' END \n" +
                    ") AS 资料是否完整,\n" +
                    "BANK.ACT_NO AS 银行卡账户号,\n" +
                    "BANK.ACT_NM AS 银行卡账户户名,\n" +
                    "BANK.ID_CARD_NO AS 结算卡人的身份证号,\n" +
                    "(CASE WHEN MEC.MEC_NORMAL_LEVEL='10' THEN '一类非授权' \n" +
                    "WHEN MEC.MEC_NORMAL_LEVEL='11' THEN '一类授权'\n" +
                    "WHEN MEC.MEC_NORMAL_LEVEL='20' THEN '二类'\n" +
                    "WHEN MEC.MEC_NORMAL_LEVEL='30' THEN '三类'\n" +
                    "ELSE '其它' END) AS 普通商户级别,\n" +
                    "MECIF.LEG_PER_CRD_NO AS 法人证件号码,MECIF.LEG_PER_NM AS 法人姓名\n" +
                    "FROM PTS.T_PTS_TRANDATA JY\n" +
                    "LEFT JOIN PTS.T_PTS_TRANDATA_EXTEND MWB ON JY.UUID=MWB.UUID AND JY.TRAN_DT=MWB.TRAN_DT\n" +
                    "LEFT JOIN BAP.T_BAP_MEC_IF MEC ON JY.IN_MNO=MEC.IN_MNO\n" +
                    "LEFT JOIN (---大POS登录地址\n" +
                    "SELECT T.IN_MNO,T.EX_MNO,T.TERMINAL_NO,T.TERMINAL_SN,T.LONG_ADDRESS,T.CREATE_TIME,\n" +
                    "LAG(T.CREATE_TIME,1,TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')) OVER (PARTITION BY T.IN_MNO,T.EX_MNO,T.TERMINAL_NO,T.TERMINAL_SN ORDER BY T.CREATE_TIME DESC) AS NEXT_CREATE_TIME\n" +
                    "FROM(\n" +
                    "SELECT S.IN_MNO,S.EX_MNO,S.TERMINAL_NO,S.TERMINAL_SN,S.LONG_ADDRESS,S.CREATE_TIME\n" +
                    "FROM MSS.T_MSS_POS_SIGN_ADDR S\n" +
                    "WHERE S.CREATE_TIME>=TO_CHAR(SYSDATE-1,'YYYYMMDD')||'000000') T\n" +
                    ") T8 ON T8.IN_MNO=JY.IN_MNO AND JY.TRAN_DT||JY.TRAN_TM>=T8.CREATE_TIME AND JY.TRAN_DT||JY.TRAN_TM<T8.NEXT_CREATE_TIME --AND T8.TERMINAL_NO=JY.TRM_NO \n" +
                    "LEFT JOIN (---手刷登录地址\n" +
                    "SELECT T.IN_MNO,T.EX_MNO,T.LONG_ADDRESS,T.CREATE_TIME,\n" +
                    "LAG(T.CREATE_TIME,1,TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')) OVER (PARTITION BY T.IN_MNO,T.EX_MNO ORDER BY T.CREATE_TIME DESC) AS NEXT_CREATE_TIME\n" +
                    "FROM(\n" +
                    "SELECT S.IN_MNO,S.EX_MNO,S.LONG_ADDRESS,S.CREATE_TIME\n" +
                    "FROM MSS.T_MSS_MOBILE_LOGIN_ADDR S\n" +
                    "WHERE S.CREATE_TIME>=TO_CHAR(SYSDATE-1,'YYYYMMDD')||'000000') T\n" +
                    ") T7 ON T7.IN_MNO=JY.IN_MNO AND JY.TRAN_DT||JY.TRAN_TM>=T7.CREATE_TIME AND JY.TRAN_DT||JY.TRAN_TM<T7.NEXT_CREATE_TIME\n" +
                    "JOIN T ON MWB.ENCRY_CRD_NO=T.交易卡号\n" +
                    "LEFT JOIN UAP.T_UAP_ORG ORG1--拓展分公司\n" +
                    "  ON MEC.AGENT_BRANCH_ORG_UUID=ORG1.ORG_UUID\n" +
                    "LEFT JOIN UAP.T_UAP_ORG ORG2--维护分公司\n" +
                    "  ON MEC.BRANCH_ORG_UUID=ORG2.ORG_UUID\n" +
                    "LEFT JOIN UAP.T_UAP_ORG ORGR--一级代理\n" +
                    "  ON MEC.ROOT_AGENT_ORG_NO=ORGR.ORG_UUID\n" +
                    "LEFT JOIN UAP.T_UAP_ORG ORGA--直属代理\n" +
                    "  ON MEC.AGENT_ORG_NO = ORGA.ORG_UUID\n" +
                    "LEFT JOIN BAP.T_BAP_MEC_IF_DETAIL MECIF\n" +
                    "  ON MEC.IN_MNO=MECIF.IN_MNO\n" +
                    "LEFT JOIN BAP.T_BAP_USR_STM_BNK_IF BANK \n" +
                    "  ON BANK.USR_ID=MECIF.USR_ID\n" +
                    "WHERE BANK.STM_MET_NO='01' AND BANK.DEL_FLG='00'\n" +
                    "AND JY.TRAN_DT>=TO_CHAR(SYSDATE,'YYYYMMDD')\n" +
                    "ORDER BY JY.TRAN_DT,JY.TRAN_TM";
            Statement sqlparsStrStatment = CCJSqlParserUtil.parse(sqlparsStr);

            Class clz = sqlparsStrStatment.getClass();  //获取实际类型  即new谁获取谁的类型
            System.out.println(clz.getCanonicalName());

        } catch (Exception e) {
            System.out.println(e);
        }


    }
    public void test() throws JSQLParserException
    {
        // TODO Auto-generated method stub
        String statement="SELECT LOCATION_D.REGION_NAME, LOCATION_D.AREA_NAME, COUNT(DISTINCT INCIDENT_FACT.TICKET_ID) FROM LOCATION_D, INCIDENT_FACT WHERE ( LOCATION_D.LOCATION_SK=INCIDENT_FACT.LOCATION_SK ) GROUP BY LOCATION_D.REGION_NAME, LOCATION_D.AREA_NAME";
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        Select select=(Select) parserManager.parse(new StringReader(statement));

        PlainSelect plain=(PlainSelect)select.getSelectBody();
        List selectitems=plain.getSelectItems();
        System.out.println(selectitems.size());
        for(int i=0;i<selectitems.size();i++) {
            Expression expression=((SelectExpressionItem) selectitems.get(i)).getExpression();
            System.out.println("Expression:-"+expression);
            Column col=(Column)expression;
            System.out.println(col.getTable()+","+col.getColumnName());
        }
    }
}
