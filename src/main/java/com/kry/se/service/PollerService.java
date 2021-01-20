package com.kry.se.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.kry.se.entity.PollerData;
import com.kry.se.repository.PollerRepository;




@Service
public class PollerService {
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 PollerRepository pollerRepository;

	 @Autowired
	 RestTemplate restTemplate;
	 //convert pollerData to pollerDTO
	public String createService(PollerData pollerData) {
		logger.info("creating service:" + pollerData.getName());
		try {
			//Need to figure Out how to use poller
			pollerData.setDateCreated(LocalDateTime.now());
			PollerData poller = pollerRepository.save(pollerData);
			logger.info("created service:" + pollerData.getName());
		} catch (Exception e) {
			logger.error("Failed to create service " + pollerData.getName(), e);
			return "Service Creation Failed due to: "+e;
		}
		return pollerData.getName()+" Service Created";
	}
	
	public void updateService(PollerData pollerData) {
		logger.info("updating service:" + pollerData.getName());
		try {
			int result = pollerRepository.updatePollerData(pollerData.getName(), pollerData.getUrl(), pollerData.getPollerId());
//			if(result!=0) {	
//				logger.info("updated service:" + pollerData.getName());
//			}else {	
//			logger.info("record not updated" + pollerData.getName());
//			}
			} catch (Exception e) {
			logger.error("Failed to update service " + pollerData.getName(), e);
			}
//		return pollerData.getName()+" Service Updated";
	}

	public List<PollerData> findAllServices() {
		logger.info("getting all the services");
		return (List<PollerData>) pollerRepository.findAll();		
	}
	
	public String testService(String url) {
		logger.info("Testing:" + url);
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);	
			//we can add a check for 200 status
			logger.info("Testing Successfull: " + response.getStatusCodeValue());	
		} catch (Exception e) {
		      logger.error("Failed to test " + url+" : "+e.getMessage());
		      return "FAIL";
		    }
		return "OK";
	}
	


	public void deleteService(int pollerId) {
		try {
			pollerRepository.deleteById(pollerId);
			logger.info("Deletion Successfull");	
		} catch (Exception e) {
		      logger.error("Failed to Delete " + pollerId+e.getMessage());
		    }		
	}

	public PollerData findServiceByPollerId(int pollerId) {
		Optional<PollerData> pollerData = pollerRepository.findById(pollerId);
		return pollerData.get();
	}
	
//	public PollerData convertPoller (Optional<PollerData> optionalData){
//		PollerData pollerData = optionalData.get();
//		return pollerData;
//	}
}
