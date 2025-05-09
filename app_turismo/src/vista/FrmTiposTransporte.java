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
import javax.swing.ImageIcon;

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
		setBackground(new Color(240, 248, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 281);
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
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(240, 248, 255));
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIdTipo.setText("");
				txtNombre.setText("");
				txtObservaciones.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnLimpiar.setBounds(239, 208, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel LtipoMedio = new JLabel("Id del tipo de transporte");
		LtipoMedio.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LtipoMedio.setBounds(60, 52, 146, 17);
		contentPane.add(LtipoMedio);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setBounds(211, 49, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO BORRAR.png"));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdTipo.getText()));
			}
		});
		btnBorrar.setBounds(350, 174, 55, 57);
		contentPane.add(btnBorrar);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO CONSULTAR.png"));
		btnConsultar.setBackground(new Color(240, 248, 255));
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.readOne(Integer.parseInt(txtIdTipo.getText()), txtNombre, txtObservaciones);
			}
		});
		btnConsultar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnConsultar.setBounds(350, 38, 55, 57);
		contentPane.add(btnConsultar);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO ACTUALIZAR.png"));
		btnActualizar.setBackground(new Color(240, 248, 255));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(Integer.parseInt(txtIdTipo.getText()), txtNombre.getText(), txtObservaciones.getText());
			}
		});
		btnActualizar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnActualizar.setBounds(350, 106, 55, 57);
		contentPane.add(btnActualizar);
	}

}
