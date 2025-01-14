package com.exel_to_db.repositories;

import com.exel_to_db.entities.StateInIndia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateInIndiaRepo extends JpaRepository<StateInIndia,Integer> {
}
