package br.com.devti.abs.view.telas.usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.devti.abs.core.entity.UsuarioEntity;
import br.com.devti.abs.core.service.UsuarioService;
import br.com.devti.abs.core.util.exception.NegocioException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField fieldCodigo;
	private JTextField fieldNome;
	private JTextField fieldLogin;
	private JTextField fieldEmail;
	private JPasswordField fieldSenha;
	private JLabel labelNomeValidacao;
	private JLabel labelTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setTitle("Formulário de Usuário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		labelTitulo = new JLabel("Cadastro de Usuário");
		
		JLabel lblNewLabel_1 = new JLabel("Código");
		
		fieldCodigo = new JTextField();
		fieldCodigo.setEnabled(false);
		fieldCodigo.setEditable(false);
		fieldCodigo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		
		fieldNome = new JTextField();
		fieldNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		
		fieldLogin = new JTextField();
		fieldLogin.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		
		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/resource/disquete.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fieldNome.getText().equals("")) {
					labelNomeValidacao.setText("Nome não preenchido");
				}else {
				
				
					UsuarioEntity usu = new UsuarioEntity();
					usu.setNome(fieldNome.getText());
					usu.setLogin(fieldLogin.getText());
					usu.setSenha(new String(fieldSenha.getPassword()));
					usu.setEmail(fieldEmail.getText());
					
					String msg = null;
					try {
						
						if(fieldCodigo.getText().equals("")) {
							msg = new UsuarioService().salvarUsuario(usu);
						}else {	
							usu.setCodigo(Long.parseLong(fieldCodigo.getText()));
							msg = new UsuarioService().alterarUsuario(usu);
						}
						
						limparCampos();
						JOptionPane.showMessageDialog(null, msg);	
						
						TelaListaUsuario tlu = new TelaListaUsuario();
						tlu.setVisible(true);
						
						dispose();
					}catch(NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		fieldSenha = new JPasswordField();
		
		labelNomeValidacao = new JLabel("");
		labelNomeValidacao.setForeground(Color.RED);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListaUsuario tlu = new TelaListaUsuario();
				tlu.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(fieldEmail)
								.addComponent(fieldLogin)
								.addComponent(fieldNome)
								.addComponent(fieldCodigo)
								.addComponent(fieldSenha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelNomeValidacao))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(labelTitulo)))
					.addContainerGap(212, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(258, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(175))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(280, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(193))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelTitulo)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(fieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(fieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelNomeValidacao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(fieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(fieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void limparCampos() {
		fieldCodigo.setText("");
		fieldNome.setText("");
		fieldLogin.setText("");
		fieldSenha.setText("");
		fieldEmail.setText("");
	}
	public void carregarUsuarioPorId(Long codigoUsuario) {
		
		try {
			UsuarioEntity usuarioEncontrado = new UsuarioService().buscarUsuarioPorId(codigoUsuario);
			
			if (usuarioEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O usuario nao foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			}else {
				fieldCodigo.setText("" + usuarioEncontrado.getCodigo());
				fieldNome.setText(usuarioEncontrado.getNome());
				fieldLogin.setText(usuarioEncontrado.getLogin());
				fieldSenha.setText(usuarioEncontrado.getSenha());
				fieldEmail.setText(usuarioEncontrado.getEmail());
			}
			
			labelTitulo.setText("Alteração de Usuário");
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
