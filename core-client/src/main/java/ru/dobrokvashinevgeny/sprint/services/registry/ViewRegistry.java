package ru.dobrokvashinevgeny.sprint.services.registry;

import ru.dobrokvashinevgeny.sprint.services.borderlayout.BorderLayoutView;
import ru.dobrokvashinevgeny.sprint.services.textbutton.TextButtonView;

/**
 * Класс ViewRegistry
 */
public interface ViewRegistry {
	BorderLayoutView borderLayoutView();

	TextButtonView textButtonView();
}