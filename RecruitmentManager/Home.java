package RecruitmentManager;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Home extends JPanel {
    
    PanelSwitcher switcher = new PanelSwitcher();
    
    public Home() {
        setLayout(new BorderLayout());
        
        JButton candidates = new JButton("CANDIDATES");
        
        candidates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switcher.switchPanel(PanelSwitcher.NewFrame.CANDIDATE);
            }
        });
        JButton exit = new JButton("X");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit, BorderLayout.NORTH);
        add(candidates);
    }
    
}