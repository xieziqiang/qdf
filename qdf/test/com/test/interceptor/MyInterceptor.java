package com.test.interceptor;

import com.qdf.core.Invocation;
import com.qdf.interceptor.QdfInterceptor;

public class MyInterceptor implements QdfInterceptor{

	@Override
	public void intercept(Invocation in) {
		System.out.println("before");
		in.invoke();
		System.out.println("after");
	}
	
}
