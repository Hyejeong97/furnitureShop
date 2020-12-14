package furnitureShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class OrderDAO {


	public OrderVO read(String product_id) throws Exception {//검색

		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector success!!");

		// 2. db연결
		String url = "jdbc:mysql://localhost:3306/furniture_shop";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db connection success!!");

		// 3. sql생성
		String sql = "select * from product where product_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, product_id);

		// 4. sql전송
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL creation success!!");
		
		OrderVO bag = new OrderVO();
		
		if (rs.next()) { 
			System.out.println("검색결과가 있어요.");
			
			String p_id = rs.getString("product_id");
			String p_name = rs.getString("product_name");
			String p_color = rs.getString("product_color");
			int p_price = rs.getInt("product_price");

			
			bag.setProduct_id(p_id);
			bag.setProduct_name(p_name);
			bag.setProduct_color(p_color);
			bag.setProduct_price(p_price);

			
		} else {
			System.out.println("검색결과가 없어요.");
		}
		return bag;
		
	}
	
	
	public void pay(OrderVO vo) throws Exception {// 저장
		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공!");

		// 2.db연결
		String url = "jdbc:mysql://localhost:3306/furniture_shop";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공!");

		// 3.sql생성
		String sql = "insert into shop_order values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vo.getOrder_id());
		ps.setString(2, vo.getProduct_id());
		ps.setString(3, vo.getProduct_name());
		ps.setString(4, vo.getProduct_color());
		ps.setInt(5, vo.getProduct_price());
		System.out.println("3. SQL생성 성공!");

		// 4. sql전송
		ps.executeUpdate();	
		System.out.println("4. SQL전송 성공!");
		
		

	}
	

}
