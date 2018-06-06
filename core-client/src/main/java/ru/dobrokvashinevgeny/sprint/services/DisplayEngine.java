package ru.dobrokvashinevgeny.sprint.services;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.Container;

/**
 * Класс DisplayEngine
 */
public interface DisplayEngine {
	void gotoNewContainer(Container container);

	void addNewComponentToCurrentContainer(Widget widget);

	void gotoPriorContainer();

	void showCurrentViewport();
}