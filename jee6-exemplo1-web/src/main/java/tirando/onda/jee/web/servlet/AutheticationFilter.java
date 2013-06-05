package tirando.onda.jee.web.servlet;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="AuthenticationFilter", urlPatterns="/pages/*", dispatcherTypes={DispatcherType.REQUEST, DispatcherType.FORWARD})
public class AutheticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter");
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
		if (httpRequest.getUserPrincipal() == null) {
			httpRequest.getRequestDispatcher("/login.jsf").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}
