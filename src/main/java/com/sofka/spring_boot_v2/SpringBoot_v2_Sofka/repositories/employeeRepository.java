package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//--> Indica que esta Interfaz es un Repositorio
public interface employeeRepository extends JpaRepository<employee, Long> {//--> Indica que es una tabla de tipo
    // 'employee' y que su identificador(PrimaryKey) será de tipo Long
    employee findByEmployeeId(String employeeId);//--> SELECT * FROM employee WHERE employeeId = '[parametro enviado]';
    List<employee> findByFirstName(String firstName);//--> SELECT * FROM employee WHERE firstName = '[parametro enviado]';
    List<employee> findByLastName(String lastName);//--> SELECT * FROM employee WHERE lastName = '[parametro enviado]';
}
