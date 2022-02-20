package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.controllers;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.role;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController//--> Indica que es un controlador
@RequestMapping("/role")//Indica en que direccion del servidor se activan los metodos de esta clase
public class roleController {
    @Autowired
    roleService rolService;

    @GetMapping()
    ArrayList<role> getAllRoles(){
        return this.rolService.getAllRoles();
    }

    @PostMapping()
    role addNewRole(@RequestBody role newRole){
        System.out.println(newRole);
        return this.rolService.addNewRole(newRole);
    }

}
