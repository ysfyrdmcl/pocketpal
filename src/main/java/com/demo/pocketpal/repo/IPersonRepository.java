package com.demo.pocketpal.repo;

import com.demo.pocketpal.entitiy.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<Person,Long> {
    @Query("Select p from Person p where p.email = ?1")
    Optional<Person> findByEmail(String email);
    @Query("Select p from Person p where p.email = ?1 and p.password = ?2")
    Optional<Person> findByEmailAndPassword(String email, String password);
}
