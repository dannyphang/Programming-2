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
        // 
        while(randomNumber == min || randomNumber == max){
            randomNumber = min + (int) (Math.random() * (max - min + 1));
        }

//        for(int i = 0; i <= 100; ++i){
//            System.out.println("-------------------\n" + i + ": ");
//            randomNumber = min;
//            while(randomNumber == min || randomNumber == max){
//                randomNumber = min + (int) (Math.random() * (max - min + 1));
//            }
//            System.out.println(randomNumber);
//        }
        
//        JOptionPane.showMessageDialog(null, minimum + "\n" + maximum);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLable = new javax.swing.JLabel();
        maxLable = new javax.swing.JLabel();
        minLable = new javax.swing.JLabel();
        until = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();
        numLable = new javax.swing.JLabel();
        okBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 300));
        setPreferredSize(new java.awt.Dimension(751, 400));

        titleLable.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        titleLable.setText("Guess The Number");
        titleLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        maxLable.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        maxLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxLable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                maxLablePropertyChange(evt);
            }
        });

        minLable.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        minLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minLable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                minLablePropertyChange(evt);
            }
        });

        until.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        until.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        until.setText(" - ");
        until.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        numText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numTextActionPerformed(evt);
            }
        });

        numLable.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        numLable.setText("Your Number");

        okBtn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numLable)
                .addGap(60, 60, 60)
                .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(titleLable)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minLable, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(until)
                                .addGap(82, 82, 82)
                                .addComponent(maxLable, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(okBtn)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(maxLable, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minLable, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(until)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numLable, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(numText))
                .addGap(29, 29, 29)
                .addComponent(okBtn)
                .addGap(36, 36, 36))
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
                int confirm = JOptionPane.showConfirmDialog(new NewJFrame(), 
                        "\nBOOM!!!\nDo you want to play one more time?", "One more time??", 
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(confirm == 0){
                    this.dispose();
                    new NewJFrame().setVisible(true);
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
        // TODO add your handling code here:
        minLable.setText(String.valueOf(minimum));
    }//GEN-LAST:event_minLablePropertyChange

    private void maxLablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_maxLablePropertyChange
        // TODO add your handling code here:
        maxLable.setText(String.valueOf(maximum));
    }//GEN-LAST:event_maxLablePropertyChange

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
