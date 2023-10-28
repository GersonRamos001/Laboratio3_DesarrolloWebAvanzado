package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadoresDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    private CamisasDTO camisa;;

    private PosicionesDTO posicion;

    private EquiposDTO equipo;



}
