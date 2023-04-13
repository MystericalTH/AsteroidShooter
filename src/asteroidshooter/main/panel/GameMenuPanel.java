package asteroidshooter.main.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import asteroidshooter.main.Game;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class GameMenuPanel extends GamePanel {
    public JRadioButton FPS30BT = new JRadioButton("30 FPS");
    public JRadioButton FPS60BT = new JRadioButton("60 FPS");
    public JButton restartBT1 = new JButton("Restart");
    public JButton restartBT2 = new JButton("Restart");
    public JButton pauseBT = new JButton("Pause");
    public JButton resumeBT = new JButton("Resume");
    // public JPanel pausePanel = new JPanel(new GridLayout(1,3));
    public JSlider sensitivitySlider = new JSlider(1,5);
    public JPanel pausePanel = new JPanel();
    public JPanel playPanel = new JPanel();
    public JPanel endPanel = new JPanel();
    public JComboBox<String> controllerModeSelectionBox;
    public GameMenuPanel() {
        super(new FlowLayout());
        setPreferredSize(new Dimension(120,600));
        JPanel FPSPanel = new JPanel();
        JPanel ControllerPanel = new JPanel();
        
        FPS60BT.setSelected(true);
        FPSPanel.setLayout(new BoxLayout(FPSPanel, BoxLayout.Y_AXIS));
        ControllerPanel.setLayout(new BoxLayout(ControllerPanel, BoxLayout.Y_AXIS));
        // FPSPanel.add(new JLabel("FPS"));
        FPSPanel.add(FPS30BT);
        FPSPanel.add(FPS60BT);
        FPSPanel.setBorder(new TitledBorder("FPS"));
        ControllerPanel.setMaximumSize(new Dimension(90, 100));
        ControllerPanel.setBorder(new TitledBorder("C"));
        // ControllerPanel.setBorder(new TitledBorder("Controller"));
        sensitivitySlider.setPreferredSize(new Dimension(120, 50));
        sensitivitySlider.setValue(3);
        sensitivitySlider.setPaintTicks(true);
        sensitivitySlider.setPaintLabels(true);
        sensitivitySlider.setMajorTickSpacing(1);
        sensitivitySlider.setSnapToTicks(true);
        
        controllerModeSelectionBox = new JComboBox<String>(new String[]{"WASD", "Arrow"});
        JLabel sensitivityLabel = new JLabel("Sensitivity");
        JLabel controllerLabel = new JLabel("Controller Mode");
        pausePanel.setPreferredSize(new Dimension(120, 300));
        pausePanel.add(resumeBT);
        pausePanel.add(FPSPanel);
        pausePanel.add(controllerLabel);
        pausePanel.add(controllerModeSelectionBox);
        pausePanel.add(sensitivityLabel);
        pausePanel.add(sensitivitySlider);
        pausePanel.add(restartBT1);
        
        endPanel.add(restartBT2);
        playPanel.add(pauseBT);

        add(playPanel);

    }
    public void changeMenu(Game.Status status) {
        remove(getComponent(0));
        switch (status) {
            case PLAY:
            add(playPanel);
            break;

            case PAUSE:
            add(pausePanel);
            break;

            case END:
            add(endPanel);
            break;
        }
        revalidate();
        repaint();
    }

    public void addGame(Game game) {
        // ActionListener
        super.addGame(game);
        FPS30BT.addActionListener(game);
        FPS60BT.addActionListener(game);
        restartBT1.addActionListener(game);
        restartBT2.addActionListener(game);
        resumeBT.addActionListener(game);
        pauseBT.addActionListener(game);

        // ItemListener
        FPS30BT.addItemListener(game);
        FPS60BT.addItemListener(game);

        sensitivitySlider.addChangeListener(game);
        controllerModeSelectionBox.addItemListener(game);
    }
}