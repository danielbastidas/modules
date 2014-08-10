/**
 * 
 */
package com.dhatacas.api.channels.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class used to override behavior of channel connection 
 * mapped in URL /_ah/channel/disconnected/ hosted in GAE.
 *
 * @author hector
 */
public class ChannelDisconnectedServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1611411590576374683L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

}
