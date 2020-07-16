package ro.jademy.milionare;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question {

    private String question;
    private ArrayList<Answer> answers;
    private int value;

    public Question(String question, ArrayList<Answer> answers, int value) {
        this.question = question;
        this.answers = answers;
        this.value = value;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public int getValue() {
        return value;
    }

    public void printQuestion() {
        System.out.println(question);
        for (int i = 0; i < answers.size(); i++) {
            if (i == 1) {
                System.out.print(i + 1 + "." + answers.get(i) + "    " + "\n");
            } else {
                System.out.print(i + 1 + "." + answers.get(i) + "    ");

            }
        }
    }

    public int getCorectAnswer() {
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isCorect()) {
                return i;
            }
        }
        return -1;
    }

    public boolean guessAnswer() {
        int option = 0;
        do {
            System.out.println();
            System.out.println("Type the answer");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            if (option > answers.size()) {
                System.out.println("Please eneter a valid choice");

            }
        }
        while (option > answers.size());
        int guessedAnswer = answers.indexOf(answers.get(option - 1));
        return guessedAnswer == getCorectAnswer();
    }

    public void removeAnswers(Question question) {
        ArrayList<Answer> removedAnswers = new ArrayList<Answer>();
        int corectAnswer = getCorectAnswer();
        int removedPosition = generateRandomNumber(answers.size(), corectAnswer);
        //First add the answer to a new list than delete
        removedAnswers.add(answers.get(removedPosition));
        answers.remove(removedPosition);
        //Repeat
        removedPosition = generateRandomNumber(answers.size(), corectAnswer);
        removedAnswers.add(answers.get(removedPosition));
        answers.remove(removedPosition);
        //Print the question without what was removed
        question.printQuestion();
        //Adding what was removed
        answers.addAll(removedAnswers);

    }

    public int generateRandomNumber(int bound, int corectAnswer) {
        Random rand = new Random();
        int number = 0;
        while (true) {
            number = rand.nextInt(bound);
            if (number != corectAnswer) {
                return number;
            }

        }
    }

}
