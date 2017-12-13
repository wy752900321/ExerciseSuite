package com.cenrise;


import java.util.regex.Pattern;

public class MBSConstants {
    public static final String  COMMA_SEPARATOR                    = ",";

    public static final Pattern COMMA_SPLIT_PATTERN                = Pattern
                                                                           .compile("\\s*[,]+\\s*");


    public static final String  ANYHOST_VALUE                      = "0.0.0.0";
    public static final String  LOCALHOST_VALUE                    = "127.0.0.1";

	public static final String GROUP_KEY                           = "group";

	public static final String VERSION_KEY                         = "version";

	public static final String INTERFACE_KEY                       =  "interface";
    public static final String  BACKUP_KEY                         = "backup";
    public static final String  FILE_KEY                           = "file";
	
    public static final String  CATEGORY_KEY                       = "category";
    public static final String  PROVIDERS_CATEGORY                 = "providers";
    public static final String  CONTAINERS_CATEGORY                = "containers";
    public static final String  DEFAULT_CATEGORY                   = CONTAINERS_CATEGORY;
    public static final String  CONSUMERS_CATEGORY                 = "consumers";
    public static final String  ROUTERS_CATEGORY                   = "routers";
    public static final String  CONFIGURATORS_CATEGORY             = "configurators";

    /**
     * 注册中心导出URL参数的KEY
     */
    public static final String  EXPORT_KEY                         = "export";

    /**
     * 注册中心引用URL参数的KEY
     */
    public static final String  REFER_KEY                          = "refer";

    /**
     * 注册中心失败事件重试事件
     */
    public static final String  REGISTRY_RETRY_PERIOD_KEY          = "retry.period";

    /**
     * 重试周期
     */
    public static final int DEFAULT_REGISTRY_RETRY_PERIOD          =  5 * 1000;
    public static final String  CHECK_KEY                          = "check";

    public static final String  COUNT_PROTOCOL                     = "count";

    public static final String  TRACE_PROTOCOL                     = "trace";

    public static final String  EMPTY_PROTOCOL                     = "empty";

    public static final String  ADMIN_PROTOCOL                     = "admin";

    public static final String  PROVIDER_PROTOCOL                  = "provider";

    public static final String  CONSUMER_PROTOCOL                  = "consumer";

    public final static String  PATH_SEPARATOR                     = "/";

    public static final String  REGISTRY_SEPARATOR                 = "|";

    public static final Pattern REGISTRY_SPLIT_PATTERN             = Pattern
                                                                           .compile("\\s*[|;]+\\s*");
    public static final String  ANY_VALUE                          = "*";
    public static final String  DYNAMIC_KEY                        = "dynamic";

    /*netty server parameters*/
    public static final String  IO_THREADS_KEY                     = "iothreads";
    public static final int     DEFAULT_IO_THREADS                 = Runtime.getRuntime()
            .availableProcessors() * 4;
    public static final String IDLE_TIME_KEY							="idle";
    public static final int  	DEFAULT_IDLE_TIME							=30;
	public static final String BACKLOG_KEY 							= "backlog";
    public static final String  TIMEOUT_KEY                        = "timeout"; //client time out parameter
	public static final int DEFAULT_TIMEOUT = 	3*1000;

    

	

	public static final String PROP_BACKENDCHANNEL = "backend";

	public static final String UUID_KEY = "uuid";

	public static final String WEIGHT_KEY = "weight";

	public static final String DEFAULT_CHARSET = "UTF-8";

	public static final String CONTEXT_CONNUUID = "localIP";

	public static short EVENT_SAYHI = 0;		//say hi event
	public static final short EVENT_CLIENT_CLUSTER = 1; //event used by client to choice connector[ client cluster]
	public static final short EVENT_REGISTER_CLIENT = 2; //向connector注册服务名称[客户端提供服务的时候才需要注册]
	public static final short EVENT_MSG_CONFIRM = 3; //对消息的确认: 可靠消息: 每个可靠消息都需要一个对应的确认, 非可靠消息: 有可能在出现错误的时候才发送确认.
	public static final short EVENT_CREATE_PRODUCER = 4; //通知connector,让connector做好准备将要调用目标服务
	public static final short EVENT_NEW_BATCH_MSG = 5; //请求一个批次的消息
	public static final short EVENT_DISCONNECT = 6;

	public static final int DEFAULT_CONNECTOR_PORT = 9000;
	public static final int DEFAULT_CONNECTOR_QUEUE_PORT = DEFAULT_CONNECTOR_PORT+1;

	//client 连接connector时进行choice balance选择的协议
	public static final String PROTOCOL_MBSCLUSTER = "mbscluster";
	//Client与MBS[connector]总线通信的协议
	public static final String PROTOCOL_MBS = "mbs";
	//mbs提供的快速queue协议
	public static final String PROTOCOL_PERSISTQUEUE = "mbspq";
	//mbs提供的持久化Queue协议
	public static final String PROTOCOL_FASTQUEUE = "mbsfq";
	public static final String PROTOCOL_TLQQUEUE = "tlq";

	public static final String PERSISTENCEQUEUE_KEY = "pq";

	public static final String FASTEQUEUE_KEY = "fq";


}
