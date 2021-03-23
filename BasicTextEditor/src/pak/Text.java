/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pak;

import java.awt.*;
import javax.swing.*;

public class Text extends JPanel {

    protected JTextArea textArea;

    public Text() {

        textArea = new JTextArea(50,50);
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        GridBagConstraints c = new GridBagConstraints();
        add(scrollPane, c);
    }
}

