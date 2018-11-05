package com.tiny.spot.gateway;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("all")
public class DefaultApigatewayInvoker implements ApiGatewayInvoker {

	public <T extends BaseResponse> T invoke(BaseRequest<T> request) {
		String interfaceName = request.getClass().getDeclaredAnnotation(GatewayAnna.class).value();
		ParameterizedType parameterizedType = (ParameterizedType) request.getClass().getGenericSuperclass();
		Type actualTypeArg = parameterizedType.getActualTypeArguments()[0];
		try {
			String jsonContent = "OK";
			return JSON.parseObject(jsonContent, actualTypeArg);
		} catch (Throwable e) {
			return (T) failMsg(actualTypeArg, e);
		}
	}

	private BaseResponse failMsg(Type actualTypeArg, Throwable e) {
		try {
			BaseResponse baseResponse = (BaseResponse) Class.forName(actualTypeArg.getTypeName()).newInstance();
			baseResponse.setSuccess(false);
			baseResponse.setMessage(e.getMessage());
			baseResponse.setResultCode(BaseResponse.SystemError);
			return baseResponse;
		} catch (Throwable error) {
			throw new RuntimeException(error);
		}
	}
	
}
