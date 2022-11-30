package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroEnvolvido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtNomeCompleto;
	private JTextField edtDocumento;

	public ViewCadastroEnvolvido() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gerenciar Envolvido - Cadastro");
		setBounds(100, 100, 450, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo*");
		lblNomeCompleto.setBounds(12, 56, 107, 16);
		contentPane.add(lblNomeCompleto);
		
		edtNomeCompleto = new JTextField();
		edtNomeCompleto.setBounds(12, 74, 410, 20);
		contentPane.add(edtNomeCompleto);
		edtNomeCompleto.setColumns(10);
		
		JLabel lblDocumento = new JLabel("Documento*");
		lblDocumento.setBounds(12, 107, 78, 16);
		contentPane.add(lblDocumento);
		
		edtDocumento = new JTextField();
		edtDocumento.setBounds(12, 124, 168, 20);
		contentPane.add(edtDocumento);
		edtDocumento.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(324, 147, 98, 26);
		contentPane.add(btnSalvar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConsultar.setBounds(324, 23, 98, 26);
		contentPane.add(btnConsultar);
		
		setLocationRelativeTo(null);
		
	}
}
