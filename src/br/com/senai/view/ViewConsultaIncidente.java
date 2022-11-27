package br.com.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewConsultaIncidente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtFiltro;

	public ViewConsultaIncidente() {
		setTitle("Gerenciar Inicidentes - Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFiltro = new JLabel("Filtro*");
		lblFiltro.setBounds(12, 41, 55, 16);
		contentPane.add(lblFiltro);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(12, 63, 247, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(271, 60, 98, 26);
		contentPane.add(btnListar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroIncidente view = new ViewCadastroIncidente();
				view.setVisible(true);
			}
		});
		btnAdicionar.setBounds(324, 13, 98, 26);
		contentPane.add(btnAdicionar);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(12, 89, 74, 16);
		contentPane.add(lblResultados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 114, 410, 121);
		contentPane.add(scrollPane);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(324, 248, 98, 26);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(214, 248, 98, 26);
		contentPane.add(btnEditar);
		setLocationRelativeTo(null);
	}
}
