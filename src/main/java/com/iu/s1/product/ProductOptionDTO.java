package com.iu.s1.product;

public class ProductOptionDTO {
	private Long optionNum;
	private Long productNum;
	private String optionName;
	private Long optionPrice;
	public Long getOptionNum() {
		return optionNum;
	}
	public void setOptionNum(Long optionNum) {
		this.optionNum = optionNum;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Long getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(Long optionPrice) {
		this.optionPrice = optionPrice;
	}
	public Long getOptionstock() {
		return optionstock;
	}
	public void setOptionstock(Long optionstock) {
		this.optionstock = optionstock;
	}
	private Long optionstock;
}
