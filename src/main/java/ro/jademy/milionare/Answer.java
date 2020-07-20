package ro.jademy.milionare;

public class Answer {
    private String answer;
    private boolean isCorect;


    public Answer(String answer, boolean isCorect){
        this.answer=answer;
        this.isCorect=isCorect;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean getIsCorect() {
        return isCorect;
    }

    @Override
    public String toString() {
        return answer;
    }
}
