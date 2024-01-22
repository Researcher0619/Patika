package Core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    public static void showMessage(String message) {
        optionPaneTR();
        String str;
        String title = switch (message) {
            case "fill" -> {
                str = "Please fill in all fields";
                yield "Error";
            }
            case "done" -> {
                str = "Operation successful";
                yield "Result";
            }
            case "notFound" -> {
                str = "Record not found";
                yield "Warning";
            }
            case "error" -> {
                str = "You made an incorrect operation";
                yield "Error";
            }
            default -> {
                str = message;
                yield "Message";
            }
        };

        JOptionPane.showMessageDialog(null, str, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String str) {
        optionPaneTR();
        String msg;
        if (str.equals("sure")) {
            msg = "Are you sure you want to perform this operation?";
        } else {
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null, msg, "Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION) == 0;
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fieldlist) {
        for (JTextField field : fieldlist) {
            if (isFieldEmpty(field)) {
                return true;
            }
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.getSize().width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.getSize().height) / 2;
            default -> 0;
        };
    }

    public static void optionPaneTR() {
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
    }
}
