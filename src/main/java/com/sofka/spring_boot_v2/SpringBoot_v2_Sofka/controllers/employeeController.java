package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.controllers;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController//--> Indica que es un controlador
@RequestMapping("/employee")//Indica en que direccion del servidor se activan los metodos de esta clase
public class employeeController {
    @Autowired
    employeeService empService = new employeeService();

    @GetMapping()
    public ArrayList<employee> getAllEmployee(){
        return this.empService.getAllEmployee();
    }

    @PostMapping()
    public employee addNewEmployee(@RequestBody employee newEmploye){
        System.out.println(newEmploye);
        return this.empService.addNewEmployee(newEmploye);
    }

}
