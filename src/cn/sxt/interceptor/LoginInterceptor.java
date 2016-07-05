package cn.sxt.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invacation) throws Exception {
	String actionName=	invacation.getProxy().getActionName();
	
			if("login_login".equals(actionName)){
				return invacation.invoke();
			}
		Map<String,Object> session=	invacation.getInvocationContext().getSession();
		
		if(session.get("currentUser")!= null){
			return invacation.invoke();
		}
		return "login";
		
	}
}
