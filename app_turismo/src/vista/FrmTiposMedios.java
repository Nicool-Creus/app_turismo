package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.TiposMedios;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmTiposMedios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtObservaciones;
	private JTextField txtIdTipoMedio;

	TiposMedios cr = new TiposMedios();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTiposMedios frame = new FrmTiposMedios();
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
	public FrmTiposMedios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 321);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lnombre = new JLabel("Nombre");
		Lnombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lnombre.setBounds(45, 127, 73, 14);
		contentPane.add(Lnombre);
		
		JLabel Lobservaciones = new JLabel("Observaciones");
		Lobservaciones.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lobservaciones.setBounds(43, 185, 86, 14);
		contentPane.add(Lobservaciones);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(183, 124, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(181, 182, 86, 20);
		contentPane.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		JLabel Lgestion = new JLabel("Gestión de Tipos de Medios");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(103, 22, 240, 20);
		contentPane.add(Lgestion);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(240, 248, 255));
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIdTipoMedio.setText("");
				txtNombre.setText("");
				txtObservaciones.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnLimpiar.setBounds(225, 239, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtIdTipoMedio.getText()), txtNombre.getText(), txtObservaciones.getText());
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(76, 239, 89, 23);
		contentPane.add(btnRegistrar);
		
		JLabel LidTipoMedio = new JLabel("Id del tipo de medio");
		LidTipoMedio.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidTipoMedio.setBounds(43, 73, 122, 17);
		contentPane.add(LidTipoMedio);
		
		txtIdTipoMedio = new JTextField();
		txtIdTipoMedio.setBounds(181, 70, 86, 20);
		contentPane.add(txtIdTipoMedio);
		txtIdTipoMedio.setColumns(10);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\3643729_bin_delete_garbage_rubbish_trash_icon.png"));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtIdTipoMedio.getText()));
			}
		});
		btnBorrar.setBounds(334, 205, 55, 57);
		contentPane.add(btnBorrar);
	}

}
