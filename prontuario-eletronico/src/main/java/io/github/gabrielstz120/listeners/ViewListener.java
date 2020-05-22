package io.github.gabrielstz120.listeners;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class ViewListener implements ActionListener {

    abstract void addListener();

    void fechar(JFrame jFrame) {
        jFrame.dispose();
    }

}
