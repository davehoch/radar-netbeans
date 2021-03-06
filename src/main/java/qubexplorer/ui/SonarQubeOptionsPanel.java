package qubexplorer.ui;

import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import org.openide.util.NbPreferences;

public final class SonarQubeOptionsPanel extends javax.swing.JPanel {

    private static final String DEFAULT_MODE="Issues";
    private final transient SonarQubeOptionsPanelController controller;
    private final Set<String> analysisModes=new HashSet<>();
    

    SonarQubeOptionsPanel(SonarQubeOptionsPanelController controller) {
        this.controller = controller;
        analysisModes.add("Issues");
        analysisModes.add("Preview");
        initComponents();
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>)analysisModeCombo.getModel();
        for (String mode : analysisModes) {
            model.addElement(mode);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        serverAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        analysisModeCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tJvmArguments = new org.jdesktop.swingx.JXTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SonarQubeOptionsPanel.class, "SonarQubeOptionsPanel.jLabel1.text")); // NOI18N

        serverAddress.setText(org.openide.util.NbBundle.getMessage(SonarQubeOptionsPanel.class, "SonarQubeOptionsPanel.serverAddress.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SonarQubeOptionsPanel.class, "SonarQubeOptionsPanel.jLabel2.text")); // NOI18N

        jLabel3.setFont(jLabel3.getFont().deriveFont((jLabel3.getFont().getStyle() | java.awt.Font.ITALIC), jLabel3.getFont().getSize()-1));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(SonarQubeOptionsPanel.class, "SonarQubeOptionsPanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(SonarQubeOptionsPanel.class, "SonarQubeOptionsPanel.jLabel4.text")); // NOI18N

        tJvmArguments.setText(org.openide.util.NbBundle.getMessage(SonarQubeOptionsPanel.class, "SonarQubeOptionsPanel.tJvmArguments.text")); // NOI18N
        tJvmArguments.setPrompt(org.openide.util.NbBundle.getMessage(SonarQubeOptionsPanel.class, "SonarQubeOptionsPanel.tJvmArguments.prompt")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                    .addComponent(analysisModeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverAddress)
                    .addComponent(tJvmArguments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(serverAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analysisModeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tJvmArguments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    protected void load() {
         serverAddress.setText(NbPreferences.forModule(SonarQubeOptionsPanel.class).get("address", "http://localhost:9000"));
         String analysisMode = NbPreferences.forModule(SonarQubeOptionsPanel.class).get("runner.analysisMode", DEFAULT_MODE);
         if(!analysisModes.contains(analysisMode)){
             analysisMode=DEFAULT_MODE;
         }
         analysisModeCombo.setSelectedItem(analysisMode);
         tJvmArguments.setText(NbPreferences.forModule(SonarQubeOptionsPanel.class).get("runner.jvmArguments", ""));
    }

    protected void store() {
         NbPreferences.forModule(SonarQubeOptionsPanel.class).put("address", serverAddress.getText());
         NbPreferences.forModule(SonarQubeOptionsPanel.class).put("runner.analysisMode", analysisModeCombo.getSelectedItem().toString());
         NbPreferences.forModule(SonarQubeOptionsPanel.class).put("runner.jvmArguments", tJvmArguments.getText());
    }

    boolean valid() {
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox analysisModeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField serverAddress;
    private org.jdesktop.swingx.JXTextField tJvmArguments;
    // End of variables declaration//GEN-END:variables
}
