package RecruitmentManager;

public class InvalidCandidateException extends RuntimeException {
    public InvalidCandidateException(String errorMessage) {
        super(errorMessage);
    }
}