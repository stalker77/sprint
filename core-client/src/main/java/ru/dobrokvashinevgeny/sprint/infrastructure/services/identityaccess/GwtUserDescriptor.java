/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.identityaccess;

import com.google.gwt.json.client.*;
import ru.dobrokvashinevgeny.sprint.services.identityaccess.UserDescriptor;

import java.util.Collections;

/**
 * Класс GwtUserDescriptor
 */
//@JsType
public class GwtUserDescriptor {
	private UserDescriptor userDescriptor;
//	public String appCode;

	public GwtUserDescriptor(String userDescriptor) {
		parseUserDescriptor(userDescriptor);
	}

	private void parseUserDescriptor(String userDescriptor) {
		JSONValue userDescriptorAsJson = JSONParser.parseStrict(userDescriptor);
		final JSONObject userDescriptorAsJsonObject = userDescriptorAsJson.isObject();
		final JSONValue appCodeValue = userDescriptorAsJsonObject.get("appCode");
		final JSONString appCodeString = appCodeValue.isString();
		String appCode = appCodeString.stringValue();

		this.userDescriptor = new UserDescriptor(
			Collections.unmodifiableList(
				Collections.singletonList(appCode)
			)
		);
	}

	public UserDescriptor asUserDescriptor() {
		return this.userDescriptor;
	}
}