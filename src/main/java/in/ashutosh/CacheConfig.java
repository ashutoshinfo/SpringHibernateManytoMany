package in.ashutosh;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //
@EnableCaching // Required to enable caching
public class CacheConfig {

// Global Caching
//	@Bean
//	CacheManager cacheManager() {
//		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
//		cacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).maximumSize(1000));
//		return cacheManager;
//	}

	// Custom Caching
	@Bean
	CacheManager customeMethodsConfig() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();

		cacheManager.registerCustomCache("findByAuthorId",
				Caffeine.newBuilder().maximumSize(1000).expireAfterAccess(5, TimeUnit.SECONDS).build());

		cacheManager.registerCustomCache("getAllAuthors",
				Caffeine.newBuilder().maximumSize(2000).expireAfterAccess(10, TimeUnit.SECONDS).build());
		return cacheManager;
	}

}