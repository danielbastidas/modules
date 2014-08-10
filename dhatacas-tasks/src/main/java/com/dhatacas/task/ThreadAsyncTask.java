/**
 * 
 */
package com.dhatacas.task;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.taskqueue.DeferredTask;

/**
 * Represents a task that will be executed in a separated execution thread.
 * 
 * @author hector
 */
public class ThreadAsyncTask implements DeferredTask {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(ThreadAsyncTask.class
			.getName());

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2119508122630151749L;

	/** The key. */
	private String key;

	/**
	 * Instantiates a new thread async task.
	 * 
	 * @param channelKey
	 *            the channel key
	 */
	public ThreadAsyncTask(String channelKey) {
		this.key = channelKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			Thread.sleep(5000);
			ChannelService service = ChannelServiceFactory.getChannelService();
			service.sendMessage(new ChannelMessage(this.key,
					"[Message sent asynchronously from Server]"));
		} catch (InterruptedException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
}
