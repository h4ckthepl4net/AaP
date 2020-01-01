package com.company.components.layout;

import javax.swing.*;

public class AppMenuBar extends JMenuBar {
    public AppMenuBar() {
        this.initFileMenu();
        this.initHelpMenu();
    }

    public void initFileMenu() {
        JMenu menu=new JMenu("File");
        menu.add(new JMenuItem("New"));
        menu.add(new JMenuItem("Open"));
        menu.add(new JMenuItem("Save"));
        menu.add(new JMenuItem("Save as"));
        this.add(menu);
    }
    public void initHelpMenu() {
        JMenu menu = new JMenu("Help");
        menu.add(new JMenuItem("About"));
        this.add(menu);
    }
}
