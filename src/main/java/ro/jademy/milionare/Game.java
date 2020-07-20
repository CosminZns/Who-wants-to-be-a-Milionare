package ro.jademy.milionare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private ArrayList<ArrayList<Question>> questions;
    private Player player;


    public Game(ArrayList<ArrayList<Question>> questions, Player player) {
        this.questions = questions;
        this.player = player;
    }

    //De paramatrizat
    public void playRound() {
        for (int i = 0; i < questions.size(); i++) {
            for (int j = 0; j < questions.get(i).size(); j++) {
                questions.get(i).get(j).printQuestion();
                if (!player.getRemoveAnswers()) {
                    ask(questions.get(i).get(j));
                }
                //if gueesed righ, continue
                if (questions.get(i).get(j).guessAnswer()) {
                    player.setMoney(player.getMoney() + questions.get(i).get(j).getValue());
                    player.setMoney(player.getMoney() + questions.get(i).get(j).getValue());
                    System.out.println("Good job, you reached " + player.getMoney() + "$");
                } else {
                    //verific la ce checkpoint esti si iti dau banii aia
                    if (player.getMoney() < 600) {
                        System.out.println("Sorry you lost, maybe next time, you will leave with 0$");
                    } else if (player.getMoney() < 10600) {
                        System.out.println("Sorry you lost, maybe next time, you will leave with " + 600 + "$");
                    } else if (player.getMoney() < 65600) {
                        System.out.println("Sorry you lost, maybe next time, you will leave with " + 10600 + "$");
                    } else if (player.getMoney() == 65600) {
                        System.out.println("Congratulations, you are a milionare now");
                    }
                    playAgain();
                    break;
                }
            }
        }
    }

    public void playRound2(ArrayList<ArrayList<Question>> questions) {
        for (int i = 0; i < questions.size(); i++) {
            for (int j = 0; j < questions.get(i).size(); j++) {
                questions.get(i).get(j).printQuestion();
                if (!player.getRemoveAnswers()) {
                    ask(questions.get(i).get(j));
                }
                //if gueesed righ, continue
                if (questions.get(i).get(j).guessAnswer()) {
                    player.setMoney(player.getMoney() + questions.get(i).get(j).getValue());
                    player.setMoney(player.getMoney() + questions.get(i).get(j).getValue());
                    System.out.println("Good job, you reached " + player.getMoney() + "$");
                } else {
                    //verific la ce checkpoint esti si iti dau banii aia
                    if (player.getMoney() < 600) {
                        System.out.println("Sorry you lost, maybe next time, you will leave with 0$");
                    } else if (player.getMoney() < 10600) {
                        System.out.println("Sorry you lost, maybe next time, you will leave with " + 600 + "$");
                    } else if (player.getMoney() < 65600) {
                        System.out.println("Sorry you lost, maybe next time, you will leave with " + 10600 + "$");
                    } else if (player.getMoney() == 65600) {
                        System.out.println("Congratulations, you are a milionare now");
                    }
                    playAgain();
                    break;
                }
            }
        }
    }


    public  ArrayList<ArrayList<Question>> randomizeAllQuestions() {
        //For each sublist of questions we get new lists of random questions
        ArrayList<ArrayList<Question>> questions1 = new ArrayList<ArrayList<Question>>();
        for (int i = 0; i < questions.size(); i++) {
            questions1.add(pickQuestions(questions.get(i)));
        }
        return questions1;
    }


    public void playGame() {
        System.out.println("Welcome " + player.getName() + " to who want's to became a milionare");
        playRound();
        //playRound2(randomizeAllQuestions());
        playAgain();
    }

    public void playAgain() {
        System.out.println("Do you want to play again?  y/n");
        Scanner sc = new Scanner(System.in);
        String decision = sc.next();
        if (decision.equals("y")) {
            player.setMoney(0);
            player.setRemoveAnswers(false);
            playGame();
        } else {
            System.exit(0);
        }
    }

    public void ask(Question question) {
        System.out.println();
        System.out.println("Do you want to use your 50-50 option?  y/n");
        Scanner sc = new Scanner(System.in);
        String decision = sc.next();
        if (decision.equals("y")) {
            question.removeAnswers(question);
            player.setRemoveAnswers(true);
        }
    }

    public ArrayList<Integer> randomizeQuestions(int bound, int howMany) {
        //Generate x numbers random with no duplicates within a range
        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> numberWithoutDuplicates = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            int nr = random.nextInt(bound);
            numbers.add(nr);
        }

        for (Integer number : numbers) {
            if (!numberWithoutDuplicates.contains(number)) {
                if (numberWithoutDuplicates.size() < howMany) {
                    numberWithoutDuplicates.add(number);

                } else break;
            }
        }

        return numberWithoutDuplicates;
    }

    public ArrayList<Question> pickQuestions(ArrayList<Question> questions) {
        // For each  question create a new list were added the random questions
        ArrayList<Integer> numbers = randomizeQuestions(questions.size()-1, 3);
        ArrayList<Question> questions1 = new ArrayList<Question>();
        for (Integer number : numbers) {
            questions1.add(questions.get(number));
        }
        return questions1;
    }
}