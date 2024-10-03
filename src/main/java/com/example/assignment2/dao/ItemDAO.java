package com.example.assignment2.dao;

import com.example.assignment2.entity.impl.ItemEntity;
import com.example.assignment2.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<ItemEntity, String> {
}
