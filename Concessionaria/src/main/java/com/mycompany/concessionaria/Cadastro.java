package com.mycompany.concessionaria;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class Cadastro extends javax.swing.JFrame{
    int ibt = 0;
    int ica;
    int icl;
    String modo;
    String modoclie;
    String modovend;
    ArrayList<Carro> ListaCar;
    ArrayList<Vendedor> ListaVend;
    ArrayList<Cliente> ListaClie;
    
    public void LoadTableCar(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Marca","Modelo","Ano","Quilometragem","Preco"},0);
        for(int i=0;i<ListaCar.size();i++){
            Object linha[] = new Object[]{ListaCar.get(i).getMarca(),
                                          ListaCar.get(i).getModelo(),
                                          ListaCar.get(i).getAno(),
                                          ListaCar.get(i).getQuilometragem(),
                                          ListaCar.get(i).getPreco(),
                                          ListaCar.get(i).getPotencia()};
    
            modelo.addRow(linha);
        }
        tbl_carro.setModel(modelo);
    }
    public void LoadTableClie(){
        DefaultTableModel md = new DefaultTableModel(new Object[]{"Nome","CPF","Dia","Mes", "Ano","Telefone","Carro Comprado"},0);
        for(int i=0;i<ListaClie.size();i++){
            Object line[] = new Object[]{ListaClie.get(i).getNome(),
                                          ListaClie.get(i).getCpf(),
                                          ListaClie.get(i).getDiaa(),
                                          ListaClie.get(i).getMess(),
                                          ListaClie.get(i).getAnoo(),
                                          ListaClie.get(i).getTelefone(), 
                                          ListaClie.get(i).getCarroComprado()};
            
            md.addRow(line);
        }
        tbl_clie.setModel(md);
        tbl_clie.getColumnModel().getColumn(2).setPreferredWidth(15);
        tbl_clie.getColumnModel().getColumn(3).setPreferredWidth(15);
        tbl_clie.getColumnModel().getColumn(4).setPreferredWidth(22);
        
        
    }
    public void LoadTableVend(){
        DefaultTableModel mdl = new DefaultTableModel(new Object[]{"Nome","Cadastro","Cliente","Carro","Situação"},0);
        for(int i=0;i<ListaVend.size();i++){
            Object linha[] = new Object[]{ListaVend.get(i).getNome(),
                                          ListaVend.get(i).getCadastro(),
                                          ListaVend.get(i).getCliente(), 
                                          ListaVend.get(i).getCarro(),
                                          ListaVend.get(i).getSituacao()};
    
            mdl.addRow(linha);
        }
        tbl_venda.setModel(mdl);
        tbl_venda.getColumnModel().getColumn(1).setPreferredWidth(10);
        
    }
    public Cadastro() {
        initComponents();
        setLocationRelativeTo(null);
        ListaCar = new ArrayList();
        ListaClie = new ArrayList();
        ListaVend = new ArrayList();
        Cadastros();
        modo = "navegar";
        modoclie = "navegar";
        modovend = "navegar";
        ManipulaInterface();
        ManipulaInterfaceClie();
        ManipulaInterfaceVend();
       
        
    }
    public void Cadastros(){
        Carro carro = new Carro("Chevrolet", "Camaro", 2014, 45000, "145.000,00", 450);
        ListaCar.add(carro);
        LoadTableCar();
        Cliente cli = new Cliente("João", "Não informado", 04, 10, 1980, "14113287661", "Nenhum");
        ListaClie.add(cli);
        LoadTableClie();
        ListaClie.get(0).setCarroComprado(ListaCar.get(0).getModelo());
        Vendedor vend = new Vendedor("José", 001, ListaCar.get(0).getModelo(), ListaClie.get(0).getNome(), "Aprovado ("+ListaClie.get(0).getCarroComprado()+")");
        ListaVend.add(vend);
        LoadTableClie();
        LoadTableVend();
    }
    public void ManipulaInterface(){
        switch(modo){
            case "navegar":
                btn_cad_salvar.setEnabled(false);
                btn_cad_cancelar.setEnabled(false);
                btn_cad_new.setEnabled(true);
                btn_cad_edit.setEnabled(false);
                btn_cad_excluir.setEnabled(false);
                cad_ano.setEnabled(false);
                cad_km.setEnabled(false);
                cad_marca.setEnabled(false);
                cad_modelo.setEnabled(false);
                cad_pot.setEnabled(false);
                cad_preco.setEnabled(false);
                break;
            case "novo":
                btn_cad_salvar.setEnabled(true);
                btn_cad_cancelar.setEnabled(true);
                btn_cad_new.setEnabled(false);
                btn_cad_edit.setEnabled(false);
                btn_cad_excluir.setEnabled(false);
                cad_ano.setEnabled(true);
                cad_km.setEnabled(true);
                cad_marca.setEnabled(true);
                cad_modelo.setEnabled(true);
                cad_pot.setEnabled(true);
                cad_preco.setEnabled(true);
                break;
            case "editar":
                btn_cad_salvar.setEnabled(true);
                btn_cad_cancelar.setEnabled(true);
                btn_cad_new.setEnabled(false);
                btn_cad_edit.setEnabled(false);
                btn_cad_excluir.setEnabled(false);
                cad_ano.setEnabled(true);
                cad_km.setEnabled(true);
                cad_marca.setEnabled(true);
                cad_modelo.setEnabled(true);
                cad_pot.setEnabled(true);
                cad_preco.setEnabled(true);
                break;
            case "excluir":
                btn_cad_salvar.setEnabled(false);
                btn_cad_cancelar.setEnabled(false);
                btn_cad_new.setEnabled(true);
                btn_cad_edit.setEnabled(false);
                btn_cad_excluir.setEnabled(false);
                cad_ano.setEnabled(false);
                cad_km.setEnabled(false);
                cad_marca.setEnabled(false);
                cad_modelo.setEnabled(false);
                cad_pot.setEnabled(false);
                cad_preco.setEnabled(false);
                break;
            case "selecao":
                btn_cad_salvar.setEnabled(true);
                btn_cad_cancelar.setEnabled(true);
                btn_cad_new.setEnabled(false);
                btn_cad_edit.setEnabled(true);
                btn_cad_excluir.setEnabled(true);
                cad_ano.setEnabled(false);
                cad_km.setEnabled(false);
                cad_marca.setEnabled(false);
                cad_modelo.setEnabled(false);
                cad_pot.setEnabled(false);
                cad_preco.setEnabled(false);
                break;
                
            default: System.out.println("Modo invalido!!");
        }
    }
    public void ManipulaInterfaceClie(){
        switch(modoclie){
            case "navegar":
                btn_cli_novo.setEnabled(true);
                btn_cli_cancelar.setEnabled(false);
                btn_cli_edit.setEnabled(false);
                btn_cli_excluir.setEnabled(false);
                btn_cli_salv.setEnabled(false);
                ComboBox.setEnabled(false);
                txt_cli_ano.setEnabled(false);
                txt_cli_cpf.setEnabled(false);
                txt_cli_dia.setEnabled(false);
                txt_cli_mes.setEnabled(false);
                txt_cli_nome.setEnabled(false);
                txt_cli_telef.setEnabled(false);
                break;
            case "novo":
                btn_cli_novo.setEnabled(false);
                btn_cli_cancelar.setEnabled(true);
                btn_cli_edit.setEnabled(false);
                btn_cli_excluir.setEnabled(false);
                btn_cli_salv.setEnabled(true);
                ComboBox.setEnabled(true);
                txt_cli_ano.setEnabled(true);
                txt_cli_cpf.setEnabled(true);
                txt_cli_dia.setEnabled(true);
                txt_cli_mes.setEnabled(true);
                txt_cli_nome.setEnabled(true);
                txt_cli_telef.setEnabled(false);
                break;
            case "editar":
                btn_cli_novo.setEnabled(false);
                btn_cli_cancelar.setEnabled(true);
                btn_cli_edit.setEnabled(false);
                btn_cli_excluir.setEnabled(false);
                btn_cli_salv.setEnabled(true);
                ComboBox.setEnabled(true);
                txt_cli_ano.setEnabled(true);
                txt_cli_cpf.setEnabled(true);
                txt_cli_dia.setEnabled(true);
                txt_cli_mes.setEnabled(true);
                txt_cli_nome.setEnabled(true);
                txt_cli_telef.setEnabled(false);
                break;
            case "excluir":
                btn_cli_novo.setEnabled(true);
                btn_cli_cancelar.setEnabled(false);
                btn_cli_edit.setEnabled(false);
                btn_cli_excluir.setEnabled(false);
                btn_cli_salv.setEnabled(false);
                ComboBox.setEnabled(false);
                txt_cli_ano.setEnabled(false);
                txt_cli_cpf.setEnabled(false);
                txt_cli_dia.setEnabled(false);
                txt_cli_mes.setEnabled(false);
                txt_cli_nome.setEnabled(false);
                txt_cli_telef.setEnabled(false);
                break;
            case "selecao":
                btn_cli_novo.setEnabled(false);
                btn_cli_cancelar.setEnabled(true);
                btn_cli_edit.setEnabled(true);
                btn_cli_excluir.setEnabled(true);
                btn_cli_salv.setEnabled(false);
                ComboBox.setEnabled(false);
                txt_cli_ano.setEnabled(false);
                txt_cli_cpf.setEnabled(false);
                txt_cli_dia.setEnabled(false);
                txt_cli_mes.setEnabled(false);
                txt_cli_nome.setEnabled(false);
                txt_cli_telef.setEnabled(false);
                break;
                
            default: System.out.println("Modo invalido!!");
        }
    }
    public void ManipulaInterfaceVend(){
        switch(modovend){
            case "navegar":
                txt_vend_cad.setEnabled(false);
                txt_vend_carro_cad.setEnabled(false);
                txt_vend_cli_cad.setEnabled(false);
                txt_vend_nome.setEnabled(false);
                btn_vend_cancelar.setEnabled(false);
                btn_vend_edit.setEnabled(false);
                btn_vend_excluir.setEnabled(false);
                btn_vend_novo.setEnabled(true);
                btn_vend_proc.setEnabled(false);
                btn_vend_vender.setEnabled(false);
                btn_vend_MC_cancel.setEnabled(false);
                break;
            case "novo":
                txt_vend_cad.setEnabled(true);
                txt_vend_carro_cad.setEnabled(true);
                txt_vend_cli_cad.setEnabled(true);
                txt_vend_nome.setEnabled(true);
                btn_vend_cancelar.setEnabled(true);
                btn_vend_edit.setEnabled(false);
                btn_vend_excluir.setEnabled(false);
                btn_vend_novo.setEnabled(false);
                btn_vend_proc.setEnabled(true);
                btn_vend_vender.setEnabled(true);
                btn_vend_MC_cancel.setEnabled(false);
                break;
            case "editar":
                txt_vend_cad.setEnabled(true);
                txt_vend_carro_cad.setEnabled(true);
                txt_vend_cli_cad.setEnabled(true);
                txt_vend_nome.setEnabled(true);
                btn_vend_cancelar.setEnabled(true);
                btn_vend_edit.setEnabled(false);
                btn_vend_excluir.setEnabled(false);
                btn_vend_novo.setEnabled(false);
                btn_vend_proc.setEnabled(true);
                btn_vend_vender.setEnabled(true);
                btn_vend_MC_cancel.setEnabled(false);
                break;
            case "excluir":
                txt_vend_cad.setEnabled(false);
                txt_vend_carro_cad.setEnabled(false);
                txt_vend_cli_cad.setEnabled(false);
                txt_vend_nome.setEnabled(false);
                btn_vend_cancelar.setEnabled(false);
                btn_vend_edit.setEnabled(false);
                btn_vend_excluir.setEnabled(false);
                btn_vend_novo.setEnabled(true);
                btn_vend_proc.setEnabled(false);
                btn_vend_vender.setEnabled(false);
                break;
            case "selecao":
                txt_vend_cad.setEnabled(false);
                txt_vend_carro_cad.setEnabled(false);
                txt_vend_cli_cad.setEnabled(false);
                txt_vend_nome.setEnabled(false);
                btn_vend_cancelar.setEnabled(false);
                btn_vend_edit.setEnabled(true);
                btn_vend_excluir.setEnabled(true);
                btn_vend_novo.setEnabled(false);
                btn_vend_proc.setEnabled(false);
                btn_vend_vender.setEnabled(false);
                btn_vend_MC_cancel.setEnabled(true);
                break;
               
                
            default: System.out.println("Modo invalido!!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cad_km = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cad_pot = new javax.swing.JTextField();
        cad_preco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_carro = new javax.swing.JTable();
        btn_cad_new = new javax.swing.JButton();
        btn_cad_edit = new javax.swing.JButton();
        btn_cad_excluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cad_marca = new javax.swing.JTextField();
        cad_modelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cad_ano = new javax.swing.JTextField();
        btn_cad_salvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_cad_cancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_cli_nome = new javax.swing.JTextField();
        txt_cli_cpf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();
        txt_cli_telef = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_cli_dia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_cli_mes = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_cli_ano = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_clie = new javax.swing.JTable();
        btn_cli_salv = new javax.swing.JButton();
        btn_cli_cancelar = new javax.swing.JButton();
        btn_cli_novo = new javax.swing.JButton();
        btn_cli_edit = new javax.swing.JButton();
        btn_cli_excluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btn_vend_vender = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btn_vend_edit = new javax.swing.JButton();
        btn_vend_excluir = new javax.swing.JButton();
        txt_vend_nome = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_venda = new javax.swing.JTable();
        txt_vend_cad = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_vend_carro_cad = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_vend_cli_cad = new javax.swing.JTextField();
        btn_vend_proc = new javax.swing.JButton();
        btn_vend_cancelar = new javax.swing.JButton();
        btn_vend_novo = new javax.swing.JButton();
        btn_vend_MC_cancel = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("Potencia");

        jLabel5.setText("Quilometragem");

        cad_pot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad_potActionPerformed(evt);
            }
        });

        cad_preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad_precoActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Preço");

        tbl_carro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marca", "Modelo", "Ano", "Quilometragem", "Preço", "Potencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        tbl_carro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_carroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_carro);

        btn_cad_new.setText("Novo");
        btn_cad_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cad_newActionPerformed(evt);
            }
        });

        btn_cad_edit.setText("Editar");
        btn_cad_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cad_editActionPerformed(evt);
            }
        });

        btn_cad_excluir.setText("Excluir");
        btn_cad_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cad_excluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de novos Carros");

        jLabel2.setText("Marca");

        cad_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad_marcaActionPerformed(evt);
            }
        });

        cad_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad_modeloActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo");

        cad_ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cad_anoActionPerformed(evt);
            }
        });

        btn_cad_salvar.setText("Salvar");
        btn_cad_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cad_salvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Ano");

        btn_cad_cancelar.setText("Cancelar");
        btn_cad_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cad_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btn_cad_new, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(52, 52, 52)
                                    .addComponent(btn_cad_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(btn_cad_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cad_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cad_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cad_km, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cad_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cad_pot, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(122, 122, 122)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cad_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cad_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cad_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cad_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cad_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cad_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cad_cancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cad_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cad_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cad_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cad_pot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cad_new)
                    .addComponent(btn_cad_edit)
                    .addComponent(btn_cad_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Carro", jPanel2);

        jLabel9.setText("Nome");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cadastro Cliente");
        jLabel10.setAutoscrolls(true);

        jLabel11.setText("CPF");

        txt_cli_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_nomeActionPerformed(evt);
            }
        });

        jLabel12.setText("Informar telefone?");

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  -       ", "Sim", "Não" }));
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        txt_cli_telef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_telefActionPerformed(evt);
            }
        });

        jLabel13.setText("Nascimento");

        txt_cli_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_diaActionPerformed(evt);
            }
        });

        jLabel14.setText("/");

        txt_cli_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cli_mesActionPerformed(evt);
            }
        });

        jLabel15.setText("/");

        tbl_clie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "Dia", "Mes", "Ano", "Carro Comprado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_clie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clieMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_clie);
        if (tbl_clie.getColumnModel().getColumnCount() > 0) {
            tbl_clie.getColumnModel().getColumn(3).setResizable(false);
            tbl_clie.getColumnModel().getColumn(3).setPreferredWidth(29);
            tbl_clie.getColumnModel().getColumn(4).setResizable(false);
            tbl_clie.getColumnModel().getColumn(4).setPreferredWidth(29);
            tbl_clie.getColumnModel().getColumn(5).setResizable(false);
            tbl_clie.getColumnModel().getColumn(5).setPreferredWidth(51);
        }

        btn_cli_salv.setText("Salvar");
        btn_cli_salv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cli_salvActionPerformed(evt);
            }
        });

        btn_cli_cancelar.setText("Cancelar");
        btn_cli_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cli_cancelarActionPerformed(evt);
            }
        });

        btn_cli_novo.setText("Novo");
        btn_cli_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cli_novoActionPerformed(evt);
            }
        });

        btn_cli_edit.setText("Editar");
        btn_cli_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cli_editActionPerformed(evt);
            }
        });

        btn_cli_excluir.setText("Excluir");
        btn_cli_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cli_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cli_cpf)
                            .addComponent(txt_cli_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cli_telef, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cli_salv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cli_cancelar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cli_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cli_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cli_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_cli_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_cli_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_cli_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_cli_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_cli_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_cli_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_cli_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_cli_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cli_telef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cli_salv)
                    .addComponent(btn_cli_cancelar))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cli_novo)
                    .addComponent(btn_cli_edit)
                    .addComponent(btn_cli_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Cliente", jPanel3);

        btn_vend_vender.setText("Vender");
        btn_vend_vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vend_venderActionPerformed(evt);
            }
        });

        jLabel18.setText("Nome");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Área Vendedor");
        jLabel19.setAutoscrolls(true);

        jLabel21.setText("Cadastro");

        btn_vend_edit.setText("Editar");
        btn_vend_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vend_editActionPerformed(evt);
            }
        });

        btn_vend_excluir.setText("Excluir Venda");
        btn_vend_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vend_excluirActionPerformed(evt);
            }
        });

        txt_vend_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vend_nomeActionPerformed(evt);
            }
        });

        tbl_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vendedor", "Cadastro", "Cliente", "Carro", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_venda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_vendaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_venda);
        if (tbl_venda.getColumnModel().getColumnCount() > 0) {
            tbl_venda.getColumnModel().getColumn(3).setResizable(false);
            tbl_venda.getColumnModel().getColumn(3).setPreferredWidth(29);
            tbl_venda.getColumnModel().getColumn(4).setResizable(false);
            tbl_venda.getColumnModel().getColumn(4).setPreferredWidth(29);
        }

        jLabel20.setText("Cliente (Numero cadastro)");

        txt_vend_carro_cad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vend_carro_cadActionPerformed(evt);
            }
        });

        jLabel22.setText("Carro (Numero cadastro)");

        txt_vend_cli_cad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vend_cli_cadActionPerformed(evt);
            }
        });

        btn_vend_proc.setText("Validar");
        btn_vend_proc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vend_procActionPerformed(evt);
            }
        });

        btn_vend_cancelar.setText("Cancelar");
        btn_vend_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vend_cancelarActionPerformed(evt);
            }
        });

        btn_vend_novo.setText("Nova Venda");
        btn_vend_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vend_novoActionPerformed(evt);
            }
        });

        btn_vend_MC_cancel.setText("Cancelar");
        btn_vend_MC_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vend_MC_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btn_vend_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_vend_proc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_vend_cancelar)
                .addGap(64, 64, 64))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_vend_vender, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_vend_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_vend_excluir)
                        .addGap(18, 18, 18)
                        .addComponent(btn_vend_MC_cancel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_vend_cli_cad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_vend_carro_cad)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_vend_cad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_vend_nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_vend_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_vend_cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_vend_cli_cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_vend_carro_cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_vend_proc)
                    .addComponent(btn_vend_cancelar)
                    .addComponent(btn_vend_novo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_vend_vender)
                    .addComponent(btn_vend_edit)
                    .addComponent(btn_vend_excluir)
                    .addComponent(btn_vend_MC_cancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Vendedor ", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_carroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_carroMouseClicked
        int index = tbl_carro.getSelectedRow();
        if(index >=0 && index<ListaCar.size()){
            Carro c = ListaCar.get(index);
            cad_ano.setText(String.valueOf(c.getAno()));
            cad_marca.setText(c.getMarca());
            cad_modelo.setText(c.getModelo());
            cad_km.setText(String.valueOf(c.getQuilometragem()));
            cad_preco.setText(c.getPreco());
            cad_pot.setText(String.valueOf(c.getPotencia()));
            modo = "selecao";
            ManipulaInterface();
        }
    }//GEN-LAST:event_tbl_carroMouseClicked

    private void btn_cad_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cad_cancelarActionPerformed
        cad_ano.setText("");
        cad_marca.setText("");
        cad_modelo.setText("");
        cad_km.setText("");
        cad_preco.setText("");
        cad_pot.setText("");
        modo = "navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_cad_cancelarActionPerformed

    private void btn_cad_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cad_salvarActionPerformed
        int ano = Integer.parseInt(cad_ano.getText());
        int km = Integer.parseInt(cad_km.getText());
        int mt = Integer.parseInt(cad_pot.getText());
        if(modo.equals("novo")){

            Carro c = new Carro(cad_marca.getText(), cad_modelo.getText(), ano , km, cad_preco.getText() , mt);
            ListaCar.add(c);
        }else if(modo.equals("editar")){
            int index = tbl_carro.getSelectedRow();
            ListaCar.get(index).setAno(ano);
            ListaCar.get(index).setMarca(cad_marca.getText());
            ListaCar.get(index).setModelo(cad_modelo.getText());
            ListaCar.get(index).setQuilometragem(km);
            ListaCar.get(index).setPreco(cad_preco.getText());
            ListaCar.get(index).setPotencia(mt);
        }

        LoadTableCar();
        modo = "navegar";
        ManipulaInterface();
        cad_ano.setText("");
        cad_marca.setText("");
        cad_modelo.setText("");
        cad_km.setText("");
        cad_preco.setText("");
        cad_pot.setText("");

    }//GEN-LAST:event_btn_cad_salvarActionPerformed

    private void cad_anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cad_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cad_anoActionPerformed

    private void cad_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cad_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cad_modeloActionPerformed

    private void cad_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cad_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cad_marcaActionPerformed

    private void btn_cad_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cad_excluirActionPerformed
        int index = tbl_carro.getSelectedRow();
        if(index>=0 && index<ListaCar.size()){
            ListaCar.remove(index);
        }
        LoadTableCar();
        modo = "navegar";
        ManipulaInterface();
        cad_ano.setText("");
        cad_marca.setText("");
        cad_modelo.setText("");
        cad_km.setText("");
        cad_preco.setText("");
        cad_pot.setText("");

    }//GEN-LAST:event_btn_cad_excluirActionPerformed

    private void btn_cad_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cad_editActionPerformed
        modo = "editar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_cad_editActionPerformed

    private void btn_cad_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cad_newActionPerformed
        cad_ano.setText("");
        cad_marca.setText("");
        cad_modelo.setText("");
        cad_km.setText("");
        cad_preco.setText("");
        cad_pot.setText("");
        modo = "novo";
        ManipulaInterface();
    }//GEN-LAST:event_btn_cad_newActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cad_precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cad_precoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cad_precoActionPerformed

    private void cad_potActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cad_potActionPerformed

    }//GEN-LAST:event_cad_potActionPerformed

    private void txt_cli_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_nomeActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        int index;
        index = ComboBox.getSelectedIndex();
        
        if(index == 0){
            txt_cli_telef.setEnabled(false);
            txt_cli_telef.setText("---------------Escolha-------------");
        }else if(index == 1){
            txt_cli_telef.setEnabled(true);
            txt_cli_telef.setText("");
        }else if(index == 2){
            txt_cli_telef.setEnabled(false);
            txt_cli_telef.setText("Não informado");
        }
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void txt_cli_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_mesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_mesActionPerformed

    private void btn_cli_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cli_editActionPerformed
        modoclie = "editar";
        ManipulaInterfaceClie();
    }//GEN-LAST:event_btn_cli_editActionPerformed

    private void txt_cli_telefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_telefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_telefActionPerformed

    private void btn_cli_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cli_novoActionPerformed
        txt_cli_ano.setText("");
        txt_cli_cpf.setText("");
        txt_cli_dia.setText("");
        txt_cli_mes.setText("");
        txt_cli_nome.setText("");
        txt_cli_telef.setText("---------------Escolha-------------");
        modoclie = "novo";
        ManipulaInterfaceClie();
    }//GEN-LAST:event_btn_cli_novoActionPerformed

    private void btn_cli_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cli_excluirActionPerformed
        
        int index = tbl_clie.getSelectedRow();
        if(index>=0 && index<ListaClie.size()){
            ListaClie.remove(index);
        }
        LoadTableClie();
        modoclie = "navegar";
        ManipulaInterfaceClie();
        txt_cli_ano.setText("");
        txt_cli_cpf.setText("");
        txt_cli_dia.setText("");
        txt_cli_mes.setText("");
        txt_cli_nome.setText("");
        txt_cli_telef.setText("---------------Escolha-------------");
    }//GEN-LAST:event_btn_cli_excluirActionPerformed

    private void btn_cli_salvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cli_salvActionPerformed
         if(modoclie.equals("novo")){
            int dia = Integer.parseInt(txt_cli_dia.getText());
            int mes = Integer.parseInt(txt_cli_mes.getText());
            int ano = Integer.parseInt(txt_cli_ano.getText());
            
            Cliente cl = new Cliente(txt_cli_nome.getText(), txt_cli_telef.getText() ,dia, mes, ano, txt_cli_cpf.getText(),"Nenhum");
            ListaClie.add(cl);
        }else if(modoclie.equals("editar")){
            int index = tbl_clie.getSelectedRow();
            ListaClie.get(index).setNome(txt_cli_nome.getText());
            ListaClie.get(index).setTelefone(txt_cli_telef.getText());
            ListaClie.get(index).setDiaa(Integer.parseInt(txt_cli_dia.getText()));
            ListaClie.get(index).setMess(Integer.parseInt(txt_cli_mes.getText()));
            ListaClie.get(index).setAnoo(Integer.parseInt(txt_cli_ano.getText()));
            ListaClie.get(index).setCpf(txt_cli_cpf.getText());
            
            
        }
        LoadTableClie();
        modoclie = "navegar";
        ManipulaInterfaceClie();
        txt_cli_ano.setText("");
        txt_cli_cpf.setText("");
        txt_cli_dia.setText("");
        txt_cli_mes.setText("");
        txt_cli_nome.setText("");
        txt_cli_telef.setText("---------------Escolha-------------");
    }//GEN-LAST:event_btn_cli_salvActionPerformed

    private void txt_cli_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cli_diaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cli_diaActionPerformed

    private void tbl_clieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clieMouseClicked
        int index = tbl_clie.getSelectedRow();
        if(index >=0 && index<ListaClie.size()){
            Cliente cl = ListaClie.get(index);
            txt_cli_nome.setText(cl.getNome());
            txt_cli_cpf.setText(cl.getCpf());
            txt_cli_dia.setText(String.valueOf(cl.getDiaa()));
            txt_cli_mes.setText(String.valueOf(cl.getMess()));
            txt_cli_ano.setText(String.valueOf(cl.getAnoo()));
            txt_cli_telef.setText(cl.getTelefone());
            
            modoclie = "selecao";
            ManipulaInterfaceClie();
        }
    }//GEN-LAST:event_tbl_clieMouseClicked

    private void btn_vend_venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vend_venderActionPerformed
        int index = Integer.parseInt(txt_vend_cli_cad.getText());
        int i = Integer.parseInt(txt_vend_carro_cad.getText());
        if(modovend.equals("novo")){
            ListaClie.get(index).setCarroComprado("Aprovado");
            String model = ListaCar.get(i).getModelo();
            String client = ListaClie.get(index).getNome();
            String situacao = "Aprovado ("+ListaClie.get(index).getCarroComprado()+")";
            int cad = Integer.parseInt(txt_vend_cad.getText());
            Vendedor vend = new Vendedor(txt_vend_nome.getText(), cad, client, model, situacao);
            ListaVend.add(vend);
           
        }else if(modovend.equals("editar")){
            int ind = tbl_venda.getSelectedRow();
            ListaVend.get(ind).setNome(txt_vend_nome.getText());
            ListaVend.get(ind).setCadastro(Integer.parseInt(txt_vend_cad.getText()));
            ListaVend.get(ind).setCarro(ListaCar.get(i).getModelo());
            ListaVend.get(ind).setCliente(ListaClie.get(index).getNome());
            ListaVend.get(ind).setSituacao("Aprovado ("+ListaClie.get(index).getCarroComprado()+")");
            
        }
            
        
        LoadTableVend();
        modovend = "navegar";
        ManipulaInterfaceVend();
    }//GEN-LAST:event_btn_vend_venderActionPerformed

    private void btn_vend_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vend_editActionPerformed
        modovend = "editar";
        ManipulaInterfaceVend();
    }//GEN-LAST:event_btn_vend_editActionPerformed

    private void btn_vend_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vend_excluirActionPerformed
        int index = tbl_venda.getSelectedRow();
        if(index>=0 && index<ListaVend.size()){
            ListaVend.remove(index);
        }
        LoadTableVend();
        txt_vend_cad.setText("");
        txt_vend_carro_cad.setText("");
        txt_vend_cli_cad.setText("");
        txt_vend_nome.setText("");
        modovend = "navegar";
        ManipulaInterfaceVend();
        
    }//GEN-LAST:event_btn_vend_excluirActionPerformed

    private void txt_vend_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vend_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vend_nomeActionPerformed

    private void tbl_vendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_vendaMouseClicked
        int index = tbl_venda.getSelectedRow();
        if(index >=0 && index<ListaVend.size()){
            Vendedor vend = ListaVend.get(index);
            txt_vend_nome.setText(vend.getNome());
            txt_vend_cad.setText(String.valueOf(vend.getCadastro()));
            txt_vend_cli_cad.setText("informe");
            txt_vend_carro_cad.setText("Informe");
            
            modovend = "selecao";
            ManipulaInterfaceVend();
        }
    }//GEN-LAST:event_tbl_vendaMouseClicked

    private void txt_vend_cli_cadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vend_cli_cadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vend_cli_cadActionPerformed

    private void btn_vend_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vend_novoActionPerformed
        txt_vend_cad.setText("");
        txt_vend_carro_cad.setText("");
        txt_vend_cli_cad.setText("");
        txt_vend_nome.setText("");
        modovend = "novo";
        ManipulaInterfaceVend();
    }//GEN-LAST:event_btn_vend_novoActionPerformed

    private void txt_vend_carro_cadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vend_carro_cadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vend_carro_cadActionPerformed

    private void btn_vend_procActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vend_procActionPerformed
        int i = Integer.parseInt(txt_vend_carro_cad.getText());
        int index = Integer.parseInt(txt_vend_cli_cad.getText());
        try{    
            JOptionPane.showMessageDialog(rootPane, "Cliente: "+ListaClie.get(index).getNome());   
            JOptionPane.showMessageDialog(rootPane, "Carro: "+ListaCar.get(i).getModelo());
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btn_vend_procActionPerformed

    private void btn_vend_MC_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vend_MC_cancelActionPerformed
        modovend = "navegar";
        txt_vend_cad.setText("");
        txt_vend_carro_cad.setText("");
        txt_vend_cli_cad.setText("");
        txt_vend_nome.setText("");
        ManipulaInterfaceVend();
    }//GEN-LAST:event_btn_vend_MC_cancelActionPerformed

    private void btn_vend_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vend_cancelarActionPerformed
        txt_vend_cad.setText("");
        txt_vend_carro_cad.setText("");
        txt_vend_cli_cad.setText("");
        txt_vend_nome.setText("");
        modovend = "navegar";
        ManipulaInterfaceVend();
    }//GEN-LAST:event_btn_vend_cancelarActionPerformed

    private void btn_cli_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cli_cancelarActionPerformed
        txt_cli_ano.setText("");
        txt_cli_cpf.setText("");
        txt_cli_dia.setText("");
        txt_cli_mes.setText("");
        txt_cli_nome.setText("");
        txt_cli_telef.setText("");
        modoclie = "navegar";
        ManipulaInterfaceClie();
    }//GEN-LAST:event_btn_cli_cancelarActionPerformed
    
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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton btn_cad_cancelar;
    private javax.swing.JButton btn_cad_edit;
    private javax.swing.JButton btn_cad_excluir;
    private javax.swing.JButton btn_cad_new;
    private javax.swing.JButton btn_cad_salvar;
    private javax.swing.JButton btn_cli_cancelar;
    private javax.swing.JButton btn_cli_edit;
    private javax.swing.JButton btn_cli_excluir;
    private javax.swing.JButton btn_cli_novo;
    private javax.swing.JButton btn_cli_salv;
    private javax.swing.JButton btn_vend_MC_cancel;
    private javax.swing.JButton btn_vend_cancelar;
    private javax.swing.JButton btn_vend_edit;
    private javax.swing.JButton btn_vend_excluir;
    private javax.swing.JButton btn_vend_novo;
    private javax.swing.JButton btn_vend_proc;
    private javax.swing.JButton btn_vend_vender;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField cad_ano;
    private javax.swing.JTextField cad_km;
    private javax.swing.JTextField cad_marca;
    private javax.swing.JTextField cad_modelo;
    private javax.swing.JTextField cad_pot;
    private javax.swing.JTextField cad_preco;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_carro;
    private javax.swing.JTable tbl_clie;
    private javax.swing.JTable tbl_venda;
    private javax.swing.JTextField txt_cli_ano;
    private javax.swing.JTextField txt_cli_cpf;
    private javax.swing.JTextField txt_cli_dia;
    private javax.swing.JTextField txt_cli_mes;
    private javax.swing.JTextField txt_cli_nome;
    private javax.swing.JTextField txt_cli_telef;
    private javax.swing.JTextField txt_vend_cad;
    private javax.swing.JTextField txt_vend_carro_cad;
    private javax.swing.JTextField txt_vend_cli_cad;
    private javax.swing.JTextField txt_vend_nome;
    // End of variables declaration//GEN-END:variables
}
