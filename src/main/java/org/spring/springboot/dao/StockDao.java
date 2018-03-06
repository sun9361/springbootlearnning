package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.GoodsStock;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface StockDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<GoodsStock> findAllGoodsStock();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
     GoodsStock findByGoodsId(@Param("goodsId") Long goodsId);

    Long saveGoodsStock(GoodsStock city);

    Long updateStock(GoodsStock city);

    Long deleteStock(Long id);
    int decreaseStock(Long goodsId);
}
