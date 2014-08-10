/**
 * 
 */
package com.dhatacas.api.endpoints;

/**
 * The Class SocialActivity.
 *
 * @author hector
 */
public class SocialActivity {

	
	/** The id. */
	private Long id;
	
	/** The like. */
	private Boolean like;
	
	/** The dislike. */
	private Boolean dislike;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Checks if is like.
	 *
	 * @return true, if checks if is like
	 */
	public Boolean isLike() {
		return like;
	}

	/**
	 * Sets the like.
	 *
	 * @param like the like
	 */
	public void setLike(Boolean like) {
		this.like = like;
	}

	/**
	 * Checks if is dislike.
	 *
	 * @return true, if checks if is dislike
	 */
	public Boolean isDislike() {
		return dislike;
	}

	/**
	 * Sets the dislike.
	 *
	 * @param dislike the dislike
	 */
	public void setDislike(Boolean dislike) {
		this.dislike = dislike;
	}
	
	
}
