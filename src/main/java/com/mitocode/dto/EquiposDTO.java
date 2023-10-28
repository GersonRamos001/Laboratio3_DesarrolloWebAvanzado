package com.mitocode.dto;

import javax.validation.constraints.Size;

public class EquiposDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

}

