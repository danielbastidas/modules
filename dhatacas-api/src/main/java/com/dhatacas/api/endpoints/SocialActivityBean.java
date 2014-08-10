/**
 * 
 */
package com.dhatacas.api.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

/**
 * The Class SocialActivityBean.
 *
 * @author hector
 */

@Api(name = "dhatacas", 
	 version = "v1", 
	 scopes = { Constants.EMAIL_SCOPE }, 
	 clientIds = {
		Constants.WEB_CLIENT_ID, 
		Constants.ANDROID_CLIENT_ID,
		Constants.IOS_CLIENT_ID 
		}, 
	 audiences = { 
		Constants.ANDROID_AUDIENCE 
		}
)
public class SocialActivityBean {

	
	/**
	 * Like.
	 *
	 * @return the social activity
	 */
	@ApiMethod(name = "socialactivity.like", httpMethod = "post")
	public SocialActivity like(@Named("id") Long id){
		SocialActivity sa = new SocialActivity();
		sa.setId(id);
		sa.setLike(true);
		return sa;
	}
	
	/**
	 * Dislike.
	 *
	 * @return the social activity
	 */
	@ApiMethod(name = "socialactivity.dislike", httpMethod = "post")
	public SocialActivity dislike(@Named("id") Long id){
		SocialActivity sa = new SocialActivity();
		sa.setId(id);
		sa.setDislike(true);
		return sa;
	}
	
	/**
	 * Follow.
	 */
	@ApiMethod(name = "socialactivity.follow", httpMethod = "post")
	public void follow(@Named("id")Long id){
	}
}
