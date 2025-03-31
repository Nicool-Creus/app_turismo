package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.TiposTransporte;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class FrmTiposTransporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtObservaciones;

	TiposTransporte cr = new TiposTransporte();
	private JTextField txtIdTipo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTiposTransporte frame = new FrmTiposTransporte();
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
	public FrmTiposTransporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 281);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lgestion = new JLabel("Gestión de tipos de transporte");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(96, 11, 261, 20);
		contentPane.add(Lgestion);
		
		JLabel Lnombre = new JLabel("Nombre");
		Lnombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lnombre.setBounds(62, 101, 64, 14);
		contentPane.add(Lnombre);
		
		JLabel Lobservaciones = new JLabel("Observaciones");
		Lobservaciones.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lobservaciones.setBounds(62, 161, 97, 14);
		contentPane.add(Lobservaciones);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(210, 98, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(210, 158, 86, 20);
		contentPane.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtIdTipo.getText()), txtNombre.getText(), txtObservaciones.getText());
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(81, 208, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setText("");
				txtObservaciones.setText("");
			}
		});
		btnBorrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnBorrar.setBounds(268, 208, 89, 23);
		contentPane.add(btnBorrar);
		
		JLabel LtipoMedio = new JLabel("Id del tipo de transporte");
		LtipoMedio.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LtipoMedio.setBounds(60, 52, 146, 17);
		contentPane.add(LtipoMedio);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setBounds(211, 49, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);
		
		JButton btnBorrarDatos = new JButton("Borrar datos del id");
		btnBorrarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdTipo.getText()));
			}
		});
		btnBorrarDatos.setBounds(311, 81, 129, 23);
		contentPane.add(btnBorrarDatos);
	}

}
