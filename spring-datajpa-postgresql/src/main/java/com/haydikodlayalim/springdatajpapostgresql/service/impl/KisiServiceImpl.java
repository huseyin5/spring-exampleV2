package com.haydikodlayalim.springdatajpapostgresql.service.impl;

import com.haydikodlayalim.springdatajpapostgresql.dto.KisiDto;
import com.haydikodlayalim.springdatajpapostgresql.entitiy.Adres;
import com.haydikodlayalim.springdatajpapostgresql.entitiy.Kisi;
import com.haydikodlayalim.springdatajpapostgresql.repo.AdresRepository;
import com.haydikodlayalim.springdatajpapostgresql.repo.KisiRepository;
import com.haydikodlayalim.springdatajpapostgresql.service.KisiService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {

        if (kisiDto.getAdi() == null || kisiDto.getAdi().isEmpty()) {
            throw new IllegalArgumentException("Adi connat be null or empty");
        } else {
            Kisi kisi = new Kisi();
            kisi.setAdi(kisiDto.getAdi());
            kisi.setSoyadi(kisiDto.getSoyadi());
            final Kisi kisiDb = kisiRepository.save(kisi);
            List<Adres> liste = new ArrayList<>();
            kisiDto.getAdresler().forEach(item -> {
                Adres adres = new Adres();
                adres.setAdres(item);
                adres.setAdresTip(Adres.AdresTip.DIGER);
                adres.setAktif(true);
                adres.setKisi(kisiDb);
                liste.add(adres);
            });
            adresRepository.saveAll(liste);
            kisiDto.setId(kisiDb.getId());
            return kisiDto;
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();

        kisiler.forEach(it -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAdi(it.getAdi());
            kisiDto.setSoyadi(it.getSoyadi());
            kisiDto.setAdresler(
                    it.getAdresleri() != null ? it.getAdresleri().stream().map(Adres::getAdres).collect(Collectors.toList()) : null);
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}
