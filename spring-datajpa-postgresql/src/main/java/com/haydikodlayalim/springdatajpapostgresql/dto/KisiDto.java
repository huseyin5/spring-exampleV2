package com.haydikodlayalim.springdatajpapostgresql.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class KisiDto {
    private Long id;
    private String adi;
    private String soyadi;
    private List<String> adresler;
}
