package com.example.easy.school.repository;

import com.example.easy.school.models.Person;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person readByEmail(String email);
}
