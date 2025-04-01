package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Agencias;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmAgencias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtWeb;
	private JTextField txtIdCompania;
	private JTextField txtIdAgencia;

	Agencias cr = new Agencias();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAgencias frame = new FrmAgencias();
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
	public FrmAgencias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lnombre = new JLabel("Nombre");
		Lnombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lnombre.setBounds(45, 135, 60, 14);
		contentPane.add(Lnombre);
		
		JLabel Ldireccion = new JLabel("Dirección");
		Ldireccion.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldireccion.setBounds(45, 188, 60, 14);
		contentPane.add(Ldireccion);
		
		JLabel Lcorreo = new JLabel("Correo");
		Lcorreo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcorreo.setBounds(45, 247, 46, 14);
		contentPane.add(Lcorreo);
		
		JLabel Ltelefono = new JLabel("Teléfono");
		Ltelefono.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ltelefono.setBounds(45, 309, 60, 17);
		contentPane.add(Ltelefono);
		
		JLabel Lweb = new JLabel("Web");
		Lweb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lweb.setBounds(45, 377, 46, 14);
		contentPane.add(Lweb);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(179, 133, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(179, 186, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(179, 245, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(179, 308, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtWeb = new JTextField();
		txtWeb.setBounds(179, 375, 86, 20);
		contentPane.add(txtWeb);
		txtWeb.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtIdAgencia.getText()), txtNombre.getText(), txtDireccion.getText(), txtCorreo.getText(), 
						txtTelefono.getText(), txtWeb.getText(), Integer.parseInt(txtIdCompania.getText()));
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(81, 496, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(0, 0, 0));
		btnLimpiar.setBackground(new Color(240, 248, 255));
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIdAgencia.setText("");
				txtNombre.setText("");
				txtDireccion.setText("");
				txtCorreo.setText("");
				txtTelefono.setText("");
				txtWeb.setText("");
				txtIdCompania.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnLimpiar.setBounds(223, 496, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel Lgestion = new JLabel("Gestión de agencias");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(127, 30, 167, 23);
		contentPane.add(Lgestion);
		
		JLabel LidCompania = new JLabel("Id de la compañia");
		LidCompania.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidCompania.setBounds(45, 434, 124, 14);
		contentPane.add(LidCompania);
		
		txtIdCompania = new JTextField();
		txtIdCompania.setBounds(179, 432, 86, 20);
		contentPane.add(txtIdCompania);
		txtIdCompania.setColumns(10);
		
		JLabel LidAgencia = new JLabel("Id de la agencia");
		LidAgencia.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidAgencia.setBounds(45, 83, 94, 17);
		contentPane.add(LidAgencia);
		
		txtIdAgencia = new JTextField();
		txtIdAgencia.setBounds(179, 80, 86, 20);
		contentPane.add(txtIdAgencia);
		txtIdAgencia.setColumns(10);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\3643729_bin_delete_garbage_rubbish_trash_icon.png"));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdAgencia.getText()));
			}
		});
		btnBorrar.setBounds(352, 481, 55, 57);
		contentPane.add(btnBorrar);
	}
}
