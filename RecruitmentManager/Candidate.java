package RecruitmentManager;

import RecruitmentManager.CandidateScreen;
import org.apache.commons.lang3.*;

public class Candidate {
    String name;
    int age;
    private Range<Integer> ageRange = Range.between(14, 18);
    private Range<Integer> gradeRange = Range.between(9, 12);
    int grade;
    String subteam;
    
    public Candidate(String name, int age, String subteam) {
        this.name = name;
        this.subteam = subteam;
        if (!ageRange.contains(age)) throw new InvalidCandidateException("Invalid age: " + age + ". Age of candidate must be between " + ageRange.getMinimum() + " and " + ageRange.getMaximum() + " inclusive.");
        else this.age = age;
        if (age == 14) {
            grade = 9;
        }
        else if (age == 15) {
            grade = 10;
        }
        else if (age == 16) {
            grade = 11;
        }
        else if (age == 17 || age == 18) {
            grade = 12;
        }
    }
    
    public Candidate(String name, int age, int grade, String subteam) {
        this(name, age, subteam);
        if (!gradeRange.contains(grade)) throw new InvalidCandidateException("Invalid grade: " + grade + ". Grade of candidate must be between " + gradeRange.getMinimum() + " and " + gradeRange.getMaximum() + " inclusive (Highschool).");
        else this.grade = grade;
    }

    public String display() {
        return String.format("Name: %s | Age: %d | Subteam: %s | Grade: %d", name, age, subteam, grade);
    }
    
    public String toString() {
        return name + "," + age + "," + grade + "," + subteam;
    }
}