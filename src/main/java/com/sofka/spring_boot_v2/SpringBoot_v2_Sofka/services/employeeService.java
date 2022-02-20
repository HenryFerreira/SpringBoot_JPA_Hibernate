package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//2. Creación de los servicios de un CRUD. ( Crear, Eliminar, Actualizar, Obtener todos y Obtener por ID). 30%
@Service
public class employeeService {
    @Autowired//Instancia de 'employeeRepository'
    employeeRepository empRepository;

    //Obtener todos los empleados
    public Optional<employee> getEmployeeById(Long id){
        return this.empRepository.findById(id);
    }

    //Obtener empleado por ID
    public List<employee> getEmployeeByName(String name){
        return this.empRepository.findByFirstName(name);
    }

    //Obtener todos los empleados por el Nombre
    public ArrayList<employee> getAllEmployee() {//Obtener todos los empleados
        return (ArrayList<employee>) empRepository.findAll();
    }

    //Agregar un nuevo empleado
    public employee addNewEmployee(employee newEmployee) {//Agregar un nuevo empleado
        return empRepository.save(newEmployee);
    }

    //Actualizar un empleado por su ID
    public ResponseEntity<employee> updateEmployeeById(Long id, employee employeeData) {
        Optional<employee> updatedEmployee = this.empRepository.findById(id);

        if (updatedEmployee.isPresent()) {
            employee _employee = updatedEmployee.get();
            _employee.setFirstName(employeeData.getFirstName());
            _employee.setLastName(employeeData.getLastName());
            _employee.setEmployeeId(employeeData.getEmployeeId());
            _employee.set_role(employeeData.get_role());
            _employee.setProjects(employeeData.getProjects());
            
            return new ResponseEntity<>(empRepository.save(_employee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar un empleado por su ID
    public boolean deleteEmployeeById(Long id) {
        try {
            this.empRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
