package RecruitmentManager;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import RecruitmentManager.Candidate;

import java.io.*;

public class CandidateScreen extends JPanel {
    
    PanelSwitcher switcher = new PanelSwitcher();
    ArrayList<Candidate> candidateList = new ArrayList<>();
    static DefaultListModel<String> model = new DefaultListModel<String>();
    
    boolean first = true;
    
    public CandidateScreen() {
        setSize(500, 400);
        setLayout(new BorderLayout());
        
        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
        
        JLabel title = new JLabel("CANDIDATES", JLabel.CENTER);
        top.add(Box.createRigidArea(new Dimension(200, 0)));
        top.add(title);
        
        JButton returnHome = new JButton("HOME");
        returnHome.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                switcher.switchPanel(PanelSwitcher.NewFrame.HOME);
            }
        });
        top.add(Box.createRigidArea(new Dimension(130-returnHome.getWidth(), 0)));
        top.add(returnHome);
        add(top, BorderLayout.NORTH);
        
        JButton newCandidate = new JButton("ADD NEW CANDIDATE");
        newCandidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switcher.switchPanel(PanelSwitcher.NewFrame.NEW_CANDIDATE);
            }
        });
        add(newCandidate, BorderLayout.SOUTH);
        if (first) {
            try {
                populate();
                first = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JList list = new JList(model);
        JScrollPane scroll = new JScrollPane(list);
        add(scroll, BorderLayout.CENTER);
    }
    
    public static void update(Candidate c) {
        try {
            writeToFile(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.insertElementAt(c.display(), 0);
    }
    
    public void populate() throws IOException {
        File candidatePersistence = new File("RecruitmentManager/CandidateStorage.txt");
        Scanner reader = new Scanner(candidatePersistence);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] dataSplit = data.split(",");
            Candidate c = new Candidate(dataSplit[0], Integer.parseInt(dataSplit[1]), Integer.parseInt(dataSplit[2]), dataSplit[3]);
            model.insertElementAt(c.display(), 0);
        }
        reader.close();
    } 

    public static void writeToFile(Candidate cNew) throws IOException {
        File candidatePersistence = new File("RecruitmentManager/CandidateStorage.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(candidatePersistence, true));
        writer.write(cNew.toString());
        writer.newLine();
        writer.close();
    }
}