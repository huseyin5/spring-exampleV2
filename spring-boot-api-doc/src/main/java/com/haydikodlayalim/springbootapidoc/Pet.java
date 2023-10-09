package com.haydikodlayalim.springbootapidoc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet nesnesi", description = "Pet")
public class Pet {

    @ApiModelProperty(value = "Pet nesnenin tekil Id alanı")
    private int id;

    @ApiModelProperty(value = "Pet nesnesinin Adi alanı")
    private String name;

    @ApiModelProperty(value = "Pet nesnesinin Tarih alanı")
    private Date date;

}
