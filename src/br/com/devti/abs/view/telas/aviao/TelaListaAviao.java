package br.com.devti.abs.view.telas.aviao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.devti.abs.core.entity.AviaoEntity;
import br.com.devti.abs.core.entity.UsuarioEntity;
import br.com.devti.abs.core.service.AviaoService;
import br.com.devti.abs.core.service.UsuarioService;
import br.com.devti.abs.core.util.exception.NegocioException;
import br.com.devti.abs.view.telas.usuario.TelaCadastroUsuario;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaAviao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<AviaoEntity> avioes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaAviao frame = new TelaListaAviao();
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
	public TelaListaAviao() {
		setTitle("Avião");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AviaoEntity aviaoSelecionado = avioes.get(table.getSelectedRow());
				if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o avião de código: " 
				+ aviaoSelecionado.getNumeroIdentificador()) == JOptionPane.OK_OPTION) {
					
					try {
						new AviaoService().excluirAviao(aviaoSelecionado.getNumeroIdentificador());
						popularTabela();
					} catch (NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
				}
				
			}
		});
		btnExcluir.setEnabled(false);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				AviaoEntity aviaoSelecionado = avioes.get(table.getSelectedRow());
				
				TelaCadastroAviao tca = new TelaCadastroAviao();
				tca.carregarAviaoPorId(aviaoSelecionado.getNumeroIdentificador());
				tca.setVisible(true);
				dispose();
				
			}
		});
		btnEditar.setEnabled(false);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroAviao tca = new TelaCadastroAviao();
				tca.setVisible(true);
				dispose();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 484, Short.MAX_VALUE)
					.addComponent(btnEditar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExcluir)
					.addGap(16))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(91, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//JOptionPane.showMessageDialog(null, "Linha selecionada foi "+ table.getSelectedRow());
//				UsuarioEntity usuario = usuarios.get(table.getSelectedRow());
//				JOptionPane.showMessageDialog(null, "O nome do usuario selecionado foi " + usuario.getNome());
				
				btnExcluir.setEnabled(true);
				btnEditar.setEnabled(true);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Marca", "Base", "Ano"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}
	
	private void popularTabela() {
		try {
			avioes = new AviaoService().listarAviao();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.getDataVector().removeAllElements();
			
			for (AviaoEntity aviaoEntity : avioes) {
				
				model.addRow(new Object[] {aviaoEntity.getNumeroIdentificador(), aviaoEntity.getMarca(), aviaoEntity.getBase(), aviaoEntity.getAnoFabricacao()});
				
			}
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar aviões do banco de dados " + e.getMensagemDeErro());
		}
	}
}
