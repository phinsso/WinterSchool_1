package gui.notepad;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class SimpleNotepad extends JFrame implements ActionListener {
	JMenuItem itemNew, itemOpen, itemSave, itemExit, itemSize, itemShape, itemRed, itemBlue, itemBlack, item10, item15,
			item20, itemFont1, itemFont2, itemFont3;
	JTextArea area = new JTextArea();
	JButton btnNew, btnOpen, btnSave;
	Object pick;

	public SimpleNotepad() {
		super("Simple Notepad");
		makeToolbar();
		makeMenu();
		add(area);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		setVisible(true);
	}

	public void makeToolbar() {
		JToolBar toolBar = new JToolBar();
		btnNew = new JButton(new ImageIcon("memo_image/new.png"));
		btnOpen = new JButton(new ImageIcon("memo_image/open.png"));
		btnSave = new JButton(new ImageIcon("memo_image/save.png"));
		btnNew.addActionListener(btnL);
		btnOpen.addActionListener(btnL);
		btnSave.addActionListener(btnL);
		toolBar.add(btnNew);
		toolBar.add(btnOpen);
		toolBar.add(btnSave);
		add(toolBar, "North");
	}

	ActionListener btnL = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object eBtn = e.getSource();
			if (eBtn == btnNew) {
				area.setText("");
			} else if (eBtn == btnOpen) {
				readFile();
			} else if (eBtn == btnSave) {
				writeFile();
			}

		}
	};

	public void makeMenu() {
		JMenuBar menuBar = new JMenuBar(); // 메뉴표시줄
		JMenu menuFile = new JMenu("File"); // 상위메뉴
		JMenu menuFormat = new JMenu("Format");
		JMenu menuColor = new JMenu("Font Color");
		JMenu menuSize = new JMenu("Font Size");
		JMenu menuShape = new JMenu("Font Shape");

		// JMenuItem: 상위메뉴 또는 하위메뉴를 클릭했을 때 선택할 수 있는 항목
		itemNew = new JMenuItem("New");
		itemOpen = new JMenuItem("Open");
		itemSave = new JMenuItem("Save");
		itemExit = new JMenuItem("Exit");
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);

		item10 = new JMenuItem("10px");
		item15 = new JMenuItem("15px");
		item20 = new JMenuItem("20px");
		item10.addActionListener(this);
		item15.addActionListener(this);
		item20.addActionListener(this);

		itemFont1 = new JMenuItem("궁서체");
		itemFont2 = new JMenuItem("맑은고딕");
		itemFont3 = new JMenuItem("신명조");
		itemFont1.addActionListener(this);
		itemFont2.addActionListener(this);
		itemFont3.addActionListener(this);

		itemRed = new JMenuItem("Red");
		itemBlue = new JMenuItem("Blue");
		itemBlack = new JMenuItem("Black");
		itemRed.addActionListener(this);
		itemBlue.addActionListener(this);
		itemBlack.addActionListener(this);

		// File 상위메뉴에 항목들을 추가
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemExit);
		menuSize.add(item10);
		menuSize.add(item15);
		menuSize.add(item20);
		menuColor.add(itemRed);
		menuColor.add(itemBlue);
		menuColor.add(itemBlack);
		menuShape.add(itemFont1);
		menuShape.add(itemFont2);
		menuShape.add(itemFont3);

		menuFormat.add(menuSize);
		menuFormat.add(menuShape);
		menuFormat.add(menuColor);
		menuFormat.add(menuShape);

		// 메뉴바에 파일 상위메뉴 추가
		menuBar.add(menuFile);
		menuBar.add(menuFormat);
		// 프레임에 메뉴바 설정
		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem eItem = (JMenuItem) e.getSource(); // Object형으로 형변환 없이도 가능함
		pick = e.getSource();

		if (eItem == itemNew) {
			area.setText("");
		} else if (eItem == itemOpen) {
			readFile();
		} else if (eItem == itemSave) {
			writeFile();
		} else if (eItem == itemExit) {
			System.exit(0);
		} else if (eItem == itemFont1 || eItem == itemFont2 || eItem == itemFont3) {
			setFontShape();
		} else if (eItem == item10 || eItem == item15 || eItem == item20) {
			setFontSize();
		} else if (eItem == itemRed) {
			area.setForeground(Color.RED);
		} else if (eItem == itemBlue) {
			area.setForeground(Color.BLUE);
		} else if (eItem == itemBlack) {
			area.setForeground(Color.BLACK);
		}

	}

	public void readFile() {
		FileDialog fileDlg = null;
		fileDlg = new FileDialog(this, "File Open", FileDialog.LOAD);
		fileDlg.setVisible(true);
		System.out.println(fileDlg.getDirectory());
		System.out.println(fileDlg.getFile());
		FileReader fReader = null;
		BufferedReader bufReader = null;

		try {
			fReader = new FileReader(new File(fileDlg.getDirectory() + "/" + fileDlg.getFile()));
			bufReader = new BufferedReader(fReader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				area.append(line + "\n"); // 기존에 있던 문자에 이어서 추가되는 (setText랑 비슷)
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeFile() {
		FileDialog fileDlg = null;
		fileDlg = new FileDialog(this, "File Save", FileDialog.SAVE);
		fileDlg.setVisible(true);
		System.out.println(fileDlg.getDirectory());
		System.out.println(fileDlg.getFile());
		FileWriter fWriter = null;
		BufferedWriter bufWriter = null;

		try {
			fWriter = new FileWriter(new File(fileDlg.getDirectory() + "/" + fileDlg.getFile()));
			bufWriter = new BufferedWriter(fWriter);
			bufWriter.write(area.getText());
			bufWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setFontSize() {
		if (pick == item10)
			area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 10)); // getFamily(): 폰트 객체의 글꼴 반환해주는 거 (유지를 위해)
		else if (pick == item15)											
			area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 15));
		else if (pick == item20)
			area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 20));
	}

	public void setFontShape() {
		if (pick == itemFont1)
			area.setFont(new Font("궁서체", Font.PLAIN, area.getFont().getSize()));
		else if (pick == itemFont2)
			area.setFont(new Font("맑은 고딕", Font.PLAIN, area.getFont().getSize()));
		else if (pick == itemFont3)
			area.setFont(new Font("신명조", Font.PLAIN, area.getFont().getSize()));
	}

	public static void main(String[] args) {
		new SimpleNotepad();
	}

}
