package me.dio.sacola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.sacola.models.Consumer;

/**
 * ConsumerRepository
 */
@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
}