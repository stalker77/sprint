/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

/**
 * Класс ComponentRuntimeInfo
 */
public class ComponentRuntimeInfo {
	private final String viewId;

	public ComponentRuntimeInfo(String viewId) {
		this.viewId = viewId;
	}

	public String getViewId() {
		return this.viewId;
	}
}