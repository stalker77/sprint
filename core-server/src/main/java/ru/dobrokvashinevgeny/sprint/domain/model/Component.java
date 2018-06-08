/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

/**
 * Класс Component
 */
public class Component {
	private String name;

	private ComponentType componentType;

	public Component(String name, ComponentType componentType) {
		this.name = name;
		this.componentType = componentType;
	}
}