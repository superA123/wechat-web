package maseratikpi.maserati.webwechat.support.constant;

/**
 * 常量类
 * 
 * @author Clark
 * @date 2014年5月11日
 */
public class Constants {

	/**
	 * 异常消息国际化标识key前缀
	 */
	public static final String MessageCommonPrefix = "message.common.";

	/** 处理成功失败相关（0：成功/1：失败） */
	public static final String Success = "0";
	public static final String Failed = "1";
	
	/** 日期常量 */
	public static class Dates {
		public static final String DATE_MIN = "1900-01-01";
		public static final String DATE_MAX = "9999-12-31";
		public static final String Formate_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
		public static final String Formate_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
		public static final String Formate_YYYY_MM_DD = "yyyy-MM-dd";
		/**
		 * 日期格式化：YYYYMMDD
		 */
		public static final String FORMATE_YYYYMMDD = "yyyyMMdd";
		/**
		 * 日期格式化：YYMMDD
		 */
		public static final String FORMATE_YYMMDD = "yyMMdd";
	}
	
	/**
	 * 错误代码常量类
	 * 
	 * @author Clark
	 * @version 2016-08-08
	 */
	public static class ErrorNo {
		/** 错误代码 未知异常 E999 */
		public static final String Error999 = "E999";
		
		/** 错误代码 参数异常 E001 */
		public static final String Error001 = "E001";
		/** 错误代码 参数异常 E002 */
		public static final String Error002 = "E002";
		/** 错误代码 参数异常 E003 */
		public static final String Error003 = "E003";
	}
}
