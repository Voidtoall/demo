package com.example.common.constrant;

import java.math.BigDecimal;

public class Constants {
	
	//用户状态 10 已注册 20 正常  30 已交押金 40 已实名制  50 注销  60 黑名单 
	public static final int USER_STATUS_REGISTER = 10;
	public static final int USER_STATUS_OK = 20;
	//public static final int USER_STATUS_PAID= 30;
	public static final int USER_STATUS_REALNAME= 40;
	public static final int USER_STATUS_DELETE= 50;
	//public static final int USER_STATUS_BLACKLIST= 60; 更改为以下：
	public static final int BLACK_YES = 1; //是
	public static final int BLACK_NO = 0 ;//否
	
	
	// 车状态 0 解锁中 10 维修中或生产中 20 可以运行 30 运行  40 异常 50 下线 60 报废
	public static final int BIKE_STATUS_UNLOCKING = 0;
	public static final int BIKE_STATUS_INIT = 10;
	public static final int BIKE_STATUS_OK = 20;
	public static final int BIKE_STATUS_WORKING = 30;
	public static final int BIKE_STATUS_EXCEPTION = 40;
	public static final int BIKE_STATUS_DELETE = 50;
	public static final int BIKE_STATUS_GIVE_UP = 60;

	public static final int LOCK_STATUS_OK = 20;
	public static final int LOCK_STATUS_EXCEPTION = 40;
	
	// 解锁的key 前缀
	public static final String BIKE_UNLOCK_KEY = "unlock";
	// 解锁的key 前缀
	public static final String BIKE_UNLOCK_SUCCESS_KEY = "unlock_success";
	
	
	
	//对应ubike_order表的 status 订单状态  0 初始状态 10 进行中 20 已完成 30 异常订单 40 手动结束 ；50已退款
	public static final int ORDER_STATUS_ING = 10;
	public static final int ORDER_STATUS_INIT = 0;
	public static final int ORDER_STATUS_OK = 20;
	public static final int ORDER_STATUS_EXCEPTION = 30;
	public static final int ORDER_STATUS_FINISH_BY_ADMIN = 40;
	public static final int ORDER_STATUS_REFUND_OK = 50;
	
	//对应pay_order表的 status字段 0 默认值 10 支付成功  20 支付失败 30 退款中 40 退款成功 50 退款失败;
	//60退押金记录创建；70退押金成功
	// 接口支付订单状态
	public static final int PAY_ORDER_STATUS_DEFAULT = 0;
    public static final int PAY_ORDER_STATUS_ING = 10;
    public static final int PAY_ORDER_STATUS_OK = 20;
    public static final int PAY_ORDER_STATUS_FAIL = 30;
//	public static final int ORDER_PAY_STATUS_OK = 10;
//	public static final int ORDER_PAY_STATUS_FAIL = 20;
	public static final int PAY_ORDER_STATUS_REFUND = 30;
	public static final int PAY_ORDER_STATUS_REFUND_OK = 40;
	public static final int PAY_ORDER_STATUS_REFUND_FAIL = 50;
	public static final int PAY_ORDER_STATUS_REFUND_DEPOSIT_INIT = 60;
	public static final int PAY_ORDER_STATUS_REFUND_DEPOSIT_OK = 70;
	
	
	// 支付渠道
	public static final int ZFB_CHANNEL_PAY  = 2;
	public static final int WEIXIN_CHANNEL_PAY  = 1;
	
	// 实名认证类型
	public static final int REAL_NAME_CARDNO  = 1;  //身份证号
	public static final int REAL_NAME_PASSPORT  = 2; // 护照
	
	// 来源
	public static final int SOURCE_TYPE_WEIXIN  = 1; // 来源微信
	public static final int SOURCE_TYPE_IOS  = 2; // 来源 app
	public static final int SOURCE_TYPE_Android  = 3; // 来源 android
	
	//isExistsBike  桩上是否有自行车
	public static final int EXISTS_YES = 1;
	public static final int EXISTS_NO = 0;
	
	//余额变化
	public static final int BALANCE_CHANGE_ADD = 20;
	public static final int BALANCE_CHANGE_MIN = 10;
	public static final int BALANCE_REFUND = 30; // 日志（用户余额日志），订单退款
	public static final int BALANCE_REFUND_DEPOSIT = 40; // 日志（用户余额日志），用户退押金
	
	//余额状态
	public static final int BALANCE_STATUS_OK = 10;
	public static final int BALANCE_STATUS_FROZEN = 20;

	//押金状态
	public static final int DEPOSIT_STATUS_INIT = 0;
	public static final int DEPOSIT_STATUS_OK = 10;
	public static final int DEPOSIT_STATUS_FROZEN = 20;

	//对应payorder表的 pay type 字段
	public static final int PAY_ORDER_TYPE_DEPOSIT = 10; // 交押金
	public static final int PAY_ORDER_TYPE_CHARGE = 20; // 充值
	public static final int PAY_ORDER_REFUND_DEPOSIT_RECORD = 30; // 退款记录表（ubike_pay_order），用户退押金

	//押金申请单 状态 申请单状态：10 创建 20 申批中  
	//30 审和通过已退押金  40退押金审核未通过退款失败 50退款异常
	public static final int APPLY_CTREATE = 10;
	public static final int APPLY_ING = 20;
	public static final int APPLY_OK = 30;
	public static final int APPLY_FAIL = 40;
	public static final int APPLY_EXCEPTION = 50;
	
	// 1 男  2女
    public static final int BOY = 1;
    public static final int GIRL = 2;
    
    //退款申请单类型 对应表 ubike_re_deposit_apply type字段 0押金退款申请   1 订单退款申请
    public static final int RRFUND_DEPOSIT = 0; 
    public static final int RRFUND_ORDER = 1;
    
	//押金金额  先这样写  后面的写入数据库 从数据库获取
	public static final String DEFAULT_DEPOSIT_KEY = "default_deposit";
	public static final String DEFAULT_PRICE_KEY = "default_price";
	public static final String CURRENT_PRICE_KEY = "current_price";
	
	// 所有的锁车通知  均记录在redis当中 然后通过定时任务  来计费结束订单
	public static final String LOCK_NUMBER_KEY = "LOCK_IMEI";
	
	//一小时用车  单价
	public static final BigDecimal MINIMUM_PRICE = new BigDecimal(1);
	
	//登陆接口
	public static final String URL_LOGIN="http://gps.txkwl.com/android/UserApi.asmx/LoginUser";
	public static final String URL_LOGIN_PARA="username=yuyi&password=12345677";

	//获取锁列表
	public static final String URL_CARLIST=
	        "http://gps.txkwl.com/android/UserApi.asmx/CarList";
	     
	//解锁
	public static final String URL_UNLOCK=
            "http://gps.txkwl.com/android/UserApi.asmx/SendDeviceCmd";
	
	//查询解锁结果
	public static final String URL_LOCK_ORDER = 
	        "http://gps.txkwl.com/android/UserApi.asmx/GetOrderList";
	
    public static final String URL_UNLOCK_PARA =   
            "cmd=LOCK&content=1,1&remote=&imei=";

	public static final String MODULE_SIGN_UP = "sign_up";

	public static final String URL_LOCK = "http://139.224.2.35:8080/v1/bikes/lock";
  

}
