package com.relentlessbank.clientarea.repository;

import com.relentlessbank.clientarea.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {
}