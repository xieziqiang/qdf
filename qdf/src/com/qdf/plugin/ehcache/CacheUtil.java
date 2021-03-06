package com.qdf.plugin.ehcache;


import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 缓存帮助类
 * 提供一系列操作缓存的方法
 * @author xiezq
 *
 */
public class CacheUtil {

	private static CacheManager cacheManager;

	//初始化
	public static void init(CacheManager cacheManager) {
		CacheUtil.cacheManager = cacheManager;
	}
	
	private static Cache getOrNewCache(String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		if(null == cache) {
			cache = cacheManager.getCache(cacheName);
			if(null == cache) {
				synchronized(CacheUtil.class) {
					cacheManager.addCacheIfAbsent(cacheName);
					cache = cacheManager.getCache(cacheName);
				}
			}
		}
		return cache;
	}
	
	public static void put(String cacheName,Object key,Object value) {
		getOrNewCache(cacheName).put(new Element(key, value));
	}
	
	public static <T> T get(String cacheName,Object key) {
		Element element = getOrNewCache(cacheName).get(key);
		return element == null ? null : (T)element.getValue() ;
	}
	
	public static <T> T get(String cacheName,Object key,DataLoader loader) {
		Object data = get(cacheName, key);
		if(null == data) {
			data = loader.load();
			put(cacheName, key, data);
		}
		return (T) data;
	}
	
	public static void remove(String cacheName,Object key) {
		getOrNewCache(cacheName).remove(key);
	}
	
	public static void removeAll(String cacheName) {
		getOrNewCache(cacheName).removeAll();
	}
	
	public static List<?> getKeys(String cacheName) {
		return getOrNewCache(cacheName).getKeys();
	}
}
