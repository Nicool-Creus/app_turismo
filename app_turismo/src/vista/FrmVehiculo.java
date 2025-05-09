package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmVehiculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtPuestos;
	private JTextField txtModelo;
	private JTextField txtNumeroMotor;
	private JTextField txtCategoria;
	private JTextField txtIdTipo;

	Vehiculo cr = new Vehiculo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVehiculo frame = new FrmVehiculo();
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
	public FrmVehiculo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lgestion = new JLabel("Gestión de vehículos");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(130, 11, 179, 20);
		contentPane.add(Lgestion);
		
		JLabel Lmatricula = new JLabel("Matrícula");
		Lmatricula.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lmatricula.setBounds(64, 69, 61, 14);
		contentPane.add(Lmatricula);
		
		JLabel Lmarca = new JLabel("Marca");
		Lmarca.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lmarca.setBounds(64, 127, 46, 14);
		contentPane.add(Lmarca);
		
		JLabel Lpuestos = new JLabel("Puestos");
		Lpuestos.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lpuestos.setBounds(64, 183, 46, 14);
		contentPane.add(Lpuestos);
		
		JLabel Lmodelo = new JLabel("Modelo");
		Lmodelo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lmodelo.setBounds(64, 238, 46, 14);
		contentPane.add(Lmodelo);
		
		JLabel LnumeroMotor = new JLabel("Número del motor");
		LnumeroMotor.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LnumeroMotor.setBounds(64, 289, 118, 14);
		contentPane.add(LnumeroMotor);
		
		JLabel Lcategoria = new JLabel("Categoría");
		Lcategoria.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcategoria.setBounds(64, 344, 86, 17);
		contentPane.add(Lcategoria);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(202, 66, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(202, 124, 86, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPuestos = new JTextField();
		txtPuestos.setBounds(202, 180, 86, 20);
		contentPane.add(txtPuestos);
		txtPuestos.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(202, 235, 86, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtNumeroMotor = new JTextField();
		txtNumeroMotor.setBounds(202, 286, 86, 20);
		contentPane.add(txtNumeroMotor);
		txtNumeroMotor.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(202, 341, 86, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(txtMatricula.getText(), txtMarca.getText(), Integer.parseInt(txtPuestos.getText()), txtModelo.getText(), 
						Integer.parseInt(txtNumeroMotor.getText()), txtCategoria.getText(), Integer.parseInt(txtIdTipo.getText()));
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(91, 446, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(240, 248, 255));
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMatricula.setText("");
				txtMarca.setText("");
				txtPuestos.setText("");
				txtModelo.setText("");
				txtNumeroMotor.setText("");
				txtCategoria.setText("");
				txtIdTipo.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnLimpiar.setBounds(262, 446, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel IdTipo = new JLabel("Id del tipo de vehículo");
		IdTipo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		IdTipo.setBounds(64, 398, 128, 14);
		contentPane.add(IdTipo);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setBounds(202, 395, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO BORRAR.png"));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(txtMatricula.getText());
			}
		});
		btnBorrar.setBounds(376, 412, 55, 57);
		contentPane.add(btnBorrar);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO CONSULTAR.png"));
		btnConsultar.setBackground(new Color(240, 248, 255));
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.readOne(txtMatricula.getText(), txtMarca, txtPuestos, txtModelo, txtNumeroMotor, txtCategoria, txtIdTipo);
			}
		});
		btnConsultar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnConsultar.setBounds(376, 276, 55, 57);
		contentPane.add(btnConsultar);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO ACTUALIZAR.png"));
		btnActualizar.setBackground(new Color(240, 248, 255));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(txtMatricula.getText(), txtMarca.getText(), Integer.parseInt(txtPuestos.getText()), txtModelo.getText(), 
						Integer.parseInt(txtNumeroMotor.getText()), txtCategoria.getText(), Integer.parseInt(txtIdTipo.getText()));
			}
		});
		btnActualizar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnActualizar.setBounds(376, 344, 55, 57);
		contentPane.add(btnActualizar);
	}
}
