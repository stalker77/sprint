/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

import java.util.*;

/**
 * Класс Container
 */
public abstract class Container extends GuiComponent {
	private List<GuiComponent> childComponents;

	public Container(String name, ComponentType componentType) {
		super(name, componentType);

		this.childComponents = new ArrayList<>();
	}

	public void add(GuiComponent component) {
		this.childComponents.add(component);
	}

	public void remove() {

	}

	protected List<GuiComponent> getChildComponents() {
		return Collections.unmodifiableList(this.childComponents);
	}

	@Override
	public void buildChildComponents() {
		for (GuiComponent component: childComponents) {
			component.buildComponent();
		}
	}
}