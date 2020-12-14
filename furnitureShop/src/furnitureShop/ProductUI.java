package furnitureShop;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductUI  {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static JTextField t6;

	
	public static void main(String[] args) throws Exception {
		JFrame frame1 = new JFrame();
		frame1.getContentPane().setBackground(new Color(204, 153, 153));
		frame1.setSize(500, 600);
		frame1.getContentPane().setLayout(null);

		JLabel title = new JLabel("상품 정보 입력");// 상품정보입력
		title.setFont(new Font("굴림", Font.BOLD, 25));
		title.setBounds(155, 15, 195, 30);
		frame1.getContentPane().add(title);

		JButton b1 = new JButton("상품번호");// 상품번호
		b1.setForeground(new Color(255, 255, 255));
		b1.setBackground(new Color(51, 51, 51));
		b1.setFont(new Font("굴림", Font.BOLD, 20));
		b1.setBounds(17, 88, 125, 29);
		frame1.getContentPane().add(b1);

		JButton b2 = new JButton("상품명");// 상품명
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("굴림", Font.BOLD, 20));
		b2.setBackground(new Color(51, 51, 51));
		b2.setBounds(17, 157, 125, 29);
		frame1.getContentPane().add(b2);

		JButton b3 = new JButton("색상");// 색상
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("굴림", Font.BOLD, 20));
		b3.setBackground(new Color(51, 51, 51));
		b3.setBounds(17, 222, 125, 29);
		frame1.getContentPane().add(b3);

		JButton b4 = new JButton("가격");// 가격
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("굴림", Font.BOLD, 20));
		b4.setBackground(new Color(51, 51, 51));
		b4.setBounds(17, 291, 125, 29);
		frame1.getContentPane().add(b4);

		JButton b6 = new JButton("수량");// 수량
		b6.setForeground(Color.WHITE);
		b6.setFont(new Font("굴림", Font.BOLD, 20));
		b6.setBackground(new Color(51, 51, 51));
		b6.setBounds(17, 362, 125, 29);
		frame1.getContentPane().add(b6);

		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.PLAIN, 20));
		t1.setBounds(188, 89, 259, 27);
		frame1.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("굴림", Font.PLAIN, 20));
		t2.setColumns(10);
		t2.setBounds(188, 158, 259, 27);
		frame1.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setFont(new Font("굴림", Font.PLAIN, 20));
		t3.setColumns(10);
		t3.setBounds(188, 223, 259, 27);
		frame1.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("굴림", Font.PLAIN, 20));
		t4.setColumns(10);
		t4.setBounds(188, 292, 259, 27);
		frame1.getContentPane().add(t4);

		t6 = new JTextField();
		t6.setFont(new Font("굴림", Font.PLAIN, 20));
		t6.setColumns(10);
		t6.setBounds(188, 362, 259, 27);
		frame1.getContentPane().add(t6);

		JButton read = new JButton("검색");// 검색
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String product_id = t1.getText();
				ProductDAO dao = new ProductDAO();
				try {
					ProductVO bag = dao.read(product_id);
					t2.setText(bag.getProduct_name());
					t3.setText(bag.getProduct_color());
					t4.setText(String.valueOf(bag.getProduct_price()));
					t6.setText(String.valueOf(bag.getProduct_amount()));
				} catch (Exception e1) {
				}
			}
		});
		read.setForeground(Color.BLACK);
		read.setFont(new Font("굴림", Font.BOLD, 24));
		read.setBackground(new Color(102, 102, 102));
		read.setBounds(17, 448, 102, 47);
		frame1.getContentPane().add(read);

		JButton delete = new JButton("삭제");// 삭제
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String product_id = t1.getText();
				String product_name = t2.getText();
				String product_color = t3.getText();
				int product_price = Integer.parseInt(t4.getText());
				int product_amount = Integer.parseInt(t6.getText());

				ProductDAO dao = new ProductDAO();
				ProductVO bag = new ProductVO();

				bag.setProduct_id(product_id);
				bag.setProduct_name(product_name);
				bag.setProduct_color(product_color);
				bag.setProduct_price(product_price);
				bag.setProduct_amount(product_amount);

				try {
					dao.delete(bag);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		delete.setForeground(Color.BLACK);
		delete.setFont(new Font("굴림", Font.BOLD, 24));
		delete.setBackground(new Color(102, 102, 102));
		delete.setBounds(131, 448, 102, 47);
		frame1.getContentPane().add(delete);

		JButton update = new JButton("수정");// 수정
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String product_id = t1.getText();
				String product_name = t2.getText();
				String product_color = t3.getText();
				int product_price = Integer.parseInt(t4.getText());
				int product_amount = Integer.parseInt(t6.getText());

				ProductDAO dao = new ProductDAO();
				ProductVO bag = new ProductVO();

				bag.setProduct_id(product_id);
				bag.setProduct_name(product_name);
				bag.setProduct_color(product_color);
				bag.setProduct_price(product_price);
				bag.setProduct_amount(product_amount);

				try {
					dao.update(bag);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		update.setForeground(Color.BLACK);
		update.setFont(new Font("굴림", Font.BOLD, 24));
		update.setBackground(new Color(102, 102, 102));
		update.setBounds(248, 448, 102, 47);
		frame1.getContentPane().add(update);

		JButton create = new JButton("저장");// 저장
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String product_id = t1.getText();
				String product_name = t2.getText();
				String product_color = t3.getText();
				int product_price = Integer.parseInt(t4.getText());
				int product_amount = Integer.parseInt(t6.getText());

				ProductDAO dao = new ProductDAO();
				ProductVO bag = new ProductVO();

				bag.setProduct_id(product_id);
				bag.setProduct_name(product_name);
				bag.setProduct_color(product_color);
				bag.setProduct_price(product_price);
				bag.setProduct_amount(product_amount);

				try {
					dao.create(bag);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		create.setForeground(Color.BLACK);
		create.setFont(new Font("굴림", Font.BOLD, 24));
		create.setBackground(new Color(102, 102, 102));
		create.setBounds(362, 448, 102, 47);
		frame1.getContentPane().add(create);

		frame1.setVisible(true);
	}
}
