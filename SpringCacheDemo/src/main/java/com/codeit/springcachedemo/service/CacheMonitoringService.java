package com.codeit.springcachedemo.service;


import com.github.benmanes.caffeine.cache.stats.CacheStats;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CacheMonitoringService {

  private final CacheManager cacheManager;

  public CacheMonitoringService(CacheManager cacheManager) {
    this.cacheManager = cacheManager;
  }

  public Map<String, Object> getCacheReport() {

    Cache cache = cacheManager.getCache("products");

    if (!(cache instanceof CaffeineCache caffeineCache)) {
      return Map.of("error", "Cache is not a CaffeineCache");
    }
    com.github.benmanes.caffeine.cache.Cache<Object, Object> nativeCache
        = caffeineCache.getNativeCache();

    CacheStats stats = nativeCache.stats();

    Map<String, Object> result = new LinkedHashMap<>();

    result.put(
        "estimatesSize",
        nativeCache.estimatedSize()
    );
    result.put(
        "hitRate",
        stats.hitRate()
    );
    result.put(
        "hitCount",
        stats.hitCount()
    );
    result.put(
        "missCount",
        stats.missCount()
    );
    result.put(
        "evictionCount",
        stats.evictionCount()
    );
    result.put(
        "averageLoadPenalty(ns)",
        stats.averageLoadPenalty()
    );
    return result;
  }


}
