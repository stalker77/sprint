/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

import java.util.*;

/**
 * Класс ComponentApplication
 */
public class ComponentApplication {
	private List<GuiComponent> childComponentList;

	public ComponentApplication() {
		childComponentList = new ArrayList<>();
	}

	public void addChildComponent(GuiComponent guiComponent) {
		childComponentList.add(guiComponent);
	}

	public List<GuiComponent> getChildComponentList() {
		return Collections.unmodifiableList(childComponentList);
	}
}