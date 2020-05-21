package com.example.demo.utils.sessionlisten;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:York
 */
public class SessionConf {
	/// <summary>
	/// 是否打开DEBUG输出. 如果要关闭当前OPENDEBUG,请在输出之前将该值设置为false, jee
	/// web项目，可以设置一个listener，设置项目启动。
	/// </summary>
	public static Boolean OpenDebug = true;
	/// <summary>
	/// 是否打开Error输出.如果要关闭当前OPENRROR,请在输出之前将该值设置为false, jee
	/// web项目，可以设置一个listener，设置项目启动。
	/// </summary>
	public static Boolean OpenError = true;

	/**
	 * 打开Log4j的输出.
	 */
	public static Boolean OpenLog = true;

	/**
	 * 后缀. 默认html
	 */
	public static String Suffix = ".html";

	/**
	 * 是否加载页面缓存。
	 */
	public static boolean PageCache = true;

	/**
	 * 单一数据库类型集群？
	 */
	public static Boolean SingleDBType = true;

	/**
	 * 系统是否使用RSA,不使用请在hoyi.config内配置，不使用可以加快一点启动速度.
	 */
	public static boolean USERSA = false;

	/**
	 * 加密公钥,公钥用于传输给客户端.
	 */
	public static String HRSAPublicKey;

	/**
	 * 加密私钥,私钥用于在服务器解密.
	 */
	public static String HRSAPrivateKey;

	// 模
	public static String HRSA_Modules;
	// 公钥指数
	public static String HRSA_Exponent;

	// 私钥指数
	public static String HRSA_private_Exponent;

	/**
	 * 默认数据库类型.
	 */
	public static String DBType = "com.mysql.jdbc.driver";

	/**
	 * 上传文件的路径.
	 */
	public static String UploadFilePath = "";

	/**
	 * 多数据库类型，暂时没用到，所以不是先.
	 */
	public static ArrayList<String> dbtypes = new ArrayList<>();

	/**
	 * 是否加密了JVM， 就是是否把Class都加密了，这个在将系统部署到客户的服务器上的时候需要用到， 需要测试这样做的解析速度。
	 */
	public static boolean EncrytedJVM = false;

	/**
	 * 是否忽略POST和GET請求的區別，打開的話，所有的請求POST,GET都可以獲取到.
	 */
	public static boolean IGNOREPOSTGET = false;

	// ------------------------------ redis 配置
	// ------------------------------------------------------

	/**
	 * redis 服务器地址，这里未做集群，不过这里可以用多个IP，逗号分开。
	 */
	public static String REDIS_ADDR_ARRAY = "127.0.0.1";

	/**
	 * redis 端口.
	 */
	public static int REDIS_PORT = 6379;

	/**
	 * 权限
	 */
	public static String REDIS_AUTH = "";

	/**
	 * 是否开启验证.
	 */
	public static boolean REDIS_openAUTH = false;

	/**
	 * 最大可用连接数， 应该是连接池的概念. 默认值 8
	 */
	public static int REDIS_MAX_ACTIVE = 1000;

	/**
	 * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例， 默认值 8
	 */
	public static int REDIS_MAX_IDLE = 1000;

	/**
	 * 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	 */
	public static int REDIS_MAX_WAIT = -1;

	/**
	 * 超时.
	 */
	public static int REDIS_TIMEOUT = 3000;

	/**
	 * 在borrow一个jedis实例时，是否提前进行validate操作，如果为true,则得到的jedis实例均是可用的.
	 */
	public static boolean REDIS_TEST_ON_BORROW = false;

	/**
	 * 是否打开Redis的集群.默认不适用集群.
	 */
	public static boolean REDIS_OPEN_CLUSTER = false;

	/**
	 * 默认用hoyi的集群，hoyi的集群就是用多台单机，每个机子插入，
	 * 
	 * hoyi集群弊端， 队列和事物可能处理不了。暂时先用这个来处理,之后再把集群的使用调好.
	 */
	public static String REDIS_CLUSTER_TYPE = "HOYI_REDIS_CLUSTER";

	/**
	 * 连接断开，重连次数.
	 */
	public static int MAXATTEMPTS = 2;

	/**
	 * 集群的IP和PORT.
	 */
	// public static Dictionary<String,Integer> REDIS_HOSTANDPORT = new
	// Hashtable<String, Integer>();

	public static List<String> REDIS_HOSTANDPORT = new ArrayList<>();

	/**
	 * 当前项目的REDIS存储前缀.
	 */
	public static String REDIS_PREFIX = "HRSP_";

	// ------------------------------ redis 配置
	// ------------------------------------------------------

	// ------------------------------ MongoDB 配置
	// ----------------------------------------------------
	/**
	 * MongoDB Host.
	 */
	public static String MONGO_HOST = "localhost";

	/**
	 * MongoDB Port
	 */
	public static int MONGO_PORT = 27710;

	/**
	 * MongoDB 数据库名称
	 */
	public static String MONGO_DBNAME = "admin";

	/**
	 * 是否打开验证.
	 */
	public static boolean MONGO_AUTHORITY = true;

	/**
	 * 用户名 .
	 */
	public static String MONGO_USERNAME = "";

	/**
	 * 密码.
	 */
	public static String MONGO_PWDS = "";

	/**
	 * 最大连接数.
	 */
	public static int MONGO_MAXCONNECT = 10;

	// ------------------------------ MongoDB 配置
	// ----------------------------------------------------

	// ------------------------------ 页面静态缓存
	// ----------------------------------------------------

	/**
	 * 是否开启动态缓存.
	 */
	public static boolean OpenedStaticCache = false;

	// ------------------------------ 页面静态缓存
	// ----------------------------------------------------

}
