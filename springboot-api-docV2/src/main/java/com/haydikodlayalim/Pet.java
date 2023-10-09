package com.haydikodlayalim;

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
@ApiModel(value = "Pet obj", description = "my pet obj")
public class Pet {

    @ApiModelProperty(value = "Pet obj single id")
    private int id;

    @ApiModelProperty(value = "Pet obj name line")
    private String name;

    @ApiModelProperty(value = "Pet obj date line")
    private Date date;


}
