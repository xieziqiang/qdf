package com.qdf.log;

public interface ILogger {

	void debug(String message);
	
	void debug(String message, Throwable t);
	
	void info(String message);
	
	void info(String message, Throwable t);
	
	void warn(String message);
	
	void warn(String message, Throwable t);
	
	void error(String message);
	
	void error(String message, Throwable t);
	
	boolean isDebugEnabled();

	boolean isInfoEnabled();

	boolean isWarnEnabled();

	boolean isErrorEnabled();
	
}
