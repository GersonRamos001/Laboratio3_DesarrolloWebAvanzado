package com.mitocode.model;

import lombok.*;
import javax.persistence.*;

import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jugadores {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camisa_id", unique = true)
    private Camisas camisa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posicion_id")
    private Posiciones posicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private Equipos equipo;
}
