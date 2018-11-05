package com.tiny.spot.gateway;

public interface ApiGatewayInvoker {
	<T extends BaseResponse> T invoke(BaseRequest<T> request);
}
