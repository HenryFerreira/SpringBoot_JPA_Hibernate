package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.employeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest//--> Indica que este TEST se va a utilizar solamente para JPA
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class employeeJpaRepositoryTest {
    @Autowired
    private employeeRepository empRepository;

    @Test
    public void saveEmployee(){
        employee jhon = new employee("Jhon", "Smith", "empl123");
        employee claire = new employee("claire", "Simpson", "empl124");

        empRepository.save(jhon);
        empRepository.save(claire);

        empRepository.flush();

        assertEquals(2, empRepository.findAll().size());
    }
}
