package miniProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class MatchingPanel extends JPanel {
	
	public MatchingPanel() {
		super(new MigLayout("filly","[][grow][grow]"));
		
		add(new JLabel("Question Title (optional) "), "right");
		JTextArea txtTitle = new JTextArea(2, 8);
		JScrollPane scroll1 = new JScrollPane(txtTitle);
		scroll1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll1, "span, growx, wrap");
		
		JButton btnAddAQ = new JButton("Add A&Q");
		add(btnAddAQ);
		
		final MyTextArea areaQA = new MyTextArea("A");
		add(areaQA, "growx, sg 1");
		final MyTextArea areaAA = new MyTextArea("A");
		add(areaAA, "growx, split, sg 1");
		final JCheckBox checkBoxA = new JCheckBox("Delete");
		add(checkBoxA, "sg 2, wrap");
		
		final MyTextArea areaQB = new MyTextArea("B");
		add(areaQB, "skip, growx, sg 1");
		final MyTextArea areaAB = new MyTextArea("B");
		add(areaAB, "growx, split, sg 1");
		final JCheckBox checkBoxB = new JCheckBox("Delete");
		add(checkBoxB, "sg 2, wrap");
		
		final MyTextArea areaQC = new MyTextArea("C");
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
