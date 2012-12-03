package miniProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

public class TrueFalsePanel extends JPanel{
	
	public TrueFalsePanel() {
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
		
		JPanel answerPan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton btnTrue = new JRadioButton("True");
		JRadioButton btnFalse = new JRadioButton("False");
		ButtonGroup group = new ButtonGroup();
		group.add(btnTrue);
		group.add(btnFalse);
		answerPan.add(btnTrue);
		answerPan.add(btnFalse);
		answerPan.setBorder(new TitledBorder("Correct Answer"));
		add(answerPan, "skip");
		
		JButton btnClear = new JButton("Cancel/Clear Question Text");
		add(btnClear, "wrap");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		add(new JLabel("\n\n\n\n\n\n\n"), "wrap");
		
		JButton btnNew = new JButton("Add Another True/False Question");
		add(btnNew);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				txtQuestion.setText("");
			}
		});
	}
}
