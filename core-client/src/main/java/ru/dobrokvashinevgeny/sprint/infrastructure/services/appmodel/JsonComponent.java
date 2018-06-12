/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.appmodel;

import com.fasterxml.jackson.annotation.*;
import ru.dobrokvashinevgeny.sprint.domain.model.ComponentType;

/**
 * Класс JsonComponent
 */
public class JsonComponent {
	private String name;

	private ComponentType componentType;

	@JsonCreator
	public JsonComponent(@JsonProperty("name") String name,
						 @JsonProperty("componentType") ComponentType componentType) {
		this.name = name;
		this.componentType = componentType;
	}
}