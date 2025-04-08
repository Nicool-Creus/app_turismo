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
import javax.swing.ImageIcon;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 446, 709);
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
		LtipoDocumento.setBounds(47, 130, 113, 17);
		contentPane.add(LtipoDocumento);
		
		JLabel Ldocumento = new JLabel("Documento");
		Ldocumento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldocumento.setBounds(47, 189, 86, 17);
		contentPane.add(Ldocumento);
		
		JLabel Lnombre = new JLabel("Nombre");
		Lnombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lnombre.setBounds(47, 252, 58, 17);
		contentPane.add(Lnombre);
		
		JLabel Lapellido = new JLabel("Apellido");
		Lapellido.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lapellido.setBounds(47, 315, 68, 17);
		contentPane.add(Lapellido);
		
		JLabel Ldireccion = new JLabel("Dirección");
		Ldireccion.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldireccion.setBounds(47, 371, 58, 17);
		contentPane.add(Ldireccion);
		
		JLabel Lcorreo = new JLabel("Correo");
		Lcorreo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcorreo.setBounds(47, 427, 46, 14);
		contentPane.add(Lcorreo);
		
		JLabel Ltelefono = new JLabel("Teléfono");
		Ltelefono.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ltelefono.setBounds(47, 487, 58, 17);
		contentPane.add(Ltelefono);
		
		JLabel Lmatricula = new JLabel("Matrícula");
		Lmatricula.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lmatricula.setBounds(47, 551, 58, 14);
		contentPane.add(Lmatricula);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setBounds(201, 127, 86, 20);
		contentPane.add(txtTipoDocumento);
		txtTipoDocumento.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(201, 186, 86, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(201, 249, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(201, 312, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(201, 368, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(201, 424, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(201, 484, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(201, 548, 86, 20);
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
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(240, 248, 255));
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtId.setText("");
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
		btnLimpiar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnLimpiar.setBounds(239, 616, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel Lid = new JLabel("Id del operador");
		Lid.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lid.setBounds(47, 80, 98, 17);
		contentPane.add(Lid);
		
		txtId = new JTextField();
		txtId.setBounds(201, 77, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO BORRAR.png"));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtId.getText()));
			}
		});
		btnBorrar.setBounds(352, 586, 55, 57);
		contentPane.add(btnBorrar);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.setBackground(new Color(240, 248, 255));
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO CONSULTAR.png"));
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.readOne(Integer.parseInt(txtId.getText()), txtTipoDocumento, txtDocumento,
						txtNombre, txtApellido, txtDireccion, txtCorreo, txtTelefono, txtMatricula);
			}
		});
		btnConsultar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnConsultar.setBounds(352, 447, 55, 57);
		contentPane.add(btnConsultar);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.setBackground(new Color(240, 248, 255));
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO ACTUALIZAR.png"));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(Integer.parseInt(txtId.getText()), Integer.parseInt(txtTipoDocumento.getText()), Integer.parseInt(txtDocumento.getText()), txtNombre.getText(), 
						txtApellido.getText(), txtDireccion.getText(), txtCorreo.getText(), txtTelefono.getText(), txtMatricula.getText());
			}
		});
		btnActualizar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnActualizar.setBounds(352, 518, 55, 57);
		contentPane.add(btnActualizar);
	}

}
