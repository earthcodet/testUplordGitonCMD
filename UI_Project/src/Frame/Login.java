package Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import DataManager.UserManager;
import DatabaseAndTools.DataCredentials;
import DatabaseAndTools.MongoConnector;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private  JTextField user_text;
	static int Limit_Register_window = 0;
	private JPasswordField pass_text;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					Login frame = new Login();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 403, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66, 60, 91));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 417, 117);
		contentPane.add(panel);
		
		JLabel lblLoginToOur = new JLabel("Sign in ready");
		lblLoginToOur.setForeground(SystemColor.textInactiveText);
		lblLoginToOur.setFont(new Font("Verdana", Font.PLAIN, 26));
		lblLoginToOur.setBounds(10, 11, 243, 44);
		panel.add(lblLoginToOur);
		
		JLabel lblEnterUsernameAnd = new JLabel("Enter username and password to log on");
		lblEnterUsernameAnd.setForeground(SystemColor.textInactiveText);
		lblEnterUsernameAnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterUsernameAnd.setBounds(10, 81, 314, 25);
		panel.add(lblEnterUsernameAnd);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\eclipse JAVA\\workspaceJAVA\\UI_Project\\src\\Frame\\key.png"));
		label_2.setBounds(291, 22, 100, 84);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_1.setBackground(new Color(153, 102, 153));
		panel_1.setBounds(30, 140, 84, 40);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("Username");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 11, 64, 14);
		panel_1.add(label);
		
		user_text = new JTextField();
		user_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		user_text.setColumns(10);
		user_text.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		user_text.setBounds(124, 140, 225, 40);
		contentPane.add(user_text);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_2.setBackground(new Color(153, 102, 153));
		panel_2.setBounds(30, 191, 84, 40);
		contentPane.add(panel_2);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 11, 64, 14);
		panel_2.add(label_1);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user_text.getText().trim().length() < 1 || new String(pass_text.getPassword()).trim().length() < 1) {
					JOptionPane.showMessageDialog(Login.this, "you have not typed username or password", "Type incomplete", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(!(UserManager.CheckLogin(user_text.getText().trim()))) {
						JOptionPane.showMessageDialog(Login.this, "your username or password incorrect", "Type incorrect", JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(Login.this, "Welcome to my site", "Type correct", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnSignIn.setForeground(new Color(0, 0, 255));
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignIn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSignIn.setBounds(255, 258, 94, 31);
		contentPane.add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Limit_Register_window < 1) {
					Register rs = new Register();
					rs.setVisible(true);
					rs.noResize();
				}
				Limit_Register_window = 1;
			}
		});
		btnSignUp.setForeground(Color.GRAY);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignUp.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSignUp.setBounds(142, 258, 94, 31);
		contentPane.add(btnSignUp);
		
		pass_text = new JPasswordField();
		pass_text.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		pass_text.setBounds(124, 191, 225, 40);
		contentPane.add(pass_text);
	}
	public static void setLimit_Register_Window() {
		Limit_Register_window = 0;
	}
}