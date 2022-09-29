package me.dio.sacola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.sacola.models.Bag;

/**
 * BagRepository
 */
@Repository
public interface BagRepository extends JpaRepository<Bag, Long> {   
}