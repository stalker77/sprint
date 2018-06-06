/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.resources;

import ru.dobrokvashinevgeny.sprint.services.AppModelDescriptor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Класс ApplicationModelResource
 */
@Path("rest/application/{appCode}/model/current")
public class ApplicationModelResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";" + MediaType.CHARSET_PARAMETER + "=utf-8;")
	public AppModelDescriptor getModelForApplication(@PathParam("appCode") String appCode) {
		return new AppModelDescriptor();
	}
}