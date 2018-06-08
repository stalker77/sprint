/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

/**
 * Класс TextButton
 */
public class TextButton extends GuiComponent {
	public TextButton(String name) {
		super(name, ComponentType.Button);
	}
}