package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.project;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.projectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class projectService {
    @Autowired//Instancia de 'projectRepository'
    projectRepository proRepository;

    //Obtener todos los proyectos
    public ArrayList<project> getAllProjects() {
        return (ArrayList<project>) this.proRepository.findAll();
    }

    //Obtener proyecto por su ID
    public project getProjectById(Long id) {
        return this.proRepository.getById(id);
    }

    //Agregar un nuevo proyecto
    public project addNewProject(project newProject) {
        return this.proRepository.save(newProject);
    }

    //Actualzar un proyecto por su ID
    public ResponseEntity<project> updateProjectById(Long id, project projectData) {
        Optional<project> updateProject = this.proRepository.findById(id);

        if (updateProject.isPresent()) {
            project _project = updateProject.get();
            _project.setName(projectData.getName());

            return new ResponseEntity<>(this.proRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar un proyecto por su ID
    public boolean deleteProjectById(Long id) {
        try {
            this.proRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
