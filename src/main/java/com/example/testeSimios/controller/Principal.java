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
	
	@RequestMapping("/true")
	public boolean devolveTrue() {
		return true;
	}
	
	@RequestMapping("/letra")
	public String letrasNaoConferem() {
		return "As letras da String ​ só podem ser: (A, T, C, G)​";
	}

}

