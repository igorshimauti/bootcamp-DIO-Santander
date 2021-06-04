package com.project.bootcamp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bootcamp.comon.MessageCommon;
import com.project.bootcamp.exception.BusinessException;
import com.project.bootcamp.exception.NotFoundException;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDto;
import com.project.bootcamp.model.dto.mapper.StockMapper;
import com.project.bootcamp.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockMapper stockMapper;
	
	@Transactional
	public StockDto save(StockDto dto) {
		Optional<Stock> optionalStock = stockRepository.findByNameAndDate(dto.getName(), dto.getDate());
		
		if (optionalStock.isPresent()) {
			throw new BusinessException(MessageCommon.STOCK_ALREADY_EXISTS);
		}
		
		Stock stock = stockMapper.toEntity(dto);
		return stockMapper.toDto(stockRepository.save(stock));
	}

	@Transactional
	public StockDto update(StockDto dto) {
		Optional<Stock> optionalStock = stockRepository.findByStockUpdate(dto.getId(), dto.getName(), dto.getDate());
		
		if (optionalStock.isPresent()) {
			throw new BusinessException(MessageCommon.STOCK_ALREADY_EXISTS);
		}
		
		Stock stock = stockMapper.toEntity(dto);
		return stockMapper.toDto(stockRepository.save(stock));
	}

	@Transactional(readOnly = true)
	public List<StockDto> findAll() {
		List<Stock> stocks = stockRepository.findAll();
		return stockMapper.toCollectionDto(stocks);
	}

	@Transactional(readOnly = true)
	public StockDto findById(Long stockId) {
		return stockRepository.findById(stockId).map(stockMapper::toDto).orElseThrow(NotFoundException::new);
	}

	public StockDto delete(Long stockId) {
		StockDto dto = findById(stockId);
		stockRepository.deleteById(stockId);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<StockDto> findByToday() {
		List<Stock> stocks = stockRepository.findByToday(LocalDate.now()); 
		return stockMapper.toCollectionDto(stocks);
	}
}