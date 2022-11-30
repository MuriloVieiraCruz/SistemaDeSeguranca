package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroIncidente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtDescricaoCurta;
	private JTextField edtGravidade;

	public ViewCadastroIncidente() {
		setResizable(false);
		setTitle("Gerenciar Incidente - Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescricaoCurta = new JLabel("Descri\u00E7\u00E3o Curta*");
		lblDescricaoCurta.setBounds(12, 60, 112, 16);
		contentPane.add(lblDescricaoCurta);
		
		edtDescricaoCurta = new JTextField();
		edtDescricaoCurta.setBounds(12, 78, 294, 20);
		contentPane.add(edtDescricaoCurta);
		edtDescricaoCurta.setColumns(10);
		
		JLabel lblGravidade = new JLabel("Gravidade*");
		lblGravidade.setBounds(318, 60, 72, 16);
		contentPane.add(lblGravidade);
		
		edtGravidade = new JTextField();
		edtGravidade.setBounds(318, 78, 91, 20);
		contentPane.add(edtGravidade);
		edtGravidade.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConsultar.setBounds(311, 21, 98, 26);
		contentPane.add(btnConsultar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(311, 111, 98, 26);
		contentPane.add(btnSalvar);
		setLocationRelativeTo(null);
	}

}
