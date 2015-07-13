package org.openhims.oauth2.rest.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openhims.oauth2.exception.BadClientCredentialException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;


@Component
public class Oauth2RestEntryPoint implements AuthenticationEntryPoint
{

	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authenticationException) throws IOException, ServletException 
	{
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		Gson gson = new Gson();
		String errorEntity = gson.toJson(new BadClientCredentialException("Bad client credentials"));
        response.getOutputStream().print(errorEntity);
	}

}
