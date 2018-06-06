/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation;

import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.container.*;
import ru.dobrokvashinevgeny.sprint.services.DisplayEngine;

import java.util.*;

/**
 * Класс GwtDisplayEngine
 */
public class GwtDisplayEngine implements DisplayEngine {
	private Deque<Container> containersStack;

	private Viewport currentViewport;

	public GwtDisplayEngine() {
		this.containersStack = new ArrayDeque<>();
		this.currentViewport = new Viewport();
	}

	@Override
	public void gotoNewContainer(Container container) {
		if (containersStack.isEmpty()) {
			currentViewport.add(container);
		}

		containersStack.push(container);
	}

	@Override
	public void addNewComponentToCurrentContainer(Widget widget) {
		containersStack.peek().add(widget);
	}

	@Override
	public void gotoPriorContainer() {
		containersStack.pop();
	}

	@Override
	public void showCurrentViewport() {
		RootPanel.get().add(currentViewport);
	}
}