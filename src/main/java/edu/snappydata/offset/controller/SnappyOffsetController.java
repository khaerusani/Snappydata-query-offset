package edu.snappydata.offset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.snappydata.offset.model.ReturnModel;
import edu.snappydata.offset.model.StarModel;
import edu.snappydata.offset.service.SnappyOffsetService;

@CrossOrigin(origins = "*")
@Controller
public class SnappyOffsetController {
	
    @Autowired
    private SnappyOffsetService service;
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ReturnModel getAll() {
    	ReturnModel returnValue = new ReturnModel();
    	
    	try {
        	List<StarModel> result = service.getAll();	
        	
        	returnValue.setResult(result);
        	returnValue.setStatus(true);
        	returnValue.setMessage("Success");
    	} catch (Exception e) {
			returnValue.setStatus(false);
			returnValue.setMessage(e.getMessage());
		}
    	
    	return returnValue;
    }
    
    @RequestMapping(value = "/getByOffset", method = RequestMethod.GET)
    @ResponseBody
    public ReturnModel getByOffset(
            @RequestParam(value = "skip", defaultValue = "0", required = false) int skip,
            @RequestParam(value = "limit", defaultValue = "10", required = false) int limit
    		) {
    	ReturnModel returnValue = new ReturnModel();
    	
    	try {
        	List<StarModel> result = service.getByOffset(skip, limit);	
        	
        	returnValue.setResult(result);
        	returnValue.setStatus(true);
        	returnValue.setMessage("Success");
    	} catch (Exception e) {
			returnValue.setStatus(false);
			returnValue.setMessage(e.getMessage());
		}
    	
    	return returnValue;
    }
}
