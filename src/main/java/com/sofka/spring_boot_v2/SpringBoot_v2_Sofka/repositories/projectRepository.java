package com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.repositories;

import com.sofka.spring_boot_v2.SpringBoot_v2_Sofka.models.project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projectRepository extends JpaRepository<project,Long> {

}
