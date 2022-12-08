package br.com.devti.abs.view.telas.passageiro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.devti.abs.core.entity.PassageiroEntity;
import br.com.devti.abs.core.service.PassageiroService;
import br.com.devti.abs.core.util.exception.NegocioException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class TelaCadastroPassageiro extends JFrame {

	private JPanel contentPane;
	private JTextField fieldId;
	private JTextField fieldCpf;
	private JTextField fieldIdade;
	private JLabel labelCpfValidacao;
	private JLabel labelTitulo;
	private JTextField fieldLogin;
	private JLabel lblNewLabel;
	private JTextField fieldEmail;
	private JTextField fieldNome;
	private JLabel lblLogin;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JPasswordField fieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPassageiro frame = new TelaCadastroPassageiro();
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
	public TelaCadastroPassageiro() {
		setTitle("Formulário de Passageiro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		labelTitulo = new JLabel("Cadastro de Passageiro");
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		
		fieldId = new JTextField();
		fieldId.setEnabled(false);
		fieldId.setEditable(false);
		fieldId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cpf");
		
		fieldCpf = new JTextField();
		fieldCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Idade");
		
		fieldIdade = new JTextField();
		fieldIdade.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setIcon(new ImageIcon(TelaCadastroPassageiro.class.getResource("/resource/disquete.png")));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(fieldCpf.getText().equals("")) {
					labelCpfValidacao.setText("Cpf não preenchido");
				}else {
				
				
					PassageiroEntity pass = new PassageiroEntity();
					pass.setNome(fieldNome.getText());
					pass.setLogin(fieldLogin.getText());
					pass.setSenha(new String(fieldSenha.getPassword()));
					pass.setEmail(fieldEmail.getText());
					pass.setCpf(fieldCpf.getText());
					pass.setIdade(Integer.parseInt(fieldIdade.getText()));
					
					String msg = null;
					try {
						
						if(fieldId.getText().equals("")) {
							msg = new PassageiroService().salvarPassageiro(pass);
						}else {	
							pass.setCodigo(Long.parseLong(fieldId.getText()));
							msg = new PassageiroService().alterarPassageiro(pass);
						}
						
						limparCampos();
						JOptionPane.showMessageDialog(null, msg);	
						
						TelaListaPassageiro tla = new TelaListaPassageiro();
						tla.setVisible(true);
						
						dispose();
					}catch(NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		labelCpfValidacao = new JLabel("");
		labelCpfValidacao.setForeground(Color.RED);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListaPassageiro tlu = new TelaListaPassageiro();
				tlu.setVisible(true);
				dispose();
			}
		});
		
		fieldLogin = new JTextField();
		fieldLogin.setColumns(10);
		
		lblNewLabel = new JLabel("Nome");
		
		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		
		fieldNome = new JTextField();
		fieldNome.setColumns(10);
		
		lblLogin = new JLabel("Login");
		
		lblEmail = new JLabel("Email");
		
		lblSenha = new JLabel("Senha");
		
		fieldSenha = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSenha))
						.addComponent(lblEmail)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblLogin))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(fieldCpf, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(fieldSenha, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(fieldLogin, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(fieldNome, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(fieldIdade, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(fieldEmail, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(fieldId, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(377)
									.addComponent(labelCpfValidacao))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(150)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addComponent(btnNewButton_1))
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(labelTitulo)))
					.addGap(1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addContainerGap(668, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addComponent(labelCpfValidacao))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(fieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(fieldIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(fieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogin)
						.addComponent(fieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(fieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(fieldCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addGap(198))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(labelTitulo)
					.addContainerGap(472, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void limparCampos() {
		fieldNome.setText("");
		fieldEmail.setText("");
		fieldLogin.setText("");
		fieldId.setText("");
		fieldCpf.setText("");
		fieldSenha.setText("");
		fieldIdade.setText("");
	}
	public void carregarPassageiroPorId(Long codigoPassageiro) {
		
		try {
			PassageiroEntity passageiroEncontrado = new PassageiroService().buscarPassageiroPorId(codigoPassageiro);
			
			if (passageiroEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O passageiro nao foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			}else {
				fieldId.setText("" + passageiroEncontrado.getCodigo());
				fieldNome.setText(passageiroEncontrado.getNome());
				fieldLogin.setText(passageiroEncontrado.getLogin());
				fieldSenha.setText(passageiroEncontrado.getSenha());
				fieldEmail.setText(passageiroEncontrado.getEmail());
				fieldCpf.setText(passageiroEncontrado.getCpf());
				fieldIdade.setText(String.valueOf(passageiroEncontrado.getIdade()));
			}
			
			labelTitulo.setText("Alteração de Passageiro");
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
