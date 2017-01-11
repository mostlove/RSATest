package com.magicbeans.util;

public class StatusConstant {
	
	/**未认证*/
	public static final Integer UNAUTHORIZED = 0;
	/**认证中*/
	public static final Integer CERTIFICATIONING = 1;
	/**已认证*/
	public static final Integer AUTHENTICATED = 2;
	/**账户有效*/
	public static final Integer ACCOUNT_VALID = 0;
	/**账户无效*/
	public static final Integer ACCOUNT_NON_VALID = 1;
	/**乘客*/
	public static final Integer PASSENGER = 0;
	/**司机*/
	public static final Integer DRIVER = 1;
	/**性别 男*/
	public static final Integer MAN = 0;
	/**性别 女*/
	public static final Integer WOMAN = 1;
	
	/**支付方式 之  余额支付*/
	public static final Integer PAYMETHOD_BANLANCE = 0;
	/**支付方式 之 支付宝支付*/
	public static final Integer PAYMETHOD_ALIPAY = 1;
	/**支付方式 之 微信支付*/
	public static final Integer PAYMETHOD_WXPAY = 2;
	/**支付方式 之 优惠券抵扣*/
	public static final Integer PAYMETHOD_COUPON = 3;
	
	
	// 钱包相关 wallet_type
	/** 钱包类型   余额*/
	public static final Integer BALANCE =0;
	/**钱包类型  优惠券  代金券和折扣券*/
	public static final Integer CASH_COUPON =1;
	//该钱包主人的类型  0:乘客  1:车主 2:平台
	/**乘客钱包*/
	public static final Integer PASSENGER_MONEY = 0; 
	/**车主钱包*/
	public static final Integer DRIVER_MONEY = 1;
	/**平台钱包*/
	public static final Integer TERRACE_MONEY = 2;
	/**代理商钱包*/
	public static final Integer AGENT_MONEY = 3;
	
	// 错误代码
	/**获取成功*/
	public static final Integer SUCCESS_CODE = 200;
	/**获取失败*/
	public static final Integer Fail_CODE = 202;
	/**第一次登录*/
	public static final Integer FRTST_LOGIN = 203;
	/**参数异常*/
	public static final Integer ARGUMENTS_EXCEPTION = 204;
	
	/**帐号未通过*/
	public static final Integer ACCOUNT_UNPASS = 205;
	
	
	/**没有权限 错误代码*/
	public static final Integer NOT_AGREE = 1001;
	/**对象不存在*/
	public static final Integer OBJECT_NOT_EXIST = 1002;
	/**字段不能为空*/
	public static final Integer FIELD_NOT_NULL= 1003;
	/**正在审核*/
	public static final Integer PENDING = 1004;
	/**未登录*/
	public static final Integer NOTLOGIN= 1005;
	/**没有数据*/
	public static final Integer  NO_DATA = 1006;
	/**账户被冻结*/
	public static final Integer ACCOUNT_FROZEN = 1007;
	/**订单无效*/
	public static final Integer ORDER_INVALID = 1008;
	/**订单状态异常*/
	public static final Integer ORDER_STATUS_ABNORMITY = 1009;
	/**对象已经存在*/
	public static final Integer OBJECT_EXIST = 1010;
	/**没有权限*/
	public static final Integer NON_ALLOW = 1011;
	/**密码为空*/
	public static final Integer PWD_EMPTY = 1012;
	/**时间无效*/
	public static final Integer TIME_INVALID = 1013;
	/**线路未开通*/
	public static final Integer LINE_UNOPEN = 1014;
	/**线路限时*/
	public static final Integer LINE_LIMIT_TIME = 1015;
	/**没有车辆*/
	public static final Integer CAR_NO_HAVA = 1016;
	/**此时属于包车时间段*/
	public static final Integer TIME_CHARTER = 1017;
	/**有未支付 或者 未完成的订单*/
	public static final Integer UN_PAY = 1018;
	/**订单的人数错误*/
	public static final Integer PEOPLE_ERROR = 1019;
	// 2000-2999 订单使用
	
	
	/**申请提现*/
	public static final Integer CASH_APPLICATION = 4001;
	/**银行正在处理中*/
	public static final Integer CASH_HANDLING = 4002;
	/**处理完成  已经提现到银行*/
	public static final Integer CASH_FINISHED = 4003;
	/**交易失败*/
	public static final Integer CASH_FILAD = 4004;
	
	// 设备类型
	/**android*/
	public static final Integer ANDROID=0;
	/**ios*/
	public static final Integer IOS = 1;
	
	
	//角色类型
	/**平台管理员*/
	public static final Integer ADMINUSER = 1;
	/**客户中心*/
	public static final Integer CUSTOMER = 2;
	/**财务*/
	public static final Integer FINANCE = 3;
	/**营销推广*/
	public static final Integer MARKETING = 4;
	/**行政办公室*/
	public static final Integer EXECUTIVE_OFFICE = 5;
	/**区域经理*/
	public static final Integer REGIONAL_MANAGER = 6;
	/**代理商*/
	public static final Integer AGENT = 7;
	
	//路线
	/**路线已存在*/
	public static final Integer LINEEXIST = 0;
	
	//有车时间段
	/**状态：关闭    说明：当前状态表示 还有车辆使用*/
	public static final Integer HAVE_STATUS_CLOSE = 0;
	/**状态：开启    说明： 当前状态表示 车辆已经达到饱和  已经没有车可使用   请设置为当前状态   并设置什么时候之后会有车辆使用*/
	public static final Integer HAVE_STATUS_OPEN = 1;
	
	
	//投诉 0:无效 1：处理中 2:有效
	/**投诉 0:无效*/
	public static final Integer COMPLAIN_INVALID= 0;
	/**投诉 1：处理中*/
	public static final Integer COMPLAIN_UNTREATED = 1;
	/**投诉 2:有效*/
	public static final Integer COMPLAIN_VALID = 2;
	/**优惠券未发放*/
	public static final Integer COMPLAIN_COUPON_ALREADY_ISSUED = 0;
	/**优惠券已发放*/
	public static final Integer COMPLAIN_COUPON_UNISSUED =1;
	
	
	
	
	//分销等级
	/**一级分销*/
	public static final Integer DISTRIBUTION_LEVEL_ONE = 1;
	/**二级分销*/
	public static final Integer DISTRIBUTION_LEVEL_TWO = 2;
	/**三级分销*/
	public static final Integer DISTRIBUTION_LEVEL_THREE = 3;
	
	
	
	
	// 短信话术
	
	/**拒绝通过认证信息 短信话术*/
	public static final String REJECTS_AUTHENTICATION_TEXT = "【黑马出行】对不起，您未通过{0}认证，请重新提交信息";
	/**审核通过认证信息 短信话术*/
	public static final String APPROVED_AUTHENTICATION_TEXT = "【黑马出行】恭喜您，您已通过{0}认证，请重新登录使用。";
	/**密码相关 验证码*/
	public static final String ABOUT_PASSWORD_TEXT = "【黑马出行】您的验证码是{0}。如非本人操作，请忽略本短信";
	/**注册时 发送短信*/
	public static final String REGISTER_TEXT = "【黑马出行】感谢您注册{0}，您的验证码是{1}";
	/**后台分配线下订单，发送消息给司机 模版*/
	public static final String OFFLINE_ORDER_TO_DRIVER = "【黑马出行】您有一个{0}人的线下订单，乘客信息：{1}先生/女士，手机号：{2} , 请尽快联系";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
