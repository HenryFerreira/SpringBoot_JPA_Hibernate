package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.role;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class roleService {
    @Autowired
    roleRepository rolRepository;

    public ArrayList<role> getAllRoles(){//Obtener todos los roles
        return (ArrayList<role>) rolRepository.findAll();
    }

    public role addNewRole(role newRole){//Agregar un nuevo rol
        return rolRepository.save(newRole);
    }
}
