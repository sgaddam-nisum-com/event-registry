package com.nisum.registry.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nisum.registry.service.PageService;

@Component
@Path("/registry")
public class RegistryController {

	@Autowired
	PageService pageService;
	private static final Logger logger = Logger
			.getLogger(RegistryController.class);

	@POST
	@Path("/savePage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePayment(@FormParam("username") String username,
			@FormParam("name") String name, @FormParam("source") String source) {

		logger.info("Inputs : username - " + username + " - name - " + name
				+ " source - " + source);

		String res = pageService.save(username, name, source);
		return Response.status(200).entity(res).build();
	}

	@GET
	@Path("/getPages")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPages(@QueryParam(value = "username") String username) {
		logger.info("RegistryController.getPages()");
		return pageService.getPages(username);

	}

	@GET
	@Path("/getPageByName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPageByName(@QueryParam(value = "username") String username,
			@QueryParam(value = "name") String name) {
		logger.info("RegistryController.getPageByName()");
		return pageService.getPageByName(username, name);

	}

}