package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    private String firstName;

    @Column(length = 25, nullable = false)//--> Indica que es una columna con longitud de 25 caracteres y no nula
    private String lastName;

    @Column(length = 10, nullable = false, unique = true)/*--> Indica que es una columna con longitud de 10 caracteres,
     no nula y unica*/
    private String employeeId;

    @ManyToOne(optional = false)//--> De muchos a uno
    @JoinColumn(name = "id_role")//--> Nombre de la columna
    private role _role;//--> va a ser el atributo foraneo en la tabla

    @ManyToMany(cascade = CascadeType.ALL)//--> Tipo cascada
    //Se crea una tabla con dos atributos 'employee_id' y 'proyect_id' además esta ultima es clave foranea de proyect
    @JoinTable(name = "employee_proyect",
                joinColumns = {@JoinColumn(name = "employee_id")},
                inverseJoinColumns = {@JoinColumn(name = "proyect_id")})
    private List<project> projects = new ArrayList<project>();
    //----------------------------------------------------------------------------------------------------------------//

    //----------------------------------------------------------------------------------------------------------------//
    //Constructores
    public employee() {//Constructor por Defecto

    }

    public employee(String firstName, String lastName, String employeeId, role _role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this._role = _role;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public role get_role() {
        return _role;
    }

    public void set_role(role _role) {
        this._role = _role;
    }

    public List<project> getProjects() {
        return projects;
    }

    public void setProjects(List<project> projects) {
        this.projects = projects;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
    //----------------------------------------------------------------------------------------------------------------//

    //----------------------------------------------------------------------------------------------------------------//
    //Relaciones de Tablas
    //----------------------------------------------------------------------------------------------------------------//


}

