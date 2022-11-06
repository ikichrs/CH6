package com.binar.challenge4.repository;


import com.binar.challenge4.entity.SeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<SeatsEntity, String>{
}
