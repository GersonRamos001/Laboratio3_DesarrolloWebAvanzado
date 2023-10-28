package com.mitocode.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JugadoresDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    private Long camisa;

    private Long posicion;

    private Long equipo;

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

    public Long getCamisa() {
        return camisa;
    }

    public void setCamisa(final Long camisa) {
        this.camisa = camisa;
    }

    public Long getPosicion() {
        return posicion;
    }

    public void setPosicion(final Long posicion) {
        this.posicion = posicion;
    }

    public Long getEquipo() {
        return equipo;
    }

    public void setEquipo(final Long equipo) {
        this.equipo = equipo;
    }

}
