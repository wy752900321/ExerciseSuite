package com.tarena.dao.impl;
import java.sql.Connection;
import java.sql.SQLException;

import com.tarena.util.DbPoolUtil;;
public class GetConnection {
	protected Connection getConnection () throws SQLException{
		return DbPoolUtil.getConnection();
	}
}
