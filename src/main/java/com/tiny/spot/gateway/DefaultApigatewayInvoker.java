package com.tiny.spot.gateway;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings("all")
public class DefaultApigatewayInvoker implements ApiGatewayInvoker {

	public <T extends BaseResponse> T invoke(BaseRequest<T> request) {
		String interfaceName = request.getClass().getDeclaredAnnotation(GatewayAnna.class).value();
		ParameterizedType parameterizedType = (ParameterizedType) request.getClass().getGenericSuperclass();
		Type actualTypeArg = parameterizedType.getActualTypeArguments()[0];
		try {
			BaseResponse baseResponse = (BaseResponse) Class.forName(actualTypeArg.getTypeName()).newInstance();
			baseResponse.setSuccess(true);
			return (T) baseResponse;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
