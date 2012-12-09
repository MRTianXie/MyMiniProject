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

public class MatchingPanel extends JPanel {
	
	private String title = null;
	private String question = null;
	private PrintWriter output;
	private File myText;
	
	public MatchingPanel() {
		super(new MigLayout("filly","[][grow][grow]"));
		
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
		
		JButton btnAddAQ = new JButton("Add A&Q");
		add(btnAddAQ);
		
		final MyTextArea areaQA = new MyTextArea("A");
		areaQA.setAreaText("");
		add(areaQA, "growx, sg 1");
		final MyTextArea areaAA = new MyTextArea("A");
		add(areaAA, "growx, split, sg 1");
		final JCheckBox checkBoxA = new JCheckBox("Delete");
		add(checkBoxA, "sg 2, wrap");
		
		final MyTextArea areaQB = new MyTextArea("B");
		areaQB.setAreaText("");
		add(areaQB, "skip, growx, sg 1");
		final MyTextArea areaAB = new MyTextArea("B");
		add(areaAB, "growx, split, sg 1");
		final JCheckBox checkBoxB = new JCheckBox("Delete");
		add(checkBoxB, "sg 2, wrap");
		
		final MyTextArea areaQC = new MyTextArea("C");
		areaQC.setAreaText("");
		add(areaQC, "skip, growx, sg 1");
		final MyTextArea areaAC = new MyTextArea("C");
		add(areaAC, "growx, split, sg 1");
		final JCheckBox checkBoxC = new JCheckBox("Delete");
		add(checkBoxC, "sg 2, wrap");
		
		JButton btnDelete = new JButton("Delete Selected");
		add(btnDelete, "skip 2, wrap, right");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		add(new JLabel("\n\n\n\n\n\n\n"), "wrap");
		
		JButton btnNew = new JButton("Add Another Matching Question");
		add(btnNew);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(checkBoxA.isSelected() == true){
					areaQA.setAreaText("");
					areaAA.setAreaText("");
				}
				
				if(checkBoxB.isSelected() == true){
					areaQB.setAreaText("");
					areaAB.setAreaText("");
				}
				
				if(checkBoxC.isSelected() == true){
					areaQC.setAreaText("");
					areaAC.setAreaText("");
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
				sb.append(question + " ");
				
				sb.append("{\n");
				String lineQA = areaQA.getAreaText();
				String lineAA = areaAA.getAreaText();
				if((!(lineQA.equals(""))) && (!(lineAA.equals("")))) {
					sb.append("=" + lineQA + " -> ");
					sb.append(lineAA + "\n");
				}
				String lineQB = areaQB.getAreaText();
				String lineAB = areaAB.getAreaText();
				if((!(lineQB.equals(""))) && (!(lineAB.equals("")))) {
					sb.append("=" + lineQB + " -> ");
					sb.append(lineAB + "\n");
				}
				String lineQC = areaQC.getAreaText();
				String lineAC = areaAA.getAreaText();
				if((!(lineQC.equals(""))) && (!(lineAC.equals("")))) {
					sb.append("=" + lineQC + " -> ");
					sb.append(lineAC + "\n");
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
				areaQA.setAreaText("");
				areaAA.setAreaText("");
				areaQB.setAreaText("");
				areaAB.setAreaText("");
				areaQC.setAreaText("");
				areaAC.setAreaText("");
				checkBoxA.setSelected(false);
				checkBoxB.setSelected(false);
				checkBoxC.setSelected(false);
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

		public void setAreaText(String str) {
			area.setText(str);
		}
	}
}
