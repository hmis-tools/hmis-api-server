package org.openhims.oauth2.rest.impl;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.oauth2.common.OAuth2AccessToken;




@XmlRootElement
public class CreateAccessTokenResponse 
{
	private OAuth2AccessToken oAuth2AccessToken;

}
