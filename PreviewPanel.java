package miniProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PreviewPanel extends JPanel {
	
	private PrintWriter output;
	private File myText;
	
	public PreviewPanel() {
		super(new MigLayout("filly","[grow]"));
		
		JButton btnView = new JButton("View/Refresh");
		add(btnView, "wrap");
		
		add(new JLabel("Questions View"), "wrap");
		final JTextArea txtQuestions = new JTextArea(14, 8);
		JScrollPane scroll = new JScrollPane(txtQuestions);
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll, "growx, wrap");
		
		JButton btnClear = new JButton("Clear Text");
		add(btnClear, "wrap");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave);
		
		myText = new File("test.txt");
		if(!myText.exists()) {
			try {
				myText.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				txtQuestions.setText("");
			}
		});
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				StringBuilder sb = new StringBuilder();
				
				try {
					Scanner input = new Scanner(myText);
					while(input.hasNext()) {
						sb.append(input.nextLine() + "\n");
					}
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				
				txtQuestions.setText(sb.toString());
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String text = txtQuestions.getText();
				
				try {
					output = new PrintWriter(myText);
					output.append(text);
					output.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
