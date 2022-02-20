package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.controllers;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController//--> Indica que es un controlador
@RequestMapping("/employee")//Indica en que direccion del servidor se activan los metodos de esta clase
public class employeeController {
    @Autowired
    employeeService empService = new employeeService();

    @GetMapping()
    public ArrayList<employee> getAllEmployee() {
        return this.empService.getAllEmployee();
    }

    @GetMapping("/search/id/{id}")
    public Optional<employee> getEmployee(@PathVariable("id") Long id) {
        return this.empService.getEmployeeById(id);
    }

    @GetMapping("/search/name/{firstName}")
    public List<employee> getEmployeeByName(@PathVariable("firstName") String name) {
        return this.empService.getEmployeeByName(name);
    }

    @PostMapping()
    public employee addNewEmployee(@RequestBody employee newEmploye) {
        System.out.println(newEmploye);
        return this.empService.addNewEmployee(newEmploye);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<employee> updateEmployeeById(@PathVariable("id") Long id, @RequestBody employee employeeData) {
        return this.empService.updateEmployeeById(id, employeeData);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteEmployeeById (@PathVariable("id") Long id){
        if(this.empService.deleteEmployeeById(id)){//Si devuelve true
            return "Se elimino el Empleado con ID: [" + id + "]";
        } else {// Si devuelve false
            return "No pudo eliminar el Empleado con ID: [" + id + "]";
        }
    }


}
