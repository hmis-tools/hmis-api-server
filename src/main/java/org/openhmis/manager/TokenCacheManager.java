package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.dao.TmpTokenCacheDAO;
import org.openhmis.domain.TmpTokenCache;
import org.openhmis.dto.TokenCacheDTO;

public class TokenCacheManager {
	private static final TmpTokenCacheDAO tmpTokenCacheDAO = new TmpTokenCacheDAO();

	public TokenCacheManager() {}

	public static TokenCacheDTO getTokenCacheById(String tokenCacheId) {
		TokenCacheDTO tokenCacheDTO = TokenCacheManager.generateTokenCacheDTO(tmpTokenCacheDAO.getTmpTokenCacheById(Integer.parseInt(tokenCacheId)));
		return tokenCacheDTO;
	}

	public static List<TokenCacheDTO> getTokenCaches() {
		List<TokenCacheDTO> tokenCacheDTOs = new ArrayList<TokenCacheDTO>();

		// Collect the tokenCaches
		List<TmpTokenCache> tmpTokenCaches = tmpTokenCacheDAO.getTmpTokenCaches();

		// For each TmpTokenCache, collect and map the data
		for (Iterator<TmpTokenCache> iterator = tmpTokenCaches.iterator(); iterator.hasNext();) {
			TmpTokenCache tmpTokenCache = iterator.next();
			TokenCacheDTO tokenCacheDTO = TokenCacheManager.generateTokenCacheDTO(tmpTokenCache);
			tokenCacheDTOs.add(tokenCacheDTO);
		}
		return tokenCacheDTOs;
	}

	public static TokenCacheDTO getTokenCacheByIdToken(String idToken) {
		
		// Collect the tokenCaches
		TmpTokenCache tmpTokenCache = tmpTokenCacheDAO.getTmpTokenCacheByIdToken(idToken);

		TokenCacheDTO tokenCacheDTO = TokenCacheManager.generateTokenCacheDTO(tmpTokenCache);
		return tokenCacheDTO;

	}
	
	public static TokenCacheDTO addTokenCache(TokenCacheDTO inputDTO) {
		// Generate a TmpTokenCache from the input
		TmpTokenCache tmpTokenCache = TokenCacheManager.generateTmpTokenCache(inputDTO);
		
		// Set Export fields (TBD: is Export right here?)
		tmpTokenCache.setDateCreated(new Date());
		tmpTokenCache.setDateUpdated(new Date());
		
		// Save the tokenCache to allow secondary object generation
		tmpTokenCacheDAO.save(tmpTokenCache);
		inputDTO.setTokenCacheId(tmpTokenCache.getTokenCacheId());
		
		// Return the resulting DTO
		return TokenCacheManager.generateTokenCacheDTO(tmpTokenCache);
	}
	
	public static TokenCacheDTO updateTokenCache(TokenCacheDTO inputDTO) {
		// Generate a tokenCache from the input
		TmpTokenCache tmpTokenCache = TokenCacheManager.generateTmpTokenCache(inputDTO);
		tmpTokenCache.setTokenCacheId(inputDTO.getTokenCacheId());
		tmpTokenCache.setDateUpdated(new Date());
                tmpTokenCache.setExternalId(inputDTO.getExternalId());
                tmpTokenCache.setIdToken(inputDTO.getIdToken());
		
		// Update the object
		tmpTokenCacheDAO.update(tmpTokenCache);
		
		// Return the resulting DTO
		return TokenCacheManager.generateTokenCacheDTO(tmpTokenCache);

	}
	
	public static boolean deleteTokenCache(String tokenCacheId) {
		TmpTokenCache tmpTokenCache = tmpTokenCacheDAO.getTmpTokenCacheById(Integer.parseInt(tokenCacheId));
		tmpTokenCacheDAO.delete(tmpTokenCache);
		return true;
	}
	
	public static TokenCacheDTO generateTokenCacheDTO(TmpTokenCache tmpTokenCache) {
		TokenCacheDTO tokenCacheDTO = new TokenCacheDTO();

		tokenCacheDTO.setTokenCacheId(tmpTokenCache.getTokenCacheId());
                tokenCacheDTO.setExternalId(tmpTokenCache.getExternalId());
                tokenCacheDTO.setIdToken(tmpTokenCache.getIdToken());
		
		// Export Standard Fields (TBD: what are "Standard Fields"?)
		tokenCacheDTO.setDateCreated(tmpTokenCache.getDateCreated());
		tokenCacheDTO.setDateUpdated(tmpTokenCache.getDateUpdated());
		
		return tokenCacheDTO;
	}
	
	public static TmpTokenCache generateTmpTokenCache(TokenCacheDTO inputDTO) {
		TmpTokenCache tmpTokenCache = new TmpTokenCache();
		
		tmpTokenCache.setExternalId(inputDTO.getExternalId());
		tmpTokenCache.setIdToken(inputDTO.getIdToken());
		
		// Export Standard Fields (TBD: what are "Standard Fields"?)
		tmpTokenCache.setDateCreated(inputDTO.getDateCreated());
		tmpTokenCache.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpTokenCache;
	}
	
}
