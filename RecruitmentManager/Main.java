package RecruitmentManager;

import RecruitmentManager.PanelSwitcher;

public class Main {
    public static void main(String[] args) {
        PanelSwitcher switcher = new PanelSwitcher();
        System.out.println("Switching to home panel");
        switcher.switchPanel(PanelSwitcher.NewFrame.HOME);
    }
}