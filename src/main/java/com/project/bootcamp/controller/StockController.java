package com.project.bootcamp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bootcamp.model.dto.StockDto;
import com.project.bootcamp.service.StockService;

@CrossOrigin
@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> save(@Valid @RequestBody StockDto dto) {
		return ResponseEntity.ok(stockService.save(dto));
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> update(@Valid @RequestBody StockDto dto) {
		return ResponseEntity.ok(stockService.update(dto));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDto>> findAll() {
		return ResponseEntity.ok(stockService.findAll());
	}
	
	@GetMapping(value = "/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> findById(@PathVariable Long stockId) {
		return ResponseEntity.ok(stockService.findById(stockId));
	}
	
	@GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDto>> findByToday() {
		return ResponseEntity.ok(stockService.findByToday());
	}
	
	@DeleteMapping(value = "/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDto> delete(@PathVariable Long stockId) {
		return ResponseEntity.ok(stockService.delete(stockId));
	}
}