package com.cenrise.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

import com.cenrise.util.DBUtil132;
import com.cenrise.util.DBUtil164;

/**
 * @author Admin
 *
 */
public class CheckAccount {
	String tablename;
	private long sum1;
	private BigDecimal sumMoney1;

	private Long sum2;
	private BigDecimal sumMoney2;
	public static final String DOT = ".";
	public static final String SOURCE = "source";
	public static final String SINK = "sink";
	public static final int jdbcTimeout=60;
	@Test
	private void checkALL() {
		try {
			Properties props = new Properties();
			InputStream inStream = CheckAccount.class.getClassLoader()
					.getResourceAsStream("checkaccountlist.properties");
			props.load(inStream);
			Set<String> sets = new HashSet<String>();
			Map<String, String> map = new HashMap<String, String>((Map) props);
			for (String keys : map.keySet()) {
				String str = keys.split("\\.")[0];
				sets.add(str);
			}

			for (String key : sets) {
				long start = System.currentTimeMillis(); // 获取开始时间

				String sql164 = map.get(key + DOT + SOURCE);
				String sql132 = map.get(key + DOT + SINK);

				Connection connection164 = DBUtil164.openConnection();
				PreparedStatement prepareStatement164 = connection164.prepareStatement(sql164);
				prepareStatement164.setQueryTimeout(jdbcTimeout);
				ResultSet rs164 = prepareStatement164.executeQuery();
				int col164 = rs164.getMetaData().getColumnCount();
				while (rs164.next()) {
					sum1 = rs164.getLong(1);
					sumMoney1 = rs164.getBigDecimal(2);
					sumMoney1 = sumMoney1 == null ? new BigDecimal("0") : sumMoney1;
				}
				Connection connection132 = DBUtil132.openConnection();
				PreparedStatement prepareStatement132 = connection132.prepareStatement(sql132);
				prepareStatement132.setQueryTimeout(jdbcTimeout);
				ResultSet rs132 = prepareStatement132.executeQuery();
				while (rs132.next()) {
					sum2 = rs132.getLong(1);
					sumMoney2 = rs132.getBigDecimal(2);
					tablename = rs132.getString(3);
					sumMoney2 = sumMoney2 == null ? new BigDecimal("0") : sumMoney2;
				}

				long end = System.currentTimeMillis(); // 获取结束时间
				System.out.println("表[" + tablename + "],程序运行时间： " + (end - start) / 1000F + "s");

				if (sum1 != sum2) {
					System.out.println("表[" + tablename + "]总记录数不一致！生产[" + sum1 + "],数据中心[" + sum2 + "]");
					return;
				}

				if (sumMoney1.compareTo(sumMoney2) != 0) {
					System.out.println("表[" + tablename + "]总金额不一致！生产[" + sumMoney1 + "],数据中心[" + sumMoney2 + "]");
					return;
				}
				System.out.println("表[" + tablename + "]对帐完成，数据一致！总记录数[" + sum1 + "],总金额[" + sumMoney1 + "]");

				DBUtil164.closeConnection();
				DBUtil132.closeConnection();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	private void check_T_PTS_XYDDBC_TRANDATA() {
		try {
			// String sql164 = "select count(*) count164,sum(FEE_AMT) as sum164
			// from T_PTS_XYDDBC_TRANDATA where tran_dt =
			// to_char(sysdate-1,'yyyymmdd')";
			String sql164 = "select count(*) count164,sum(FEE_AMT) as sum164 from T_PTS_XYDDBC_TRANDATA where tran_dt = '20160928'";
			Connection connection164 = DBUtil164.openConnection();
			PreparedStatement prepareStatement164 = connection164.prepareStatement(sql164);
			ResultSet rs164 = prepareStatement164.executeQuery();
			int col164 = rs164.getMetaData().getColumnCount();
			while (rs164.next()) {
				sum1 = rs164.getLong(1);
				sumMoney1 = rs164.getBigDecimal(2);
				System.out.println("");
			}
			// System.out.println(sum1 + "============================" +
			// sumMoney1);

			// String sql132 = "select 'T_PTS_XYDDBC_TRANDATA' as
			// tablename,count(*) as count132,sum(FEE_AMT) as sum132 from
			// pts.T_PTS_XYDDBC_TRANDATA where tran_dt =
			// to_char(sysdate-1,'yyyymmdd')";
			String sql132 = "select count(*) as count132,sum(FEE_AMT) as sum132,'T_PTS_XYDDBC_TRANDATA' as tablename  from pts.T_PTS_XYDDBC_TRANDATA where tran_dt = '20160928'";
			Connection connection132 = DBUtil132.openConnection();
			PreparedStatement prepareStatement132 = connection132.prepareStatement(sql132);
			ResultSet rs132 = prepareStatement132.executeQuery();
			int col132 = rs132.getMetaData().getColumnCount();
			while (rs132.next()) {
				sum2 = rs132.getLong(1);
				sumMoney2 = rs132.getBigDecimal(2);
				tablename = rs132.getString(3);
				System.out.println("");
			}
			// System.out.println(sum2 + "=============" + sumMoney2 +
			// "=============" + tablename + "==");

			if (sum1 != sum2) {
				System.out.println("表" + tablename + "总记录数不一致！生产[" + sum1 + "],数据中心[" + sum2 + "]");
				return;
			}

			if (sumMoney1.compareTo(sumMoney2) != 0) {
				System.out.println("表" + tablename + "总金额不一致！生产[" + sumMoney1 + "],数据中心[" + sumMoney2 + "]");
				return;
			}

			System.out.println("表[" + tablename + "]对帐完成，数据一致！");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	private void test() {
		try {
			String sql164 = "select count(*) count164,sum(FEE_AMT) as sum164 from T_PTS_XYDDBC_TRANDATA where tran_dt = '20160928'";
			Connection connection164 = DBUtil164.openConnection();
			PreparedStatement prepareStatement164 = connection164.prepareStatement(sql164);
			ResultSet rs164 = prepareStatement164.executeQuery();
			int col164 = rs164.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs164.next()) {
				for (int i = 1; i <= col164; i++) {
					System.out.print(rs164.getString(i) + "\t");
					if ((i == 2) && (rs164.getString(i).length() < 8)) {
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
			System.out.println("============================");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CheckAccount checkAccount = new CheckAccount();
		// checkAccount.check_T_PTS_XYDDBC_TRANDATA();
		checkAccount.checkALL();
	}

}
