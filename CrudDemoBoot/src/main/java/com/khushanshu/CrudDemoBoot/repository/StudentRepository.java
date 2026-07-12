package com.khushanshu.CrudDemoBoot.repository;

import com.khushanshu.CrudDemoBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndStatusIsTrue(Long id);

    Boolean existsByEmail(String email);


}
