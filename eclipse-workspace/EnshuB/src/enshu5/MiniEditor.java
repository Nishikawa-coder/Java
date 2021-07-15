//B9TB2174
//西川凜
package enshu5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileWriter;
import java.io.PrintWriter;

public class MiniEditor {
	private JTextArea ta = null;
	private JTextField FileField = null;
	private BufferedReader br = null;
	private String fname = null;
	private PrintWriter pw = null;

	public MiniEditor() {
		JFrame jf = new JFrame("MiniEditor");

		// ファイル読み込み用 JPanel
		JPanel FileBar = new JPanel();
		// 本文用テキストエリア
		ta = new JTextArea("本文用テキストエリア");
		jf.setLayout(new BorderLayout());
		jf.add(FileBar, BorderLayout.NORTH);
		jf.add(new JScrollPane(ta), BorderLayout.CENTER);

		// File:の部分
		JLabel FileName = new JLabel("File:");
		// ファイル名入力用テキストフィールド
		FileField = new JTextField("ファイル名を入れてください");
		// ボタン
		JPanel jb = new JPanel();
		FileBar.setLayout(new BorderLayout());
		FileBar.add(FileName, BorderLayout.WEST);
		FileBar.add(FileField, BorderLayout.CENTER);
		FileBar.add(jb, BorderLayout.EAST);
		
		//loadボタン
		JButton load = new JButton("Load");
		//Saveボタン
		JButton save = new JButton("Save");
		jb.add(load, BorderLayout.WEST);
		jb.add(save, BorderLayout.EAST);

		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				fname = FileField.getText();
				try {
					br = new BufferedReader(new FileReader(fname));
					String line;
					while ((line = br.readLine()) != null) {
						ta.append(line + "\n");
					}
					br.close();
				} catch (FileNotFoundException e1) {
					ta.append(fname + "が見つかりませんでした。");
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fname = FileField.getText();
				try {
					pw = new PrintWriter(new FileWriter(fname));
					pw.println(ta.getText());
					
					pw.close();
					} catch (IOException e1) {
					      e1.printStackTrace();
					    }
			}
		});

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(320, 240);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new MiniEditor();
	}
}
