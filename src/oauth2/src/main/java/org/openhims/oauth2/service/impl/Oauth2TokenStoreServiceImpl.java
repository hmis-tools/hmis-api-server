package org.openhims.oauth2.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openhims.oauth2.dao.OAuth2RefreshTokenRepository;
import org.openhims.oauth2.dao.Oauth2AccessTokenRepository;
import org.openhims.oauth2.domain.OAuth2AuthenticationAccessToken;
import org.openhims.oauth2.domain.OAuth2AuthenticationRefreshToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

@Service
public class Oauth2TokenStoreServiceImpl implements TokenStore 
{
	private final Oauth2AccessTokenRepository oauth2AccessTokenRepository;
	private final OAuth2RefreshTokenRepository oauth2RefreshTokenRepository;
	
	private AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();
	
	@Autowired
	public Oauth2TokenStoreServiceImpl(final Oauth2AccessTokenRepository oauth2AccessTokenRepository, final OAuth2RefreshTokenRepository oauth2RefreshTokenRepository)
	{
		this.oauth2AccessTokenRepository = oauth2AccessTokenRepository;
		this.oauth2RefreshTokenRepository = oauth2RefreshTokenRepository;
	}
	
	public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) 
	{
		List<OAuth2AuthenticationAccessToken> tokens = oauth2AccessTokenRepository.findByClientId(clientId);
		return extractAccessTokens(tokens);
	}

	public Collection<OAuth2AccessToken> findTokensByUserName(String clientId, String userName) 
	{
		List<OAuth2AuthenticationAccessToken> tokens =  oauth2AccessTokenRepository.findByClientIdAndUserName(clientId, userName);
		return extractAccessTokens(tokens);
	}

	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) 
	{
		OAuth2AuthenticationAccessToken token = oauth2AccessTokenRepository.findByAuthenticationId(authenticationKeyGenerator.extractKey(authentication));
		return token == null?null:token.getoAuth2AccessToken();
	}

	public OAuth2AccessToken readAccessToken(String tokenValue) {
		OAuth2AuthenticationAccessToken token = oauth2AccessTokenRepository.findByTokenId(tokenValue);
		if (token == null)
			return null;
		OAuth2AccessToken accessToken = token.getoAuth2AccessToken();
		return accessToken;
	}

	public OAuth2Authentication readAuthentication(OAuth2AccessToken oauth2AccessToken) 
	{
		return readAuthentication(oauth2AccessToken.getValue());
	}

	public OAuth2Authentication readAuthentication(String tokenId)
	{
		return oauth2AccessTokenRepository.findByTokenId(tokenId).getAuthentication();
	}

	public void removeAccessToken(OAuth2AccessToken token) 
	{
		OAuth2AuthenticationAccessToken accessToken =  oauth2AccessTokenRepository.findByTokenId(token.getValue());
		if (accessToken != null)
		{
			oauth2AccessTokenRepository.delete(accessToken);
		}
	}
	public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken refreshToken) 
	{
		return oauth2RefreshTokenRepository.findByTokenId(refreshToken.getValue()).getAuthentication();
	}

	public OAuth2RefreshToken readRefreshToken(String tokenValue) 
	{
		return oauth2RefreshTokenRepository.findByTokenId(tokenValue).getoAuth2RefreshToken();
	}
	public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) 
	{
		oauth2AccessTokenRepository.delete(oauth2AccessTokenRepository.findByRefreshToken(refreshToken.getValue()));
	}

	public void removeRefreshToken(OAuth2RefreshToken refreshToken) {
		oauth2RefreshTokenRepository.delete(oauth2RefreshTokenRepository.findByTokenId(refreshToken.getValue()));

	}

	public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) 
	{
		OAuth2AuthenticationAccessToken oAuth2AuthenticationAccessToken = new OAuth2AuthenticationAccessToken(token,authentication, authenticationKeyGenerator.extractKey(authentication));
		oauth2AccessTokenRepository.save(oAuth2AuthenticationAccessToken);
	}

	public void storeRefreshToken(OAuth2RefreshToken refreshToken,OAuth2Authentication authentication) 
	{
		OAuth2AuthenticationRefreshToken oauth2AuthenticationRefreshToken = new OAuth2AuthenticationRefreshToken(refreshToken, authentication);
		oauth2RefreshTokenRepository.save(oauth2AuthenticationRefreshToken);
	}
	
	 private Collection<OAuth2AccessToken> extractAccessTokens(List<OAuth2AuthenticationAccessToken> tokens) 
	 {
        List<OAuth2AccessToken> accessTokens = new ArrayList<OAuth2AccessToken>();
        for(OAuth2AuthenticationAccessToken token : tokens)
        {
            accessTokens.add(token.getoAuth2AccessToken());
        }
        return accessTokens;
	 }


	public Collection<OAuth2AccessToken> findTokensByUserName(String userName) {
		List<OAuth2AuthenticationAccessToken> tokens =  oauth2AccessTokenRepository.findByUserName(userName);
		return extractAccessTokens(tokens);
	}
}
