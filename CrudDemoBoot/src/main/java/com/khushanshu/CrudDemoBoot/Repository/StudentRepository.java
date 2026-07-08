package com.khushanshu.CrudDemoBoot.Repository;

import com.khushanshu.CrudDemoBoot.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
