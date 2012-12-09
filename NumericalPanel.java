package miniProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class NumericalPanel extends JPanel {
	private final int MAX = 100;
	private String title = null;
	private String question = null;
	private PrintWriter output;
	private File myText;
	
	public NumericalPanel() {
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
		
		add(new JLabel("Add Correct Answer"), "right");
		final JTextArea txtAnswer = new JTextArea(1, 8);
		JScrollPane scroll3 = new JScrollPane(txtAnswer);
		scroll3.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll3, "span, growx, wrap");
		
		add(new JLabel("Error Margin"), "right");
		final JTextArea txtMargin = new JTextArea(1, 4);
		CreditPanel marginPan = new CreditPanel(txtMargin);
		add(marginPan, "wrap");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		JButton btnNew = new JButton("Add Another Numerical Question");
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
				String answer = txtAnswer.getText();
				String margin = txtMargin.getText();
				
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
				sb.append(question + " {#");
				sb.append(answer + ":" + margin + "}\n");
				
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
				txtMargin.setText("0");
				txtAnswer.setText("");
			}
		});
	}
	
	private class CreditPanel extends JScrollPane {
		public CreditPanel(final JTextArea jta) {
			super(jta);
			jta.setText("0");
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
