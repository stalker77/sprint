/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.appmodel;

import com.fasterxml.jackson.annotation.*;
import ru.dobrokvashinevgeny.sprint.domain.model.GuiComponent;

import java.util.List;

/**
 * Класс JsonComponentApplication
 */
@JsonRootName("ComponentApplication")
public class JsonComponentApplication {
	private final List<GuiComponent> childComponentList;

	@JsonCreator
	public JsonComponentApplication(@JsonProperty("childComponentList") List<GuiComponent> childComponentList) {
		this.childComponentList = childComponentList;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public List<GuiComponent> getChildComponentList() {
		return childComponentList;
	}
}