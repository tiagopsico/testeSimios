package com.example.testeSimios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Principal {

	@RequestMapping("/")
	public String HelloWorld() {
		String devolve = "Hello World";
		return "Projeto para verificacao de DNA de Simios";
	}
}

