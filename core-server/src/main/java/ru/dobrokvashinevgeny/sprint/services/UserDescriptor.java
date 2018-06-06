/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.services;

/**
 * Класс UserDescriptor
 */
public class UserDescriptor {
	private final String appCode;

	public UserDescriptor(String appCode) {
		this.appCode = appCode;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getAppCode() {
		return appCode;
	}
}