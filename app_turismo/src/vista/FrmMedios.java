package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Medios;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmMedios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtObservaciones;
	private JButton btnLimpiar;
	private JLabel Lgestion;
	private JLabel LidTipoMedio;
	private JTextField txtIdTipoMedio;
	private JLabel LidMedios;
	private JTextField txtIdMedio;
	private JButton btnBorrar;

	Medios cr = new Medios();
	private JButton btnConsultar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMedios frame = new FrmMedios();
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
	public FrmMedios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lnombre = new JLabel("Nombre");
		Lnombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lnombre.setBounds(45, 107, 64, 14);
		contentPane.add(Lnombre);
		
		JLabel Lobservaciones = new JLabel("Observaciones");
		Lobservaciones.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lobservaciones.setBounds(45, 158, 98, 17);
		contentPane.add(Lobservaciones);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(180, 104, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(180, 157, 86, 20);
		contentPane.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtIdMedio.getText()), txtNombre.getText(), txtObservaciones.getText(), Integer.parseInt(txtIdTipoMedio.getText()));
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(61, 282, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(240, 248, 255));
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIdMedio.setText("");
				txtNombre.setText("");
				txtObservaciones.setText("");
				txtIdTipoMedio.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnLimpiar.setBounds(226, 282, 89, 23);
		contentPane.add(btnLimpiar);
		
		Lgestion = new JLabel("Gestión de medios");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(136, 11, 159, 20);
		contentPane.add(Lgestion);
		
		LidTipoMedio = new JLabel("Id del tipo de medio");
		LidTipoMedio.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidTipoMedio.setBounds(45, 218, 125, 14);
		contentPane.add(LidTipoMedio);
		
		txtIdTipoMedio = new JTextField();
		txtIdTipoMedio.setBounds(180, 215, 86, 20);
		contentPane.add(txtIdTipoMedio);
		txtIdTipoMedio.setColumns(10);
		
		LidMedios = new JLabel("Id del medio");
		LidMedios.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidMedios.setBounds(45, 59, 86, 14);
		contentPane.add(LidMedios);
		
		txtIdMedio = new JTextField();
		txtIdMedio.setBounds(180, 56, 86, 20);
		contentPane.add(txtIdMedio);
		txtIdMedio.setColumns(10);
		
		btnBorrar = new JButton("");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\3643729_bin_delete_garbage_rubbish_trash_icon.png"));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdMedio.getText()));
			}
		});
		btnBorrar.setBounds(347, 248, 55, 57);
		contentPane.add(btnBorrar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.readOne(Integer.parseInt(txtIdMedio.getText()), txtNombre, txtObservaciones, txtIdTipoMedio);
			}
		});
		btnConsultar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnConsultar.setBounds(302, 104, 89, 23);
		contentPane.add(btnConsultar);
	}

}
