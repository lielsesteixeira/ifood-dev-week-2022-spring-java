package me.dio.sacola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.sacola.models.Product;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}