package diplomaFYP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 675, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrHiThisWas = new JTextArea();
		txtrHiThisWas.setLineWrap(true);
		txtrHiThisWas.setWrapStyleWord(true);
		txtrHiThisWas.setEditable(false);
		txtrHiThisWas.setText(
				"Hi,\r\nthis was diploma final year project, yes it was too easy. it had picture encryption as well.\r\nbut I will get into that later, I just do what I remember first.\r\nI saw a lot of redundant codes, I will get to that later too.\r\nbut if you have some question. please email me at simhedi90@gmail.com\r\n\r\nThank you very much");
		txtrHiThisWas.setBounds(0, 0, 4, 22);

		JScrollPane scrollPane = new JScrollPane(txtrHiThisWas);
		scrollPane.setBounds(0, 0, 659, 434);
		contentPane.add(scrollPane);
	}

}
