package imcCalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

/**
 * 
 * @author Tiago Barbosa, github.com/tiagocbarbosa
 *
 */
public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField tfHeight;
	private JTextField tfWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setResizable(false);
		setTitle("BMI CALCULATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCalculateBodyMass = new JLabel("Calculate Body Mass");
		lblCalculateBodyMass.setBounds(10, 11, 151, 14);
		contentPane.add(lblCalculateBodyMass);
		
		JLabel lblYourHeight = new JLabel("Your Height (m):");
		lblYourHeight.setBounds(36, 53, 96, 14);
		contentPane.add(lblYourHeight);
		
		tfHeight = new JTextField();
		tfHeight.setBounds(142, 51, 96, 20);
		contentPane.add(tfHeight);
		tfHeight.setColumns(10);
		
		JLabel lblYourWeight = new JLabel("Your Weight (kg):");
		lblYourWeight.setBounds(36, 89, 107, 14);
		contentPane.add(lblYourWeight);
		
		tfWeight = new JTextField();
		tfWeight.setBounds(142, 87, 96, 20);
		contentPane.add(tfWeight);
		tfWeight.setColumns(10);
		
		JLabel lblYourBMI = new JLabel("Your BMI:");
		lblYourBMI.setBounds(95, 190, 66, 14);
		contentPane.add(lblYourBMI);
		
		JLabel lblValue = new JLabel("0.00");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValue.setBounds(159, 182, 81, 23);
		contentPane.add(lblValue);
		
		JLabel lblResult = new JLabel("...");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblResult.setBounds(159, 206, 275, 34);
		contentPane.add(lblResult);
		
		JLabel lblBMIResult = new JLabel("BMI RESULT");
		lblBMIResult.setBounds(157, 150, 134, 14);
		contentPane.add(lblBMIResult);
		
		JButton btnCalculateBMI = new JButton("Calculate BMI");
		btnCalculateBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(tfWeight.getText());
					double height = Double.parseDouble(tfHeight.getText());
					double bmi = weight / Math.pow(height, 2);
					bmi = (double)Math.round(bmi * 100d) / 100d;
					
					String message = null;
					Color color = new Color(1, 1, 1);
					if(bmi < 17.00) {
						message = "Very Underweight";
						color = color.RED;
					} else if(bmi < 18.49) {
						message = "Under Weight";
						color = color.ORANGE;
					} else if(bmi < 24.99) {
						message = "Normal Weight";
						color = color.GREEN;
					} else if(bmi < 34.99) {
						message = "Obesity I";
						color = color.YELLOW;
					} else if(bmi < 39.99) {
						message = "Obesity II";
						color = color.ORANGE;
					} else {
						message = "Obesity III";
						color = color.RED;
					}
					
					lblValue.setText(String.valueOf(bmi));
					lblResult.setText(message);
					lblResult.setForeground(color);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Please enter valid entries.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCalculateBMI.setBounds(293, 30, 134, 23);
		contentPane.add(btnCalculateBMI);
		
		JButton btnClean = new JButton("Clean");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfHeight.setText(null);
				tfWeight.setText(null);
				lblValue.setText("0.00");
				lblResult.setText("...");
				lblResult.setForeground(Color.BLACK);
			}
		});
		btnClean.setBounds(293, 64, 134, 23);
		contentPane.add(btnClean);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(293, 98, 134, 23);
		contentPane.add(btnExit);
	}
}
