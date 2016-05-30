package diplomaFYP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel cPanel = new JPanel();
		cPanel.setBounds(325, 39, 302, 201);
		frame.getContentPane().add(cPanel);
		cPanel.setLayout(null);

		JTextArea CtextArea = new JTextArea();
		CtextArea.setBounds(0, 0, 302, 201);
		cPanel.add(CtextArea);
		CtextArea.setLineWrap(true);
		CtextArea.setWrapStyleWord(true);

		JPanel rPanel = new JPanel();
		rPanel.setBounds(10, 39, 305, 201);
		frame.getContentPane().add(rPanel);
		rPanel.setLayout(null);

		JTextArea RtextArea = new JTextArea();
		RtextArea.setBounds(0, 0, 305, 201);
		RtextArea.setLineWrap(true);
		rPanel.add(RtextArea);
		RtextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		RtextArea.setWrapStyleWord(true);

		JLabel lblRealText = new JLabel("Decrypted");
		lblRealText.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRealText.setBounds(10, 23, 185, 14);
		frame.getContentPane().add(lblRealText);

		JLabel lblConverted = new JLabel("Encrypted");
		lblConverted.setBounds(325, 23, 302, 14);
		frame.getContentPane().add(lblConverted);

		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code = "";
				int n = JOptionPane.showConfirmDialog(frame, "Would you like to encrypt it with password?",
						"An Inane Question", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					JFrame frame = new JFrame("InputDialog Example #2");
					code = JOptionPane.showInputDialog(frame, "Enter your password here:",
							"i don't know what to put here", JOptionPane.WARNING_MESSAGE);

					// encryption
					String normaltext = RtextArea.getText();
					// encrypting texarea
					char[] asciitext = normaltext.toCharArray();
					int[] encrypted = new int[asciitext.length];

					int counter = 0;
					int something = 0;
					for (char at : asciitext) {
						something = (int) at;
						encrypted[counter] = something;

						counter++;
					}

					// encrypting password
					char[] asciipassword = code.toCharArray();
					int[] encryptedpassword = new int[asciipassword.length];

					int counterpassowrd = 0;
					int converterpassword = 0;

					for (char maggiegoreng : asciipassword) {
						converterpassword = (int) maggiegoreng;
						encryptedpassword[counterpassowrd] = converterpassword;

						counterpassowrd++;
					}

					int epl = 0;
					int el = 0;
					epl = encryptedpassword.length;
					el = encrypted.length;
					int cPassword = 0;
					String encryptedoutput = "";

					// multiply encrypted stuff
					for (int z = 0; z < el; z++) {
						encryptedoutput = encryptedoutput + (encrypted[z] * encryptedpassword[cPassword]) + " ";
						cPassword++;

						// sometimes password is shorter than the text
						// if password is longer than the text than this will
						// just cut off
						if (cPassword >= epl) {

							cPassword = 0;
						}
					}
					CtextArea.setText(encryptedoutput);

				} else {

					// encryption
					String normaltext = RtextArea.getText();
					// encrypting texarea
					char[] asciitext = normaltext.toCharArray();
					int[] encrypted = new int[asciitext.length];

					int counter = 0;
					int something = 0;
					for (char at : asciitext) {
						something = (int) at;
						encrypted[counter] = something;

						counter++;
					}

					int el = 0;

					el = encrypted.length;

					String encryptedoutput = "";
					// multiply encrypted stuff
					for (int z = 0; z < el; z++) {
						encryptedoutput = encryptedoutput + encrypted[z] + " ";
					}
					CtextArea.setText(encryptedoutput);
				}
			}
		});
		btnEncrypt.setBounds(10, 261, 305, 23);
		frame.getContentPane().add(btnEncrypt);

		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code;
				int n = JOptionPane.showConfirmDialog(frame, "Would you like to encrypt it with password?",
						"An Inane Question", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					JFrame frame = new JFrame("InputDialog Example #2");
					code = JOptionPane.showInputDialog(frame, "Enter your password here:",
							"i don't know what to put here", JOptionPane.WARNING_MESSAGE);

					String encryptedTxt = CtextArea.getText();

					// encrypting password
					// have to encrypt the password because that's the way to
					// decrypt the whole text
					char[] asciipassword = code.toCharArray();
					int[] encryptedpassword = new int[asciipassword.length];

					int counterpassowrd = 0;
					int converterpassword = 0;

					for (char maggiegoreng : asciipassword) {
						converterpassword = (int) maggiegoreng;
						encryptedpassword[counterpassowrd] = converterpassword;

						counterpassowrd++;
					}

					String[] splitencryptedTxt = encryptedTxt.split(" ");

					int[] convertstringtoint = new int[splitencryptedTxt.length];

					int cPassword = 0;
					int decryptedoutput = 0;
					String decryptedword = "";

					// divide encrypted stuff
					for (int z = 0; z < splitencryptedTxt.length; z++) {
						convertstringtoint[z] = Integer.parseInt(splitencryptedTxt[z]);
						decryptedoutput = convertstringtoint[z] / encryptedpassword[cPassword];
						cPassword++;

						decryptedword = decryptedword + (new Character((char) decryptedoutput).toString());

						// sometimes password is shorter than the text
						// if password is longer than the text than this will
						// just cut off
						if (cPassword >= counterpassowrd) {

							cPassword = 0;
						}
					}

					RtextArea.setText(decryptedword);

				} else {

					String encryptedTxt = CtextArea.getText();

					String[] splitencryptedTxt = encryptedTxt.split(" ");

					int[] convertstringtoint = new int[splitencryptedTxt.length];

					int decryptedoutput = 0;
					String decryptedword = "";

					// divide encrypted stuff
					for (int z = 0; z < splitencryptedTxt.length; z++) {
						convertstringtoint[z] = Integer.parseInt(splitencryptedTxt[z]);
						decryptedword = decryptedword + (new Character((char) convertstringtoint[z]).toString());
					}
					RtextArea.setText(decryptedword);

				}
			}
		});
		btnDecrypt.setBounds(325, 261, 302, 23);
		frame.getContentPane().add(btnDecrypt);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnOpen = new JMenu("Open");
		mnFile.add(mnOpen);

		JMenuItem mntmOpenDecryptedText = new JMenuItem("Open Decrypted text", KeyEvent.VK_T);
		KeyStroke ctrlTKeyStroke = KeyStroke.getKeyStroke("control T");
		mntmOpenDecryptedText.setAccelerator(ctrlTKeyStroke);
		mntmOpenDecryptedText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fileName = "/User/desktop";
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setCurrentDirectory(new File(fileName));
				jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt and .java files", "txt", "java");
				jFileChooser.setFileFilter(filter);

				try {

					int code = jFileChooser.showOpenDialog(RtextArea);
					if (code == JFileChooser.APPROVE_OPTION) {
						File selectedFile = jFileChooser.getSelectedFile();
						// fileName = selectedFile.getName();
						FileInputStream fis = new FileInputStream(selectedFile);
						InputStreamReader in = new InputStreamReader(fis, Charset.forName("UTF-8"));
						char[] buffer = new char[1024];
						int n = in.read(buffer);
						String text = new String(buffer, 0, n);
						RtextArea.setText(text);
						in.close();
					}

				} catch (Exception f) {
					f.printStackTrace();
				}

			}
		});
		mnOpen.add(mntmOpenDecryptedText);

		JMenuItem mntmOpenEncryptedText = new JMenuItem("Open Encrypted text", KeyEvent.VK_E);
		KeyStroke ctrlEKeyStroke = KeyStroke.getKeyStroke("control E");
		mntmOpenEncryptedText.setAccelerator(ctrlEKeyStroke);
		mntmOpenEncryptedText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String fileName = "/User/desktop";
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setCurrentDirectory(new File(fileName));
				jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt and .java files", "txt", "java");
				jFileChooser.setFileFilter(filter);

				try {

					int code = jFileChooser.showOpenDialog(CtextArea);
					if (code == JFileChooser.APPROVE_OPTION) {
						File selectedFile = jFileChooser.getSelectedFile();
						// fileName = selectedFile.getName();
						FileInputStream fis = new FileInputStream(selectedFile);
						InputStreamReader in = new InputStreamReader(fis, Charset.forName("UTF-8"));
						char[] buffer = new char[1024];
						int n = in.read(buffer);
						String text = new String(buffer, 0, n);
						CtextArea.setText(text);
						in.close();
					}

				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		mnOpen.add(mntmOpenEncryptedText);

		JMenu mnSave = new JMenu("Save");
		mnFile.add(mnSave);

		JMenuItem mntmSaveEncryptedText = new JMenuItem("Save Encrypted Text", KeyEvent.VK_Y);
		KeyStroke ctrlYKeyStroke = KeyStroke.getKeyStroke("control Y");
		mntmSaveEncryptedText.setAccelerator(ctrlYKeyStroke);
		mntmSaveEncryptedText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String file = "somestuff.txt";
					FileWriter writer = new FileWriter(file, true);

					PrintWriter writers = new PrintWriter(file);
					writers.print("");
					writers.close();

					writer.write(RtextArea.getText());
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		mnSave.add(mntmSaveEncryptedText);

		JMenuItem mntmSaveDecryptedText = new JMenuItem("Save Decrypted Text", KeyEvent.VK_D);
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke("control D");
		mntmSaveDecryptedText.setAccelerator(ctrlDKeyStroke);
		mntmSaveDecryptedText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String file = "somestuff.txt";
					FileWriter writer = new FileWriter(file, true);

					PrintWriter writers = new PrintWriter(file);
					writers.print("");
					writers.close();

					writer.write(CtextArea.getText());
					writer.close();
				} catch (IOException z) {
					z.printStackTrace();
				}
			}
		});
		mnSave.add(mntmSaveDecryptedText);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About about = new About();
				about.pack();
				about.setBounds(100, 100, 653, 356);
				about.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
	}
}
