package Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_ComboBox implements ActionListener {

    JComboBox combobox;
    public Controleur_ComboBox(JComboBox combobox){
        this.combobox=combobox;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (combobox.getSelectedIndex()==0){
            combobox.setEditable(true);
        }
        else {
            combobox.setEditable(false);
        }
    }

}
