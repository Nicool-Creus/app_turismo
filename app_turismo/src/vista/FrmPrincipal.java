package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LmenuFormularios = new JLabel("Formularios");
		LmenuFormularios.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		LmenuFormularios.setBounds(228, 11, 100, 23);
		contentPane.add(LmenuFormularios);
		
		JLabel Lcompañia = new JLabel("Compañia");
		Lcompañia.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcompañia.setBounds(41, 60, 62, 14);
		contentPane.add(Lcompañia);
		
		JLabel Lagencia = new JLabel("Agencia");
		Lagencia.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lagencia.setBounds(161, 60, 46, 14);
		contentPane.add(Lagencia);
		
		JLabel Lpromotor = new JLabel("Promotor");
		Lpromotor.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lpromotor.setBounds(282, 60, 62, 14);
		contentPane.add(Lpromotor);
		
		JLabel Lcliente = new JLabel("Cliente");
		Lcliente.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcliente.setBounds(398, 60, 46, 14);
		contentPane.add(Lcliente);
		
		JLabel Lpaquete = new JLabel("Paquete");
		Lpaquete.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lpaquete.setBounds(41, 154, 62, 14);
		contentPane.add(Lpaquete);
		
		JLabel LtipoMedio = new JLabel("Tipo de medio");
		LtipoMedio.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LtipoMedio.setBounds(161, 154, 89, 14);
		contentPane.add(LtipoMedio);
		
		JLabel Lmedio = new JLabel("Medio");
		Lmedio.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lmedio.setBounds(282, 154, 46, 14);
		contentPane.add(Lmedio);
		
		JLabel Loperador = new JLabel("Operador");
		Loperador.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Loperador.setBounds(398, 154, 70, 14);
		contentPane.add(Loperador);
		
		JLabel LtipoTransporte = new JLabel("Tipo de transporte");
		LtipoTransporte.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LtipoTransporte.setBounds(171, 250, 112, 14);
		contentPane.add(LtipoTransporte);
		
		JLabel Lvehiculo = new JLabel("Vehículo");
		Lvehiculo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lvehiculo.setBounds(314, 250, 57, 14);
		contentPane.add(Lvehiculo);
		
		JButton btnCompania = new JButton("");
		btnCompania.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO COMPAÑIA.png"));
		btnCompania.setBackground(new Color(240, 248, 255));
		btnCompania.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCompanias view = new FrmCompanias();
				view.show();
			}
		});
		btnCompania.setBounds(41, 85, 55, 57);
		contentPane.add(btnCompania);
		
		JButton btnAgencia = new JButton("");
		btnAgencia.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO AGENCIA.png"));
		btnAgencia.setBackground(new Color(240, 248, 255));
		btnAgencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmAgencias view = new FrmAgencias();
				view.show();
			}
		});
		btnAgencia.setBounds(161, 85, 55, 57);
		contentPane.add(btnAgencia);
		
		JButton btnPromotor = new JButton("Promotor");
		btnPromotor.setBackground(new Color(240, 248, 255));
		btnPromotor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmPromotores view = new FrmPromotores();
				view.show();
			}
		});
		btnPromotor.setBounds(271, 107, 89, 23);
		contentPane.add(btnPromotor);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBackground(new Color(240, 248, 255));
		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmClientes view = new FrmClientes();
				view.show();
			}
		});
		btnCliente.setBounds(398, 107, 89, 23);
		contentPane.add(btnCliente);
		
		JButton btnPaquete = new JButton("Paquete");
		btnPaquete.setBackground(new Color(240, 248, 255));
		btnPaquete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmPaquetes view = new FrmPaquetes();
				view.show();
			}
		});
		btnPaquete.setBounds(26, 209, 89, 23);
		contentPane.add(btnPaquete);
		
		JButton btnTipoMedio = new JButton("TipoMedio");
		btnTipoMedio.setBackground(new Color(240, 248, 255));
		btnTipoMedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmTiposMedios view = new FrmTiposMedios();
				view.show();
			}
		});
		btnTipoMedio.setBounds(161, 209, 89, 23);
		contentPane.add(btnTipoMedio);
		
		JButton btnMedio = new JButton("Medio");
		btnMedio.setBackground(new Color(240, 248, 255));
		btnMedio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmMedios view = new FrmMedios();
				view.show();
			}
		});
		btnMedio.setBounds(282, 198, 89, 23);
		contentPane.add(btnMedio);
		
		JButton btnOperador = new JButton("Operador");
		btnOperador.setBackground(new Color(240, 248, 255));
		btnOperador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmOperadores view = new FrmOperadores();
				view.show();
			}
		});
		btnOperador.setBounds(398, 209, 89, 23);
		contentPane.add(btnOperador);
		
		JButton btnTipoTransporte = new JButton("Tipo de transporte");
		btnTipoTransporte.setBackground(new Color(240, 248, 255));
		btnTipoTransporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmTiposTransporte view = new FrmTiposTransporte();
				view.show();
			}
		});
		btnTipoTransporte.setBounds(161, 299, 122, 23);
		contentPane.add(btnTipoTransporte);
		
		JButton btnVehiculo = new JButton("Vehículo");
		btnVehiculo.setBackground(new Color(240, 248, 255));
		btnVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmVehiculo view = new FrmVehiculo();
				view.show();
			}
		});
		btnVehiculo.setBounds(314, 299, 89, 23);
		contentPane.add(btnVehiculo);
	}
}
