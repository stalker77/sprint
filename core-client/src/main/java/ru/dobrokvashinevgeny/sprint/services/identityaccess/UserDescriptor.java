/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.services.identityaccess;

import java.util.List;

/**
 * Класс UserDescriptor
 */
public class UserDescriptor {
	private final List<String> allowedAppCodeList;

	public UserDescriptor(List<String> allowedAppCodeList) {
		this.allowedAppCodeList = allowedAppCodeList;
	}

	public String appCode() {
		return allowedAppCodeList.get(0);
	}

	@Override
	public String toString() {
		return "UserDescriptor{" +
			"allowedAppCodeList=" + allowedAppCodeList +
			'}';
	}
}