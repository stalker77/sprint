/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.resources;

import ru.dobrokvashinevgeny.sprint.domain.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Класс ApplicationModelResource
 */
@Path("rest/application/{appCode}/model/current")
public class ApplicationModelResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";" + MediaType.CHARSET_PARAMETER + "=utf-8;")
	public ComponentApplication getModelForApplication(@PathParam("appCode") String appCode) {
		return fakeComponentApplication();
	}

	private ComponentApplication fakeComponentApplication() {
		ComponentApplication result = new ComponentApplication();

		GuiComponent guiComponent = new GuiComponent("myButton", ComponentType.Button);

		Container container = new Container("myContainer", ComponentType.BorderLayout);
		container.add(guiComponent);

		result.addChildComponent(container);

		return result;
	}
}