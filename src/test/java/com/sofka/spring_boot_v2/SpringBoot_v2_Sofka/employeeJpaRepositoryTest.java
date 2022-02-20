package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.employee;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.project;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.role;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.employeeRepository;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.proyectRepository;
import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories.roleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @AutoConfigureTestDatabase (connection = EmbeddedDatabaseConnection.H2)
public class employeeJpaRepositoryTest {
    @Autowired
    private employeeRepository repoEmpl;

    @Autowired
    private roleRepository repoRole;

    @Autowired
    private proyectRepository repoProj;

    @Test
    public void saveEmployee() {

        role admin = new role("ROLE_ADMIN");
        role dev = new role("ROLE_DEV");

        admin = repoRole.save(admin);
        dev = repoRole.save(dev);

        project proj1 = new project("proj1");
        project proj2 = new project("proj2");
        project proj3 = new project("proj3");

        proj1 = repoProj.save(proj1);
        proj2 = repoProj.save(proj2);
        proj3 = repoProj.save(proj3);

        employee john = new employee("John", "Smith", "empl123", dev);
        employee claire = new employee("Claire", "Simpson", "empl124", admin);

        john.getProjects().add(proj1);
        john.getProjects().add(proj2);

        claire.getProjects().add(proj1);
        claire.getProjects().add(proj2);
        claire.getProjects().add(proj3);

        repoEmpl.save(john);
        repoEmpl.save(claire);

        repoEmpl.flush();

        employee empl124 = repoEmpl.findByEmployeeId("empl124");
        assertEquals("Claire", empl124.getFirstName());
        assertEquals(2, repoEmpl.findAll().size());
        assertEquals(admin, empl124.get_role());

    }
}
