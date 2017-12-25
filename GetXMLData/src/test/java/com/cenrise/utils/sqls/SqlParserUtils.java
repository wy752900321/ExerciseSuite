package com.cenrise.utils.sqls;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.dialect.oracle.parser.OracleStatementParser;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import net.sf.jsqlparser.JSQLParserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlParserUtils {
    private static List<String> exprTables = new ArrayList<>();

    public static void main(String[] args) throws JSQLParserException {


        // String sql = "update t set name = 'x' where id < 100 limit 10";
        // String sql = "SELECT ID, NAME, AGE FROM USER WHERE ID = ? limit 2";
        // String sql = "select * from tablename limit 10";

        String sql = "";
        /// CCJSqlParserUtil;
        sql =
                "merge into RPT_CLEARING_DIFFERENCE_REPORT B\n" +
                        " using (\n" +
                        " SELECT\n" +
                        "        CORG_NM,\n" +
                        "        SUM(SUM_TXN_COT) AS COT_L,\n" +
                        "        SUM(SUM_TXN_AMT) AS AMT_L\n" +
                        "      FROM (\n" +
                        "        SELECT\n" +
                        "          T.CORG_NM,\n" +
                        "          1        AS SUM_TXN_COT,\n" +
                        "          TRAN_AMT AS SUM_TXN_AMT\n" +
                        "        FROM DCM_PTS_TRANDATA_STG T\n" +
                        "        WHERE T.TRAN_CD IN ('10110001', '10110005','20110001')\n" +
                        "              AND T.TRAN_FLG <> 'L'\n" +
                        "              AND T.TRAN_STS = 'S'\n" +
                        "              AND exists(SELECT 1\n" +
                        "                         FROM DCM_AMS_AC_PMT_DTL_STG PMT\n" +
                        "                         WHERE PMT.ADT = process_date AND T.UUID = PMT.ORN_ORD_NO)\n" +
                        "        UNION ALL\n" +
                        "        SELECT\n" +
                        "          T.CORG_NM,\n" +
                        "          1        AS SUM_TXN_COT,\n" +
                        "          TRAN_AMT AS SUM_TXN_AMT\n" +
                        "        FROM DCM_PTS_TRANDATA_STG T\n" +
                        "        WHERE T.FINISH_DT BETWEEN process_date AND\n" +
                        "              TO_CHAR(TO_DATE(process_date, 'YYYYMMDD') + 1, 'YYYYMMDD')\n" +
                        "              AND T.TRAN_FLG <> 'L'\n" +
                        "              AND T.TRAN_STS = 'S'\n" +
                        "              AND T.TRAN_CD IN ('10110025', '10110028')\n" +
                        "              AND exists(SELECT 1\n" +
                        "                         FROM DCM_AMS_AC_PMT_DTL_STG PMT\n" +
                        "                         WHERE PMT.ADT = process_date AND T.UUID = PMT.ORN_ORD_NO)\n" +
                        "        UNION ALL\n" +
                        "        SELECT\n" +
                        "          T.CORG_NM,\n" +
                        "          -1        AS SUM_TXN_COT,\n" +
                        "          -TRAN_AMT AS SUM_TXN_AMT\n" +
                        "        FROM DCM_PTS_TRANDATA_STG T\n" +
                        "        WHERE T.TRAN_CD IN ('10110002', '10110008', '10110006')\n" +
                        "              AND T.TRAN_FLG <> 'L'\n" +
                        "              AND T.TRAN_STS = 'S'\n" +
                        "              AND exists(SELECT 1\n" +
                        "                         FROM DCM_AMS_AC_PMT_DTL_STG PMT\n" +
                        "                         WHERE PMT.ADT = process_date AND T.UUID = PMT.ORN_ORD_NO)\n" +
                        "        UNION ALL\n" +
                        "        SELECT\n" +
                        "          T.CORG_NM,\n" +
                        "          -1          AS SUM_TXN_COT,\n" +
                        "          -T.TRAN_AMT AS SUM_TXN_AMT\n" +
                        "        FROM DCM_PTS_TRANDATA_STG T, DCM_PTS_TRANDATA_STG T2\n" +
                        "        WHERE T.TRAN_CD IN ('10110001', '10110005')\n" +
                        "              AND T.UUID = T2.OUUID\n" +
                        "              AND T.TRAN_FLG <> 'L'\n" +
                        "              AND T.TRAN_STS = 'S'\n" +
                        "              AND T2.TRAN_CD = '10110007'\n" +
                        "              AND exists(SELECT 1\n" +
                        "                         FROM DCM_AMS_AC_PMT_DTL_STG PMT\n" +
                        "                         WHERE PMT.ADT = process_date AND T2.UUID = PMT.ORN_ORD_NO)\n" +
                        "      )\n" +
                        "      GROUP BY CORG_NM\n" +
                        " ) ROW_REC\n" +
                        " on (B.CORG_NM = ROW_REC.CORG_NM AND B.ac_dt = process_date)\n" +
                        " when matched then\n" +
                        "   update set B.ACC_CLE_COT = NVL(ROW_REC.COT_L, 0), B.ACC_CLE_AMT = NVL(ROW_REC.AMT_L, 0);";
        //getProInfo(sql);
        //String proSql = getProSql("USER_AUTH_IF_SALESMAN_PROC","dcdball_163");
        Map<String, String> manipulation = getManipulation(sql);
        System.out.print(manipulation);
        /*String dbType = JdbcConstants.ALI_ORACLE_DRIVER;

        //格式化输出
        String result = SQLUtils.format(sql, dbType);
        System.out.println(result); // 缺省大写格式
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);

        //解析出的独立语句的个数
        System.out.println("size is:" + stmtList.size());
        for (int i = 0; i < stmtList.size(); i++) {

            SQLStatement stmt = stmtList.get(i);
            OracleSchemaStatVisitor visitor = new OracleSchemaStatVisitor();
            stmt.accept(visitor);

            //获取表名称
            System.out.println("Tables : " + visitor.getCurrentTable());
            //获取操作方法名称,依赖于表名称
            System.out.println("Manipulation : " + visitor.getTables());
            //获取字段名称
            System.out.println("fields : " + visitor.getColumns());
        }*/

    }

    public static Map<String, String> getManipulation(String sql) {
        Map<String, String> map = new HashMap<>();
        String[] sqls = sql.split(";");
        Map<TableStat.Name, TableStat> tables = null;
        for (int i = 0; i < sqls.length; i++) {
            try {
                OracleStatementParser parser = new OracleStatementParser(sqls[i]);
                SQLStatement statement = parser.parseStatement();
                OracleSchemaStatVisitor visitor = new OracleSchemaStatVisitor();
                statement.accept(visitor);
                tables = visitor.getTables();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    MySqlStatementParser parser = new MySqlStatementParser(sqls[i]);
                    SQLStatement statement = parser.parseStatement();
                    MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
                    statement.accept(visitor);
                    tables = visitor.getTables();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    return null;
                }

            }


            //获取表名称
            //System.out.println("Tables : " + visitor.getCurrentTable());
            //获取字段名称
            //System.out.println("fields : " + visitor.getColumns());
            //获取操作方法名称,依赖于表名称
            if (!tables.isEmpty()) {
                for (TableStat.Name tableName : tables.keySet()) {
                    TableStat tableStat = tables.get(tableName);
                    String tableNameStr = tableName.toString();
                    String[] tableArr = tableNameStr.split("\\.");
                    if (tableArr.length > 0) {
                        tableNameStr = tableArr[0].equalsIgnoreCase("dcm_owner") ? tableArr[1] : tableNameStr;
                    }
                    if (!exprTables.contains(tableName.toString())) {
                        map.put(tableNameStr, tableStat.toString());
                    }
                }
            }
        }


        return map;
    }

    public static String getProSql(String proName, String datasourceName) {
        List<String> exportTablesNow = new ArrayList<>();
        String sql = "";
        String sqlNow = "";
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        try {
            con = DataSourceUtils.getConnection(datasourceName);
            if (con == null) {
                return "500";
            }
            pre = con.prepareStatement("SELECT text FROM user_source where TYPE='PROCEDURE' and NAME = '" + proName + "'");
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                String result = resultSet.getString(1);
                sql += result;
            }
            if (!sql.equals("")) {
                sql = sql.toUpperCase();

                //去掉注释
                while (sql.indexOf("--") != -1) {
                    String ignoreStr = sql.substring(sql.indexOf("--"));
                    String ignore = ignoreStr.substring(0, ignoreStr.indexOf("\n") + 1);
                    sql = sql.replace(ignore, "\n");
                }

                while (sql.indexOf("/*") != -1) {
                    String ignoreStr = sql.substring(sql.indexOf("/*"));
                    String ignore = ignoreStr.substring(0, ignoreStr.indexOf("*/") + 2);
                    sql = sql.replace(ignore, "\n");
                }

                sql = sql.replace("INSERT INTO", "${REPLACEINSERT}");
                sql = sql.replace("MERGE INTO", "${REPLACEMERGE}");
                while (sql.indexOf("INTO") != -1) {
                    String intoCut = sql.substring(sql.indexOf("INTO"));
                    String intoCutStr = "";
                    String insertInto = sql.substring(sql.indexOf("INTO") - 7, sql.indexOf("INTO") - 1);
                    intoCutStr = intoCut.substring(0, intoCut.indexOf("FROM") + 4);
                    sql = sql.replace(intoCutStr, "FROM");
                }
                sql = sql.replace("${REPLACEINSERT}", "INSERT INTO");
                sql = sql.replace("${REPLACEMERGE}", "MERGE INTO");
                sql = sql.replace("（", "(");
                sql = sql.replace("）", ")");
                sql = sql.replaceAll(" +", " ");
                sql = sql.substring(sql.indexOf("BEGIN") + 5);
                sql = sql.replace("BEGIN", "");
                sql = sql.replace("COMMIT;", "");
                String[] sqlArr = sql.split(";");
                for (int i = 0; i < sqlArr.length; i++) {
                    if (sqlArr[i].contains("INSERT") || sqlArr[i].contains("UPDATE") || sqlArr[i].contains("SELECT") || sqlArr[i].contains("DELETE")) {
                        String sqlStr = "";
                        String contentNew = "";
                        String contentNewTotal = "";
                        if (sqlArr[i].contains("CREATE TABLE")) {
                            sqlStr = sqlArr[i].substring(sqlArr[i].indexOf("AS") + 2);
                            sqlStr = sqlStr.substring(0, sqlStr.length() - 1);
                            sqlStr = sqlStr.replace("''", "'");
                        } else if (sqlArr[i].contains("EXECUTE IMMEDIATE")) {
                            sqlStr = sqlArr[i].substring(sqlArr[i].indexOf("IMMEDIATE") + 11);
                            sqlStr = sqlStr.substring(0, sqlStr.length() - 1);
                        } else {
                            sqlStr = sqlArr[i];
                        }

                        while (sqlStr.indexOf(" WITH ") != -1 || sqlStr.indexOf(" WITH\n") != -1 || sqlStr.indexOf("\nWITH ") != -1 || sqlStr.indexOf("\nWITH\n") != -1) {
                            int withIndex = 0;
                            if (sqlStr.indexOf(" WITH ") != -1) {
                                withIndex = sqlStr.indexOf(" WITH ");
                            } else if (sqlStr.indexOf(" WITH\n") != -1) {
                                withIndex = sqlStr.indexOf(" WITH\n");
                            } else if (sqlStr.indexOf("\nWITH ") != -1) {
                                withIndex = sqlStr.indexOf("\nWITH ");
                            } else if (sqlStr.indexOf("\nWITH\n") != -1) {
                                withIndex = sqlStr.indexOf("\nWITH\n");
                            }
                            String exprTableStr = sqlStr.substring(withIndex + 5).trim();
                            String content = exprTableStr;
                            contentNew = content;
                            int count = 0;
                            int lastIndex = 0;
                            int sqlLastIndex = 0;
                            int firstIndex = content.indexOf("(");
                            while (true) {
                                if (content.indexOf("(") == -1) {
                                    count -= 1;
                                    content = content.substring(content.indexOf(")") + 1);
                                } else if (content.indexOf("(") < content.indexOf(")")) {
                                    count += 1;
                                    content = content.substring(content.indexOf("(") + 1);
                                } else {
                                    count -= 1;
                                    content = content.substring(content.indexOf(")") + 1);
                                }

                                if (count == 0) {
                                    lastIndex = contentNew.indexOf(content);
                                    sqlLastIndex = sqlStr.indexOf(content);
                                    break;
                                }
                            }
                            contentNew = contentNew.substring(firstIndex, lastIndex);
                            contentNewTotal += contentNew + ";";
                            String cutSrt = sqlStr.substring(withIndex, sqlLastIndex);
                            int firstNum = sqlStr.substring(sqlLastIndex).replaceAll("\n", "").trim().indexOf(",");
                            if (firstNum == 0) {
                                sqlStr = sqlStr.substring(0, sqlLastIndex) + sqlStr.substring(sqlLastIndex).replaceFirst(",", " WITH");
                            }
                            sqlStr = sqlStr.replace(cutSrt, "");
                            exprTableStr = exprTableStr.replace("\n", " ");
                            exportTablesNow.add(exprTableStr.substring(0, exprTableStr.indexOf(" ")));
                        }
                        if (contentNew.equals("")) {
                            sqlNow += sqlStr + ";";
                        } else {
                            contentNew = contentNew.substring(1, contentNew.length() - 1);
                            sqlNow += sqlStr + ";" + contentNewTotal + ";";
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pre != null) {
                try {
                    pre.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        exprTables = exportTablesNow;
        return sqlNow;
    }

}
