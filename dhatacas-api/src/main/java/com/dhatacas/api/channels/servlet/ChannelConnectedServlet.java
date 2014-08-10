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
 * mapped in URL /_ah/channel/connected/ hosted in GAE.
 *
 * @author hector
 */
public class ChannelConnectedServlet extends HttpServlet {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8837724052485267898L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
}
