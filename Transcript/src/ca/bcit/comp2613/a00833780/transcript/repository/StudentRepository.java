package ca.bcit.comp2613.a00833780.transcript.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.bcit.comp2613.a00833780.transcript.model.Students;


public interface StudentRepository extends CrudRepository<Students, String> {

    List<Students> findById(String studentNumber);
}