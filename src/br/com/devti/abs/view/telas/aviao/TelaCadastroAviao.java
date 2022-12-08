package br.com.devti.abs.view.telas.aviao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.devti.abs.core.entity.AviaoEntity;
import br.com.devti.abs.core.service.AviaoService;
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

public class TelaCadastroAviao extends JFrame {

	private JPanel contentPane;
	private JTextField fieldId;
	private JTextField fieldMarca;
	private JTextField fieldBase;
	private JLabel labelMarcaValidacao;
	private JLabel labelTitulo;
	private JTextField fieldAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAviao frame = new TelaCadastroAviao();
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
	public TelaCadastroAviao() {
		setTitle("Formulário de Avião");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		labelTitulo = new JLabel("Cadastro de Avião");
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		
		fieldId = new JTextField();
		fieldId.setEnabled(false);
		fieldId.setEditable(false);
		fieldId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Marca");
		
		fieldMarca = new JTextField();
		fieldMarca.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Base");
		
		fieldBase = new JTextField();
		fieldBase.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ano de Fabricação");
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setIcon(new ImageIcon(TelaCadastroAviao.class.getResource("/resource/disquete.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fieldMarca.getText().equals("")) {
					labelMarcaValidacao.setText("Marca não preenchida");
				}else {
				
				
					AviaoEntity avi = new AviaoEntity();
					avi.setMarca(fieldMarca.getText());
					avi.setBase(fieldBase.getText());
					avi.setAnoFabricacao(fieldAno.getText());
					
					String msg = null;
					try {
						
						if(fieldId.getText().equals("")) {
							msg = new AviaoService().salvarAviao(avi);
						}else {	
							avi.setNumeroIdentificador(fieldId.getText());
							msg = new AviaoService().alterarAviao(avi);
						}
						
						limparCampos();
						JOptionPane.showMessageDialog(null, msg);	
						
						TelaListaAviao tla = new TelaListaAviao();
						tla.setVisible(true);
						
						dispose();
					}catch(NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		labelMarcaValidacao = new JLabel("");
		labelMarcaValidacao.setForeground(Color.RED);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListaAviao tlu = new TelaListaAviao();
				tlu.setVisible(true);
				dispose();
			}
		});
		
		fieldAno = new JTextField();
		fieldAno.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(fieldBase)
									.addComponent(fieldMarca)
									.addComponent(fieldId))
								.addComponent(fieldAno, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelMarcaValidacao))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(labelTitulo)))
					.addContainerGap(241, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(258, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(175))
				.addGroup(gl_contentPane.createSequentialGroup()
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
						.addComponent(fieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(fieldMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelMarcaValidacao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(fieldBase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(fieldAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void limparCampos() {
		fieldId.setText("");
		fieldMarca.setText("");
		fieldBase.setText("");
		fieldAno.setText("");
	}
	public void carregarAviaoPorId(String IdAviao) {
		
		try {
			AviaoEntity aviaoEncontrado = new AviaoService().buscarAviaoPorId(IdAviao);
			
			if (aviaoEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O aviao nao foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			}else {
				fieldId.setText("" + aviaoEncontrado.getNumeroIdentificador());
				fieldMarca.setText(aviaoEncontrado.getMarca());
				fieldBase.setText(aviaoEncontrado.getBase());
				fieldAno.setText(aviaoEncontrado.getAnoFabricacao());
			}
			
			labelTitulo.setText("Alteração de Avião");
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
