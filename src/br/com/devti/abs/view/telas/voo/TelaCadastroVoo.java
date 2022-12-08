package br.com.devti.abs.view.telas.voo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.devti.abs.core.entity.AviaoEntity;
import br.com.devti.abs.core.entity.VooEntity;
import br.com.devti.abs.core.service.AviaoService;
import br.com.devti.abs.core.service.VooService;
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

public class TelaCadastroVoo extends JFrame {

	private JPanel contentPane;
	private JTextField fieldNumero;
	private JTextField fieldData;
	private JTextField fieldDestino;
	private JLabel labelDataValidacao;
	private JLabel labelTitulo;
	private JTextField fieldOrigem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVoo frame = new TelaCadastroVoo();
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
	public TelaCadastroVoo() {
		setTitle("Formulário de Voo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		labelTitulo = new JLabel("Cadastro de Voo");
		
		JLabel lblNewLabel_1 = new JLabel("Número");
		
		fieldNumero = new JTextField();
		fieldNumero.setEnabled(false);
		fieldNumero.setEditable(false);
		fieldNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data");
		
		fieldData = new JTextField();
		fieldData.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Destino");
		
		fieldDestino = new JTextField();
		fieldDestino.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Origem");
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setIcon(new ImageIcon(TelaCadastroVoo.class.getResource("/resource/disquete.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fieldData.getText().equals("")) {
					labelDataValidacao.setText("Data não preenchida");
				}else {
				
				
					VooEntity voo = new VooEntity();
					voo.setData(fieldData.getText());
					voo.setDestino(fieldDestino.getText());
					voo.setOrigem(fieldOrigem.getText());
					
					String msg = null;
					try {
						
						if(fieldNumero.getText().equals("")) {
							msg = new VooService().salvarVoo(voo);
						}else {	
							voo.setNumeroVoo(fieldNumero.getText());
							msg = new VooService().alterarVoo(voo);
						}
						
						limparCampos();
						JOptionPane.showMessageDialog(null, msg);	
						
						TelaListaVoo tlv = new TelaListaVoo();
						tlv.setVisible(true);
						
						dispose();
					}catch(NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		labelDataValidacao = new JLabel("");
		labelDataValidacao.setForeground(Color.RED);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListaVoo tlv = new TelaListaVoo();
				tlv.setVisible(true);
				dispose();
			}
		});
		
		fieldOrigem = new JTextField();
		fieldOrigem.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(labelTitulo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4))
							.addGap(147)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(fieldDestino, Alignment.LEADING)
								.addComponent(fieldNumero, Alignment.LEADING)
								.addComponent(fieldData, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addComponent(fieldOrigem, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
							.addComponent(labelDataValidacao)))
					.addGap(250))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(358, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(175))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(380, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(193))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addContainerGap(588, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelTitulo)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(fieldNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(fieldData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelDataValidacao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldOrigem, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(fieldDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void limparCampos() {
		fieldNumero.setText("");
		fieldData.setText("");
		fieldDestino.setText("");
		fieldOrigem.setText("");
	}
	public void carregarVooPorNum(String numVoo) {
		
		try {
			VooEntity vooEncontrado = new VooService().buscarVooPorNum(numVoo);
			
			if (vooEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O voo não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			}else {
				fieldNumero.setText("" + vooEncontrado.getNumeroVoo());
				fieldData.setText(vooEncontrado.getData());
				fieldDestino.setText(vooEncontrado.getDestino());
				fieldOrigem.setText(vooEncontrado.getOrigem());
			}
			
			labelTitulo.setText("Alteração de Voo");
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
