package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.project;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.role;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class roleService {
    @Autowired//Instancia de 'roleRepository'
    roleRepository rolRepository;

    //Obtener todos los roles
    public ArrayList<role> getAllRoles() {//Obtener todos los roles
        return (ArrayList<role>) rolRepository.findAll();
    }

    //Obtener rol por su ID
    public role getRoleById(Long id) {
        return this.rolRepository.getById(id);
    }

    //Agregar un nuevo rol
    public role addNewRole(role newRole) {//Agregar un nuevo rol
        return rolRepository.save(newRole);
    }

    //Actualizar rol por ID
    public ResponseEntity<role> updateRoleById(Long id, role roleData) {
        Optional<role> updateRole = this.rolRepository.findById(id);

        if (updateRole.isPresent()) {
            role _role = updateRole.get();
            _role.setName(roleData.getName());

            return new ResponseEntity<>(this.rolRepository.save(_role), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar rol por ID
    public boolean deleteRoleById(Long id) {
        try {
            this.rolRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
