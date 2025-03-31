package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Operadores;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class FrmOperadores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTipoDocumento;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtMatricula;
	private JTextField txtId;

	Operadores cr = new Operadores();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOperadores frame = new FrmOperadores();
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
	public FrmOperadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 709);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lgestion = new JLabel("Gestión de operadores");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(124, 26, 183, 20);
		contentPane.add(Lgestion);
		
		JLabel LtipoDocumento = new JLabel("Tipo de documento");
		LtipoDocumento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LtipoDocumento.setBounds(47, 122, 113, 17);
		contentPane.add(LtipoDocumento);
		
		JLabel Ldocumento = new JLabel("Documento");
		Ldocumento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldocumento.setBounds(47, 181, 86, 17);
		contentPane.add(Ldocumento);
		
		JLabel Lnombre = new JLabel("Nombre");
		Lnombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lnombre.setBounds(47, 244, 58, 17);
		contentPane.add(Lnombre);
		
		JLabel Lapellido = new JLabel("Apellido");
		Lapellido.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lapellido.setBounds(47, 307, 68, 17);
		contentPane.add(Lapellido);
		
		JLabel Ldireccion = new JLabel("Dirección");
		Ldireccion.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldireccion.setBounds(47, 363, 58, 17);
		contentPane.add(Ldireccion);
		
		JLabel Lcorreo = new JLabel("Correo");
		Lcorreo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcorreo.setBounds(47, 419, 46, 14);
		contentPane.add(Lcorreo);
		
		JLabel Ltelefono = new JLabel("Teléfono");
		Ltelefono.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ltelefono.setBounds(47, 479, 58, 17);
		contentPane.add(Ltelefono);
		
		JLabel Lmatricula = new JLabel("Matrícula");
		Lmatricula.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lmatricula.setBounds(47, 543, 58, 14);
		contentPane.add(Lmatricula);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setBounds(201, 119, 86, 20);
		contentPane.add(txtTipoDocumento);
		txtTipoDocumento.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(201, 178, 86, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(201, 241, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(201, 304, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(201, 360, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(201, 416, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(201, 476, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(201, 540, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtId.getText()), Integer.parseInt(txtTipoDocumento.getText()), Integer.parseInt(txtDocumento.getText()), txtNombre.getText(), 
						txtApellido.getText(), txtDireccion.getText(), txtCorreo.getText(), txtTelefono.getText(), txtMatricula.getText());
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(86, 616, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTipoDocumento.setText("");
				txtDocumento.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtDireccion.setText("");
				txtCorreo.setText("");
				txtTelefono.setText("");
				txtMatricula.setText("");
			}
		});
		btnBorrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnBorrar.setBounds(239, 616, 89, 23);
		contentPane.add(btnBorrar);
		
		JLabel Lid = new JLabel("Id");
		Lid.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lid.setBounds(47, 80, 46, 14);
		contentPane.add(Lid);
		
		txtId = new JTextField();
		txtId.setBounds(201, 77, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnBorrarDatos = new JButton("Borrar datos del id");
		btnBorrarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtId.getText()));
			}
		});
		btnBorrarDatos.setBounds(318, 284, 121, 23);
		contentPane.add(btnBorrarDatos);
	}

}
