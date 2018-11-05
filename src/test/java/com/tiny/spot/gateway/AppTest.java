package com.tiny.spot.gateway;

import java.util.UUID;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("all")
public class AppTest {
	
	/**
	 * http://router.jd.com/api/apichannel/apiSummary?channelId=2
	 */
	public static void main(String[] args) {
		DemoBaseRequest request = new DemoBaseRequest();
		DefaultApigatewayInvoker defaultApigatewayInvoker = new DefaultApigatewayInvoker();
		request.setUserId(UUID.randomUUID().toString());
		DemoBaseResponse demoBaseResponse = defaultApigatewayInvoker.invoke(request);
		System.out.println(JSON.toJSON(demoBaseResponse));
	}
}
