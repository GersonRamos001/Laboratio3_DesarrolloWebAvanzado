package com.mitocode.dto;

import javax.validation.constraints.Size;

public class PosicionesDTO {

    private Long id;

    @Size(max = 255)
    private String posicion;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(final String posicion) {
        this.posicion = posicion;
    }

}
