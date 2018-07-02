package maseratikpi.maserati.webwechat.jeesite.core.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import  maseratikpi.maserati.webwechat.jeesite.core.common.config.Global;
import  maseratikpi.maserati.webwechat.jeesite.core.common.utils.StringUtils;
import nl.bitwalker.useragentutils.DeviceType;
import nl.bitwalker.useragentutils.UserAgent;

/**
 * 系统拦截器
 * @author Clark
 * @version 2014-11-20
 */
@Component
public class LogInterceptor implements HandlerInterceptor {
	/**
	 * 日志对象
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null) {
			String viewName = modelAndView.getViewName();
			UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent")); 
			if(viewName.startsWith("modules/") && DeviceType.MOBILE.equals(userAgent.getOperatingSystem().getDeviceType())){
				modelAndView.setViewName(viewName.replaceFirst("modules", "mobile"));
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {
		
		String requestRri = request.getRequestURI();
		String uriPrefix = request.getContextPath() + Global.getAdminPath();
		// 是否保存日志
		if ((StringUtils.startsWith(requestRri, uriPrefix) && this.isSaveLog(requestRri)) || ex != null) {
		
				
		}
	}
	
	/**
	 * @author Clark
	 * @date 2014年11月20日
	 * 
	 * @Description 判断当前操作是否保存日志
	 * @param requestRri
	 * @return
	 */
	private boolean isSaveLog(String requestRri){
		boolean isSave = false;
		// 取得URL后缀
		String[] urlSuffixs = Global.getStringArray("mvc.logInterceptor.urlSuffix");
		if (urlSuffixs == null || urlSuffixs.length == 0) {
			isSave = true;
		} else {
			for (String urlSuffix : urlSuffixs) {
				if (StringUtils.endsWith(requestRri, urlSuffix)) {
					isSave = true;
					break;
				}
			}
		}
		
		return isSave;
	}
}
