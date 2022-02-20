package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class project {
    //----------------------------------------------------------------------------------------------------------------//
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)/*--> Indica que el valor se genera de forma automatica sin
     importar el gestor de Base de Datos*/
    private Long id;

    @Column(length = 25, nullable = false)//--> Indica que es una columna con longitud de 25 caracteres y no nula
    private String name;
    //----------------------------------------------------------------------------------------------------------------//

    //----------------------------------------------------------------------------------------------------------------//
    //Constructores
    public project() {
    }

    public project(String name) {
        this.name = name;
    }
    //----------------------------------------------------------------------------------------------------------------//

    //----------------------------------------------------------------------------------------------------------------//
    //Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //----------------------------------------------------------------------------------------------------------------//

    //----------------------------------------------------------------------------------------------------------------//
    //Equals, HashCode y ToString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        project proyect = (project) o;
        return Objects.equals(id, proyect.id) && Objects.equals(name, proyect.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "proyect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //----------------------------------------------------------------------------------------------------------------//



}
