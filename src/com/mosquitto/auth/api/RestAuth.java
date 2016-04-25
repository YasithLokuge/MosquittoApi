/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
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

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




/**
 * The Class RestMqttAuth.
 * @author Yasith Lokuge
 */
@Path("/authplugin")
public class RestAuth {
		
	/** The mosquitto auth. */
	MosquittoAuth mosquittoAuth = new MosquittoAuth();
	
	/**
	 * Auth.
	 *
	 * @param username the username
	 * @param password the password
	 * @param topic the topic
	 * @param acc the acc
	 * @return the response
	 */
	@POST
	@Path("/auth")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response auth(	@FormParam("username") String username,   // consume only username and password
    						@FormParam("password") String password,
    						@FormParam("topic") String topic,
    						@FormParam("acc") String acc) {
		
		
		if(mosquittoAuth.authCheck(username, password)){			
			return Response.status(Response.Status.OK).build();			
		}

		return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }   
	
	
	/**
	 * Superuser.
	 *
	 * @param username the username
	 * @param password the password
	 * @param topic the topic
	 * @param acc the acc
	 * @return the response
	 */
	@POST
	@Path("/superuser")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response superuser(	@FormParam("username") String username,  // consume only username
    							@FormParam("password") String password,
    							@FormParam("topic") String topic,
    							@FormParam("acc") String acc) {
						
		if(mosquittoAuth.superUserCheck(username)){			
			return Response.status(Response.Status.OK).build();			
		}

		return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }  
	
	/**
	 * Acl.
	 *
	 * @param username the username
	 * @param password the password
	 * @param topic the topic
	 * @param acc the acc
	 * @param clientid the clientid
	 * @return the response
	 */
	@POST
	@Path("/acl")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response acl(	@FormParam("username") String username,  // consume only username and topic
    						@FormParam("password") String password,
    						@FormParam("topic") String topic,
    						@FormParam("acc") String acc,
    						@FormParam("clientid") String clientid) {
		
		
		if(mosquittoAuth.aclCheck(username, topic)){			
			return Response.status(Response.Status.OK).build();			
		}

		return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }  
	
	
}
