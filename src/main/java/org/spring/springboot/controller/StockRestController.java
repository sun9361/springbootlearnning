package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.domain.City;
import org.spring.springboot.domain.GoodsStock;
import org.spring.springboot.service.GoodsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class StockRestController {

    @Autowired
    private GoodsStockService cityService;

    @RequestMapping(value = "/api/stock/{id}", method = RequestMethod.GET)
    public GoodsStock findByGoodsId(@PathVariable("id") Long id) {
        return cityService.findByGoodsId(id);
    }

    @RequestMapping(value = "/api/Stock", method = RequestMethod.GET)
    public List<GoodsStock> findAllGoodsStock() {
        return cityService.findAllGoodsStock();
    }

//    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
//    public void createCity( City city) {
//        cityService.saveCity(city);
//    }

//    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
//    public void modifyCity(@RequestBody City city) {
//        cityService.updateCity(city);
//    }

    @RequestMapping(value = "/api/goods/{id}", method = RequestMethod.PUT)
    public void modifyStock(@PathVariable("id") Long id) {
        cityService.decreaseStock(id);
    }

@RequestMapping(value = "/api/redis/goods/{id}", method = RequestMethod.PUT)
public void modifyStockFromRedia(@PathVariable("id") Long id) {
    cityService.decreaseStockFromRedis(id);

}
}
