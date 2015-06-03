package org.openhims.oauth2.dao;

import java.util.List;

import org.openhims.oauth2.domain.OAuth2AuthenticationAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Oauth2AccessTokenRepository extends JpaRepository<OAuth2AuthenticationAccessToken,Long>
{
 	public OAuth2AuthenticationAccessToken findByTokenId(String tokenId);
    public OAuth2AuthenticationAccessToken findByRefreshToken(String refreshToken);
    public OAuth2AuthenticationAccessToken findByAuthenticationId(String authenticationId);
    public List<OAuth2AuthenticationAccessToken> findByClientIdAndUserName(String clientId, String userName);
    public List<OAuth2AuthenticationAccessToken> findByClientId(String clientId);
    public List<OAuth2AuthenticationAccessToken> findByUserName(String userName);
} 
