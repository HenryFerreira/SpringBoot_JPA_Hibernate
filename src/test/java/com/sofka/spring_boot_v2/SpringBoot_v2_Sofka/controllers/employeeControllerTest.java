package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.controllers;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.role;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.employeeRepository;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.services.employeeService;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
//import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class employeeControllerTest {
    @MockBean
    private employeeService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private employeeRepository repository;

    @Test
    @DisplayName("GET /employee success")
    void testGetWidgetsSuccess() throws Exception {
        //Empleados
        role admin = new role("ROLE_ADMIN");
        role dev = new role("ROLE_DEV");

        employee john = new employee("John", "Smith", "empl123", dev);
        employee claire = new employee("Claire", "Simpson", "empl124", admin);

        doReturn(Lists.newArrayList(john, claire)).when(service).getAllEmployee();

        this.mockMvc
                .perform(get("/employee"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.is(2)))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Smith"))
                .andExpect(jsonPath("$[1].firstName").value("Claire"))
                .andExpect(jsonPath("$[1].lastName").value("Simpson"));
    }


    @Test
    @DisplayName("GET /employee by ID success")
    void testEmployeeById() throws Exception {
        //Empleados
        role admin = new role("ROLE_ADMIN");
        role dev = new role("ROLE_DEV");

        employee john = new employee("John", "Smith", "empl123", dev);
        john.setId(1L);
        System.out.println(john.getId());
        employee claire = new employee("Claire", "Simpson", "empl124", admin);

        doReturn(Optional.of(john)).when(service).getEmployeeById(john.getId());
        URI uri = new URI("/employee/search/id/1");
        this.mockMvc
                .perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Smith"));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //PUT para modificar un elemento que se encuentra en la base de datos
    @Test
    void testPutEmployeeById() throws Exception {
        role dev = new role("ROLE_DEV");
        employee empleado = new employee("Henry", "Ferreira", "empl123", dev);
        empleado.setId(1L);
        employee nuevaInformacion = new employee("Haff", "Soul", "empl123", dev);
        nuevaInformacion.setId(1L);

        doReturn(ResponseEntity.of(Optional.of(employee.class))).when(service).updateEmployeeById(empleado.getId(), nuevaInformacion);

        URI uri = new URI("/employee/update/id/1");
        this.mockMvc
                .perform(MockMvcRequestBuilders.put(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(nuevaInformacion))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    //PUT para modificar un elemento que no se encuentra en la base de datos (not found)
    @Test
    void testPutModificarElementoNotFound() throws Exception {
        role dev = new role("ROLE_DEV");
        employee empleado = new employee("Henry", "Ferreira", "empl123", dev);
        empleado.setId(1L);
        employee nuevaInformacion = new employee("Haff", "Soul", "empl123", dev);
        nuevaInformacion.setId(1L);
        doReturn(null).when(service).updateEmployeeById(empleado.getId(), nuevaInformacion);

        URI uri = new URI("/usuario");
        mockMvc.perform(MockMvcRequestBuilders.put(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(nuevaInformacion))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }
}