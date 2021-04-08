package view;

import database.DeleteMsg;
import database.InsertMsg;
import database.ReadMsg;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Client_1 extends javax.swing.JFrame {
    
    static Socket client;
    static DataInputStream din ;
    static DataOutputStream dout;
    static String string;
    public static ArrayList<String> list = new ArrayList<>();
    
    public Client_1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        label = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnMode = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client 1");
        setBackground(new java.awt.Color(102, 153, 255));

        btnClear.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        text.setColumns(20);
        text.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        text.setLineWrap(true);
        text.setRows(5);
        text.setWrapStyleWord(true);
        text.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jScrollPane1.setViewportView(text);

        btnSend.setBackground(new java.awt.Color(102, 153, 255));
        btnSend.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        label.setEditable(false);
        label.setColumns(20);
        label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label.setLineWrap(true);
        label.setRows(5);
        label.setWrapStyleWord(true);
        jScrollPane2.setViewportView(label);

        btnDelete.setText("Delete Chat");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnMode.setText("Dark Mode");
        btnMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnModeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnClear)
                            .addComponent(btnSend))))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSend))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnMode))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try {
            String msg = text.getText().trim();
            text.setText("");
            if(!"".equals(msg)){
                System.out.println(msg);
                String st = "Client_1 : " + msg;
                dout.writeUTF(st);
                InsertMsg in = new InsertMsg();
                in.addMsg(msg,"Client_1");
            }
        } catch (IOException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        text.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeleteMsg dm = new DeleteMsg();
        dm.deleteMsg("client_1");
        label.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnModeItemStateChanged
        int state = evt.getStateChange(); 
  
        if (state == evt.SELECTED) { 
            System.out.println("Dark Mode");
            jPanel1.setBackground(new Color(64, 64, 64));
            label.setBackground(new Color(128, 128, 128));
            text.setBackground(new Color(128, 128, 128));
            btnMode.setText("Light Mode");
        } 
        else { 
            System.out.println("Light Mode");
            jPanel1.setBackground(new Color(240, 240, 240));
            label.setBackground(new Color(250, 250, 250));
            text.setBackground(new Color(250, 250, 250));
            btnMode.setText("Dark Mode");
        } 
    }//GEN-LAST:event_btnModeItemStateChanged

    public static void main(String args[]) {
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_1().setVisible(true);
            }
        });
        
        try {  
            client = new Socket ("localhost",1111);
            dout = new DataOutputStream(client.getOutputStream()); 
            din = new DataInputStream(client.getInputStream());
            
            try {
                String user = "client_1";
                ReadMsg out = new ReadMsg(user);
                ResultSet set = out.readMsg();
                while(set.next()){
                    String str = set.getString(3) + ":" + set.getString(2);
                    list.add(str);
                }
                System.out.println(list);
                for(String str:list){
                    if(str.startsWith("Client_1:")){
                        str = str.replace("Client_1:", "You\t: ");
                    }
                    if(str.startsWith("Client_2:")){
                        str = str.replace("Client_2:", "Client_2\t: ");
                    }
                    label.append(str + "\n");
                    label.setCaretPosition(label.getDocument().getLength());
                }
                while (true) {                
                    string = din.readUTF();
                    if(string.startsWith("Client_1 : ")){
                        string = string.replace("Client_1 : ", "You\t: ");
                    }
                    if(string.startsWith("Client_2 : ")){
                        string = string.replace("Client_2 : ", "Client_2\t: ");
                    }
                    System.out.println("msg : " + string);
                    label.append(string + "\n");
                    label.setCaretPosition(label.getDocument().getLength());
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    din.close();
                } catch (IOException ex) {
                    Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);                }
                }    
        } catch (IOException ex) {
            Logger.getLogger(Client_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JToggleButton btnMode;
    private javax.swing.JButton btnSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea label;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
