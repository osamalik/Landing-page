package PresentationLayer;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import BussinessLayer.CHeck_Words;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Hilight extends JFrame {

	private JPanel contentPane;
     JTextArea textArea_1;
	private JTextArea textArea;
	private static JScrollPane Scoll;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hilight frame = new Hilight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public Hilight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(UIManager.getBorder("DesktopIcon.border"));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Scoll=new JScrollPane();
		
		Scoll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Scoll.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Scoll.setBounds(71, 109, 679, 183);
		contentPane.add(Scoll);
		Scoll.setViewportView(textArea);
		getContentPane().add(Scoll);
		
		textArea = new JTextArea();
		textArea.setTabSize(14);
		Scoll.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textArea_1.setText(textArea.getText());
				CHeck_Words obj=new CHeck_Words();
				
				obj.String_Breaker(textArea.getText());
				if(obj.check_List()) {
				obj.Hilight(textArea_1);
				}
				else {
					JOptionPane.showMessageDialog(null,"No Error Found 👌");    
				}
			}
		});
		btnNewButton.setBounds(760, 246, 125, 47);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(71, 346, 679, 213);
		contentPane.add(scrollPane);
		    
		      this.textArea_1 = new JTextArea();
		      textArea_1.setTabSize(14);
		      scrollPane.setViewportView(textArea_1);
		      textArea_1.setEditable(false);
		      
		      JLabel lblNewLabel = new JLabel("Spell Checker");
		      lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 26));
		      lblNewLabel.setBounds(299, 37, 249, 62);
		      contentPane.add(lblNewLabel);
		      
		      JLabel lblResult = new JLabel("Result");
		      lblResult.setFont(new Font("Snap ITC", Font.BOLD, 26));
		      lblResult.setBounds(365, 302, 112, 47);
		      contentPane.add(lblResult);
		      
		      JButton btnNewButton_1 = new JButton("Clear");
		      btnNewButton_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		textArea_1.setText(null);
		      		textArea.setText(null);
		      		
		      	}
		      });
		      btnNewButton_1.setBounds(760, 346, 125, 41);
		      contentPane.add(btnNewButton_1);
		
	}
}
