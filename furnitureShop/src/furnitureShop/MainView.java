package furnitureShop;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;

public class MainView {

	protected static final String WHAT_THE_CLICKED_ON = null;

	public static void main(String[] args) {

		JFrame f = new JFrame("Furniture Shop");
		f.setLayout(new FlowLayout());
		f.getContentPane().setForeground(Color.WHITE);
		f.getContentPane().setBackground(new Color(204, 153, 153));

		JLabel top = new JLabel("Furniture Shop");
		f.setBounds(120, 120, 300, 200);
		top.setBounds(374, 10, 309, 58);
		top.setFont(new Font("Serif", Font.BOLD, 40));
		top.setText("Furniture Shop");
		f.getContentPane().add(top);

		String[] mem = { "로그인", "관리자" };

		for (int i = 0; i < 2; i++) {
			JPanel panel1 = new JPanel();
			panel1.setBackground(Color.gray);
			FlowLayout flowLayout = (FlowLayout) panel1.getLayout();
			flowLayout.setVgap(2);
			flowLayout.setHgap(2);
			f.getContentPane().add(panel1);
			JButton btn2 = new JButton(mem[i]);
			panel1.add(btn2);

			if (mem[i].equals(mem[1])) {
				btn2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						String adminpw1 = JOptionPane.showInputDialog(f, "관리자 비밀번호를 입력하시오.");
						int adminpw2 = Integer.parseInt(adminpw1);

						if (adminpw2 == 1234) {

							JTextField t1;
							JTextField t2;
							JTextField t3;
							JTextField t4;
							JTextField t6;

							JFrame frame1 = new JFrame();
							frame1.getContentPane().setBackground(new Color(204, 153, 153));
							frame1.setSize(500, 600);
							frame1.getContentPane().setLayout(null);

							JLabel title = new JLabel("상품정보입력");
							title.setFont(new Font("굴림", Font.BOLD, 25));
							title.setBounds(155, 15, 195, 30);
							frame1.getContentPane().add(title);

							JButton b1 = new JButton("상품번호");
							b1.setForeground(new Color(255, 255, 255));
							b1.setBackground(new Color(51, 51, 51));
							b1.setFont(new Font("굴림", Font.BOLD, 20));
							b1.setBounds(17, 88, 125, 29);
							frame1.getContentPane().add(b1);

							JButton b2 = new JButton("상품명");
							b2.setForeground(Color.WHITE);
							b2.setFont(new Font("굴림", Font.BOLD, 20));
							b2.setBackground(new Color(51, 51, 51));
							b2.setBounds(17, 157, 125, 29);
							frame1.getContentPane().add(b2);

							JButton b3 = new JButton("색상");
							b3.setForeground(Color.WHITE);
							b3.setFont(new Font("굴림", Font.BOLD, 20));
							b3.setBackground(new Color(51, 51, 51));
							b3.setBounds(17, 222, 125, 29);
							frame1.getContentPane().add(b3);

							JButton b4 = new JButton("가격");
							b4.setForeground(Color.WHITE);
							b4.setFont(new Font("굴림", Font.BOLD, 20));
							b4.setBackground(new Color(51, 51, 51));
							b4.setBounds(17, 291, 125, 29);
							frame1.getContentPane().add(b4);

							JButton b6 = new JButton("수량");
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

							JButton read = new JButton("검색");
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

							JButton delete = new JButton("삭제");
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

							JButton update = new JButton("수정");
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

							JButton create = new JButton("저장");
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
							frame1.setResizable(false);

							frame1.setVisible(true);
							frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						} else {
							JOptionPane.showMessageDialog(f, "비밀번호를 확인해주세요!");
						}

					}

				});
			}

		}

		String[] menubar = { "소파/거실", "침실", "드레스룸", "행거" };

		for (int i = 0; i < 4; i++) {
			JPanel panel2 = new JPanel();
			panel2.setBackground(Color.gray);
			FlowLayout flowLayout = (FlowLayout) panel2.getLayout();
			flowLayout.setVgap(10);
			flowLayout.setHgap(10);
			f.getContentPane().add(panel2);
			JButton btn3 = new JButton(menubar[i]);
			panel2.add(btn3);

			btn3.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

				}
			});
		}

		for (int i = 1; i < 7; i++) {
			JPanel panel3 = new JPanel();
			panel3.setBackground(Color.lightGray);
			FlowLayout flowLayout = (FlowLayout) panel3.getLayout();
			flowLayout.setVgap(5);
			flowLayout.setHgap(20);
			f.getContentPane().add(panel3);
			JButton btn3 = new JButton();
			ImageIcon icon = new ImageIcon("sofa" + i + ".jpg");
			btn3.setIcon(icon);
			panel3.add(btn3);
			JLabel name = new JLabel("Sofa" + i);
			name.setFont(new Font("Serif", Font.BOLD, 30));
			panel3.add(name);

			if (i == 1) {

				btn3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JTextField t1;
						JTextField t2;
						JTextField t3;

						JFrame frame5 = new JFrame();
						frame5.getContentPane().setBackground(new Color(204, 153, 153));
						frame5.setSize(800, 800);
						frame5.setTitle("상품정보");
						frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						frame5.getContentPane().setLayout(null);

						t1 = new JTextField();
						t1.setBounds(548, 251, 109, 35);
						t1.setFont(new Font("굴림", Font.BOLD, 18));
						t1.setColumns(10);
						frame5.getContentPane().add(t1);

						t2 = new JTextField();
						t2.setBounds(548, 306, 109, 35);
						t2.setFont(new Font("굴림", Font.BOLD, 18));
						t2.setColumns(10);
						frame5.getContentPane().add(t2);

						t3 = new JTextField();
						t3.setBounds(548, 382, 78, 35);
						t3.setFont(new Font("굴림", Font.BOLD, 18));
						t3.setColumns(10);
						frame5.getContentPane().add(t3);

						JButton pay = new JButton("장바구니");
						pay.setFont(new Font("굴림", Font.PLAIN, 25));
						pay.setBounds(537, 600, 160, 35);
						pay.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

							}
						});
						pay.setBackground(new Color(102, 102, 102));
						pay.setForeground(new Color(255, 255, 255));

						JButton btnImg1 = new JButton();
						ImageIcon img = new ImageIcon("sofa1.jpg");
						btnImg1.setIcon(img);
						frame5.getContentPane().add(btnImg1);
						btnImg1.setBounds(62, 251, 230, 230);

						JLabel lblNewLabel_2 = new JLabel("상품명");
						lblNewLabel_2.setBounds(370, 251, 75, 35);
						lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_3 = new JLabel("상품색상");
						lblNewLabel_3.setBounds(370, 301, 120, 34);
						lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_4 = new JLabel("배송비");
						lblNewLabel_4.setBounds(370, 339, 78, 35);
						lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_6 = new JLabel("가격");
						lblNewLabel_6.setBounds(370, 384, 80, 31);
						lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel label = new JLabel("무료배송");
						label.setBounds(548, 349, 76, 25);

						JLabel title = new JLabel("Furniture Shop");
						title.setBounds(235, 64, 300, 56);
						title.setFont(new Font("Serif", Font.BOLD, 40));

						JLabel p_id = new JLabel("s100");
						p_id.setBounds(67, 221, 78, 21);
						p_id.setFont(new Font("굴림", Font.BOLD, 20));
						frame5.getContentPane().add(p_id);

						JLabel lblNewLabel_1 = new JLabel("만원");
						lblNewLabel_1.setBounds(636, 389, 78, 21);

						JButton read = new JButton("상품정보 보기");
						read.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								String product_id = p_id.getText();
								OrderDAO dao = new OrderDAO();
								try {
									OrderVO bag = dao.read(product_id);
									p_id.setText(bag.getProduct_id());
									t1.setText(bag.getProduct_name());
									t2.setText(bag.getProduct_color());
									t3.setText(String.valueOf(bag.getProduct_price()));

								} catch (Exception e1) {
								}
							}
						});
						read.setForeground(Color.BLACK);
						read.setFont(new Font("굴림", Font.BOLD, 18));
						read.setBackground(new Color(102, 102, 102));
						read.setBounds(70, 500, 180, 40);
						frame5.getContentPane().add(read);
						frame5.getContentPane().setLayout(null);
						frame5.getContentPane().add(btnImg1);
						frame5.getContentPane().add(lblNewLabel_4);
						frame5.getContentPane().add(lblNewLabel_6);
						frame5.getContentPane().add(lblNewLabel_2);
						frame5.getContentPane().add(label);
						frame5.getContentPane().add(lblNewLabel_3);
						frame5.getContentPane().add(pay);
						frame5.getContentPane().add(title);
						frame5.getContentPane().add(lblNewLabel_1);
						frame5.setResizable(false);

						frame5.setVisible(true);

					}

				});
			} else if (i == 2) {

				btn3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JTextField t1;
						JTextField t2;
						JTextField t3;

						JFrame frame5 = new JFrame();
						frame5.getContentPane().setBackground(new Color(204, 153, 153));
						frame5.setSize(800, 800);
						frame5.setTitle("상품정보");
						frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						frame5.getContentPane().setLayout(null);

						t1 = new JTextField();
						t1.setBounds(548, 251, 109, 35);
						t1.setFont(new Font("굴림", Font.BOLD, 18));
						t1.setColumns(10);
						frame5.getContentPane().add(t1);

						t2 = new JTextField();
						t2.setBounds(548, 306, 109, 35);
						t2.setFont(new Font("굴림", Font.BOLD, 18));
						t2.setColumns(10);
						frame5.getContentPane().add(t2);

						t3 = new JTextField();
						t3.setBounds(548, 382, 78, 35);
						t3.setFont(new Font("굴림", Font.BOLD, 18));
						t3.setColumns(10);
						frame5.getContentPane().add(t3);

						JButton pay = new JButton("장바구니");
						pay.setFont(new Font("굴림", Font.PLAIN, 25));
						pay.setBounds(537, 600, 160, 35);
						pay.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

							}
						});
						pay.setBackground(new Color(102, 102, 102));
						pay.setForeground(new Color(255, 255, 255));

						JButton btnImg1 = new JButton();
						ImageIcon img = new ImageIcon("sofa2.jpg");
						btnImg1.setIcon(img);
						frame5.getContentPane().add(btnImg1);
						btnImg1.setBounds(62, 251, 230, 230);

						JLabel lblNewLabel_2 = new JLabel("상품명");
						lblNewLabel_2.setBounds(370, 251, 75, 35);
						lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_3 = new JLabel("상품색상");
						lblNewLabel_3.setBounds(370, 301, 120, 34);
						lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_4 = new JLabel("배송비");
						lblNewLabel_4.setBounds(370, 339, 78, 35);
						lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_6 = new JLabel("가격");
						lblNewLabel_6.setBounds(370, 384, 80, 31);
						lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel label = new JLabel("무료배송");
						label.setBounds(548, 349, 76, 25);

						JLabel title = new JLabel("Furniture Shop");
						title.setBounds(235, 64, 300, 56);
						title.setFont(new Font("Serif", Font.BOLD, 40));

						JLabel p_id = new JLabel("s101");
						p_id.setBounds(67, 221, 78, 21);
						p_id.setFont(new Font("굴림", Font.BOLD, 20));
						frame5.getContentPane().add(p_id);

						JLabel lblNewLabel_1 = new JLabel("만원");
						lblNewLabel_1.setBounds(636, 389, 78, 21);

						JButton read = new JButton("상품정보 보기");
						read.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								String product_id = p_id.getText();
								OrderDAO dao = new OrderDAO();
								try {
									OrderVO bag = dao.read(product_id);
									p_id.setText(bag.getProduct_id());
									t1.setText(bag.getProduct_name());
									t2.setText(bag.getProduct_color());
									t3.setText(String.valueOf(bag.getProduct_price()));

								} catch (Exception e1) {
								}
							}
						});
						read.setForeground(Color.BLACK);
						read.setFont(new Font("굴림", Font.BOLD, 18));
						read.setBackground(new Color(102, 102, 102));
						read.setBounds(70, 500, 180, 40);
						frame5.getContentPane().add(read);
						frame5.getContentPane().setLayout(null);
						frame5.getContentPane().add(btnImg1);
						frame5.getContentPane().add(lblNewLabel_4);
						frame5.getContentPane().add(lblNewLabel_6);
						frame5.getContentPane().add(lblNewLabel_2);
						frame5.getContentPane().add(label);
						frame5.getContentPane().add(lblNewLabel_3);
						frame5.getContentPane().add(pay);
						frame5.getContentPane().add(title);
						frame5.getContentPane().add(lblNewLabel_1);
						frame5.setResizable(false);
						
						frame5.setVisible(true);

					}
				});

			} else if (i == 3) {
				btn3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JTextField t1;
						JTextField t2;
						JTextField t3;

						JFrame frame5 = new JFrame();
						frame5.getContentPane().setBackground(new Color(204, 153, 153));
						frame5.setSize(800, 800);
						frame5.setTitle("상품정보");
						frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						frame5.getContentPane().setLayout(null);

						t1 = new JTextField();
						t1.setBounds(548, 251, 109, 35);
						t1.setFont(new Font("굴림", Font.BOLD, 18));
						t1.setColumns(10);
						frame5.getContentPane().add(t1);

						t2 = new JTextField();
						t2.setBounds(548, 306, 109, 35);
						t2.setFont(new Font("굴림", Font.BOLD, 18));
						t2.setColumns(10);
						frame5.getContentPane().add(t2);

						t3 = new JTextField();
						t3.setBounds(548, 382, 78, 35);
						t3.setFont(new Font("굴림", Font.BOLD, 18));
						t3.setColumns(10);
						frame5.getContentPane().add(t3);

						JButton pay = new JButton("장바구니");
						pay.setFont(new Font("굴림", Font.PLAIN, 25));
						pay.setBounds(537, 600, 160, 35);
						pay.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

							}
						});
						pay.setBackground(new Color(102, 102, 102));
						pay.setForeground(new Color(255, 255, 255));

						JButton btnImg1 = new JButton();
						ImageIcon img = new ImageIcon("sofa3.jpg");
						btnImg1.setIcon(img);
						frame5.getContentPane().add(btnImg1);
						btnImg1.setBounds(62, 251, 230, 230);

						JLabel lblNewLabel_2 = new JLabel("상품명");
						lblNewLabel_2.setBounds(370, 251, 75, 35);
						lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_3 = new JLabel("상품색상");
						lblNewLabel_3.setBounds(370, 301, 120, 34);
						lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_4 = new JLabel("배송비");
						lblNewLabel_4.setBounds(370, 339, 78, 35);
						lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel lblNewLabel_6 = new JLabel("가격");
						lblNewLabel_6.setBounds(370, 384, 80, 31);
						lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 20));

						JLabel label = new JLabel("무료배송");
						label.setBounds(548, 349, 76, 25);

						JLabel title = new JLabel("Furniture Shop");
						title.setBounds(235, 64, 300, 56);
						title.setFont(new Font("Serif", Font.BOLD, 40));

						JLabel p_id = new JLabel("s102");
						p_id.setBounds(67, 221, 78, 21);
						p_id.setFont(new Font("굴림", Font.BOLD, 20));
						frame5.getContentPane().add(p_id);

						JLabel lblNewLabel_1 = new JLabel("만원");
						lblNewLabel_1.setBounds(636, 389, 78, 21);

						JButton read = new JButton("상품정보 보기");
						read.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								String product_id = p_id.getText();
								OrderDAO dao = new OrderDAO();
								try {
									OrderVO bag = dao.read(product_id);
									p_id.setText(bag.getProduct_id());
									t1.setText(bag.getProduct_name());
									t2.setText(bag.getProduct_color());
									t3.setText(String.valueOf(bag.getProduct_price()));

								} catch (Exception e1) {
								}
							}
						});
						read.setForeground(Color.BLACK);
						read.setFont(new Font("굴림", Font.BOLD, 18));
						read.setBackground(new Color(102, 102, 102));
						read.setBounds(70, 500, 180, 40);
						frame5.getContentPane().add(read);
						frame5.getContentPane().setLayout(null);
						frame5.getContentPane().add(btnImg1);
						frame5.getContentPane().add(lblNewLabel_4);
						frame5.getContentPane().add(lblNewLabel_6);
						frame5.getContentPane().add(lblNewLabel_2);
						frame5.getContentPane().add(label);
						frame5.getContentPane().add(lblNewLabel_3);
						frame5.getContentPane().add(pay);
						frame5.getContentPane().add(title);
						frame5.getContentPane().add(lblNewLabel_1);
						frame5.setResizable(false);
						
						frame5.setVisible(true);

					}
				});

			}
		}

		f.setResizable(false);
		f.setSize(900, 900);
		f.setVisible(true);

	}

}
