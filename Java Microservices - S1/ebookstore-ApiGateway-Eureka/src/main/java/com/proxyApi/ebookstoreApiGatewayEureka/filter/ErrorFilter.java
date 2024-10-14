package com.proxyApi.ebookstoreApiGatewayEureka.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class ErrorFilter extends ZuulFilter{
@Override
public boolean shouldFilter() {
	return true;
}

@Override
public Object run() throws ZuulException {
	System.out.println("----------------------------------------------");
	System.out.println("This is Error Filter");
	System.err.println("Error found work on the deck");
	System.out.println("----------------------------------------------");
	return null;
}

@Override
public String filterType() {
	return "error";
}

@Override
public int filterOrder() {
	return 0;
}

}
