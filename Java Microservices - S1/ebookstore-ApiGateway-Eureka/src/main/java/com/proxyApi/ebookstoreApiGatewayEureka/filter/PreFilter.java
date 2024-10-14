package com.proxyApi.ebookstoreApiGatewayEureka.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter{
	@Override
	public boolean shouldFilter() {
		// This boolean value decides that the filter request should go to the next filter or not
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		// Write your logic here
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		
		System.out.println("----------------------------------------------");
		System.out.println("The request method is: " + request.getMethod());
		System.out.println("The request URL is: " + request.getRequestURI().toString());
		System.out.println("----------------------------------------------");

		return null;
	}

	@Override
	public String filterType() {
		// Return pre for PREFILTER, post for POSTFILTER, route for ROUTEFILTER
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
