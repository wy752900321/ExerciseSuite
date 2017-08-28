# -*- encoding: utf-8 -*-

__author__ = "wentianle (wenzaile@163.com)"
__version__ = "$Revision: 1.0 $"
__date__ = "$Date: 2009/02/19 $"
__license__ = "Python"

from DBUtils.PooledDB import PooledDB

import MySQLdb
import time
from conf.config import Config
from util import func_ext


# 数据库连接池句柄
class DBPool:
    pool = {};

    @staticmethod
    def getInstance(db_name):
        try:
            if isinstance(db_name, unicode):
                db_name = db_name.encode("utf8")
            if DBPool.pool.get(db_name):
                return DBPool.pool.get(db_name)
            else:
                #                print Config.getConf('db_'+db_name,"dbhost")

                tmp_pool = PooledDB(MySQLdb, \
                                    int(Config.getConf("dbpool_config", "db_mincached")), \
                                    int(Config.getConf("dbpool_config", "db_maxcached")), \
                                    int(Config.getConf("dbpool_config", "db_maxshared")), \
                                    int(Config.getConf("dbpool_config", "db_maxconnections")), \
                                    int(Config.getConf("dbpool_config", "db_blocking")), \
                                    int(Config.getConf("dbpool_config", "db_maxusage")), \
                                    ["SET NAMES utf8", "SET CHARACTER SET utf8"], \
                                    host=Config.getConf('db_' + db_name, "dbhost"), \
                                    user=Config.getConf('db_' + db_name, "dbuser"), \
                                    passwd=Config.getConf('db_' + db_name, "dbpass"), \
                                    db=Config.getConf('db_' + db_name, "dbname"), \
                                    charset=Config.getConf('db_' + db_name, "charset"), \
                                    port=int(Config.getConf('db_' + db_name, "dbport")))
                tmp_pool.charset = Config.getConf('db_' + db_name, "charset")
                DBPool.pool[db_name] = tmp_pool
                return DBPool.pool[db_name]
        except Exception, e:
            func_ext.error_log(e)
            time.sleep(5)
            return DBPool.getInstance(db_name)


if __name__ == '__main__':
    while True:
        pool = DBPool.getInstance("plat")
        time.sleep(2)
        db_conn = pool.connection()
        cur = db_conn.cursor()
        cur.execute("select * from sc_supplier")
        res = cur.fetchone()
        print res
        time.sleep(2)