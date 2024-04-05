package net.javaguides.springboot.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Coder;
import net.javaguides.springboot.repository.CoderRepository;

@Service
@Slf4j
public class CoderService {
	
	
	@Autowired
    private CoderRepository coderRepository;

	//get Total count of coders
	public long getTotalRecords() {
		return coderRepository.count();
	}
	
	//get All coders

	public Page<Coder> getResponseAllCoders(Pageable pageable) {
		log.info("CoderService --> Fetching all coder data");
        Page<Coder> coders = coderRepository.findAll(pageable);
		return coders;
	}


	//create coder
	@SuppressWarnings("null")
	public Coder getResponseCreateCoder(Coder coder) {
		log.info("CoderService --> Saving all coder data");
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0, 5);
        coder.setId(id);
		return coderRepository.save(coder);
		
	}

	//get coder By coderId
	public Coder getResponseGetCoderById(String coderId) {
		//Long covertToLong = Optional.ofNullable(coderId).map(Long::parseLong).orElseThrow(() -> new IllegalArgumentException("Coder ID cannot be null"));
		Coder coder = coderRepository.findById(coderId).orElseThrow(() -> new ResourceNotFoundException("Coder not exist with id:" + coderId));
		return coder;
	}

	//update coder By coderId
	public Coder getResponseUpdateCoderById(String coderId, Coder coderDetails) {
		//Long covertToLong = Optional.ofNullable(coderId).map(Long::parseLong).orElseThrow(() -> new IllegalArgumentException("Coder ID cannot be null"));
		Coder updateCoder = coderRepository.findById(coderId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + coderId));
		updateCoder.setFirstName(coderDetails.getFirstName());
		updateCoder.setLastName(coderDetails.getLastName());
		updateCoder.setEmailId(coderDetails.getEmailId());		
			return coderRepository.save(updateCoder);
	}

	//delete coder By coderId
	public void getResponseDeleteCoderById(String coderId) {
		//Long covertToLong = Optional.ofNullable(coderId).map(Long::parseLong).orElseThrow(() -> new IllegalArgumentException("Coder ID cannot be null"));
		Coder coder = coderRepository.findById(coderId).orElseThrow(() -> new ResourceNotFoundException("Coder not exist with id: " + coderId));
		coderRepository.delete(coder);
		 
	}
}
