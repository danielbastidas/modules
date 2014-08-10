package com.dhatacas.api.channels.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhatacas.task.ThreadAsyncTask;
import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

/**
 * Class used to serve as communication channel between dhatacas application
 * running with node.js technology and enterprise part of solution. This
 * implementation just receive the channel key and message and proceed with as
 * echo behavior. In addition there is a simple test of asynchronous task with
 * purpose of sending messages in different execution's thread
 */
@SuppressWarnings("serial")
public class ChatServlet extends HttpServlet {

	/** The channel service. */
	private static ChannelService channelService = ChannelServiceFactory
			.getChannelService();

	/** The my queue. */
	private static Queue myQueue = QueueFactory.getDefaultQueue();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String channelKey = req.getParameter("channelKey");
		String message = req.getParameter("message");
		message = "ECHO: [" + message + "]";

		// Send a message based on the 'channelKey' any channel with this key
		// will receive the message
		channelService.sendMessage(new ChannelMessage(channelKey, message));
		ThreadAsyncTask myTask = new ThreadAsyncTask(channelKey);
		myQueue.add(TaskOptions.Builder.withPayload(myTask));
	}
}
