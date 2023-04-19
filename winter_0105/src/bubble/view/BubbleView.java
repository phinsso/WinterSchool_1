package bubble.view;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bubble.vo.Pearl;
import bubble.vo.Stone;

public class BubbleView extends JFrame {

	Stone[] stones = new Stone[7];; // 돌 배열
	JLabel[] lblStone = new JLabel[stones.length]; // 돌 갯수만큼 돌 라벨
	Pearl[] pearls = new Pearl[5]; // 펄 배열
	JLabel[] lblPearl = new JLabel[pearls.length]; // 펄 갯수만큼 펄 라벨
	JLabel charLbl = new JLabel(new ImageIcon("bubble_image/character.jpg")); // 캐릭터
	String[] comboCharStr = { "한교동", "폼폼푸린", "마이멜로디", "케로피" };
	JComboBox<String> comboChar = new JComboBox<String>(comboCharStr);
	String[] comboFallStr = { "돌", "타이어", "폭탄", "악마" };
	JComboBox<String> comboFall = new JComboBox<String>(comboFallStr);
	String[] comboPearlStr = { "타피오카 펄", "딸기 펄", "망고 펄" };
	JComboBox<String> comboPearl = new JComboBox<String>(comboPearlStr);
	JLabel Score = new JLabel("점수: 0");
	JLabel level = new JLabel("레벨: 1");
	int total;
	int levelUp = 1;
	

