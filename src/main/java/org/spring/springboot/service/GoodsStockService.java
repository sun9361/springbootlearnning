package org.spring.springboot.service;

 

import java.util.List;

import org.spring.springboot.domain.GoodsStock;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface GoodsStockService {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<GoodsStock> findAllGoodsStock();

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    GoodsStock findByGoodsId(Long id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveGoodsStock(GoodsStock city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    Long updateStock(GoodsStock city);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    int decreaseStock(Long id);

	Long decreaseStockFromRedis(Long goodsId);
}
