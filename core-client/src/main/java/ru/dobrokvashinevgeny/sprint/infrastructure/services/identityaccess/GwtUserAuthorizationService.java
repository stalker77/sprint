/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.identityaccess;

import com.google.gwt.http.client.*;
import ru.dobrokvashinevgeny.sprint.infrastructure.services.GwtRestClientFactory;
import ru.dobrokvashinevgeny.sprint.services.identityaccess.*;

import java.util.logging.*;

/**
 * Класс GwtUserAuthorizationService
 */
public class GwtUserAuthorizationService {
	private final static Logger LOG = Logger.getLogger("Main");
	private static final String AUTH_USER_RESOURCE_URI = "rest/user/current/authorization";

	public void authorizeCurrentUserTo(AuthorizedUserController controller) {
		RequestBuilder request = GwtRestClientFactory.createGetRequestTo(AUTH_USER_RESOURCE_URI);
		try {
			request.sendRequest("", new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					if (response.getStatusCode() == Response.SC_OK) {
						controller.onReceiveAuthorization(toUserDescriptor(response.getText()));
					}
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
		try {
			LOG.log(Level.SEVERE, "GwtUserAuthorizationService.toUserDescriptor(\"" + userDescriptor + "\") begin");
			return new GwtUserDescriptor(userDescriptor).asUserDescriptor();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.toString());
			throw e;
		} finally {
			LOG.log(Level.SEVERE, "GwtUserAuthorizationService.toUserDescriptor() end");
		}
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