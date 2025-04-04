package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Promotores;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class FmAcceso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;

	Promotores cr = new Promotores();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FmAcceso frame = new FmAcceso();
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
	public FmAcceso() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 373, 249);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lacceso = new JLabel("Acceso");
		Lacceso.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lacceso.setBounds(148, 11, 55, 20);
		contentPane.add(Lacceso);
		
		JLabel Lusuario = new JLabel("Usuario");
		Lusuario.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lusuario.setBounds(52, 60, 46, 14);
		contentPane.add(Lusuario);
		
		JLabel Lcontraseña = new JLabel("Contraseña");
		Lcontraseña.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcontraseña.setBounds(52, 123, 73, 14);
		contentPane.add(Lcontraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(164, 58, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(164, 121, 86, 20);
		contentPane.add(txtContrasena);
		
		JButton btnAcceso = new JButton("Acceso");
		btnAcceso.setBackground(new Color(240, 248, 255));
		btnAcceso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.controlAcceso(Integer.parseInt(txtUsuario.getText()), txtContrasena.getText());
			}
		});
		btnAcceso.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnAcceso.setBounds(129, 176, 89, 23);
		contentPane.add(btnAcceso);
	}
}
