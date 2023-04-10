package main.panel;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import main.Game;

import javax.swing.JButton;
import javax.swing.JLabel;

public class InGameMenuPanel extends JPanel {
    public JRadioButton FPS30 = new JRadioButton("30 FPS");
    public JRadioButton FPS60 = new JRadioButton("60 FPS");
    public JButton restartBT = new JButton("Restart");
    public JButton pauseBT = new JButton("Pause");
    public JButton resumeBT = new JButton("Resume");
    // public JPanel pausePanel = new JPanel(new GridLayout(1,3));
    public JPanel pausePanel = new JPanel(new FlowLayout());
    public InGameMenuPanel() {
        super();
        add(pauseBT);
        JPanel FPSPanel = new JPanel(new FlowLayout());
        FPS60.setSelected(true);

        FPSPanel.add(new JLabel("FPS: "));
        FPSPanel.add(FPS30);
        FPSPanel.add(FPS60);
        

        pausePanel.add(resumeBT);
        pausePanel.add(FPSPanel);
        pausePanel.add(restartBT);

    }
    public void changeMenu(Game.Status status) {
        removeAll();
        switch (status) {
            case PLAY:
            add(pauseBT);
            break;

            case PAUSE:
            add(pausePanel);
            break;

            case END:
            add(restartBT);
            break;
        }
        validate();
        repaint();
    }

    public void addGameListener(Game game) {
        // ActionListener
        FPS30.addActionListener(game);
        FPS60.addActionListener(game);
        restartBT.addActionListener(game);
        resumeBT.addActionListener(game);
        pauseBT.addActionListener(game);
        // ItemListener
        FPS30.addItemListener(game);
        FPS60.addItemListener(game);
    }

}