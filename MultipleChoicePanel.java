package miniProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class MultipleChoicePanel extends JPanel {
	
	private String title = null;
	private String question = null;
	private ArrayList<String> correctAnswers = null;
	private ArrayList<String> wrongAnswers = null;
	private PrintWriter output;
	private File myText;

	public MultipleChoicePanel() {
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
		
		JButton btnAddAnswer = new JButton("Add Answer");
		add(btnAddAnswer);
		
		final JTextField option1 = new JTextField();
		add(option1, "growx, span, split");
		final JTextArea jtaCredit1 = new JTextArea(1,4);
		CreditPanel scrollCredit1 = new CreditPanel(jtaCredit1);
		add(scrollCredit1, "wrap, right");
		
		final JTextField option2 = new JTextField();
		add(option2, "skip, growx, span, split");
		final JTextArea jtaCredit2 = new JTextArea(1,4);
		CreditPanel scrollCredit2 = new CreditPanel(jtaCredit2);
		add(scrollCredit2, "wrap, right");
		
		final JTextField option3 = new JTextField();
		add(option3, "skip, growx, span, split");
		final JTextArea jtaCredit3 = new JTextArea(1,4);
		CreditPanel scrollCredit3 = new CreditPanel(jtaCredit3);
		add(scrollCredit3, "wrap, right");
		
		final JTextField option4 = new JTextField();
		add(option4, "skip, growx, span, split");
		final JTextArea jtaCredit4 = new JTextArea(1,4);
		CreditPanel scrollCredit4 = new CreditPanel(jtaCredit4);
		add(scrollCredit4, "wrap, right");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		JButton btnNew = new JButton("Add Another Multiple Choice Question");
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
				String first = option1.getText();
				String second = option2.getText();
				String third = option3.getText();
				String forth = option4.getText();
				correctAnswers = new ArrayList<String>();
				wrongAnswers = new ArrayList<String>();
				ArrayList<String> credits = new ArrayList<String>();
				
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
				
				if((!jtaCredit1.getText().equals("0")) 
						&& (!(first.equals("")))) {
					correctAnswers.add(first);
					credits.add(jtaCredit1.getText());
				}else if(!(first.equals(""))){
					wrongAnswers.add(first);
				}
				
				if((!jtaCredit2.getText().equals("0"))
						&& (!(second.equals("")))) {
					correctAnswers.add(second);
					credits.add(jtaCredit2.getText());
				}else if(!(second.equals(""))){
					wrongAnswers.add(second);
				}
				
				if((!jtaCredit3.getText().equals("0"))
						&& (!(third.equals("")))) {
					correctAnswers.add(third);
					credits.add(jtaCredit3.getText());
				}else if(!(third.equals(""))){
					wrongAnswers.add(third);
				}
				
				if((!jtaCredit4.getText().equals("0"))
						&& (!(forth.equals("")))) {
					correctAnswers.add(forth);
					credits.add(jtaCredit4.getText());
				}else if(!(forth.equals(""))){
					wrongAnswers.add(forth);
				}
				
				sb.append("{\n");
				if(correctAnswers.size() == 1) {
					sb.append("=" + correctAnswers.get(0) + "\n");
					for(int i = 0; i < wrongAnswers.size(); i ++) {
						sb.append("~" + wrongAnswers.get(i) + "\n");
					}
				}else {
					for(int i = 0; i < correctAnswers.size(); i ++) {
						sb.append("~%" + credits.get(i) + "%"
					+ correctAnswers.get(i) + "\n");
					}
					for(int i = 0; i < wrongAnswers.size(); i ++) {
						sb.append("~%-100%" + wrongAnswers.get(i) + "\n");
					}
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
				correctAnswers = null;
				wrongAnswers = null;
				title = "";
				question = "";
				option1.setText("");
				option2.setText("");
				option3.setText("");
				option4.setText("");
				jtaCredit1.setText("0");
				jtaCredit2.setText("0");
				jtaCredit3.setText("0");
				jtaCredit4.setText("0");
			}
		});
	}
	
	private class CreditPanel extends JScrollPane {
		public CreditPanel(JTextArea jta) {
			super(jta);
			jta.setText("0");
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
