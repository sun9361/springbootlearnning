package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@Controller
public class AccessCityRestController {

    @Autowired  
    private RestTemplate restTemplate;

    @RequestMapping(value = "/access/city/{id}", method = RequestMethod.GET)
    @ResponseBody
    public City findOneCity(@PathVariable("id") Long id) {
    	City u = this.restTemplate.getForObject("http://localhost:8080/api/city/" + id,  
    			City.class);  
          System.out.println(u);  
        return u;
    }
    @RequestMapping(value = "/access/city")
    @ResponseBody
    public String saveOneCity() {
    	City u1=new City();
    	//u1.setId(2L);
    	u1.setCityName("广州");
    	u1.setDescription("美丽的羊城");
    	u1.setProvinceId(020L);
    	ResponseEntity<String> u = this.restTemplate.postForEntity("http://localhost:8080/api/city" ,  
    			u1,String.class);  
          System.out.println(u);  
        return u.getBody();
    }

 

 
}
