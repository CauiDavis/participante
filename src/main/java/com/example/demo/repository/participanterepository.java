package com.example.demo.repository;
import com.example.demo.models.Teste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface participanterepository extends JpaRepository<Teste,Long>{
}
