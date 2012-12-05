package miniProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class NumericalPanel extends JPanel {
	private int percentage = 100;
	private final int MAX = 100;
	
	public NumericalPanel() {
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
		
		add(new JLabel("Add Correct Answer"), "right");
		JTextArea txtAnswer = new JTextArea(1, 8);
		JScrollPane scroll3 = new JScrollPane(txtAnswer);
		scroll3.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll3, "span, growx, wrap");
		
		add(new JLabel("Error Margin"), "right");
		JTextArea txtMargin = new JTextArea(1, 4);
		CreditPanel marginPan = new CreditPanel(txtMargin);
		add(marginPan, "wrap");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		JButton btnNew = new JButton("Add Another Numerical Question");
		add(btnNew);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				txtQuestion.setText("");
			}
		});
	}
	
	private class CreditPanel extends JScrollPane {
		public CreditPanel(final JTextArea jta) {
			super(jta);
			jta.setText(percentage + "%");
			this.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			final JScrollBar verticalBar = this.getVerticalScrollBar();
			verticalBar.setValue(MAX);
			verticalBar.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e){
					//verticalBar
					System.out.println("Clicked");
				}
			});
//			verticalBar.addAdjustmentListener(new AdjustmentListener() {
//				public void adjustmentValueChanged(AdjustmentEvent e) {
//					percentage = MAX - verticalBar.getValue();
//					jta.setText(percentage + "%");
//				}
//			});
		}
	}
}
