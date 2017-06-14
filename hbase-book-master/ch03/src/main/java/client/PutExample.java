package client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import util.HBaseHelper;

import java.io.IOException;


public class PutExample {

    public static void main2(String[] args) throws IOException {
        // 创建所需要的配置
        Configuration conf = HBaseConfiguration.create();
        //实例化一个新的客户端
        HTable table = new HTable(conf, "testtable");
        //指定一行来创建一个Put
        Put put = new Put(Bytes.toBytes("row1"));
        //向Pub中添加一个名为"colfam1:qual1“的列。
        put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"), Bytes.toBytes("val1"));
        //向Pub中添加一个名为"colfam1:qual2“的列。
        put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"), Bytes.toBytes("val2"));
        //将这一行存储到HBase表中。
        table.put(put);
    }

    public static void main(String[] args) throws IOException {
        // 创建所需要的配置
        Configuration conf = HBaseConfiguration.create();
        HBaseHelper helper = HBaseHelper.getHelper(conf);

        helper.dropTable("testtable");
        helper.createTable("testtable", "colfam1");

        Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf("testtable"));

        Put put = new Put(Bytes.toBytes("row1"));

        put.addColumn(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"),
                Bytes.toBytes("val1"));
        put.addColumn(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"),
                Bytes.toBytes("val2"));

        table.put(put);  //Store row with column into the HBase table.
        table.close(); //Close table and connection instances to free resources.
        connection.close();
        helper.close();
    }
}

