package com.kamibytes.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamibytes.main.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
