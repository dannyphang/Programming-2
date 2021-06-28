package GuessTheNumber;

import javax.swing.*;

/**
 *
 * @author Danny
 */
public class GamePage extends javax.swing.JFrame {

    int minimum = -1, maximum = -2, inputNum = -3, randomNumber = 0, min2 = -5, max2 = -6;
    
    public GamePage(int min, int max) {
        minimum = min;
        maximum = max;
        max2 = maximum;
        min2 = minimum;
        
//        while(randomNumber == min || randomNumber == max){
//            randomNumber = min + (int) (Math.random() * (max - min + 1));
//        }

        for(int i = 0; i <= 100; ++i){
            System.out.println("-------------------\n" + i + ": ");
            randomNumber = min;
            while(randomNumber == min || randomNumber == max){
                randomNumber = min + (int) (Math.random() * (max - min + 1));
            }
            System.out.println(randomNumber);
        }
        
//        JOptionPane.showMessageDialog(null, minimum + "\n" + maximum);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLable = new javax.swing.JLabel();
        minLable = new javax.swing.JLabel();
        until = new javax.swing.JLabel();
        maxLable = new javax.swing.JLabel();
        okBtn = new javax.swing.JButton();
        numLable = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guess The Number");
        setLocation(new java.awt.Point(500, 300));
        setPreferredSize(new java.awt.Dimension(751, 400));

        titleLable.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        titleLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLable.setText("Guess The Number");

        minLable.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        minLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minLable.setText("0");
        minLable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                minLablePropertyChange(evt);
            }
        });

        until.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        until.setText("-");

        maxLable.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        maxLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxLable.setText("0");
        maxLable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                maxLablePropertyChange(evt);
            }
        });

        okBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        numLable.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        numLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numLable.setText("Your Number : ");

        numText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 140, Short.MAX_VALUE)
                        .addComponent(titleLable))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(minLable, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(until)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(numLable)
                                .addGap(60, 60, 60)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxLable, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)))
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(okBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(titleLable)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minLable)
                    .addComponent(until)
                    .addComponent(maxLable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numLable))
                .addGap(26, 26, 26)
                .addComponent(okBtn)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numTextActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        // TODO add your handling code here:
        repaint();
        inputNum = Integer.parseInt(numText.getText());
        if(inputNum <= minimum || inputNum >= maximum){
            JOptionPane.showMessageDialog(null, "Wrong number is entered!");
        }
        else{
            if(inputNum > randomNumber){
                max2 = inputNum;
                maximum = max2;
                repaint();
            }else if(inputNum < randomNumber){
                min2 = inputNum;
                minimum = min2;
                repaint();
            }else{
                int confirm = JOptionPane.showConfirmDialog(new GuessTheNumber2(), 
                        "\nBOOM!!!\nDo you want to play one more time?", "One more time??", 
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(confirm == 0){
                    this.dispose();
                    new GuessTheNumber2().setVisible(true);
                }else{
                    System.exit(0);
                }
            }
        }
        
        minimum = min2;
        maximum = max2;
        minLable.setText(String.valueOf(minimum));
        maxLable.setText(String.valueOf(maximum));
        numText.setText("");
    }//GEN-LAST:event_okBtnActionPerformed

    private void minLablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_minLablePropertyChange
        minLable.setText(String.valueOf(minimum));
    }//GEN-LAST:event_minLablePropertyChange

    private void maxLablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_maxLablePropertyChange
        maxLable.setText(String.valueOf(maximum));
    }//GEN-LAST:event_maxLablePropertyChange

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
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePage(0, 3).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel maxLable;
    private javax.swing.JLabel minLable;
    private javax.swing.JLabel numLable;
    private javax.swing.JTextField numText;
    private javax.swing.JButton okBtn;
    private javax.swing.JLabel titleLable;
    private javax.swing.JLabel until;
    // End of variables declaration//GEN-END:variables
}
