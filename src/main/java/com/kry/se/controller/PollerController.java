package com.kry.se.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kry.se.entity.PollerData;

import com.kry.se.service.PollerService;

@Controller
public class PollerController {
	
	@Autowired
	PollerService pollerService;
	
	@GetMapping("/index")
	public ModelAndView getAllService() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("list", pollerService.findAllServices());
        return model;
    }
	
	@GetMapping("/getServices")
	public List<PollerData> findAllServices() {
		return (List<PollerData>) pollerService.findAllServices();
	}
	

		@GetMapping("/{pollerId}/edit")
	    public ModelAndView edit(@PathVariable("pollerId") int pollerId) {
		 System.out.println("INside Controller Edit");
		  ModelAndView model = new ModelAndView("edit");
	        PollerData pollerData = pollerService.findServiceByPollerId(pollerId);
	        model.addObject("service", pollerData);
	        return model;
	    }
		@GetMapping("/{pollerId}/delete")
	    public ModelAndView deleteService(@PathVariable int pollerId) {
		   pollerService.deleteService(pollerId);
	        return new ModelAndView("redirect:/index");
	    }
		
	   @PostMapping(value="/createService")
	    public ModelAndView serviceRegister(@ModelAttribute("user") PollerData pollerData){
		   ModelAndView model = new ModelAndView("index");
	    	if(pollerData!=null){
	    		pollerService.createService(pollerData);
	    	model.addObject("warning", "Service Registration Success");	    	
	    	}
	    	else{
	    		model.addObject("danger","Service Registration Failed" );	    		
	    	}
	    	return new ModelAndView("redirect:/index");
	   }
	   
	   @PostMapping(value="/update")
	    public ModelAndView serviceUpdate(@ModelAttribute("service") PollerData pollerData){
		   ModelAndView model = new ModelAndView("index");
	    	if(pollerData!=null){
	    		pollerService.updateService(pollerData);
	    	model.addObject("warning", "Service Registration Success");	    	
	    	}
	    	else{
	    		model.addObject("danger","Service Registration Failed" );	    		
	    	}
	    	return new ModelAndView("redirect:/index");
	   }
}
