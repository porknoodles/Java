package diplomaFYP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Encryption {

	private JFrame AboutFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encryption window = new Encryption();
					window.AboutFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Encryption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AboutFrame = new JFrame();
		AboutFrame.setTitle("About");
		AboutFrame.setBounds(100, 100, 665, 469);
		AboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AboutFrame.getContentPane().setLayout(null);
		
		JTextArea txtrHiThisWas = new JTextArea();
		txtrHiThisWas.setText("Hi,\r\nthis was diploma final year project, yes it was too easy. it had picture encryption as well.\r\nbut I will get into that later, I just do what I remember first.\r\nI saw a lot of redundant codes, I will get to that later too.\r\nbut if you have some question. please email me at simhedi90@gmail.com\r\n\r\nThank you very much");
		txtrHiThisWas.setBounds(0, 0, 649, 431);
		
		JScrollPane scrollPane = new JScrollPane(txtrHiThisWas);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 649, 431);
		AboutFrame.getContentPane().add(scrollPane);
	}
}
