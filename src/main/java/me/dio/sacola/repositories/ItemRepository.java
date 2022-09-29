package me.dio.sacola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.sacola.models.Item;

/**
 * ItemRepository
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}