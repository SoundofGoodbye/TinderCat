package com.chuchi.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuchi.Person;
import com.chuchi.bean.Greeting;
import com.chuchi.repositories.PersonRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/{id}")
	public Response greeting(@PathVariable("id") String id) {
		return Response.status(Status.OK).entity(new Greeting(id, "Test Content")).build();
	}

	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws URISyntaxException {
		if (userName != null && password != null) {
			// Save
			personRepository.save(new Person(userName,password));
			return Response.created(new URI("/123")).build();
		} else {
			return Response.noContent().status(Status.BAD_REQUEST).build();
		}

	}
}
