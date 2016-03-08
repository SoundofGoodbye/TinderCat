package com.chuchi.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuchi.bean.Greeting;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/{id}")
	public Response greeting(@PathVariable("id") String id) {
		return Response.status(Status.OK).entity(new Greeting(id, "Test Content")).build();
	}

	@RequestMapping("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws URISyntaxException {
		if (userName != null && password != null) {
			// Save
			return Response.created(new URI("/123")).build();
		} else {
			return Response.noContent().status(Status.BAD_REQUEST).build();
		}

	}
}
