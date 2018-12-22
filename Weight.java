import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Weight extends JFrame {

	private JPanel contentPane;
	private JTextField num;
	private JLabel plates;
	private JLabel tewnties;
	private JLabel tens;
	private JLabel fives;
	private JLabel twos;
	private JTextPane plateText, twenText, twoText, tenText, fiveText;
	double weight;
	private JButton calc;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Weight frame = new Weight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Weight() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterBenchWeight = new JLabel("Enter Bench Weight");
		lblEnterBenchWeight.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblEnterBenchWeight.setBounds(7, 11, 229, 32);
		contentPane.add(lblEnterBenchWeight);

		num = new JTextField();
		num.setFont(new Font("Tahoma", Font.PLAIN, 26));
		num.setBounds(10, 48, 226, 38);
		contentPane.add(num);
		num.setColumns(10);

		plates = new JLabel("Plates");
		plates.setFont(new Font("Tahoma", Font.PLAIN, 26));
		plates.setBounds(7, 149, 68, 32);
		contentPane.add(plates);

		tewnties = new JLabel("25s");
		tewnties.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tewnties.setBounds(168, 149, 68, 32);
		contentPane.add(tewnties);

		tens = new JLabel("10s");
		tens.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tens.setBounds(7, 237, 68, 32);
		contentPane.add(tens);

		fives = new JLabel("5s");
		fives.setFont(new Font("Tahoma", Font.PLAIN, 26));
		fives.setBounds(168, 237, 68, 32);
		contentPane.add(fives);

		twos = new JLabel("2.5s");
		twos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		twos.setBounds(90, 308, 68, 32);
		contentPane.add(twos);

		plateText = new JTextPane();
		plateText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		plateText.setBounds(7, 188, 68, 38);
		contentPane.add(plateText);

		twenText = new JTextPane();
		twenText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		twenText.setBounds(168, 188, 68, 38);
		contentPane.add(twenText);

		tenText = new JTextPane();
		tenText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tenText.setBounds(7, 270, 68, 38);
		contentPane.add(tenText);

		fiveText = new JTextPane();
		fiveText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		fiveText.setBounds(168, 270, 68, 38);
		contentPane.add(fiveText);

		twoText = new JTextPane();
		twoText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		twoText.setBounds(90, 351, 68, 38);
		contentPane.add(twoText);

		calc = new JButton("Calculate");
		calc.setFont(new Font("Tahoma", Font.PLAIN, 26));
		calc.setBounds(20, 97, 204, 41);
		contentPane.add(calc);

		ListenForButton l = new ListenForButton();
		calc.addActionListener(l);
	}

	private class ListenForButton implements ActionListener { 
 
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == calc) {
				weight = Double.parseDouble(num.getText());
				double plate = 0, twen = 0, ten = 0, five = 0, two = 0;
				if (weight < 135) {
					JOptionPane.showMessageDialog(Weight.this, "Increase the weight", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					weight = weight - 45;

					for (int i = 1; i <= (weight / 90); i++) {
						plate = plate + 2;
					}
					for (int i = 1; i <= (weight - (45 * plate)) / 50; i++) {
						twen = twen + 2;
					}
					for (int i = 1; i <= (weight - 45 * plate - 25 * twen) / 20; i++) {
						ten = ten + 2;
					}
					for (int i = 1; i <= (weight - 45 * plate - 25 * twen - 10 * ten) / 10; i++) {
						five = five + 2;
					}
					for (int i = 1; i <= (weight - 45 * plate - 25 * twen - 10 * ten - 5 * five) / 5; i++) {
						two = two + 2;
					}

					plateText.setText(Double.toString(plate));
					twenText.setText(Double.toString(twen));
					tenText.setText(Double.toString(ten));
					fiveText.setText(Double.toString(five));
					twoText.setText(Double.toString(two));
				}

			}
		}
	}
}
