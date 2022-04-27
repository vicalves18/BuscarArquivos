package com.DesafioBackEnd.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DesafioBackEnd.Model.*;
import com.BackEnd.Repository.*;


@RestController
@RequestMapping(value="/pesquisa")
public class DesafioController {
	@Autowired
	private DesafioBackEndRepository desafioRepository;
	
	@GetMapping
	public List<DesafioBackEnd> ListUsers(){
		return desafioRepository.findAll();
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<DesafioBackEnd> FindByIdUser(@PathVariable int id){
		Optional<DesafioBackEnd> desafioBackEnd = desafioRepository.findById(id);
		if(desafioBackEnd.isPresent()) {
			return new ResponseEntity<DesafioBackEnd>(desafioBackEnd.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
	
	