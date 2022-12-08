package br.com.devti.abs.view.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import br.com.devti.abs.core.entity.GrupoUsuarioEntity;
import br.com.devti.abs.core.service.GrupoUsuarioService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroGrupoUsuario {

	private JFrame frame;
	private JTextField fieldNomeGrupo;
	private JTextField fieldAcesso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroGrupoUsuario window = new TelaCadastroGrupoUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroGrupoUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fieldNomeGrupo = new JTextField();
		fieldNomeGrupo.setColumns(10);
		
		JLabel LabelGrupo = new JLabel("Nome do Grupo");
		
		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(fieldNomeGrupo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nome não preenchido");
				}
				if(fieldAcesso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Acesso preenchido");
				}
				
				
				else {
				
				
					GrupoUsuarioEntity gu = new GrupoUsuarioEntity();
					gu.setNomeGrupo(fieldNomeGrupo.getText());
					gu.setAcesso(fieldAcesso.getText());
					
					try {
						String msg = new GrupoUsuarioService().salvarGrupoUsuario(gu);
						limparCampos();
						JOptionPane.showMessageDialog(null, msg);					
					}catch(Exception e1) {
					}
				}
				
			}
		});
		
		JLabel LabelAcesso = new JLabel("Acesso do Grupo");
		
		fieldAcesso = new JTextField();
		fieldAcesso.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(botaoSalvar)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(LabelGrupo)
								.addComponent(LabelAcesso, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldNomeGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldAcesso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(199))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(LabelGrupo)
							.addGap(24)
							.addComponent(LabelAcesso))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(fieldNomeGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(fieldAcesso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(51)
					.addComponent(botaoSalvar)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private void limparCampos() {
		fieldNomeGrupo.setText("");
		fieldAcesso.setText("");
	}
}
