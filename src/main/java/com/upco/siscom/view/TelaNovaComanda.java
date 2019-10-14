/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.view;

import com.upco.siscom.model.bean.Comanda;
import com.upco.siscom.model.bean.Produto;
import com.upco.siscom.model.dao.ComandaDAO;
import com.upco.siscom.model.dao.ProdutoDAO;
import com.upco.siscom.util.DateTimeUpdater;
import com.upco.siscom.util.PrinterUtils;
import com.upco.siscom.util.StringUtils;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.print.PrintException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author higor
 */
public class TelaNovaComanda extends javax.swing.JFrame {
    
    private static final String DEFAULT_COD = "000000";
    private static final String DEFAULT_QTD = "1";
    
    // Armazena todos os produtos salvos na DB
    private List<Produto> produtosDb;
    
    // Produtos adicionados à comanda
    private Map<Produto, Integer> produtosComanda;
    
    // Valor total da comanda
    double valorTotal;
    DecimalFormat valorTotalFmt;
    
    /**
     * Creates new form NewOrderScreen
     */
    public TelaNovaComanda() {
        // Inicializa a lista de produtos
        produtosComanda = new LinkedHashMap<>();
        
        // Inicializa o formator do valor total
         valorTotalFmt = new DecimalFormat("#0.00");
        
        // Carrega os produtos da db
        carregaProdutos();
        
        // Inicializa todos os componentes
        initComponents();
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRoot = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        spProdutosComanda = new javax.swing.JScrollPane();
        tbProdutosComanda = new javax.swing.JTable();
        lbQtd = new javax.swing.JLabel();
        tfProdutoCod = new javax.swing.JTextField();
        btEmitirComanda = new javax.swing.JButton();
        lbProd = new javax.swing.JLabel();
        tfProdutoQtd = new javax.swing.JTextField();
        lbCod = new javax.swing.JLabel();
        btAddProduto = new javax.swing.JButton();
        pnAtalhos = new javax.swing.JPanel();
        lbAtalhoNovaComanda = new javax.swing.JLabel();
        lbAtalhoConsultarComanda = new javax.swing.JLabel();
        lbAtalhoEmitirComanda = new javax.swing.JLabel();
        lbAtalhoNovoProduto = new javax.swing.JLabel();
        lbAtalhoConsultarProduto = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        cbProduto = new AutoCompleteComboBox(new ProdutoSearchable(produtosDb));
        lbTotal = new javax.swing.JLabel();
        mbMenus = new javax.swing.JMenuBar();
        mnComandas = new javax.swing.JMenu();
        miNovaComanda = new javax.swing.JMenuItem();
        miEditarComanda = new javax.swing.JMenuItem();
        miExcluirComanda = new javax.swing.JMenuItem();
        miConsultarComanda = new javax.swing.JMenuItem();
        mnProdutos = new javax.swing.JMenu();
        miNovoProduto = new javax.swing.JMenuItem();
        miEditarProduto = new javax.swing.JMenuItem();
        miExcluirProduto = new javax.swing.JMenuItem();
        miConsultarProduto = new javax.swing.JMenuItem();
        mnSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SisCom - 1000GRAU");
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("fmNovaComanda"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        pnRoot.setBackground(new java.awt.Color(254, 139, 0));
        pnRoot.setMaximumSize(new java.awt.Dimension(1280, 720));
        pnRoot.setMinimumSize(new java.awt.Dimension(1280, 720));
        pnRoot.setName("pnRoot"); // NOI18N
        pnRoot.setPreferredSize(new java.awt.Dimension(1280, 720));

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/upco/siscom/icones/Logo.png"))); // NOI18N

        tbProdutosComanda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbProdutosComanda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Porção", "Valor Unit.", "Qtd", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProdutosComanda.setEnabled(false);
        tbProdutosComanda.setIntercellSpacing(new java.awt.Dimension(20, 1));
        tbProdutosComanda.setRowHeight(30);
        tbProdutosComanda.setShowGrid(false);
        tbProdutosComanda.getTableHeader().setResizingAllowed(false);
        tbProdutosComanda.getTableHeader().setReorderingAllowed(false);
        tbProdutosComanda.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 14));
        tbProdutosComanda.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));
        spProdutosComanda.setViewportView(tbProdutosComanda);
        if (tbProdutosComanda.getColumnModel().getColumnCount() > 0) {
            tbProdutosComanda.getColumnModel().getColumn(0).setResizable(false);
            tbProdutosComanda.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbProdutosComanda.getColumnModel().getColumn(1).setResizable(false);
            tbProdutosComanda.getColumnModel().getColumn(1).setPreferredWidth(700);
            tbProdutosComanda.getColumnModel().getColumn(2).setResizable(false);
            tbProdutosComanda.getColumnModel().getColumn(2).setPreferredWidth(10);
            tbProdutosComanda.getColumnModel().getColumn(3).setResizable(false);
            tbProdutosComanda.getColumnModel().getColumn(3).setPreferredWidth(5);
            tbProdutosComanda.getColumnModel().getColumn(4).setResizable(false);
            tbProdutosComanda.getColumnModel().getColumn(4).setPreferredWidth(5);
            tbProdutosComanda.getColumnModel().getColumn(5).setResizable(false);
            tbProdutosComanda.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        lbQtd.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbQtd.setText("QTD:");

        tfProdutoCod.setDocument(new TextFieldLimit(6));
        tfProdutoCod.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfProdutoCod.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        tfProdutoCod.setText("000000");
        tfProdutoCod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfProdutoCodFocusGained(evt);
            }
        });
        tfProdutoCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfProdutoCodKeyPressed(evt);
            }
        });

        btEmitirComanda.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btEmitirComanda.setText("EMITIR");
        btEmitirComanda.setFocusPainted(false);
        btEmitirComanda.setFocusable(false);
        Action emiteComanda = new AbstractAction("Emite") {
            @Override
            public void actionPerformed(ActionEvent e) {
                emiteComanda();
            }
        };
        emiteComanda.putValue(
            Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control E")
        );
        btEmitirComanda.getActionMap().put("emiteComanda", emiteComanda);
        btEmitirComanda.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            (KeyStroke) emiteComanda.getValue(Action.ACCELERATOR_KEY), "emiteComanda"
        );
        btEmitirComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEmitirComandaMouseClicked(evt);
            }
        });

        lbProd.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbProd.setText("PROD:");

        tfProdutoQtd.setDocument(new TextFieldLimit(6));
        tfProdutoQtd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfProdutoQtd.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        tfProdutoQtd.setText("1");
        tfProdutoQtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfProdutoQtdFocusGained(evt);
            }
        });
        tfProdutoQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfProdutoQtdKeyPressed(evt);
            }
        });

        lbCod.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbCod.setText("COD:");

        btAddProduto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btAddProduto.setText("ADICIONAR");
        btAddProduto.setFocusPainted(false);
        btAddProduto.setFocusable(false);
        btAddProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddProdutoMouseClicked(evt);
            }
        });

        lbAtalhoNovaComanda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAtalhoNovaComanda.setText("CTRL+N: Nova Comanda");

        lbAtalhoConsultarComanda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAtalhoConsultarComanda.setText("CTRL+C: Consulta Comanda");

        lbAtalhoEmitirComanda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAtalhoEmitirComanda.setText("CTRL+E: Emite");

        lbAtalhoNovoProduto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAtalhoNovoProduto.setText("CTRL+O: Novo Produto");

        lbAtalhoConsultarProduto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAtalhoConsultarProduto.setText("CTRL+P: Consulta Produto");

        javax.swing.GroupLayout pnAtalhosLayout = new javax.swing.GroupLayout(pnAtalhos);
        pnAtalhos.setLayout(pnAtalhosLayout);
        pnAtalhosLayout.setHorizontalGroup(
            pnAtalhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAtalhosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbAtalhoNovaComanda)
                .addGap(45, 45, 45)
                .addComponent(lbAtalhoConsultarComanda)
                .addGap(44, 44, 44)
                .addComponent(lbAtalhoNovoProduto)
                .addGap(45, 45, 45)
                .addComponent(lbAtalhoConsultarProduto)
                .addGap(45, 45, 45)
                .addComponent(lbAtalhoEmitirComanda)
                .addGap(19, 19, 19))
        );
        pnAtalhosLayout.setVerticalGroup(
            pnAtalhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAtalhosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnAtalhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAtalhoEmitirComanda)
                    .addComponent(lbAtalhoNovaComanda)
                    .addComponent(lbAtalhoConsultarComanda)
                    .addComponent(lbAtalhoNovoProduto)
                    .addComponent(lbAtalhoConsultarProduto))
                .addContainerGap())
        );

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbHora.setText("23:58");

        lbData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbData.setText("5 de outubro de 2019");

        cbProduto.setEditable(true);
        cbProduto.setFocusTraversalPolicyProvider(true);
        cbProduto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cbProduto.setMinimumSize(new java.awt.Dimension(30, 35));
        cbProduto.setPreferredSize(new java.awt.Dimension(30, 35));
        cbProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProdutoItemStateChanged(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Tahoma", 1, 62)); // NOI18N
        lbTotal.setText("0,00");

        javax.swing.GroupLayout pnRootLayout = new javax.swing.GroupLayout(pnRoot);
        pnRoot.setLayout(pnRootLayout);
        pnRootLayout.setHorizontalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spProdutosComanda)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRootLayout.createSequentialGroup()
                        .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRootLayout.createSequentialGroup()
                                .addComponent(lbCod)
                                .addGap(10, 10, 10)
                                .addComponent(tfProdutoCod, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbProd)
                                .addGap(10, 10, 10)
                                .addComponent(cbProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lbQtd)
                                .addGap(10, 10, 10)
                                .addComponent(tfProdutoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRootLayout.createSequentialGroup()
                                .addComponent(lbLogo)
                                .addGap(18, 18, 18)
                                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbHora)
                                    .addComponent(lbData))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbTotal)))
                        .addGap(18, 18, 18)
                        .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btAddProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(btEmitirComanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
            .addComponent(pnAtalhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnRootLayout.setVerticalGroup(
            pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEmitirComanda, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lbLogo)
                    .addGroup(pnRootLayout.createSequentialGroup()
                        .addComponent(lbHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbData)
                        .addGap(13, 13, 13))
                    .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spProdutosComanda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbProd)
                        .addComponent(tfProdutoCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCod)
                        .addComponent(lbQtd)
                        .addComponent(tfProdutoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAddProduto))
                    .addComponent(cbProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnAtalhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mbMenus.setBackground(new java.awt.Color(254, 139, 0));

        mnComandas.setText("Comandas");
        mnComandas.setName("mnComandas"); // NOI18N

        miNovaComanda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        miNovaComanda.setText("Nova");
        miNovaComanda.setName("miNovaComanda"); // NOI18N
        miNovaComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovaComandaActionPerformed(evt);
            }
        });
        mnComandas.add(miNovaComanda);

        miEditarComanda.setText("Editar");
        mnComandas.add(miEditarComanda);

        miExcluirComanda.setText("Excluir");
        mnComandas.add(miExcluirComanda);

        miConsultarComanda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        miConsultarComanda.setText("Consultar");
        mnComandas.add(miConsultarComanda);

        mbMenus.add(mnComandas);

        mnProdutos.setText("Produtos");
        mnProdutos.setName("mnOrders"); // NOI18N

        miNovoProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        miNovoProduto.setText("Novo");
        miNovoProduto.setName("miNewOrder"); // NOI18N
        mnProdutos.add(miNovoProduto);

        miEditarProduto.setText("Editar");
        mnProdutos.add(miEditarProduto);

        miExcluirProduto.setText("Excluir");
        mnProdutos.add(miExcluirProduto);

        miConsultarProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        miConsultarProduto.setText("Consultar");
        mnProdutos.add(miConsultarProduto);

        mbMenus.add(mnProdutos);

        mnSobre.setText("Sobre");
        mbMenus.add(mnSobre);

        setJMenuBar(mbMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 712, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(1296, 770));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEmitirComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEmitirComandaMouseClicked
        emiteComanda();
    }//GEN-LAST:event_btEmitirComandaMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Seta a data e hora do sistema
        DateTimeUpdater.start(lbData, lbHora);
        
        // Inicializa o campo do código com o valor padrão
        tfProdutoCod.setText(DEFAULT_COD);
    }//GEN-LAST:event_formWindowActivated

    private void tfProdutoCodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProdutoCodFocusGained
        // Seleciona o texto assim que ganhar foco
        tfProdutoCod.selectAll();
    }//GEN-LAST:event_tfProdutoCodFocusGained

    private void tfProdutoQtdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProdutoQtdFocusGained
        // Seleciona o texto assim que ganhar foco
        tfProdutoQtd.selectAll();
    }//GEN-LAST:event_tfProdutoQtdFocusGained

    private void btAddProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddProdutoMouseClicked
        Produto produto = (Produto)cbProduto.getSelectedItem();
        int qtd = Integer.parseInt(tfProdutoQtd.getText());
        adicionaProduto(produto, qtd);
    }//GEN-LAST:event_btAddProdutoMouseClicked

    private void tfProdutoCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoCodKeyPressed
        // Se ENTER for pressionado, procura o produto com o código especificado
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String codigo = tfProdutoCod.getText();
            Produto p = encontraProduto(codigo);
            if (p != null) {
                // Seleciona o produto
                cbProduto.setSelectedItem(p);
                
                // Faz com que o TextField da qtd receba foco
                SwingUtilities.invokeLater(() -> {
                    tfProdutoQtd.requestFocusInWindow();
                });
            } else {
                cbProduto.setSelectedItem(null);
            }
        }
    }//GEN-LAST:event_tfProdutoCodKeyPressed

    private void tfProdutoQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoQtdKeyPressed
        // Se ENTER for pressionado, adiciona o produto à tabela
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Produto produto = (Produto)cbProduto.getSelectedItem();
            int qtd = Integer.parseInt(tfProdutoQtd.getText());
            adicionaProduto(produto, qtd);
        }
    }//GEN-LAST:event_tfProdutoQtdKeyPressed

    private void cbProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProdutoItemStateChanged
        if (cbProduto.getSelectedItem() instanceof Produto) {
            Produto produto = (Produto)cbProduto.getSelectedItem();
            tfProdutoCod.setText(produto.getCodigo());
        }
    }//GEN-LAST:event_cbProdutoItemStateChanged

    private void miNovaComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovaComandaActionPerformed
        novaComanda();
    }//GEN-LAST:event_miNovaComandaActionPerformed

    private void carregaProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        produtosDb = dao.read();
    }
    
    private void atualizaTBProdutos() {
        DefaultTableModel model = (DefaultTableModel)tbProdutosComanda.getModel();
        model.setNumRows(0);
        
        produtosComanda.forEach((p, qtd) -> {
            model.addRow(new Object[] {
                p.getCodigo(),
                p.getDescricao(),
                p.getPorcao(),
                p.getPreco(),
                qtd,
                p.getPreco() * qtd
            });
        });
    }
    
    private void atualizaTotal() {
        valorTotal = 0.0;
        
        // Calcula o valor total da comanda
        produtosComanda.forEach((p, qtd) -> {
            valorTotal += p.getPreco() * qtd;
        });
        
        // Formata e exibe o valor
        lbTotal.setText(valorTotalFmt.format(valorTotal));
    }
    
    private void resetaCamposProduto() {
        tfProdutoCod.setText(DEFAULT_COD);
        tfProdutoQtd.setText(DEFAULT_QTD);
        cbProduto.setSelectedItem(null);
        SwingUtilities.invokeLater(() -> {
            tfProdutoCod.requestFocus();
        });
    }
    
    private Produto encontraProduto(String codigo) {
        // Verifica se o codigo é válido
        if (codigo != null && !codigo.isEmpty()) {
            for (Produto p : produtosDb) {
                // Procura pelo código nos produtos, e se encontrar, retorna
                if (codigo.equals(p.getCodigo())) {
                    // Produto encontrado
                    return p;
                }
            }
        } else {
            // Código inválido, notifica o usuário
            JOptionPane.showMessageDialog(null, "Código inválido!");
        }
        
        // Produto não encontrado, retorna nulo
        return null;
    }
    
    private void adicionaProduto(Produto produto, int qtd) {
        // Só adiciona o produto se a qtd for maior que 0
        if (qtd > 0) {
            if (produto != null) {
                // Verifica se o produto já está na comanda
                if (produtosComanda.containsKey(produto)) {
                    // Adiciona a nova qtd aos que já estão na comanda
                    qtd += produtosComanda.get(produto);
                    produtosComanda.replace(produto, qtd);
                } else {
                    // Caso contrário, adiciona o produto à comanda
                    produtosComanda.put(produto, qtd);   
                }

                // Atualiza a tabela com o produto
                atualizaTBProdutos();
                
                // Atualiza o valor total da comanda
                atualizaTotal();
                
                // Reseta os campos referentes ao produto
                resetaCamposProduto();
            }
        } else {
            // Se qtd for menor que 1, notifica o usuário
            JOptionPane.showMessageDialog(
                null, "Quantidade inválida!\nDigite uma quantidade acima de 1."
            );
        }
    }
    
    private void emiteComanda() {
        // Tem de haver pelo menos um produto na comanda
        if (produtosComanda.size() > 0) {
            ComandaDAO dao = new ComandaDAO();
            
            // Salva a comanda
            Comanda comanda = new Comanda(produtosComanda);
            dao.create(comanda);

            // Se tudo der certo, imprime a comanda
            imprimeComanda();
            
            int in = JOptionPane.showConfirmDialog(
                null,
                "Retire a comanda e pressione ENTER",
                "Imprimir segunda via",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null
            );
            
            if (in == JOptionPane.OK_OPTION) {
                // Imprime a segunda via
                imprimeComanda();
            }
            
            // Reseta o estado da tela
            novaComanda();
        } else {
            JOptionPane.showMessageDialog(
                null, "A comanda precisa ter pelo menos um produto!"
            );
        }
    }
    
    // TODO: Desacoplar código!
    private void imprimeComanda() {
        var wrapper = new Object() { String str = ""; };
        
        byte[] SEXP = { 0x1B, 'W', '1' };
        byte[] EEXP = { 0x1B, 'W', '0' };
        byte[] SBOL = { 0x1B, 'E' };
        byte[] EBOL = { 0x1B, 'F' };
        
        wrapper.str = "   SISCOM - 1000GRAU RESTAURANTE E LANCHONETE   \n\r" + 
                      "------------------------------------------------\n\r" +
                      new String(SBOL) + new String(SEXP) +
                      "        COMANDA         \n\r\n\r" +
                      new String(EEXP) + new String(EBOL) +
                      "COD.      QTD.    DESCRICAO                     \n\r" +
                      "------------------------------------------------\n\r";
        
        String dataHora = lbData.getText() + " " + lbHora.getText();
        
        produtosComanda.forEach((p, qtd) -> {
            wrapper.str += String.format("%6s", p.getCodigo()) + "    " +
                           String.format("%-7s", qtd) + " " +
                           StringUtils.deAccent(p.getDescricao()) + "\n\r";
        });
        
        wrapper.str += "------------------------------------------------\n\r" +
                       new String(SBOL) + "TOTAL" + new String(EBOL) +
                       String.format("%43s", valorTotalFmt.format(valorTotal)) +
                       "------------------------------------------------\n\r" +
                       dataHora + "\n\r" +
                       "UpCO SISCOM v1.0\n\r" +
                       "\n\r\n\r\f\f";
        
        try {
            PrinterUtils.print(wrapper.str);
        } catch (PrintException ex) {
            JOptionPane.showMessageDialog(
                null, "Erro ao imprimir comanda!", "Erro", JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                null, "Erro ao encontrar impressora!", "Erro", JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
        }
    }
    
    private void novaComanda() {
        produtosComanda.clear();
        atualizaTotal();
        atualizaTBProdutos();
        resetaCamposProduto();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaNovaComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovaComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovaComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovaComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovaComanda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddProduto;
    private javax.swing.JButton btEmitirComanda;
    private com.upco.siscom.view.AutoCompleteComboBox cbProduto;
    private javax.swing.JLabel lbAtalhoConsultarComanda;
    private javax.swing.JLabel lbAtalhoConsultarProduto;
    private javax.swing.JLabel lbAtalhoEmitirComanda;
    private javax.swing.JLabel lbAtalhoNovaComanda;
    private javax.swing.JLabel lbAtalhoNovoProduto;
    private javax.swing.JLabel lbCod;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbProd;
    private javax.swing.JLabel lbQtd;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JMenuBar mbMenus;
    private javax.swing.JMenuItem miConsultarComanda;
    private javax.swing.JMenuItem miConsultarProduto;
    private javax.swing.JMenuItem miEditarComanda;
    private javax.swing.JMenuItem miEditarProduto;
    private javax.swing.JMenuItem miExcluirComanda;
    private javax.swing.JMenuItem miExcluirProduto;
    private javax.swing.JMenuItem miNovaComanda;
    private javax.swing.JMenuItem miNovoProduto;
    private javax.swing.JMenu mnComandas;
    private javax.swing.JMenu mnProdutos;
    private javax.swing.JMenu mnSobre;
    private javax.swing.JPanel pnAtalhos;
    private javax.swing.JPanel pnRoot;
    private javax.swing.JScrollPane spProdutosComanda;
    private javax.swing.JTable tbProdutosComanda;
    private javax.swing.JTextField tfProdutoCod;
    private javax.swing.JTextField tfProdutoQtd;
    // End of variables declaration//GEN-END:variables
}
