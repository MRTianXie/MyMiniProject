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

public class ShortAnswerPanel extends JPanel {
	
	private String title = null;
	private String question = null;
	private PrintWriter output;
	private File myText;
	
	public ShortAnswerPanel() {
		super(new MigLayout("filly","[][grow][]"));
		
		add(new JLabel("Question Title (optional) "), "right");
		final JTextArea txtTitle = new JTextArea(2, 8);
		JScrollPane scroll1 = new JScrollPane(txtTitle);
		scroll1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll1, "span, growx, wrap");
		
		add(new JLabel("Question "), "right");
		final JTextArea txtQuestion = new JTextArea(4, 8);
		JScrollPane scroll2 = new JScrollPane(txtQuestion);
		scroll2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll2, "span, growx, wrap");
		
		JButton btnClear = new JButton("Cancel/Clear Question Text");
		add(btnClear, "skip 2, wrap, right");
		
		add(new JLabel("Alternative Answer 1"), "right");
		final JTextArea txtAnswer1 = new JTextArea(1, 8);
		txtAnswer1.setText("");
		JScrollPane scroll3 = new JScrollPane(txtAnswer1);
		scroll3.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll3, "span, growx, wrap");
		
		add(new JLabel("Alternative Answer 2"), "right");
		final JTextArea txtAnswer2 = new JTextArea(1, 8);
		txtAnswer2.setText("");
		JScrollPane scroll4 = new JScrollPane(txtAnswer2);
		scroll4.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll4, "span, growx, wrap");
		
		add(new JLabel("Alternative Answer 3"), "right");
		final JTextArea txtAnswer3 = new JTextArea(1, 8);
		txtAnswer3.setText("");
		JScrollPane scroll5 = new JScrollPane(txtAnswer3);
		scroll5.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll5.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll5, "span, growx, wrap");
		
		add(new JLabel("Alternative Answer 4"), "right");
		final JTextArea txtAnswer4 = new JTextArea(1, 8);
		txtAnswer4.setText("");
		JScrollPane scroll6 = new JScrollPane(txtAnswer4);
		scroll6.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll6.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll6, "span, growx, wrap");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		JButton btnNew = new JButton("Add Another Short Answer Question");
		add(btnNew);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				txtQuestion.setText("");
				txtTitle.setText("");
			}
		});
		
		myText = new File("test.txt");
		if(!myText.exists()) {
			try {
				myText.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				StringBuilder sb = new StringBuilder();
				String answer1 = txtAnswer1.getText();
				String answer2 = txtAnswer2.getText();
				String answer3 = txtAnswer3.getText();
				String answer4 = txtAnswer4.getText();
				
				try {
					Scanner input = new Scanner(myText);
					while(input.hasNext()) {
						sb.append(input.nextLine() + "\n");
					}
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				
				title = txtTitle.getText();
				if(!(title.equals(""))) {
					sb.append("\n::" + title + ":: ");
				}else sb.append("\n");
				question = txtQuestion.getText();
				sb.append(question + " {");
				
				if(!(answer1.equals(""))) {
					sb.append("=" + answer1 + " ");
				}
				if(!(answer2.equals(""))) {
					sb.append("=" + answer2 + " ");
				}
				if(!(answer3.equals(""))) {
					sb.append("=" + answer3 + " ");
				}
				if(!(answer4.equals(""))) {
					sb.append("=" + answer4);
				}
				sb.append("}\n");
				
				try {
					output = new PrintWriter(myText);
					output.append(sb.toString());
					output.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				txtQuestion.setText("");
				txtTitle.setText("");
				title = "";
				question = "";
				txtAnswer1.setText("");
				txtAnswer2.setText("");
				txtAnswer3.setText("");
				txtAnswer4.setText("");
			}
		});
	}
}
