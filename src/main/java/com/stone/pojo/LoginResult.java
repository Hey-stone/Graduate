/**
 * 
 */
package com.stone.pojo;

import java.io.Serializable;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-6-10]
 */
public class LoginResult implements Serializable{

	private static final long serialVersionUID = 2882859596513446420L;
	
	private String code;
	
	private String message;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
