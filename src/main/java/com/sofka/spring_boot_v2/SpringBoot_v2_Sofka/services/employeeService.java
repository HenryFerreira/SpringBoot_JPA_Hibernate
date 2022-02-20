package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//2. Creación de los servicios de un CRUD. ( Crear, Eliminar, Actualizar, Obtener todos y Obtener por ID). 30%
@Service
public class employeeService {
    @Autowired
    employeeRepository empRepository;

    public ArrayList<employee> getAllEmployee(){//Obtener todos los empleados
        return (ArrayList<employee>) empRepository.findAll();
    }

    public employee addNewEmployee(employee newEmployee){//Agregar un nuevo empleado
        return empRepository.save(newEmployee);
    }


}
