package ru.sablin.lab4;

import ru.sablin.lab4.utils.OutputFunctions;


import javax.swing.*;

public class Main {
    public static MainWindowOfTheBank createWindowUI(){
        JFrame frame = new JFrame("Система управления банком");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainWindowOfTheBank form = new MainWindowOfTheBank();

        frame.setContentPane(form.getContentPane());
        JPanel content = form.getContentPane();

        JScrollPane scroll = new JScrollPane(content);

        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getHorizontalScrollBar().setUnitIncrement(16);

        frame.setContentPane(scroll);

        frame.setSize(1250, 900);
        frame.setMinimumSize(new java.awt.Dimension(500, 400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return form;
    }

    static void main() {
        OutputFunctions.simpleLog("Запуск программы");

        MainWindowOfTheBank mainWindow = createWindowUI();
    }
}
