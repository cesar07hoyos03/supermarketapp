package com.edu.uniminuto.eds.controller;

import com.edu.uniminuto.eds.config.Constants;
import com.edu.uniminuto.eds.model.User;
import com.edu.uniminuto.eds.model.UserCRUD;
import com.edu.uniminuto.eds.view.UserView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class UserController {

    private UserView userView;
    private UserCRUD userCRUD;

    public UserController(UserView userView, UserCRUD userCRUD) {
        this.userView = userView;
        this.userCRUD = userCRUD;

        initWindowListener();
        initActionListener();
        this.updateTableData(true);

        userView.setVisible(true);
    }

    private void initActionListener() {

        this.userView.getBtnQuery().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTableData(false);
            }
        });

        this.userView.getBtnNewUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userCRUD.createNewUser(new User(userView.getTxtFirstName().getText(),
                            userView.getTxtSurName().getText(),
                            userView.getComboPosition().getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(userView, "Usuario creado con Exito!");
                    updateTableData(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(userView, "Error", "Error", 4);
                    ex.printStackTrace();
                }
            }
        });
    }

    private void updateTableData(boolean init) {
        try {
            String selectedPosition = userView.getComboPositionQuery().getSelectedItem().toString();
            Object[][] data = (init || selectedPosition.equals("TODOS")) ? userCRUD.findAll() : userCRUD.findByPosition(selectedPosition);
            DefaultTableModel tableModel = (DefaultTableModel) userView.getTblUsers().getModel();
            tableModel.setDataVector(data, Constants.COLUMN_NAMES);
            tableModel.fireTableDataChanged();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(userView, "Error", "Error", 4);
            ex.printStackTrace();
        }
    }


    private void initWindowListener() {
        this.userView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                this.exitForm(e);
            }

            private void exitForm(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
