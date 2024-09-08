package com.example.scm.repsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scm.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
