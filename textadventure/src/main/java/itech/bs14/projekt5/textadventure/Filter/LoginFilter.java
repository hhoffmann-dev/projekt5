package itech.bs14.projekt5.textadventure.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import itech.bs14.projekt5.textadventure.Views.LoginView;


@Component("LoginFilter")
@Scope("session")
public class LoginFilter implements Filter {


	  public static final String LOGIN_PAGE = "/Login.xhtml";

	  @Override
	  public void doFilter(ServletRequest servletRequest,
	      ServletResponse servletResponse, FilterChain filterChain)
	      throws IOException, ServletException {

	    HttpServletRequest httpServletRequest =
	        (HttpServletRequest) servletRequest;
	    HttpServletResponse httpServletResponse =
	        (HttpServletResponse) servletResponse;

	    // managed bean name is exactly the session attribute name
	    LoginView userManager = (LoginView) httpServletRequest
	        .getSession().getAttribute("LoginView");

	    if (userManager != null) {
	      if (userManager.isLoggedIn()) {
	        // user is logged in, continue request
	        filterChain.doFilter(servletRequest, servletResponse);
	      } else {
	        // user is not logged in, redirect to login page
	        httpServletResponse.sendRedirect(
	            httpServletRequest.getContextPath() + LOGIN_PAGE);
	      }
	    } else {
	      // user is not logged in, redirect to login page
	      httpServletResponse.sendRedirect(
	          httpServletRequest.getContextPath() + LOGIN_PAGE);
	    }
	  }

	  @Override
	  public void init(FilterConfig arg0) throws ServletException {
	  }

	  @Override
	  public void destroy() {
	    // close resources
	  }
	}
