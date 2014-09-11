package com.nisum.registry.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nisum.registry.service.PageService;

@Component
@Path("/registry")
public class RegistryController {

	@Autowired
	PageService pageService;
	private static final Logger logger = Logger
			.getLogger(RegistryController.class);

	@RequestMapping(method = RequestMethod.POST)
	@Path("/savePage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePayment(@FormParam("username") String username,
			@FormParam("name") String name, @FormParam("source") String source) {

		logger.info("Inputs : username - " + username + " - name - " + name
				+ " source - " + source);
		return Response.status(200)
				.entity(pageService.save(username, name, source)).build();
	}

	@GET
	@Path("/getPages")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPages() {
		logger.info("RegistryController.getPages()");
		return pageService.getPages();

	}

	@GET
	@Path("/getPageByName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPageByName(@QueryParam(value = "name") String name) {
		logger.info("RegistryController.getPageByName()");
		return pageService.getPageByName(name);

	}

}