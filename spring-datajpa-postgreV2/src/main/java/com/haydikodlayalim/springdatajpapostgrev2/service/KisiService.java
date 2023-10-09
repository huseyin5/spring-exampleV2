package com.haydikodlayalim.springdatajpapostgrev2.service;

import com.haydikodlayalim.springdatajpapostgresql.dto.KisiDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface KisiService {
    KisiDto save(KisiDto kisiDto);
    void delete(Long id);
    List<KisiDto> getAll();
    Page<KisiDto> getAll(Pageable pageable);
}
