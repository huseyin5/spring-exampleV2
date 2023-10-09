package com.haydikodlayalim.springdatajpapostgresql.repo;

import com.haydikodlayalim.springdatajpapostgresql.entitiy.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KisiRepository extends JpaRepository<Kisi, Long> {
}
