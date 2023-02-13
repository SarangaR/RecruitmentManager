package RecruitmentManager;

import javax.swing.*;
import java.awt.*;

public class PanelSwitcher {
    
    private boolean visible = false;
    
    public static enum NewFrame {
        HOME(new Home()),
        CANDIDATE(new CandidateScreen()),
        NEW_CANDIDATE(new AddNewCandidateScreen());
        
        JPanel panel;
        NewFrame(JPanel panel) {
            this.panel = panel;
        }
    }
    
    private JFrame mainFrame;
    public PanelSwitcher() {
        mainFrame = new JFrame();
        mainFrame.setSize(500, 400);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void switchPanel(NewFrame panel) {
        mainFrame.dispose();
        mainFrame.setContentPane(panel.panel);
        mainFrame.repaint();
        mainFrame.revalidate();
        mainFrame.setUndecorated(true);
        mainFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        mainFrame.setVisible(true);
    }
}