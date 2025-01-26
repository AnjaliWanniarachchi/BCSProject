package com.bcs.project.stpauls.repository;

import com.bcs.project.stpauls.model.Batch;
import com.bcs.project.stpauls.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

}
