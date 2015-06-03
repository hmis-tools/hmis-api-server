package org.openhims.oauth2.dao;

import org.openhims.oauth2.domain.OAuth2AuthenticationRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuth2RefreshTokenRepository extends JpaRepository<OAuth2AuthenticationRefreshToken,Long>
{
	public OAuth2AuthenticationRefreshToken findByTokenId(String tokenId);
}
