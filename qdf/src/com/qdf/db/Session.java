package com.qdf.db;

import java.util.List;

/**
 * 数据库操作接口
 * @author xiezq
 *
 */
public interface Session {

	int save(Object obj);
	
	int delete(Object obj);
	
	int update(Object obj);
	
	<T> T findById(Class<?> clazz, Object id);
	
	<T> List<T> queryList(Class<?> clazz, String sql, Object... objects);
	
	<T> List<T> queryPage(Class<?> clazz,int page,int pageSize);
	
	<T> List<T> queryPage(Class<?> clazz,String sql,int page,int pageSize);
	
}
