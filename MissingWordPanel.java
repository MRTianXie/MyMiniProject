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

public class MissingWordPanel extends JPanel {
	
	private String title = null;
	private PrintWriter output;
	private File myText;
	
	public MissingWordPanel() {
		super(new MigLayout("filly","[][grow]"));
		
		add(new JLabel("Question Title (optional) "), "right");
		final JTextArea txtTitle = new JTextArea(2, 8);
		JScrollPane scroll1 = new JScrollPane(txtTitle);
		scroll1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll1, "span, growx, wrap");
		
		add(new JLabel("First Part of the Sentence"), "right");
		final MyTextArea firstSentence = new MyTextArea("A");
		add(firstSentence, "growx, split, sg 1, span");
		final JCheckBox checkBoxA = new JCheckBox("Delete");
		add(checkBoxA, "sg 2, wrap, right");
		
		add(new JLabel("Correct Answer in Blank Line"), "right");
		final MyTextArea correctAnswer = new MyTextArea("B");
		add(correctAnswer, "growx, split, sg 1, span");
		final JCheckBox checkBoxB = new JCheckBox("Delete");
		add(checkBoxB, "sg 2, wrap, right");
		
		add(new JLabel("Wrong Answer in Blank Line"), "right");
		final MyTextArea wrongAnswer1 = new MyTextArea("C");
		add(wrongAnswer1, "growx, split, sg 1, span");
		final JCheckBox checkBoxC = new JCheckBox("Delete");
		add(checkBoxC, "sg 2, wrap, right");
		
		add(new JLabel("Wrong Answer in Blank Line"), "right");
		final MyTextArea wrongAnswer2 = new MyTextArea("D");
		add(wrongAnswer2, "growx, split, sg 1, span");
		final JCheckBox checkBoxD = new JCheckBox("Delete");
		add(checkBoxD, "sg 2, wrap, right");
		
		add(new JLabel("Wrong Answer in Blank Line"), "right");
		final MyTextArea wrongAnswer3 = new MyTextArea("E");
		add(wrongAnswer3, "growx, split, sg 1, span");
		final JCheckBox checkBoxE = new JCheckBox("Delete");
		add(checkBoxE, "sg 2, wrap, right");
		
		add(new JLabel("Second Part of the Sentence"), "right");
		final MyTextArea secondSentence = new MyTextArea("F");
		add(secondSentence, "growx, split, sg 1, span");
		final JCheckBox checkBoxF = new JCheckBox("Delete");
		add(checkBoxF, "sg 2, wrap, right");
		
		JButton btnDelete = new JButton("Delete Selected");
		add(btnDelete, "skip 2, wrap, right");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		JButton btnNew = new JButton("Add Another Missing Word Question");
		add(btnNew);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(checkBoxA.isSelected() == true){
					firstSentence.setAreaText("");
				}
				
				if(checkBoxB.isSelected() == true){
					correctAnswer.setAreaText("");
				}
				
				if(checkBoxC.isSelected() == true){
					wrongAnswer1.setAreaText("");
				}
				
				if(checkBoxD.isSelected() == true){
					wrongAnswer2.setAreaText("");
				}
				
				if(checkBoxE.isSelected() == true){
					wrongAnswer3.setAreaText("");
				}
				
				if(checkBoxF.isSelected() == true){
					secondSentence.setAreaText("");
				}
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
				String firstStc = firstSentence.getAreaText();
				String correctAns = correctAnswer.getAreaText();
				String wrongAns1 = wrongAnswer1.getAreaText();
				String wrongAns2 = wrongAnswer2.getAreaText();
				String wrongAns3 = wrongAnswer3.getAreaText();
				String secondStc = secondSentence.getAreaText();
				
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
				
				sb.append(firstStc + " {\n");
				sb.append("=" + correctAns);
				if(!(wrongAns1.equals(""))) {
					sb.append("\n~" + wrongAns1);
				}
				if(!(wrongAns2.equals(""))) {
					sb.append("\n~" + wrongAns2);
				}
				if(!(wrongAns3.equals(""))) {
					sb.append("\n~" + wrongAns3);
				}
				sb.append("\n}" + secondStc);
				
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
				txtTitle.setText("");
				title = "";
				firstSentence.setAreaText("");
				correctAnswer.setAreaText("");
				wrongAnswer1.setAreaText("");
				wrongAnswer2.setAreaText("");
				wrongAnswer3.setAreaText("");
				secondSentence.setAreaText("");
				checkBoxA.setSelected(false);
				checkBoxB.setSelected(false);
				checkBoxC.setSelected(false);
				checkBoxD.setSelected(false);
				checkBoxE.setSelected(false);
				checkBoxF.setSelected(false);
			}
		});
	}
	
	private class MyTextArea extends JPanel {
		private JTextArea area;
		
		public MyTextArea(String label) {
			super(new MigLayout("", "[right][grow]"));
			
			add(new JLabel("  " + label + "  "));
			area = new JTextArea(1, 8);
			JScrollPane scroll1 = new JScrollPane(area);
			scroll1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(scroll1, "growx");
		}
		
		public String getAreaText() {
			String str = area.getText();
			return str;
			
		}
		
		public JTextArea getArea() {
			return area;
		}

		public void setAreaText(String str) {
			area.setText(str);
		}
	}
}
