package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ViewConsultaEnvolvido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtFiltro;

	public ViewConsultaEnvolvido() {
		setTitle("Gerenciar Envolvido - Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFiltro = new JLabel("Filtro*");
		lblFiltro.setBounds(12, 54, 55, 16);
		contentPane.add(lblFiltro);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(12, 72, 255, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(279, 69, 98, 26);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 104, 410, 109);
		contentPane.add(scrollPane);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(324, 13, 98, 26);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(324, 222, 98, 26);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(214, 222, 98, 26);
		contentPane.add(btnEditar);
		
		setLocationRelativeTo(null);
		
	}
}
