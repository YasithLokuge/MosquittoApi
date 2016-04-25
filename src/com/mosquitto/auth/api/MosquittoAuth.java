/*******************************************************************************
 * Copyright  (c) 2015-2016, Cobweb IO (http://www.cobweb.io) All Rights Reserved.
 *   
 * Cobweb IO licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.mosquitto.auth.api;


/**
 * The Class MosquittoAuth.
 * @author Yasith Lokuge
 */
public class MosquittoAuth {

	/** The Constant SUPER_USER_NAME. */
	private static final String SUPER_USER_NAME = "superuser";	
	
	/** The Constant USER_NAME. */
	private static final String USER_NAME = "user";
	
	/** The Constant PASSWORD. */
	private static final String PASSWORD= "root123";
	
	/** The Constant TOPIC. */
	private static final String TOPIC= "temperature";
	
	
	/**
	 * Check user name.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean checkUserName(String username){
		return username.equals(USER_NAME);
	}	
	
	/**
	 * Auth check.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean authCheck(String username ,String password){				
		return (username.equals(USER_NAME) && password.equals(PASSWORD));							
	}	

	/**
	 * Acl check.
	 *
	 * @param username the username
	 * @param topic the topic
	 * @return true, if successful
	 */
	public boolean aclCheck(String username ,String topic){		
		return(username.equals(USER_NAME) && topic.equals(TOPIC));			 				
	}
	
	/**
	 * Super user check.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean superUserCheck(String username){		
		return username.equals(SUPER_USER_NAME);							
	}
}