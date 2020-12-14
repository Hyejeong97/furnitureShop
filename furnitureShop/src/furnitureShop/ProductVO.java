package furnitureShop;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class ProductVO implements Icon {

	String product_id;
	String product_name;
	String product_color;
	int product_price;
	int product_amount;
	String column;
	
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
	
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
