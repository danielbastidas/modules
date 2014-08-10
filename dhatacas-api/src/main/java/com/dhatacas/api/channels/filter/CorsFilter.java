/*
 * 
 */
package com.dhatacas.api.channels.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter used to intercept all request and responses and set some header values
 * in order to avoid No Access-Control-Allow-Origin error
 * 
 * @author hector
 */
public class CorsFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!DoFilter");
		
		if (response instanceof HttpServletResponse) {
			HttpServletResponse alteredResponse = ((HttpServletResponse) response);
			// I need to find a way to make sure this only gets called on
			// 200-300 http responses
			addHeadersFor200Response(alteredResponse);
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * Adds the headers for200 response.
	 * 
	 * @param response
	 *            the response
	 */
	private void addHeadersFor200Response(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!init");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ContextPath:"+filterConfig.getServletContext().getContextPath());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ServerInfo:"+filterConfig.getServletContext().getServerInfo());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ContextName:"+filterConfig.getServletContext().getServletContextName());
		Enumeration en = filterConfig.getServletContext().getServletNames();
		while (en.hasMoreElements()) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ServletName:"+en.nextElement().toString());
		}
		
	}
}