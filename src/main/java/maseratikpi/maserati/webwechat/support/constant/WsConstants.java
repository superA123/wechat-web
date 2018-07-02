package maseratikpi.maserati.webwechat.support.constant;

/**
 * Webservices常量类
 * 
 * @author Clark
 * @version 2016-08-08
 */
public class WsConstants extends Constants {

	/** 版本号 */
	public static final String VersionNo01 = "01";

	/** 结果代码 成功 00 */
	public static final String ResultSuccess = "00";
	/** 结果代码 失败 01 */
	public static final String ResultFailure = "01";

	/**
	 * 推送消息类型
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class MsgType {

		/** 图文推送 */
		public static final String NEWS = "news";
	}

	/**
	 * 服务代码常量类
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class ServiceNo {

		/** 个案状态变更推送 */
		public static final String AlertCaseStatus = "101";
		/** Survey */
		public static final String Survey = "102";
		/** 会议通知 */
		public static final String AlertMeeting = "103";

		/** 下拉列表值 */
		public static final String PicklistValues = "999";

		/** 创建case时，企业号提醒TS的信息 */
		public static final String AlertCase = "201";
		/** 创建work order派单时，企业号的提醒现场工程师信息 */
		public static final String AlertWorkOrder = "202";
		/** 现场工程师查询名下待办的work order列表 */
		public static final String WorkOrderList = "203";
		/** 现场工程师查询待办的work order列表 */
		public static final String WorkOrderDetail = "204";
		/** 现场工程师填写的反馈页面 */
		public static final String WorkOrderFeedback = "205";

		/** SFDC 查询工作订单列表 */
		public static final String SfdcWorkOrderList = "301";
		/** SFDC 查询工作订单详细 */
		public static final String SfdcWorkOrderDetail = "302";
		/** SFDC 接单或退单 */
		public static final String SfdcWorkOrderAccept = "303";
		/** SFDC Field Service人员，查询工单信息 */
		public static final String SfdcWorkOrderUpdateRetrive = "304";
		/** SFDC Field Service人员，提交工单信息 */
		public static final String SfdcWorkOrderUpdateCommit = "305";
		/** CreateCaseYq */
		public static final String CreateCaseYq = "306";
		/** CreateCaseHc */
		public static final String CreateCaseHc = "307";
		/** 页面返回值 ---- 接单 */
		public static final String WorkOrderStart05 = "wo_status04";
		/** 页面返回值 ---- 退单 */
		public static final String WorkOrderStart06 = "wo_status05";
		/** 页面返回值 ---- 申请配件 */
		public static final String WorkOrderStart02 = "wo_status02";
		/** 页面返回值 ---- 反馈 */
		public static final String FeedBack = "feedback";
		/** 返回结果：00正常。 */
		public static final String ResultFlag00 = "00";
		/** 返回结果：01异常。 */
		public static final String ResultFlag01 = "01";

	}

	/**
	 * 错误代码常量类
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class ErrorNo {
		/** SFDC连接失败 */
		public static final String Error901 = "E901";

		/** 错误代码 版本号不正确 E001 */
		public static final String Error001 = "E001";
		/** 错误代码 服务代码不正确 E002 */
		public static final String Error002 = "E002";
		/** 错误代码 参数异常 E003 */
		public static final String Error003 = "E003";
	}

	/**
	 * 错误代码常量类
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class Status {
		/** 绑定身份成功 */
		public static final String Binding0 = "0";
		/** 绑定身份失败 */
		public static final String Binding1 = "1";
		/** 绑定身份重复 */
		public static final String Binding2 = "2";

		/** 检验身份成功 */
		public static final String CheckBinding0 = "0";
		/** 已绑定标识 */
		public static final String CheckBindingIsExist0 = "0";

		/** Survey成功 */
		public static final String Survey0 = "0";
		/** Survey重复提交 */
		public static final String Survey2 = "2";
	}
	/**
	 * 字符常量
	 */

}
