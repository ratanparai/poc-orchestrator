package com.ratanparai.crm.infrastructure;

import com.ratanparai.crm.models.Olcm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OlcmRepository extends JpaRepository<Olcm, Long> {
    
}