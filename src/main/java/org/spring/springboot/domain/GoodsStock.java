package org.spring.springboot.domain;

/**
 * 商品库存表
 *
 * Created by bysocket on 07/02/2017.
 */
public class GoodsStock {

    /**
     * 编号
     */
    private Long id;

    /**
     * 商品编号
     */
    private Long goodsId;

  
    /**
     * 描述
     */
    private Integer amount;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getGoodsId() {
		return goodsId;
	}


	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}

    
}
