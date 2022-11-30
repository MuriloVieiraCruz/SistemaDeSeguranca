package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewPrincipal() {
		setTitle("ERP SENAI - M\u00F3dulo de Gest\u00E3o de incidentes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 683, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 667, 22);
		contentPane.add(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem miIncidentes = new JMenuItem("Incidentes");
		miIncidentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaIncidente view = new ViewConsultaIncidente();
				view.setVisible(true);
			}
		});
		mnCadastros.add(miIncidentes);
		
		JMenuItem miEnvolvidos = new JMenuItem("Envolvidos");
		miEnvolvidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaEnvolvido view = new ViewConsultaEnvolvido();
				view.setVisible(true);
			}
		});
		mnCadastros.add(miEnvolvidos);
		
		JMenu mnAcompanhamento = new JMenu("Acompanhamento");
		menuBar.add(mnAcompanhamento);
		
		JMenuItem miOcorrencias = new JMenuItem("Ocorr\u00EAncias");
		miOcorrencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultaOcorrencia view = new ViewConsultaOcorrencia();
				view.setVisible(true);
			}
		});
		mnAcompanhamento.add(miOcorrencias);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		JMenuItem miSair = new JMenuItem("Sair");
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnSair.add(miSair);
		setLocationRelativeTo(null);
	}
}
