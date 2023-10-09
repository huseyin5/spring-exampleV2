package com.haydikodlayalim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private int id;

    private String name;

    private Date date;

}
