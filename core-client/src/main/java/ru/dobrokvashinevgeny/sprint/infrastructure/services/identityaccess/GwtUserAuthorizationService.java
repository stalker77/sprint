/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.identityaccess;

import com.google.gwt.http.client.*;
import ru.dobrokvashinevgeny.sprint.infrastructure.services.*;
import ru.dobrokvashinevgeny.sprint.services.identityaccess.*;

import java.util.Collections;

/**
 * Класс GwtUserAuthorizationService
 */
public class GwtUserAuthorizationService {
	private static final String AUTH_USER_RESOURCE_URI = "rest/user/current/authorization";

	public void authorizeCurrentUserTo(AuthorizedUserController controller) {
		RequestBuilder request = GwtRestClientFactory.createGetRequestTo(AUTH_USER_RESOURCE_URI);
		try {
			request.sendRequest("", new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					controller.onReceiveAuthorization(toUserDescriptor(response.getText()));
				}

				@Override
				public void onError(Request request, Throwable exception) {
					controller.onReceiveAuthorizationError(new UserAuthorizationException(exception));
				}
			});
		} catch (RequestException e) {
			controller.onReceiveAuthorizationError(new UserAuthorizationException(e));
		}
	}

	private UserDescriptor toUserDescriptor(String userDescriptor) {
		GwtUserDescriptor gwtUserDescriptor = (GwtUserDescriptor) JSON.parse(userDescriptor);

		return new UserDescriptor(Collections.unmodifiableList(Collections.singletonList(gwtUserDescriptor.appCode)));
		/*JSONValue userDescriptorAsJson = JSONParser.parseStrict(userDescriptor);
		final JSONObject userDescriptorAsJsonObject = userDescriptorAsJson.isObject();
		final JSONValue allowedApplicationCodesValue = userDescriptorAsJsonObject.get("allowedApplicationCodes");
		final JSONArray allowedApplicationCodesArray = allowedApplicationCodesValue.isArray();
		final List<String> allowedAppCodeList = new ArrayList<>();
		for(int i = 0; i < allowedApplicationCodesArray.size(); i++) {
			JSONValue appCodeValue = allowedApplicationCodesArray.get(i);
			JSONString appCodeString = appCodeValue.isString();
			String appCode = appCodeString.stringValue();
			allowedAppCodeList.add(appCode);
		}

		return new UserDescriptor(allowedAppCodeList);*/
	}
}