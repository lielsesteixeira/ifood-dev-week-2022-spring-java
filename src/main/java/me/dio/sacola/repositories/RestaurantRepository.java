package me.dio.sacola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.sacola.models.Restaurant;

/**
 * RestaurantRepository
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}