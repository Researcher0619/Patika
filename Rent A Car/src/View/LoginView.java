package View;

import Business.UserManager;
import Core.Helper;
import Entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends Layout {
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JPanel w_bottom;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private final UserManager userManager;

    public LoginView() {
        userManager = new UserManager();
        this.add(container);
        this.guiInitialize(400, 400);
        btn_login.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_username, this.fld_password};
            if (Helper.isFieldListEmpty(checkFieldList)) {
                Helper.showMessage("fill");
            } else {
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(), this.fld_password.getText());
                if (loginUser == null) {
                    Helper.showMessage("notFound");
                } else {
                    AdminView adminView = new AdminView(loginUser);
                    dispose(); // login ekranının login işlemi sonrası kapanması için
                }
            }

        });
    }
}
