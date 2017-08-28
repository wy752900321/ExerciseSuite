# -*- encoding: utf-8 -*-

__author__ = "wentianle (wenzaile@163.com)"
__version__ = "$Revision: 1.0 $"
__date__ = "$Date: 2009/02/19 $"
__license__ = "Python"

import MySQLdb
from db.DBPool import DBPool
from util import func_ext
from conf.config import Config
import string


class DB:
    fields = None

    def open(self, db_name, autoCommit=True):
        pass

    def query(self, sql):
        pass

    def error(self, e):
        print "Error %d: %s" % (e.args[0], e.args[1])

    def close(self):
        """close the mysql connect"""
        self.cur.close()
        self.db_conn.close()

    def next_record(self):
        self.cur.nextset()

    def insert(self, p_table_name, p_data):
        for key in p_data:
            p_data[key] = func_ext.addslashes(func_ext.uni_str(p_data[key]))
        key = string.join(p_data.keys(), "`,`")
        value = string.join(p_data.values(), "','")
        real_sql = "INSERT INTO " + p_table_name + " (`" + key + "`) VALUES ('" + value + "')"
        self.query("set names 'utf8'")
        return self.query(real_sql)

    def replace(self, p_table_name, p_data):
        for key in p_data:
            p_data[key] = func_ext.addslashes(func_ext.uni_str(p_data[key]))
        key = string.join(p_data.keys(), "`,`")
        value = string.join(p_data.values(), "','")
        real_sql = "REPLACE INTO " + p_table_name + " (`" + key + "`) VALUES ('" + value + "')"
        self.query("set names 'utf8'")
        return self.query(real_sql)

    def update(self, p_table_name, p_data, p_where):
        for key in p_data:
            p_data[key] = func_ext.addslashes(func_ext.uni_str(p_data[key]))
        for key in p_where:
            p_where[key] = func_ext.addslashes(func_ext.uni_str(p_where[key]))
        edit_sql = string.join([str(x[0]) + "='" + str(x[1]) + "'" for x in p_data.items()], ",")
        where_sql = string.join([str(x[0]) + "='" + str(x[1]) + "'" for x in p_where.items()], " AND ")
        real_sql = "UPDATE " + p_table_name + " SET " + edit_sql + " WHERE " + where_sql
        self.query("set names 'utf8'")
        return self.query(real_sql)

    def delete(self, p_table_name, p_where):
        for key in p_where:
            p_where[key] = func_ext.addslashes(func_ext.uni_str(p_where[key]))
        where_sql = string.join([x[0] + "='" + x[1] + "'" for x in p_where.items()], " AND ")
        real_sql = "DELETE FROM " + p_table_name + " WHERE " + where_sql
        self.query("set names 'utf8'")
        return self.query(real_sql)

    def isinstance(self, p_table_name, p_where):
        for key in p_where:
            p_where[key] = func_ext.addslashes(func_ext.uni_str(p_where[key]))
        where_sql = string.join([x[0] + "='" + x[1] + "'" for x in p_where.items()], " AND ")
        real_sql = "SELECT count(*) as cnt FROM " + p_table_name + " WHERE " + where_sql
        if self.query(real_sql):
            res = self.fetch_assoc()
            return res[0]
        else:
            return 0

    def select(self, sql):
        self.query("set names 'utf8'")
        self.query(sql)
        return self.fetch_all()

    def selectRow(self, sql):
        self.query("set names 'utf8'")
        self.query(sql)
        return self.fetch_assoc()

    def fetch_all(self, upper=0):
        if self.get_num_rows():
            d = []
            result = self.cur.fetchall()
            desc = self.cur.description

            for inv in result:
                _d = {}
                if upper:
                    for i in xrange(0, len(inv)):
                        if isinstance(inv[i], (unicode)):
                            _d[desc[i][0].upper()] = str(inv[i])
                        else:
                            _d[desc[i][0].upper()] = inv[i]
                elif not upper:
                    for i in xrange(0, len(inv)):
                        if isinstance(inv[i], (unicode)):
                            _d[desc[i][0].lower()] = str(inv[i])
                        else:
                            _d[desc[i][0].lower()] = inv[i]
                else:
                    for i in xrange(0, len(inv)):
                        if isinstance(inv[i], (unicode)):
                            _d[desc[i][0]] = str(inv[i])
                        else:
                            _d[desc[i][0]] = inv[i]

                d.append(_d)
            return d
        else:
            return None

    def fetch_assoc(self, upper=0):
        if self.get_num_rows():
            d = {}
            #            i = 0
            desc = self.cur.description
            self.fields = self.cur.fetchone()

            if upper:
                for i in xrange(0, len(self.fields)):
                    if isinstance(self.fields[i], (unicode)):
                        d[desc[i][0].upper()] = str(self.fields[i])
                    else:
                        d[desc[i][0].upper()] = self.fields[i]
            elif not upper:
                for i in xrange(0, len(self.fields)):
                    if isinstance(self.fields[i], (unicode)):
                        d[desc[i][0].lower()] = str(self.fields[i])
                    else:
                        d[desc[i][0].lower()] = self.fields[i]
            else:
                for i in xrange(0, len(self.fields)):
                    if isinstance(self.fields[i], (unicode)):
                        d[desc[i][0]] = str(self.fields[i])
                    else:
                        d[desc[i][0]] = self.fields[i]
            return d
        else:
            return None

    def get_num_rows(self):
        return self.cur.rowcount

    def autoCommit(self, flag):
        self.query("Set AUTOCOMMIT = " + str(flag))

    def debug_sql(self, sql):
        if Config.getConf("public", "debug_sql") == "True":
            pass


# 数据库操作类配合(dbpool)使用
class Mysql(DB):
    def get_mysql_version(self):
        """return the mysql version"""
        return MySQLdb.get_client_info()

    def open(self, db_name, autoCommit=True):
        """mysql connect"""
        pool = DBPool.getInstance(db_name)
        if pool:
            self.db_conn = pool.connection(0)
            self.cur = self.db_conn.cursor()
            if autoCommit == True:
                self.autoCommit(1)
            self.charset = DBPool.getInstance(db_name).charset
            self.set_name()
            return True
        else:
            raise Exception, "open database %s Failure" % (db_name)

    def set_name(self):
        self.query("SET NAMES " + self.charset)
        self.query("SET CHARACTER SET " + self.charset)

    def query(self, sql):
        if isinstance(sql, unicode):
            sql = sql.encode("utf8")
        self.debug_sql(sql);

        return self.cur.execute(sql)

    def getInsertId(self):
        self.query("SELECT LAST_INSERT_ID() AS lid")
        rs = self.cur.fetchone()
        return rs[0]

    def commit(self):
        self.db_conn.commit()

        # if __name__ == '__main__':
        #    myTest = Mysql()
        #    if myTest.open("b2b_platform"):
        #        sql = "select * from sc_goods"
        #        myTest.query(sql)
        #        aa = myTest.fetch_assoc()
        #        print aa