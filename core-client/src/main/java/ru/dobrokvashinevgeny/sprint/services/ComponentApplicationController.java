package ru.dobrokvashinevgeny.sprint.services;

import ru.dobrokvashinevgeny.sprint.domain.model.GuiComponent;

/**
 * Класс ComponentApplicationController
 */
public interface ComponentApplicationController {
	void initDisplaySystem();

	void putComponentToDisplaySystem(GuiComponent component);

	void placeComponentAppToDisplaySystem();
}