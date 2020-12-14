package furnitureShop;

public class OrderVO {
	
	private String Order_id;
	private String product_id;
	private String product_name;
	private int product_price;
	private String product_color;
	

	public String getOrder_id() {
		return Order_id;
	}
	
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_color() {
		return product_color;
	}

	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}


	
	
	
}