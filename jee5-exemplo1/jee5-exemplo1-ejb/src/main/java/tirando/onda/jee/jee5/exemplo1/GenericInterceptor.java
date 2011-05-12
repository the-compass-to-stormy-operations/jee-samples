package tirando.onda.jee.jee5.exemplo1;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class GenericInterceptor {
	
	@AroundInvoke
	public Object invoke(InvocationContext ctx) throws Exception {
		if (ctx.getContextData().containsKey("key")) {
			String result = (String) ctx.getContextData().get("key");
			ctx.getContextData().put("key", result+" ["+System.currentTimeMillis()+"]");
		} else {
			ctx.getContextData().put("key", "["+System.currentTimeMillis()+"]");
		}
		
		System.out.println(ctx.getMethod()+" --- "+ctx.getContextData());
		
		return ctx.proceed();
	}

}
