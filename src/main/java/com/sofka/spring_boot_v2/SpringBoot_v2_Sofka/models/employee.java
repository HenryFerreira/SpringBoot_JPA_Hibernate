package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models;

import javax.persistence.*;
import java.util.Objects;

@Entity//--> Indica que está clase va a ser una entidad, o sea, un Tabla en SQL
public class employee {
    //----------------------------------------------------------------------------------------------------------------//
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)/*--> Indica que el valor se genera de forma automatica sin
     importar el gestor de Base de Datos*/
    private Long id;

    @Column(length = 25, nullable = false)//--> Indica que es una columna con longitud de 25 caracteres y no nula
    private String first_name;

    @Column(length = 25, nullable = false)//--> Indica que es una columna con longitud de 25 caracteres y no nula
    private String last_name;

    @Column(length = 10, nullable = false, unique = true)/*--> Indica que es una columna con longitud de 10 caracteres,
     no nula y unica*/
    private String employee_id;
    //----------------------------------------------------------------------------------------------------------------//

    //----------------------------------------------------------------------------------------------------------------//
    //Constructores
    public employee() {//Constructor por Defecto

    }

    public employee(String first_name, String last_name, String employee_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.employee_id = employee_id;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
    //----------------------------------------------------------------------------------------------------------------//

    //----------------------------------------------------------------------------------------------------------------//
    //Equals, HashCode y ToString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee employee = (employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {//Devuelve el objeto en formato JSON
        return "employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", employee_id='" + employee_id + '\'' +
                '}';
    }
    //----------------------------------------------------------------------------------------------------------------//

}

