package com.DesafioBackEnd.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value="{nome}")
	public ResponseEntity<DesafioBackEnd> FindByIdUser(@RequestBody String nome, String data,String tipo){
		Optional<DesafioBackEnd> desafioBackEnd = desafioRepository.findByNome(nome);
		if(desafioBackEnd.isPresent()) {
			if(desafioBackEnd.get().getData()==data) {
				if(desafioBackEnd.get().getTipo()==tipo) {
					return new ResponseEntity<DesafioBackEnd>(desafioBackEnd.get(), HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PostMapping
	public DesafioBackEnd CreateUser(@RequestBody DesafioBackEnd desafioBackEnd) {
		return desafioRepository.save(desafioBackEnd);
	}
}
	
	