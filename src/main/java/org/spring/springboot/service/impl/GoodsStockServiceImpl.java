package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.StockDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.domain.GoodsStock;
import org.spring.springboot.service.GoodsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class GoodsStockServiceImpl implements GoodsStockService {

    @Autowired
    private StockDao cityDao;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    public List<GoodsStock> findAllGoodsStock(){
        return cityDao.findAllGoodsStock();
    }

    public GoodsStock findByGoodsId(Long id) {
        return cityDao.findByGoodsId(id);
    }

	@Override
	public Long saveGoodsStock(GoodsStock city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateStock(GoodsStock city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int decreaseStock(Long goodsId) {
		int sign=0;
	 int amount=cityDao.findByGoodsId(goodsId).getAmount();
	 if(amount>0)
		 sign=  cityDao.decreaseStock(goodsId);
		return sign;
	}

 
	@Override
	public Long decreaseStockFromRedis(Long goodsId) {
		Long amount=redisTemplate.opsForValue().increment("apple", -1);
//		int sign=0;
//	 int amount=cityDao.findByGoodsId(goodsId).getAmount();
//	 if(amount>0)
//		 sign=  cityDao.decreaseStock(goodsId);
//		if(amount<0)
//			redisTemplate.opsForValue().increment("apple", 1);
		return amount;
	}
   

}
