package com.nisum.registry.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

	@RequestMapping(method = RequestMethod.POST)
	@Path("/savePage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePayment(@FormParam("name") String name,
			@FormParam("code") String code) {
		System.out.println("Inputs : name - " + name + " code - " + code);
		return Response.status(200).entity(pageService.save(name, code))
				.build();
	}

	@GET
	@Path("/getPages")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPages() {
		return pageService.getPages();

	}

	@GET
	@Path("/getPageByName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPageByName(@QueryParam(value = "name") String name) {
		return pageService.getPageByName(name);

	}

}