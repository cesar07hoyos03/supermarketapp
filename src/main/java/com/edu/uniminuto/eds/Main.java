package com.edu.uniminuto.eds;

import com.edu.uniminuto.eds.controller.UserController;
import com.edu.uniminuto.eds.model.UserCRUD;
import com.edu.uniminuto.eds.view.UserView;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            new UserController(new UserView(), new UserCRUD());
        } catch (ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException |
                SQLException e) {
            e.printStackTrace();
        }
    }
}