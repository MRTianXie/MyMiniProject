package miniProject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class EssayPanel extends JPanel {
	
	private String title = null;
	private String question = null;
	private PrintWriter output;
	private File myText;
	
	public EssayPanel() {
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
		add(btnClear, "wrap");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave, "wrap");
		
		add(new JLabel("\n\n\n\n\n\n\n"), "wrap");
		
		JButton btnNew = new JButton("Add Another Essay Question");
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
				
				sb.append("{}");
				
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
			}
		});
	}

}
