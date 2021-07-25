package TicTacToe;
import GameMenu.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Danny
 */
public class TicTacToe extends javax.swing.JFrame {

    /**
     * Creates new form TicTacToe
     */
    int randomNumber, currentTurn = -1;
    String playerStart;
    String[] board;
    int loop = -1;
    String path;
    Image im = Toolkit.getDefaultToolkit().createImage(path);
    ImageIcon ii = new ImageIcon(im);
    
    public TicTacToe() {
//        for(int i = 0; i < 100; i++){
//            randomNumber = 1 + (int) (Math.random() * (2 - 1 + 1));
//            System.out.println(randomNumber);
//        }

        randomNumber = 1 + (int) (Math.random() * (2 - 1 + 1));
        board = new String[9];
        initComponents();
        loop = 1;
        while(loop == 1 || loop == 3){
            loop = 2;
            randomNumber++;
            playerDisplay();
            System.out.println("Numhber: " + randomNumber);
//            for(int i = 0; i < board.length; i++){
//                if(board[i] == "o" || board[i] == "x"){
//                    
//                }
//            }
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p1 = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        turnLable = new javax.swing.JLabel();
        playerLable = new javax.swing.JLabel();
        p4 = new javax.swing.JLabel();
        p5 = new javax.swing.JLabel();
        p6 = new javax.swing.JLabel();
        p7 = new javax.swing.JLabel();
        p8 = new javax.swing.JLabel();
        p9 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p1.setPreferredSize(new java.awt.Dimension(100, 100));
        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
        });

        p3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p3.setPreferredSize(new java.awt.Dimension(100, 100));
        p3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p3MouseClicked(evt);
            }
        });

        p2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p2.setPreferredSize(new java.awt.Dimension(100, 100));
        p2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p2MouseClicked(evt);
            }
        });

        turnLable.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        turnLable.setText("Turn: ");

        playerLable.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        playerLable.setText("Player 1");

        p4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p4.setPreferredSize(new java.awt.Dimension(100, 100));
        p4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p4MouseClicked(evt);
            }
        });

        p5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p5.setPreferredSize(new java.awt.Dimension(100, 100));
        p5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p5MouseClicked(evt);
            }
        });

        p6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p6.setPreferredSize(new java.awt.Dimension(100, 100));
        p6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p6MouseClicked(evt);
            }
        });

        p7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p7.setPreferredSize(new java.awt.Dimension(100, 100));
        p7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p7MouseClicked(evt);
            }
        });

        p8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p8.setPreferredSize(new java.awt.Dimension(100, 100));
        p8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p8MouseClicked(evt);
            }
        });

        p9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        p9.setPreferredSize(new java.awt.Dimension(100, 100));
        p9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p9MouseClicked(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(turnLable)
                        .addGap(18, 18, 18)
                        .addComponent(playerLable))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(backBtn)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerLable)
                    .addComponent(turnLable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        // TODO add your handling code here:
        if(board[0] != "o" || board[0] != "x"){
            if(currentTurn == 1){
                board[0] = "o";
                path = "D:\\Users\\Danny\\Documents\\NetBeansProjects\\Games\\src\\main\\java\\image\\circle.png";
                p1.setIcon(ii);
            }else{
                board[0] = "x";
            }
//            new MainMenu().setVisible(true);
//            System.out.println(randomNumber);
            
//            randomNumber++;
        }
        
        loop = 3;
        playerDisplay();
    }//GEN-LAST:event_p1MouseClicked

    private void p2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p2MouseClicked
        // TODO add your handling code here:
        if(board[1] != "o" || board[1] != "x"){
            if(currentTurn == 1){
                board[1] = "o";
            }else{
                board[1] = "x";
            }
        }
    }//GEN-LAST:event_p2MouseClicked

    private void p3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p3MouseClicked
        // TODO add your handling code here:
        if(board[2] != "o" || board[2] != "x"){
            if(currentTurn == 1){
                board[2] = "o";
            }else{
                board[2] = "x";
            }
        }
    }//GEN-LAST:event_p3MouseClicked

    private void p4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p4MouseClicked
        // TODO add your handling code here:
        if(board[3] != "o" || board[3] != "x"){
            if(currentTurn == 1){
                board[3] = "o";
            }else{
                board[3] = "x";
            }
        }
    }//GEN-LAST:event_p4MouseClicked

    private void p5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseClicked
        // TODO add your handling code here:
        if(board[4] != "o" || board[4] != "x"){
            if(currentTurn == 1){
                board[4] = "o";
            }else{
                board[4] = "x";
            }
        }
    }//GEN-LAST:event_p5MouseClicked

    private void p6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p6MouseClicked
        // TODO add your handling code here:
        if(board[5] != "o" || board[5] != "x"){
            if(currentTurn == 1){
                board[5] = "o";
            }else{
                board[5] = "x";
            }
        }
    }//GEN-LAST:event_p6MouseClicked

    private void p7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p7MouseClicked
        // TODO add your handling code here:
        if(board[6] != "o" || board[6] != "x"){
            if(currentTurn == 1){
                board[6] = "o";
            }else{
                board[6] = "x";
            }
        }
    }//GEN-LAST:event_p7MouseClicked

    private void p8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p8MouseClicked
        // TODO add your handling code here:
        if(board[7] != "o" || board[7] != "x"){
            if(currentTurn == 1){
                board[7] = "o";
            }else{
                board[7] = "x";
            }
        }
    }//GEN-LAST:event_p8MouseClicked

    private void p9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p9MouseClicked
        // TODO add your handling code here:
        if(board[8] != "o" || board[8] != "x"){
            if(currentTurn == 1){
                board[8] = "o";
            }else{
                board[8] = "x";
            }
        }
    }//GEN-LAST:event_p9MouseClicked

    private void playerDisplay(){
        if(randomNumber % 2 != 0){
            playerLable.setText("Player 1");
            currentTurn = 1;
            playerOne();
        }else{
            playerLable.setText("Player 2");
            currentTurn = 2;
            playerTwo();
        }
    }
    
    public void playerOne(){
        path = ".\\image\\circle.png";
    }
    
    public void playerTwo(){
        path = ".\\image\\cross.png";
    }
    
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
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JLabel p5;
    private javax.swing.JLabel p6;
    private javax.swing.JLabel p7;
    private javax.swing.JLabel p8;
    private javax.swing.JLabel p9;
    private javax.swing.JLabel playerLable;
    private javax.swing.JLabel turnLable;
    // End of variables declaration//GEN-END:variables
}
