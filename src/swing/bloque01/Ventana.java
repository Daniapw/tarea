package swing.bloque01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class Ventana extends JFrame{
	
	protected JTextField textField01 = new JTextField(30);
	protected JCheckBox checkbox = getCheckbox01();
	private static char digitosHexadecimales[] = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	/**
	 * Constructor
	 */
	public Ventana() {
		super("Ejercicio 1");
		
		setDimensionesBasicas();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(getPanePrincipal());
	}
	
	/**
	 * Metodo para establecer las dimensiones del JFrame
	 */
	private void setDimensionesBasicas () {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, 800, 600);
		this.setMinimumSize(new Dimension(500,300));

	}
	
	/**
	 * 
	 * @return
	 */
	private JTabbedPane getPanePrincipal() {
		
		JTabbedPane panel = new JTabbedPane();
		panel.setBackground(Color.LIGHT_GRAY);
		
		panel.addTab("Tab01", getPanel01());
		panel.add("Tab02", getPanel02());
		
		return panel;
	}
	
	/**
	 * Primer panel
	 * @return
	 */
	private JPanel getPanel01() {
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout());
		
		panel.add(new JLabel("JLabel"));
		panel.add(textField01);
		panel.add(checkbox);
		panel.add(getButton01());
		
		return panel;
	}
	
	/**
	 * Segundo panel
	 * @return
	 */
	private JPanel getPanel02() {
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		anadirPaneles02(panel);
		
		return panel;
	}
	
	/**
	 * Anadir paneles flow
	 * @param panel
	 */
	private void anadirPaneles02(JPanel panel) {
		
		JPanel panel01 = new JPanel();
		JPanel panel02 = new JPanel();
		JPanel panel03 = new JPanel();
		JPanel panel04 = new JPanel();
		
		panel.add(panel01);
		panel.add(panel02);
		panel.add(panel03);
		panel.add(panel04);
		
		//Primer panel (JTextField)
		panel01.add(new JLabel("JTextField:"));
		panel01.add(new JTextField(20));
		panel01.setOpaque(false);
		
		//Segundo panel (JPasswordField)
		panel02.add(new JLabel("JPasswordField:"));
		panel02.add(new JPasswordField(20));
		panel02.setOpaque(false);
		//Tercer panel (JComboBox)
		panel03.add(new JLabel("JComboBox:"));
		panel03.setOpaque(false);
		
		JComboBox<String> comboBox = new JComboBox<String>(new String[] {"Opcion1", "Opcion2", "Opcion3", "Opcion4"});
		
		comboBox.setSelectedItem(0);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ha elegido la Opcion" + (comboBox.getSelectedIndex() + 1));
				
			}
		});
		
		panel03.add(comboBox);
		
		//Cuarto panel
		JButton boton = new JButton("Cambiar color");
		panel04.setOpaque(false);
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.decode(getColorAzar()));
				
				panel.repaint();
			}
		});
		
		panel04.add(boton);
		
		
	}
	
	/**
	 * getCheckBox
	 * @return
	 */
	private JCheckBox getCheckbox01() {
		
		JCheckBox checkbox = new JCheckBox("JCheckbox");
		
		checkbox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ha cambiado el estado del JCheckBox");
				
			}
		});
		
		return checkbox;
	}
	
	/**
	 * getButton
	 * @return
	 */
	private JButton getButton01() {
		
		JButton boton = new JButton("Boton");
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Informacion introducida: "
						+ "\nJTextField: " + textField01.getText()
						+ "\nJCheckBox: "  + checkbox.isSelected());
				
			}
		});
		
		return boton;
	}
	
	
	/**
	 * Color al azar
	 * @return
	 */
	
	private static String getColorAzar () {
		StringBuffer sb = new StringBuffer ("#");
		for (int i = 0; i < 6; i++) {
			sb.append(digitosHexadecimales[obtenerNumeroAzar(0, digitosHexadecimales.length - 1)]);
		}
		return sb.toString();
	}
	
	/**
	 * Numero al azar
	 * @param min
	 * @param max
	 * @return
	 */
	public static int obtenerNumeroAzar (int min, int max) {
		 return (int) Math.round(Math.random() * (max - min)) + min;
	}
}
