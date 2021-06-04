package com.project.bootcamp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.bootcamp.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	Optional<Stock> findByNameAndDate(String name, LocalDate date);

	@Query("SELECT s FROM Stock s WHERE s.name = :name AND s.date = :date AND s.id <> :id")
	Optional<Stock> findByStockUpdate(Long id, String name, LocalDate date);

	@Query("SELECT s FROM Stock s WHERE s.date = :date")
	List<Stock> findByToday(LocalDate date);
}