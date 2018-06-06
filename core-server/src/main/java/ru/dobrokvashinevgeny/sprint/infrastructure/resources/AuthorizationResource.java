/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.resources;

import ru.dobrokvashinevgeny.sprint.services.UserDescriptor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Класс AuthorizationResource
 */
@Path("user/current/authorization")
public class AuthorizationResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";" + MediaType.CHARSET_PARAMETER + "=utf-8;")
	public UserDescriptor getAuthorizationForCurrentUser(@QueryParam("serverId") @DefaultValue("single") String serverId) {
		return new UserDescriptor("single");
	}
}