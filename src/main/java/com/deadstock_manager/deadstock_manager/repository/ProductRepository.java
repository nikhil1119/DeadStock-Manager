package com.deadstock_manager.deadstock_manager.repository;

import com.deadstock_manager.deadstock_manager.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByDsrNoContainingIgnoreCase(String dsrNo);

    List<Product> findByTypeContainingIgnoreCase(String type);

    List<Product> findByRoomNoContainingIgnoreCase(String roomNo);

    List<Product> findByCategoryContainingIgnoreCase(String category);
}
