package com.binar.challenge4.repository;

import com.binar.challenge4.entity.OrderEntity;
import com.binar.challenge4.entity.StudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<StudioEntity, Integer>{
}
