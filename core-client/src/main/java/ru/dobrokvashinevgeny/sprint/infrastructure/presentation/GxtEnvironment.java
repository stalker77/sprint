/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation;

import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.*;

import java.util.*;

/**
 * Класс GxtEnvironment
 */
public class GxtEnvironment {
	private Deque<Container> containersStack;

	private final Map<String, Widget> createdComponents;

	private long componentCounter;

	private Viewport currentViewport;

	public GxtEnvironment() {
		this.containersStack = new ArrayDeque<>();
		this.createdComponents = new HashMap<>();
		this.componentCounter = 0;
		this.currentViewport = new Viewport();
	}

	public Widget getCreatedComponentWithId(String componentId) {
		return createdComponents.get(componentId);
	}

	public String nextComponentId() {
		return String.valueOf(++componentCounter);
	}

	public void removeCreatedComponentById(String componentId) {
		createdComponents.put(componentId, null);
	}

	public BorderLayoutContainer newBorderLayoutContainerWithId(String componentId) {
		final BorderLayoutContainer result = new BorderLayoutContainer();
		addCreatedComponent(componentId, result);

		return result;
	}

	private void addCreatedComponent(String componentId, Widget createdComponent) {
		this.createdComponents.put(componentId, createdComponent);
	}

	public TextButton newTextButtonWithId(String componentId) {
		final TextButton result = new TextButton();
		addCreatedComponent(componentId, result);

		return result;
	}

	public void gotoNewContainer(Container container) {
		if (containersStack.isEmpty()) {
			currentViewport.add(container);
		}

		containersStack.push(container);
	}

	public void setCurrentViewportWidget(Widget widget) {
		currentViewport.setWidget(widget);
	}

	public void showCurrentViewport() {
		RootPanel.get().add(currentViewport);
	}
}