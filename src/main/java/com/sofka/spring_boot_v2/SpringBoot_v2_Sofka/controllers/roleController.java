package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.controllers;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.role;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController//--> Indica que es un controlador
@RequestMapping("/role")//Indica en que direccion del servidor se activan los metodos de esta clase
public class roleController {
    @Autowired
    roleService rolService;

    @GetMapping()
    public ArrayList<role> getAllRoles(){
        return this.rolService.getAllRoles();
    }

    @GetMapping("/search/id/{id}")
    public role getRoleById(@PathVariable("id")Long id){
        return this.rolService.getRoleById(id);
    }

    @PostMapping()
    public role addNewRole(@RequestBody role newRole){
        System.out.println(newRole);
        return this.rolService.addNewRole(newRole);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<role> updateRoleById(@PathVariable("id")Long id, @RequestBody role roleData){
        return this.rolService.updateRoleById(id, roleData);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteRoleById(@PathVariable("id")Long id){
        if(this.rolService.deleteRoleById(id)){//Si devuelve true
            return "Se elimino el Rol con ID: [" + id + "]";
        } else {// Si devuelve false
            return "No pudo eliminar el Rol con ID: [" + id + "]";
        }
    }

}
