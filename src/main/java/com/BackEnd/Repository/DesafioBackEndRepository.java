package com.BackEnd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DesafioBackEnd.Model.*;

@Repository
public interface DesafioBackEndRepository extends JpaRepository<DesafioBackEnd, Integer>{
	Optional<DesafioBackEnd> findByNome(String nome);
}
