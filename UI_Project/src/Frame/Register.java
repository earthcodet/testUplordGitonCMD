package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import DataManager.UserManager;
import DatabaseAndTools.MongoConnector;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Panel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import Frame.Login;
import DatabaseAndTools.*;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField email_text;
	private JTextField user_text;
	private ButtonGroup group = new ButtonGroup();
	private JComboBox<String> comboEmail;
	private JPasswordField pass;
	private JPasswordField repass;
	private JTextField passShow;
	/** 
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UIManager.setLookAndFeel(
//				            UIManager.getSystemLookAndFeelClassName());
//					Register frame = new Register();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 409, 613);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66, 60, 91));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel SignUpLabel = new JPanel();
		SignUpLabel.setBackground(SystemColor.text);
		SignUpLabel.setBounds(0, 0, 411, 117);
		contentPane.add(SignUpLabel);
		SignUpLabel.setLayout(null);
		
		JLabel lblSignUpNow = new JLabel("Sign up now");
		lblSignUpNow.setForeground(SystemColor.textInactiveText);
		lblSignUpNow.setFont(new Font("Verdana", Font.PLAIN, 26));
		lblSignUpNow.setBounds(10, 11, 172, 44);
		SignUpLabel.add(lblSignUpNow);
		
		JLabel lblFillInThe = new JLabel("Fill in the form below to get instant access");
		lblFillInThe.setForeground(SystemColor.textInactiveText);
		lblFillInThe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFillInThe.setBounds(10, 81, 314, 25);
		SignUpLabel.add(lblFillInThe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\eclipse JAVA\\workspaceJAVA\\UI_Project\\src\\Frame\\dadd.png"));
		label.setBounds(290, 22, 90, 84);
		SignUpLabel.add(label);
		
		JPanel PersonaLabel = new JPanel();
		PersonaLabel.setBackground(new Color(66, 60, 91));
		PersonaLabel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Personal information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		PersonaLabel.setBounds(0, 128, 391, 138);
		contentPane.add(PersonaLabel);
		PersonaLabel.setLayout(null);
		
		email_text = new JTextField();
		email_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email_text.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		email_text.setBounds(118, 32, 132, 40);
		PersonaLabel.add(email_text);
		email_text.setColumns(10);
		
		JRadioButton dotmale = new JRadioButton("Male");
		dotmale.setActionCommand("male");
		dotmale.setForeground(new Color(255, 255, 255));
		dotmale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dotmale.setBackground(new Color(153, 102, 153));
		dotmale.setBounds(116, 92, 54, 23);
		PersonaLabel.add(dotmale);
		
		JRadioButton dotfemale = new JRadioButton("Female");
		dotfemale.setActionCommand("female");
		dotfemale.setForeground(new Color(255, 255, 255));
		dotfemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dotfemale.setBackground(new Color(153, 102, 153));
		dotfemale.setBounds(190, 92, 74, 23);
		PersonaLabel.add(dotfemale);
		
		JRadioButton dotother = new JRadioButton("Other");
		dotother.setActionCommand("other");
		dotother.setForeground(new Color(255, 255, 255));
		dotother.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dotother.setBackground(new Color(153, 102, 153));
		dotother.setBounds(275, 92, 65, 23);
		PersonaLabel.add(dotother);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_4.setBackground(new Color(153, 102, 153));
		panel_4.setBounds(24, 32, 80, 40);
		PersonaLabel.add(panel_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBackground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 11, 46, 14);
		panel_4.add(lblEmail);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_5.setBackground(new Color(153, 102, 153));
		panel_5.setBounds(24, 83, 80, 40);
		PersonaLabel.add(panel_5);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(10, 11, 46, 14);
		panel_5.add(lblGender);
		
		JPanel UserLabel = new JPanel();
		UserLabel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "User information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		UserLabel.setBackground(new Color(66, 60, 91));
		UserLabel.setBounds(0, 277, 391, 199);
		contentPane.add(UserLabel);
		UserLabel.setLayout(null);
		
		user_text = new JTextField();
		user_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		user_text.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		user_text.setColumns(10);
		user_text.setBounds(116, 30, 251, 40);
		UserLabel.add(user_text);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_6.setBackground(new Color(153, 102, 153));
		panel_6.setBounds(21, 30, 84, 40);
		UserLabel.add(panel_6);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 11, 64, 14);
		panel_6.add(label_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_7.setBackground(new Color(153, 102, 153));
		panel_7.setBounds(21, 81, 84, 40);
		UserLabel.add(panel_7);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(10, 11, 64, 14);
		panel_7.add(lblPassword);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_8.setBackground(new Color(153, 102, 153));
		panel_8.setBounds(21, 132, 84, 40);
		UserLabel.add(panel_8);
		
		JLabel lblRepassword = new JLabel("Re-Pass");
		lblRepassword.setForeground(new Color(255, 255, 255));
		lblRepassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRepassword.setBounds(10, 11, 64, 14);
		panel_8.add(lblRepassword);
		
		pass = new JPasswordField();
		pass.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		pass.setBounds(116, 81, 200, 40);
		UserLabel.add(pass);
		
		repass = new JPasswordField();
		repass.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		repass.setBounds(116, 132, 251, 40);
		UserLabel.add(repass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				passShow.setText(new String(pass.getPassword()).trim());
				passShow.setVisible(true);
				pass.setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
				passShow.setText(null);
				passShow.setVisible(false);
				pass.setVisible(true);
			}
		});
		lblNewLabel.setBounds(321, 81, 46, 40);
		UserLabel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse JAVA\\workspaceJAVA\\UI_Project\\src\\Frame\\eye2.png"));
		
		passShow = new JTextField();
		passShow.setVisible(false);
		passShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passShow.setColumns(10);
		passShow.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		passShow.setBounds(116, 81, 200, 40);
		UserLabel.add(passShow);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setForeground(new Color(255, 0, 51));
		btnCancel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearInformation();
			}
		});
		btnCancel.setBounds(176, 527, 94, 31);
		contentPane.add(btnCancel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String typeWrong = "";
				if(email_text.getText().trim().length() < 1) {
					typeWrong += "you have not typed email\n";
				}
				if(comboEmail.getSelectedIndex() == 0) {
					typeWrong += "you have not selected email address\n";
				}
				if(group.getSelection() == null) {
					typeWrong += "you have not selected gender\n";
				}
				if(user_text.getText().trim().length() < 1) {
					typeWrong += "you have not typed username\n";
				}
				if(new String(pass.getPassword()).trim().length() < 1) {
					typeWrong += "you have not typed password\n";
				}
				if(new String(repass.getPassword()).trim().length() < 1) {
					typeWrong += "you have not typed re-password\n";
				}
				if(!new String(pass.getPassword()).trim().equals(new String(repass.getPassword()).trim())) {
					typeWrong += "your password and re-password not match\n";
				}
				if(!(UserManager.CheckLogin(user_text.getText().trim()))) {
					typeWrong += "your username has already in use\n";
				}	
				if(!typeWrong.equals("")) {
					JOptionPane.showMessageDialog(Register.this, typeWrong, "Show incomplete list", JOptionPane.WARNING_MESSAGE);
				}
				else {
					UserManager.InsertUser(email_text.getText().trim()+"@"+comboEmail.getSelectedItem(), group.getSelection().getActionCommand(), user_text.getText().trim(), new String(pass.getPassword()).trim());
					JOptionPane.showMessageDialog(Register.this, "Thank you for your acception", "Register Success", JOptionPane.PLAIN_MESSAGE);
					ClearInformation();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setForeground(new Color(0, 102, 0));
		btnRegister.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRegister.setBounds(289, 527, 94, 31);
		contentPane.add(btnRegister);
		group.add(dotmale);
		group.add(dotfemale);
		group.add(dotother);
		
		comboEmail = new JComboBox<>();
		comboEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboEmail.addItem("-Select-");
		comboEmail.addItem("hotmail.com");
		comboEmail.addItem("outlook.com");
		comboEmail.addItem("gmail.com");
		comboEmail.setBounds(275, 32, 93, 40);
		PersonaLabel.add(comboEmail);
		
		JLabel label_2 = new JLabel("@");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(257, 45, 20, 14);
		PersonaLabel.add(label_2);
	}
	public void noResize() {
		this.setResizable(false);
	}
	public void ClearInformation() {
		setVisible(false);
		email_text.setText(null);
		pass.setText(null);
		repass.setText(null);
		user_text.setText(null);
		group.clearSelection();
		Login.setLimit_Register_Window();
	}	
}