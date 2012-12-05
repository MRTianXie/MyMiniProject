package miniProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class MissingWordPanel extends JPanel {
	public MissingWordPanel() {
		super(new MigLayout("filly","[][grow]"));
		
		add(new JLabel("Question Title (optional) "), "right");
		JTextArea txtTitle = new JTextArea(2, 8);
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
		
		add(new JLabel("Wrong Answer in Blank Line"), "right");
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
