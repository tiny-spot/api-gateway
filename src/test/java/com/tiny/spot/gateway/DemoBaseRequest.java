package com.tiny.spot.gateway;

@GatewayAnna("biz.message.del")
public class DemoBaseRequest extends BaseRequest<DemoBaseResponse>{

	private static final long serialVersionUID = -3090501271751005676L;
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
