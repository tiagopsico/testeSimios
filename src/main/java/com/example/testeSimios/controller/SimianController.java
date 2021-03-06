package com.example.testeSimios.controller;

import java.io.IOException;
import java.net.URI;
import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/simian")
public class SimianController {

	@PostMapping
	public ResponseEntity<Void> testeSimios(@RequestBody DnaForm dnaForm) {
		
		String[] dna = dnaForm.getDna(); 
		//String[] dna = {"TTAAGT", "TAAGTC", "CAGGGA", "AGGTGA", "CGCAGG", "GCACTG"};
		int countHorizontal = 0;
		int countVertical = 0;

		for (int x = 0; x < dna.length; x++) {

			countHorizontal = 0;
			countVertical = 0;

			for (int i = 0; i < (dna[x].length()); i++) {
				System.out.println("x: " + x + ",y: " + i);
				System.out.println("*************");

				String testeLetra = dna[x].substring(i,i+1);
				
				if (testeLetra.equals("A") || testeLetra.equals("T") || testeLetra.equals("C") || testeLetra.equals("G")) {
					
				} else {
					return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/letra")).build();
				}
				// Procura letras iguais na horizontal
				if (i < dna[x].length() - 3) {
					if ((dna[x].substring(i, i + 1)).equals(dna[x].substring(i + 1, i + 2))) {
						countHorizontal++;
					}
				}

				// Procura letras iguais na vertical
				if (x < dna.length - 3) {
					if ((dna[x].substring(i, i + 1)).equals(dna[x + 1].substring(i, i + 1))
							&& (dna[x + 1].substring(i, i + 1)).equals(dna[x + 2].substring(i, i + 1))
							&& (dna[x + 2].substring(i, i + 1)).equals(dna[x + 3].substring(i, i + 1))) {

						countVertical++;

					}
				}
				if (x < dna.length - 3 && i < dna[x].length() - 3) {
					if ((dna[x].substring(i, i + 1)).equals(dna[x + 1].substring(i + 1, i + 2))
							&& (dna[x + 1].substring(i + 1, i + 2)).equals(dna[x + 2].substring(i + 2, i + 3))
							&& (dna[x + 2].substring(i + 2, i + 3)).equals(dna[x + 3].substring(i + 3, i + 4))) {

						System.out.println("Achou diagonal inferior direita "+dna[x].substring(i, i + 1));
						return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/true")).build();
						//return true;
					}
				}

				if (x > 2 && i < dna[x].length() - 3) {
					if ((dna[x].substring(i, i + 1)).equals(dna[x - 1].substring(i + 1, i + 2))
							&& (dna[x - 1].substring(i + 1, i + 2)).equals(dna[x - 2].substring(i + 2, i + 3))
							&& (dna[x - 2].substring(i + 2, i + 3)).equals(dna[x - 3].substring(i + 3, i + 4))) {

						System.out.println("Achou diagonal superior direita"+dna[x].substring(i, i + 1));
						return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/true")).build();
						//return true;
					}
				}

				// Mostra resultados
				if (countHorizontal == 3) {
					System.out.println("Encontrado na horizontal");
					return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/true")).build();
					
					
					//return true;
				}

				if (countVertical == 1) {
					System.out.println("Encontrado na vertical");
					return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/true")).build();
					//return true;
				}
			}
		}
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();    

	}
}
