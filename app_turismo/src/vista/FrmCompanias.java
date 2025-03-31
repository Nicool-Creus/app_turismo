package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Companias;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmCompanias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRazonSocial;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtFechaCreacion;
	private JTextField txtWeb;

	Companias cr = new Companias();
	private JTextField txtIdCompania;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCompanias frame = new FrmCompanias();
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
	public FrmCompanias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lgestion = new JLabel("Gestión de compañias");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(123, 11, 176, 20);
		contentPane.add(Lgestion);
		
		JLabel LrazonSocial = new JLabel("Razon social");
		LrazonSocial.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LrazonSocial.setBounds(44, 110, 79, 17);
		contentPane.add(LrazonSocial);
		
		JLabel Ldireccion = new JLabel("Dirección");
		Ldireccion.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ldireccion.setBounds(44, 162, 65, 17);
		contentPane.add(Ldireccion);
		
		JLabel Lcorreo = new JLabel("Correo");
		Lcorreo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcorreo.setBounds(44, 219, 65, 14);
		contentPane.add(Lcorreo);
		
		JLabel Ltelefono = new JLabel("Teléfono");
		Ltelefono.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Ltelefono.setBounds(44, 276, 65, 17);
		contentPane.add(Ltelefono);
		
		JLabel LfechaCreacion = new JLabel("Fecha de creación");
		LfechaCreacion.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LfechaCreacion.setBounds(44, 329, 116, 17);
		contentPane.add(LfechaCreacion);
		
		JLabel Lweb = new JLabel("Web");
		Lweb.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lweb.setBounds(44, 391, 46, 14);
		contentPane.add(Lweb);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setBounds(194, 107, 86, 20);
		contentPane.add(txtRazonSocial);
		txtRazonSocial.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(194, 159, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(194, 216, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(194, 273, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setBounds(194, 326, 86, 20);
		contentPane.add(txtFechaCreacion);
		txtFechaCreacion.setColumns(10);
		
		txtWeb = new JTextField();
		txtWeb.setBounds(194, 388, 86, 20);
		contentPane.add(txtWeb);
		txtWeb.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtIdCompania.getText()), txtRazonSocial.getText(), txtDireccion.getText(), txtCorreo.getText(), txtTelefono.getText(), txtFechaCreacion.getText(), txtWeb.getText());
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(71, 451, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRazonSocial.setText("");
				txtDireccion.setText("");
				txtCorreo.setText("");
				txtTelefono.setText("");
				txtFechaCreacion.setText("");
				txtWeb.setText("");
			}
		});
		btnBorrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnBorrar.setBounds(245, 451, 89, 23);
		contentPane.add(btnBorrar);
		
		JLabel LidCompania = new JLabel("Id de la compañia");
		LidCompania.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidCompania.setBounds(44, 60, 116, 14);
		contentPane.add(LidCompania);
		
		txtIdCompania = new JTextField();
		txtIdCompania.setBounds(194, 57, 86, 20);
		contentPane.add(txtIdCompania);
		txtIdCompania.setColumns(10);
		
		JButton btnBorrarDatos = new JButton("");
		btnBorrarDatos.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\3643729_bin_delete_garbage_rubbish_trash_icon.png"));
		btnBorrarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdCompania.getText()));
			}
		});
		btnBorrarDatos.setBounds(355, 425, 55, 57);
		contentPane.add(btnBorrarDatos);
	}

}
