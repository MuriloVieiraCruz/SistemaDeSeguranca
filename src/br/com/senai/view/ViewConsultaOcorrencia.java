package br.com.senai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewConsultaOcorrencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtFiltro;

	public ViewConsultaOcorrencia() {
		setResizable(false);
		setTitle("Gerenciar Ocorr\u00EAncia - Listagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFiltro = new JLabel("Filtro*");
		lblFiltro.setBounds(12, 57, 55, 16);
		contentPane.add(lblFiltro);
		
		edtFiltro = new JTextField();
		edtFiltro.setBounds(12, 74, 232, 20);
		contentPane.add(edtFiltro);
		edtFiltro.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultados");
		lblResultado.setBounds(12, 107, 69, 16);
		contentPane.add(lblResultado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 136, 410, 96);
		contentPane.add(scrollPane);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(324, 244, 98, 26);
		contentPane.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(214, 245, 98, 26);
		contentPane.add(btnEditar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(256, 71, 98, 26);
		contentPane.add(btnListar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroOcorrencia view = new ViewCadastroOcorrencia();
				view.setVisible(true);
			}
		});
		btnAdicionar.setBounds(324, 13, 98, 26);
		contentPane.add(btnAdicionar);
		
		setLocationRelativeTo(null);
	}
}
