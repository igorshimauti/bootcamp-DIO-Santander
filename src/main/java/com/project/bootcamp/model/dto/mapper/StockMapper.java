package com.project.bootcamp.model.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDto;

@Component
public class StockMapper {

	public Stock toEntity(@Valid StockDto dto) {
		Stock stock = new Stock();
		stock.setId(dto.getId());
		stock.setName(dto.getName());
		stock.setDate(dto.getDate());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		return stock;
	}
	
	public StockDto toDto(Stock stock) {
		StockDto dto = new StockDto();
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setDate(stock.getDate());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		return dto;		
	}

	public List<StockDto> toCollectionDto(List<Stock> stocks) {
		return stocks.stream().map(this::toDto).collect(Collectors.toList());
	}
}