package com.example.demo.Dao;

import com.example.demo.model.Simple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleDao extends JpaRepository<Simple,Integer> {
}
