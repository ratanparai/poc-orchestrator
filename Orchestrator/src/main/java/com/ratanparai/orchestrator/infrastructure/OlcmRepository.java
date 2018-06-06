package com.ratanparai.orchestrator.infrastructure;

import com.ratanparai.orchestrator.events.incoming.Olcm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OlcmRepository extends JpaRepository<Olcm, Long> {

}