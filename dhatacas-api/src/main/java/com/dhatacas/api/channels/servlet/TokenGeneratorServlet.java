package com.dhatacas.api.channels.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

/**
 * Class used to instantiate a new Channel of communication with a chat client
 * running HTML. This implementation receive a parameter that represents a
 * unique identifier (Webogram user ID) and proceed to create an object of
 * google Channel API. This channel is represented as a token and it is written
 * to client through a server resp.
 */
@SuppressWarnings("serial")
public class TokenGeneratorServlet extends HttpServlet {

	/** The channel service. */
	private static ChannelService channelService = ChannelServiceFactory
			.getChannelService();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletreq
	 * , javax.servlet.http.HttpServletresp)
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String channelKey = req.getParameter("c");

		// Create a Channel using the 'channelKey' we received from the client
		String token = channelService.createChannel(channelKey);

		// Send the client the 'token' + the 'channelKey' this way the client
		// can start using the new channel
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write(token);
		out.flush();
	}
}
