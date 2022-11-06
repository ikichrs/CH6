package com.binar.challenge4.repository;

import com.binar.challenge4.entity.OrderEntity;
import com.binar.challenge4.entity.SchedulesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepository extends JpaRepository<SchedulesEntity, Long>{
}
