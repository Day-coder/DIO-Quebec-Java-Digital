package com.projeto.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.mapper.ParkingMapper;
import com.projeto.dto.ParkingDTO;
import com.projeto.model.Parking;
import com.projeto.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	private final ParkingService parkingService;
	private final ParkingMapper parkingMapper;
	
	public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
		this.parkingService= parkingService;
		this.parkingMapper= parkingMapper;
	}
	
	@GetMapping
	public List<ParkingDTO> findAll(){
List<Parking> parkingList= parkingService.findAll();
	List<ParkingDTO> result= parkingMapper.toParkingDTOList(parkingList);
	return result;
	}

}
