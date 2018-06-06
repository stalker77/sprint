/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.services;

import ru.dobrokvashinevgeny.sprint.services.borderlayout.BorderLayoutViewController;
import ru.dobrokvashinevgeny.sprint.services.textbutton.TextButtonController;

/**
 * Класс ControllersRegistry
 */
public interface ControllersRegistry {
	BorderLayoutViewController borderLayoutViewController();

	TextButtonController textButtonController();
}