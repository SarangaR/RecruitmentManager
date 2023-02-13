package RecruitmentManager;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.util.List;
import java.io.*;
import java.lang.management.BufferPoolMXBean;

public class AddNewCandidateScreen extends JPanel {
    
    PanelSwitcher switcher = new PanelSwitcher();

    private static String name = "";
    private static int age = 0;
    private static int grade = 0;
    private static String subteam = "";

    private static Candidate cNew;
    
    public AddNewCandidateScreen() {
        setLayout(new BorderLayout());
        
        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
        
        JLabel title = new JLabel("NEW CANDIDATE", JLabel.CENTER);
        top.add(Box.createRigidArea(new Dimension(200, 0)));
        top.add(title);
        add(top, BorderLayout.NORTH);

        JPanel labels = new JPanel();
        labels.setLayout(new BoxLayout(labels, BoxLayout.PAGE_AXIS));

        JLabel nameLabel = new JLabel("NAME: ");
        JLabel ageLabel = new JLabel("AGE: ");
        JLabel gradeLabel = new JLabel("GRADE: ");
        JLabel subteamLabel = new JLabel("SUBTEAM: ");

        JTextField name = new JTextField(20);
        JTextField age = new JTextField(20);
        JTextField grade = new JTextField(20);
        JTextField subteam = new JTextField(20);

        ArrayList<JTextField> fieldArray = new ArrayList<>(List.of(new JTextField[]{name, age, grade, subteam}));

        for (JTextField field : fieldArray) {
            field.setPreferredSize(new Dimension(20, 20));
            field.setMaximumSize(field.getPreferredSize());
        }


        labels.add(Box.createRigidArea(new Dimension(15, 0)));
        labels.add(Box.createRigidArea(new Dimension(0, 30)));
        labels.add(nameLabel);
        labels.add(Box.createRigidArea(new Dimension(0, 30)));
        labels.add(ageLabel);
        labels.add(Box.createRigidArea(new Dimension(0, 30)));
        labels.add(gradeLabel);
        labels.add(Box.createRigidArea(new Dimension(0, 30)));
        labels.add(subteamLabel);

        add(labels, BorderLayout.WEST);

        JPanel fields = new JPanel();
        fields.setLayout(new BoxLayout(fields, BoxLayout.PAGE_AXIS));

        fields.add(Box.createRigidArea(new Dimension(15, 0)));
        fields.add(Box.createRigidArea(new Dimension(0, 30)));
        fields.add(name);
        fields.add(Box.createRigidArea(new Dimension(0, 25)));
        fields.add(age);
        fields.add(Box.createRigidArea(new Dimension(0, 25)));
        fields.add(grade);
        fields.add(Box.createRigidArea(new Dimension(0, 25)));
        fields.add(subteam);

        add(fields, BorderLayout.EAST);

        JButton submit = new JButton("SUBMIT");
        submit.addActionListener(l -> {
            AddNewCandidateScreen.name = name.getText();
            AddNewCandidateScreen.age = Integer.parseInt(age.getText());
            AddNewCandidateScreen.grade = Integer.parseInt(grade.getText());
            AddNewCandidateScreen.subteam = subteam.getText();
            cNew = new Candidate(AddNewCandidateScreen.name, AddNewCandidateScreen.age, AddNewCandidateScreen.grade, AddNewCandidateScreen.subteam);
            CandidateScreen.update(cNew);
            // try {
            // }
            // catch (Exception e) {
            //     e.printStackTrace();
            // }
            name.setText("");
            age.setText("");
            grade.setText("");
            subteam.setText("");
            switcher.switchPanel(PanelSwitcher.NewFrame.CANDIDATE);
        });
        add(submit, BorderLayout.SOUTH);
    }

    public static Candidate getNewCandidate() {
        return cNew;
    }
    
}