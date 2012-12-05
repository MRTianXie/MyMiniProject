package miniProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class MultipleChoicePanel extends JPanel {

	public MultipleChoicePanel() {
		super(new MigLayout("filly","[][grow][]"));
		
		add(new JLabel("Question Title (optional) "), "right");
		JTextArea txtTitle = new JTextArea(2, 8);
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
		
		JButton btnAddAnswer = new JButton("Add Answer");
		add(btnAddAnswer);
		
		JTextField option1 = new JTextField();
		add(option1, "growx, span, split");
		JTextArea jtaCredit1 = new JTextArea(1,4);
		CreditPanel scrollCredit1 = new CreditPanel(jtaCredit1);
		add(scrollCredit1, "wrap, right");
		
		JTextField option2 = new JTextField();
		add(option2, "skip, growx, span, split");
		JTextArea jtaCredit2 = new JTextArea(1,4);
		CreditPanel scrollCredit2 = new CreditPanel(jtaCredit2);
		add(scrollCredit2, "wrap, right");
		
		JTextField option3 = new JTextField();
		add(option3, "skip, growx, span, split");
		JTextArea jtaCredit3 = new JTextArea(1,4);
		CreditPanel scrollCredit3 = new CreditPanel(jtaCredit3);
		add(scrollCredit3, "wrap, right");
		
		JTextField option4 = new JTextField();
		add(option4, "skip, growx, span, split");
		JTextArea jtaCredit4 = new JTextArea(1,4);
		CreditPanel scrollCredit4 = new CreditPanel(jtaCredit4);
		add(scrollCredit4, "wrap, right");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		JButton btnNew = new JButton("Add Another Multiple Choice Question");
		add(btnNew);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				txtQuestion.setText("");
			}
		});
	}
	
	private class CreditPanel extends JScrollPane {
		public CreditPanel(JTextArea jta) {
			super(jta);
			jta.setText("0%");
			this.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			final JScrollBar verticalBar = this.getVerticalScrollBar();
			
			verticalBar.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e){
//					float y = verticalBar.getAlignmentY();
//					System.out.println("Clicked " + y);
				}
			});
//			verticalBar.addAdjustmentListener(new AdjustmentListener() {
//				public void adjustmentValueChanged(AdjustmentEvent e) {
//					int value = verticalBar.getValue();
//					System.out.println(value);
//				}
//			});
		}
	}
}
