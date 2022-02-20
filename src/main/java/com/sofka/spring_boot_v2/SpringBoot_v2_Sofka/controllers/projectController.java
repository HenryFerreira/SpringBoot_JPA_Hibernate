package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.controllers;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.project;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController//--> Indica que es un controlador
@RequestMapping("/project")//Indica en que direccion del servidor se activan los metodos de esta clase
public class projectController {
    @Autowired
    projectService proService;

    @GetMapping()
    public ArrayList<project> getAllProjects() {
        return this.proService.getAllProjects();
    }

    @GetMapping("/search/id/{id}")
    public project getProjectById(@PathVariable("id") Long id){
        return this.proService.getProjectById(id);
    }

    @PostMapping()
    public project addNewProject(@RequestBody project newProject) {
        return this.proService.addNewProject(newProject);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<project> updateProjectById(@PathVariable("id") Long id, @RequestBody project projectData){
        return this.proService.updateProjectById(id,projectData);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteProjectById(@PathVariable("id") Long id){
        if(this.proService.deleteProjectById(id)){//Si devuelve true
            return "Se elimino el Proyecto con ID: [" + id + "]";
        } else {// Si devuelve false
            return "No pudo eliminar el Proyecto con ID: [" + id + "]";
        }
    }


}
