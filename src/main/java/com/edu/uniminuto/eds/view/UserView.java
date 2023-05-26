package com.edu.uniminuto.eds.view;

import com.edu.uniminuto.eds.config.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserView extends JFrame {

    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblSurName;
    private JTextField txtSurName;
    private JButton btnNewUser;
    private JLabel lblPosition;
    private JComboBox<String> comboPosition;
    private JComboBox<String> comboPositionQuery;
    private JTable tblUsers;
    private JButton btnQuery;

    private JPanel upperPanel;
    private JPanel buttonPanel;

    private JPanel pnlFirstName = new JPanel(new FlowLayout());
    private JPanel pnlSurName = new JPanel(new FlowLayout());
    private JPanel pnlTxtFirstName = new JPanel(new FlowLayout());
    private JPanel pnlTxtSurName = new JPanel(new FlowLayout());
    private JPanel pnlBtnNewUser = new JPanel(new FlowLayout());
    private JPanel pnlPosition = new JPanel(new FlowLayout());
    private JPanel pnlComboPostion = new JPanel(new FlowLayout());

    public UserView() {
        this.setSize(600, 400);
        this.setTitle("SuperMarket App");
        this.setResizable(false);
        this.initContainer();
    }

    private void initContainer() {
        this.upperPanel = new JPanel();
        this.upperPanel.setLayout(new GridLayout(4, 2));
        this.buttonPanel = new JPanel();

        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.setLocationRelativeTo(null);

        this.getContentPane().add(upperPanel);
        this.getContentPane().add(buttonPanel);

        this.initComponents();
    }

    private void initComponents() {
        this.initUserForm();
        this.initButton();
    }

    private void initButton() {
        this.btnNewUser = new JButton();
        this.btnNewUser.setText("Crear usuario");
        this.btnNewUser.setToolTipText("Botón de pulsación");
        this.btnNewUser.setMnemonic('c');
        this.upperPanel.add(new JLabel());
        this.pnlBtnNewUser.add(this.btnNewUser);
        this.upperPanel.add(this.pnlBtnNewUser);
    }

    private void initUserForm() {

        this.lblFirstName = new JLabel("Nombre: ");
        this.pnlFirstName.add(this.lblFirstName);
        this.upperPanel.add(this.pnlFirstName);

        this.txtFirstName = new JTextField(15);
        this.pnlTxtFirstName.add(this.txtFirstName);
        this.upperPanel.add(this.pnlTxtFirstName);

        this.lblSurName = new JLabel("Apellido: ");
        this.pnlSurName.add(this.lblSurName);
        this.upperPanel.add(this.pnlSurName);

        this.txtSurName = new JTextField(15);
        this.pnlTxtSurName.add(txtSurName);
        this.upperPanel.add(this.pnlTxtSurName);

        this.lblPosition = new JLabel("Cargo: ");
        this.pnlPosition.add(this.lblPosition);
        this.upperPanel.add(this.pnlPosition);

        this.comboPosition = new JComboBox<>(Constants.POSITIONS_ONLY);
        this.pnlComboPostion.add(this.comboPosition);
        this.upperPanel.add(this.pnlComboPostion);

        this.tblUsers = new JTable(new DefaultTableModel(Constants.COLUMN_NAMES, 0));
        tblUsers.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(tblUsers);
        buttonPanel.add(scrollPane, BorderLayout.CENTER);

        this.comboPositionQuery = new JComboBox<>(Constants.POSITIONS);
        this.buttonPanel.add(this.comboPositionQuery);

        this.btnQuery = new JButton();
        this.btnQuery.setText("Buscar por cargo");
        this.btnQuery.setToolTipText("Botón de pulsación");
        this.btnQuery.setMnemonic('b');
        this.buttonPanel.add(this.btnQuery);
    }

    public JButton getBtnNewUser() {
        return btnNewUser;
    }

    public JTextField getTxtFirstName() {
        return txtFirstName;
    }

    public JTextField getTxtSurName() {
        return txtSurName;
    }

    public JComboBox<String> getComboPosition() {
        return comboPosition;
    }

    public JButton getBtnQuery() {
        return btnQuery;
    }

    public JTable getTblUsers() {
        return tblUsers;
    }

    public JComboBox<String> getComboPositionQuery() {
        return comboPositionQuery;
    }
}
