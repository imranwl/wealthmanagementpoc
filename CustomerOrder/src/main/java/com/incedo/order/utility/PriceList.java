package com.incedo.order.utility;

public enum PriceList {
	
	fruit_juice("fruit_juice" ,20),
	veg_biryani("veg_biryani",200),
	mineral_water("mineral_water",20);
	
	 private String key;
	 private Integer value;
	
	PriceList(String key,Integer value){
		this.key=key;
		this.value=value;
	}

	public String getKey() {
		return key;
	}

	public Integer getValue() {
		
		//PriceList.Fruit_Juice.getValue();
		//PriceList.valueOf(key);
		//PriceList.
		return value;
	}
	
	
	
	
	
	

}
 