/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation.components;

/**
 * Класс AbstractView
 */
public abstract class AbstractView {
	private String internalComponentId;

	protected String getInternalComponentId() {
		return this.internalComponentId;
	}

	protected void setInternalComponentId(String internalComponentId) {
		this.internalComponentId = internalComponentId;
	}
}