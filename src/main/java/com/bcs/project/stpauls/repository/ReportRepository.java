package com.bcs.project.stpauls.repository;

import com.bcs.project.stpauls.model.Report;
import com.bcs.project.stpauls.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}
