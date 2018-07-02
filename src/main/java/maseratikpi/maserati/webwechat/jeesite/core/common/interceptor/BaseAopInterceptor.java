package maseratikpi.maserati.webwechat.jeesite.core.common.interceptor;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import  maseratikpi.maserati.webwechat.jeesite.core.common.service.BusinessException;
import  maseratikpi.maserati.webwechat.jeesite.core.common.service.ExceptionConstant;
import  maseratikpi.maserati.webwechat.jeesite.core.common.service.ServiceException;
import  maseratikpi.maserati.webwechat.jeesite.core.common.utils.Collections3;
import  maseratikpi.maserati.webwechat.jeesite.core.common.utils.Exceptions;

/**
 * @author Clark
 * @version 2014-11-20
 * 
 * Aop拦截器基类
 */
public abstract class BaseAopInterceptor{
	private static final Logger logger  = LoggerFactory.getLogger(BaseAopInterceptor.class);
	
	/**
	 * 切入点
	 */
	//@Pointcut("execution(public * com.jeesite.*.modules..service.*.*(..)) && @annotation(org.springframework.transaction.annotation.Transactional)")
	protected abstract void pointcut();
	
	/**
	 * 异常切入点
	 */
//	@Pointcut("execution(public * com.jeesite.*.modules..service.*.*(..))")
	protected abstract void pointcutForThrowing();

	/**
	 * 前置通知
	 * @param joinPoint
	 */
	// @Before(value="pointcut()")
	public void doBefore(JoinPoint joinPoint) {
	};

	/**
	 * 最终通知
	 * @param joinPoint
	 */
	// @After(value="pointcut()")
	public void doAfter(JoinPoint joinPoint) {
	};

	/**
	 * 后置通知
	 * @param joinPoint
	 */
	// @AfterReturning(value="pointcut()")
	public void doAfterReturning(JoinPoint joinPoint) {
	};
	
	/**
	 * 环线通知
	 * @param joinPoint
	 */
	@Around(value="pointcut()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 调用方法名
		String methodName = joinPoint.getSignature().toString();
		// logger.info("==========Begin="+methodName+"==========");
		logger.info("==========开始=" + methodName + "==========");
		// 调用参数
		Object[] args = joinPoint.getArgs();
		// logger.info("==========Args==========");
		logger.info("==========参数==========");
		String argsString = Collections3.convertToString(Arrays.asList(args), "=");
		logger.info("=" + argsString);
		// 方法返回值
		Object result = joinPoint.proceed();
		// logger.info("==========Result==========");
		logger.info("==========返回值==========");
		if (result == null) {
			logger.info("=null");
		} else {
			logger.info("=" + result.toString());
		}
		
		// logger.info("==========End="+methodName+"==========");
		logger.info("==========结束=" + methodName + "==========");
		
		return result;
	}
	
	/**
	 * 例外通知
	 * @param joinPoint
	 */
	@AfterThrowing(value = "pointcutForThrowing()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Exception e) throws Throwable {
		if (e instanceof DataAccessException) {
			logger.error("==========SQLException==========");
			logger.error("=" + Exceptions.getStackTraceAsString(e));
			throw new ServiceException(ExceptionConstant.DB_CONNECTION_EXCEPTION);
		} else if (e instanceof BusinessException) {
			throw e;
		} else if (e instanceof ServiceException) {
			logger.error("==========ServiceException==========");
			throw e;
		} else {
			logger.error("==========Exception==========");
			logger.error("=" + Exceptions.getStackTraceAsString(e));
			throw new ServiceException(ExceptionConstant.SYSTEM_EXCEPTION);
		}
	}
}
