package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Clientes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTipoDocumento;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEps;
	private JTextField txtAlergias;
	private JTextField txtFechaNacimiento;
	private JTextField txtCorreo;
	private JTextField txtEstadoCivil;
	private JTextField txtTelefono;
	private JTextField txtDireccion;

	Clientes cr = new Clientes();
	private JTextField txtId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes frame = new FrmClientes();
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
	public FrmClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LtipoDocumento = new JLabel("Tipo de documento");
		LtipoDocumento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LtipoDocumento.setBounds(43, 140, 130, 18);
		contentPane.add(LtipoDocumento);
		
		JLabel Ldocumento = new JLabel("Documento");
		Ldocumento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldocumento.setBounds(43, 198, 72, 17);
		contentPane.add(Ldocumento);
		
		JLabel Lnombre = new JLabel("Nombre");
		Lnombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lnombre.setBounds(43, 259, 61, 17);
		contentPane.add(Lnombre);
		
		JLabel Lapellido = new JLabel("Apellido");
		Lapellido.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lapellido.setBounds(43, 320, 61, 17);
		contentPane.add(Lapellido);
		
		JLabel Leps = new JLabel("EPS");
		Leps.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Leps.setBounds(43, 380, 46, 14);
		contentPane.add(Leps);
		
		JLabel Lalergias = new JLabel("Alergias");
		Lalergias.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lalergias.setBounds(43, 433, 61, 17);
		contentPane.add(Lalergias);
		
		JLabel LfechaNacimiento = new JLabel("Fecha de nacimiento");
		LfechaNacimiento.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LfechaNacimiento.setBounds(43, 491, 117, 17);
		contentPane.add(LfechaNacimiento);
		
		JLabel Lcorreo = new JLabel("Correo");
		Lcorreo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcorreo.setBounds(349, 83, 46, 18);
		contentPane.add(Lcorreo);
		
		JLabel LestadoCivil = new JLabel("Estado civil");
		LestadoCivil.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LestadoCivil.setBounds(350, 142, 86, 17);
		contentPane.add(LestadoCivil);
		
		JLabel Ltelefono = new JLabel("Teléfono");
		Ltelefono.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ltelefono.setBounds(350, 201, 61, 17);
		contentPane.add(Ltelefono);
		
		JLabel Ldireccion = new JLabel("Dirección");
		Ldireccion.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldireccion.setBounds(350, 262, 72, 17);
		contentPane.add(Ldireccion);
		
		JLabel Lgestion = new JLabel("Gestión de clientes");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(218, 22, 149, 20);
		contentPane.add(Lgestion);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setBounds(183, 138, 86, 20);
		contentPane.add(txtTipoDocumento);
		txtTipoDocumento.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(183, 195, 86, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(183, 256, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(183, 317, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEps = new JTextField();
		txtEps.setBounds(183, 377, 86, 20);
		contentPane.add(txtEps);
		txtEps.setColumns(10);
		
		txtAlergias = new JTextField();
		txtAlergias.setBounds(183, 430, 86, 20);
		contentPane.add(txtAlergias);
		txtAlergias.setColumns(10);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(183, 488, 86, 20);
		contentPane.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(444, 81, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtEstadoCivil = new JTextField();
		txtEstadoCivil.setBounds(446, 141, 86, 20);
		contentPane.add(txtEstadoCivil);
		txtEstadoCivil.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(446, 200, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(446, 261, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtId.getText()), Integer.parseInt(txtTipoDocumento.getText()), Integer.parseInt(txtDocumento.getText()), txtNombre.getText(), 
						txtApellido.getText(), txtEps.getText(), txtAlergias.getText(), txtFechaNacimiento.getText(), txtCorreo.getText(), 
						txtEstadoCivil.getText(), txtTelefono.getText(), txtDireccion.getText());
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(131, 549, 89, 23);
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
				txtEps.setText("");
				txtAlergias.setText("");
				txtFechaNacimiento.setText("");
				txtCorreo.setText("");
				txtEstadoCivil.setText("");
				txtTelefono.setText("");
				txtDireccion.setText("");
			}
		});
		btnBorrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnBorrar.setBounds(303, 549, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnBorrarDatos = new JButton("");
		btnBorrarDatos.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\3643729_bin_delete_garbage_rubbish_trash_icon.png"));
		btnBorrarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtId.getText()));
			}
		});
		btnBorrarDatos.setBounds(432, 515, 55, 57);
		contentPane.add(btnBorrarDatos);
		
		JLabel Lid = new JLabel("Id del cliente");
		Lid.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lid.setBounds(41, 86, 74, 14);
		contentPane.add(Lid);
		
		txtId = new JTextField();
		txtId.setBounds(183, 81, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
	}

}
