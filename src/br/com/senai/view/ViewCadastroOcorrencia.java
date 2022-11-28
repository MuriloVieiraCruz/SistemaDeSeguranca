package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroOcorrencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewCadastroOcorrencia() {
		setTitle("Gerenciar Ocorr\u00EAncia - Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnvolvido = new JLabel("Envolvido*");
		lblEnvolvido.setBounds(12, 43, 73, 16);
		contentPane.add(lblEnvolvido);
		
		JComboBox cbEnvolvidos = new JComboBox();
		cbEnvolvidos.setBounds(12, 64, 188, 25);
		contentPane.add(cbEnvolvidos);
		
		JLabel lblColaborador = new JLabel("Colaborador*");
		lblColaborador.setBounds(212, 43, 96, 16);
		contentPane.add(lblColaborador);
		
		JComboBox cbColaborador = new JComboBox();
		cbColaborador.setBounds(212, 64, 210, 25);
		contentPane.add(cbColaborador);
		
		JLabel lblIncidente = new JLabel("Incidente*");
		lblIncidente.setBounds(12, 102, 73, 16);
		contentPane.add(lblIncidente);
		
		JComboBox cbIncidentes = new JComboBox();
		cbIncidentes.setBounds(12, 131, 247, 25);
		contentPane.add(cbIncidentes);
		
		JLabel lblData = new JLabel("Data*");
		lblData.setBounds(270, 102, 55, 16);
		contentPane.add(lblData);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(271, 133, 151, 20);
		contentPane.add(formattedTextField);
		
		JLabel lblDetalhamento = new JLabel("Detalhamento*");
		lblDetalhamento.setBounds(12, 169, 121, 16);
		contentPane.add(lblDetalhamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 195, 410, 115);
		contentPane.add(scrollPane);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(324, 317, 98, 26);
		contentPane.add(btnSalvar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConsultar.setBounds(324, 13, 98, 26);
		contentPane.add(btnConsultar);
		
		setLocationRelativeTo(null);
	}
}