	public BubbleView() {
		setLayout(null); // 레이아웃 null로 설정
		getContentPane().setBackground(Color.WHITE); // 프레임 색상 하양으로 설정
		Random random = new Random();
		StoneThread sThread = null; // 돌 스레드 선언
		PearlThread pThread = null; // 펄 스레드 선언

		comboChar.setBounds(150, 20, 100, 30);
		comboChar.addItemListener(comboL);
		add(comboChar);

		comboFall.setBounds(300, 20, 100, 30);
		comboFall.addItemListener(comboL);
		add(comboFall);

		comboPearl.setBounds(450, 20, 100, 30);
		comboPearl.addItemListener(comboL);
		add(comboPearl);

		for (int i = 0; i < stones.length; i++) {
			stones[i] = new Stone(); // 돌 객체 생성
			stones[i].setX(i * 120);
			stones[i].setY(i * random.nextInt(50));
			stones[i].setW(60);
			stones[i].setH(60);
			stones[i].setImgName("bubble_image/돌.PNG");
			stones[i].setPoint(10); // 점수 설정
			lblStone[i] = new JLabel(new ImageIcon(stones[i].getImgName()));
			lblStone[i].setBounds(stones[i].getX(), stones[i].getY(), stones[i].getW(), stones[i].getH());
			add(lblStone[i]);
			sThread = new StoneThread(lblStone[i], stones[i]);
			sThread.start();
		}

		for (int i = 0; i < pearls.length; i++) {
			pearls[i] = new Pearl();
			pearls[i].setX(i * 50 + random.nextInt(500));
			pearls[i].setY(i * random.nextInt(30));
			pearls[i].setW(60);
			pearls[i].setH(60);
			pearls[i].setImgName("bubble_image/펄.png");
			pearls[i].setPoint(10);
			lblPearl[i] = new JLabel(new ImageIcon(pearls[i].getImgName()));
			lblPearl[i].setBounds(pearls[i].getX(), pearls[i].getY(), pearls[i].getW(), pearls[i].getH());
			add(lblPearl[i]);
			pThread = new PearlThread(lblPearl[i], pearls[i]);
			pThread.start();
		}

		charLbl.setBounds(300, 400, 90, 90);
		add(charLbl);
		addKeyListener(keyL);

		Score.setBounds(600, 500, 50, 50);
		add(Score);

		level.setBounds(100, 500, 50, 50);
		add(level);

		setTitle("버블티 만들기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(10, 10, 700, 600);
		setVisible(true);
		requestFocus();
	}

	ItemListener comboL = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			ImageIcon icon = null;
			String imgName = null;

			if (e.getSource() == comboChar) {
				switch (comboChar.getSelectedIndex()) {
				case 0:
					imgName = "character";
					break;
				case 1:
					imgName = "character2";
					break;
				case 2:
					imgName = "character3";
					break;
				case 3:
					imgName = "character4";
					break;
				}
				icon = new ImageIcon("bubble_image/" + imgName + ".jpg");
				charLbl.setIcon(icon);

			} else if (e.getSource() == comboFall) {
				switch (comboFall.getSelectedIndex()) {
				case 0:
					imgName = "돌.png";
					break;
				case 1:
					imgName = "Fall1.jpg";
					break;
				case 2:
					imgName = "Fall2.jpg";
					break;
				case 3:
					imgName = "Fall3.jpg";
					break;
				}
				icon = new ImageIcon("bubble_image/" + imgName);
				for (int j = 0; j < lblStone.length; j++) {
					lblStone[j].setIcon(icon);
				}
			} else if (e.getSource() == comboPearl) {
				switch (comboPearl.getSelectedIndex()) {
				case 0:
					imgName = "펄";
					break;
				case 1:
					imgName = "펄2";
					break;
				case 2:
					imgName = "펄3";
					break;
				}
				icon = new ImageIcon("bubble_image/" + imgName + ".jpg");
				for (int j = 0; j < lblPearl.length; j++) {
					lblPearl[j].setIcon(icon);
				}

			}
			BubbleView.this.setFocusable(true);
			BubbleView.this.requestFocus();
		}
	};

	KeyAdapter keyL = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (charLbl.getY() >= 0)
					charLbl.setLocation(charLbl.getX(), charLbl.getY() - 10);
				break;
			case KeyEvent.VK_DOWN:
				if (charLbl.getY() + charLbl.getHeight() + 40 <= 600)
					charLbl.setLocation(charLbl.getX(), charLbl.getY() + 10);
				break;
			case KeyEvent.VK_LEFT:
				if (charLbl.getX() >= 0)
					charLbl.setLocation(charLbl.getX() - 10, charLbl.getY());
				break;
			case KeyEvent.VK_RIGHT:
				if (charLbl.getX() + charLbl.getWidth() + 30 <= 700)
					charLbl.setLocation(charLbl.getX() + 10, charLbl.getY());
				break;
			}
		}
	};

	public class StoneThread extends Thread {
		JLabel stoneLbl;
		Stone stone;

		public StoneThread(JLabel stoneLbl, Stone stone) { // 돌 스레드 생성자
			this.stoneLbl = stoneLbl;
			this.stone = stone;
		}

		@Override
		public void run() {
			int i = 0;

			while (true) {
				Random random = new Random();
				if (stoneLbl.getY() <= 600)
					stoneLbl.setLocation(stoneLbl.getX(), stoneLbl.getY() + 10);
				else {
					stoneLbl.setLocation(stoneLbl.getX(), random.nextInt(70));
				}

				try {
					sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// 돌
				if (stoneLbl.getY() + stoneLbl.getHeight() >= charLbl.getY() + 20) {
					if (stoneLbl.getX() + stoneLbl.getWidth() - 30 <= charLbl.getX() + charLbl.getWidth()
							&& stoneLbl.getX() + 30 >= charLbl.getX()) {
						total -= stone.getPoint();
						stoneLbl.setLocation(stoneLbl.getX(), random.nextInt(50));
					}
				}
				Score.setText("점수: " + total);

				if (total / 50 == levelUp) {
					level.setText("레벨: " + ++levelUp);
					System.out.println(levelUp);
				}
				
			}
		}
	}

	public class PearlThread extends Thread {
		JLabel pearlLbl;
		Pearl pearl;

		public PearlThread(JLabel pearlLbl, Pearl pearl) {
			this.pearlLbl = pearlLbl;
			this.pearl = pearl;
		}

		@Override
		public void run() {
			while (true) {
				Random random = new Random();
				if (pearlLbl.getY() <= 600)
					pearlLbl.setLocation(pearlLbl.getX(), pearlLbl.getY() + 15);
				else {
					pearlLbl.setLocation(pearlLbl.getX(), random.nextInt(30));
				}

				try {
					sleep(5 * random.nextInt(120));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// 펄
				if (pearlLbl.getY() + pearlLbl.getHeight() >= charLbl.getY() + 20) {
					if (pearlLbl.getX() + pearlLbl.getWidth() - 30 <= charLbl.getX() + charLbl.getWidth()
							&& pearlLbl.getX() + 30 >= charLbl.getX()) {
						total += pearl.getPoint();
						pearlLbl.setLocation(pearlLbl.getX(), random.nextInt(40));
					}
				}
				Score.setText("점수: " + total);
			}
		}
	}
}
