package com.haydikodlayalim.service.impl;

import com.haydikodlayalim.springdatajpapostgresql.dto.KisiDto;
import com.haydikodlayalim.springdatajpapostgresql.entitiy.Adres;
import com.haydikodlayalim.springdatajpapostgresql.entitiy.Kisi;
import com.haydikodlayalim.springdatajpapostgresql.repo.AdresRepository;
import com.haydikodlayalim.springdatajpapostgresql.repo.KisiRepository;
import com.haydikodlayalim.springdatajpapostgresql.service.impl.KisiServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KisiServiceImplTest {

    @InjectMocks
    private KisiServiceImpl kisiService;

    @Mock
    private KisiRepository kisiRepository;

    @Mock
    private AdresRepository adresRepository;

    @Test
    public void testSave() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setAdi("Test-Name");
        kisiDto.setSoyadi("Test-Lastname");
        kisiDto.setAdresler(Arrays.asList("Test-Adres-1"));
        Kisi kisiMock = mock(Kisi.class);

        when(kisiMock.getId()).thenReturn(1L);
        when(kisiRepository.save(ArgumentMatchers.any(Kisi.class))).thenReturn(kisiMock);
        KisiDto result = kisiService.save(kisiDto);

        assertEquals(result.getAdi(), kisiDto.getAdi());
        assertEquals(result.getId(), 1L);
    }

    @Test
    public void testSaveException() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setSoyadi("Test-Lastname");
        kisiDto.setAdresler(Arrays.asList("Test-List-1"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            kisiService.save(kisiDto);
        });
    }

    @Test
    public void testGetAllWithAddress() {
        Kisi kisi = new Kisi();
        kisi.setAdi("Test-Name");
        kisi.setSoyadi("Test-Lastname");

        Adres ad = new Adres();
        ad.setAdresTip(Adres.AdresTip.DIGER);
        ad.setAdres("Test-Adres");
        kisi.setAdresleri(Collections.singletonList(ad));

        when(kisiRepository.findAll()).thenReturn(Collections.singletonList(kisi));
        List<KisiDto> kisiDtos = kisiService.getAll();

        assertEquals(kisiDtos.get(0).getAdresler().size(), 1);
    }
}
