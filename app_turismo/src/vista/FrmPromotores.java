package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Promotores;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmPromotores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTipoDocumento;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtCorreoPersonal;
	private JTextField txtCorreoCorp;
	private JTextField txtFechaNacimiento;
	private JTextField txtTelefono;
	private JTextField txtId;

	Promotores cr = new Promotores();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPromotores frame = new FrmPromotores();
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
	public FrmPromotores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 684);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lgestion = new JLabel("Gestión de promotores");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(122, 11, 191, 20);
		contentPane.add(Lgestion);
		
		JLabel LtipoDocumento = new JLabel("Tipo de documento");
		LtipoDocumento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LtipoDocumento.setBounds(54, 122, 114, 17);
		contentPane.add(LtipoDocumento);
		
		JLabel Ldocumento = new JLabel("Documento");
		Ldocumento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldocumento.setBounds(54, 174, 86, 17);
		contentPane.add(Ldocumento);
		
		JLabel Lnombre = new JLabel("Nombre");
		Lnombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lnombre.setBounds(54, 222, 59, 14);
		contentPane.add(Lnombre);
		
		JLabel Lapellido = new JLabel("Apellido");
		Lapellido.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lapellido.setBounds(54, 276, 59, 17);
		contentPane.add(Lapellido);
		
		JLabel Ldireccion = new JLabel("Dirección");
		Ldireccion.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldireccion.setBounds(54, 325, 75, 14);
		contentPane.add(Ldireccion);
		
		JLabel LcorreoPersonal = new JLabel("Correo personal");
		LcorreoPersonal.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LcorreoPersonal.setBounds(54, 383, 103, 17);
		contentPane.add(LcorreoPersonal);
		
		JLabel LcorreoCorp = new JLabel("Correo corporativo");
		LcorreoCorp.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LcorreoCorp.setBounds(54, 436, 114, 17);
		contentPane.add(LcorreoCorp);
		
		JLabel LfechaNacimiento = new JLabel("Fecha de nacimiento");
		LfechaNacimiento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LfechaNacimiento.setBounds(54, 488, 136, 17);
		contentPane.add(LfechaNacimiento);
		
		JLabel Ltelefono = new JLabel("Teléfono");
		Ltelefono.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ltelefono.setBounds(54, 548, 59, 14);
		contentPane.add(Ltelefono);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setBounds(200, 121, 86, 20);
		contentPane.add(txtTipoDocumento);
		txtTipoDocumento.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(200, 168, 86, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(200, 219, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(200, 273, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(200, 322, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreoPersonal = new JTextField();
		txtCorreoPersonal.setBounds(200, 380, 86, 20);
		contentPane.add(txtCorreoPersonal);
		txtCorreoPersonal.setColumns(10);
		
		txtCorreoCorp = new JTextField();
		txtCorreoCorp.setBounds(200, 433, 86, 20);
		contentPane.add(txtCorreoCorp);
		txtCorreoCorp.setColumns(10);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(200, 485, 86, 20);
		contentPane.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(200, 545, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtId.getText()), Integer.parseInt(txtTipoDocumento.getText()), Integer.parseInt(txtDocumento.getText()), 
						txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(), txtCorreoPersonal.getText(), txtCorreoCorp.getText(),
						txtFechaNacimiento.getText(), txtTelefono.getText());
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(79, 610, 89, 23);
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
				txtCorreoPersonal.setText("");
				txtCorreoCorp.setText("");
				txtFechaNacimiento.setText("");
				txtTelefono.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnLimpiar.setBounds(248, 610, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel Lid = new JLabel("Id del promotor");
		Lid.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lid.setBounds(54, 68, 103, 14);
		contentPane.add(Lid);
		
		txtId = new JTextField();
		txtId.setBounds(200, 65, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\3643729_bin_delete_garbage_rubbish_trash_icon.png"));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtId.getText()));
			}
		});
		btnBorrar.setBounds(368, 576, 53, 57);
		contentPane.add(btnBorrar);
	}

}
