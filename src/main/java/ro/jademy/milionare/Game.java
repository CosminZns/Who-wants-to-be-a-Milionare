package ro.jademy.milionare;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<EasyQuestion> easyQuestions;
    private ArrayList<MediumQuestion> mediumQuestions;
    private ArrayList<HardQuestion> hardQuestions;
    private Player player;


    public Game(ArrayList<EasyQuestion> easyQuestions, Player player, ArrayList<MediumQuestion> mediumQuestions, ArrayList<HardQuestion> hardQuestions) {
        this.easyQuestions = easyQuestions;
        this.mediumQuestions = mediumQuestions;
        this.hardQuestions = hardQuestions;
        this.player = player;
    }


    public int playEasyRound() {
        for (EasyQuestion easyQuestion : easyQuestions) {
            easyQuestion.printQuestion();
            if (!player.getRemoveAnswers()) {
                ask(easyQuestion);
            }
            //if gueesed righ, continue
            if (easyQuestion.guessAnswer()) {
                player.setMoney(player.getMoney() + easyQuestion.getValue());
                System.out.println("Good job, you reached " + player.getMoney() + "$");
            }
            //guessed wrong, game stops
            else {
                System.out.println("Sorry you lost, maybe next time");
                playAgain();
            }
            System.out.println("-----------------");

        }
        return player.getMoney();
    }

    public int playMediumRound(int money) {
        System.out.println("Congratulations, you reached the first checkpoint ");
        for (MediumQuestion mediumQuestion : mediumQuestions) {
            mediumQuestion.printQuestion();
            if (!player.getRemoveAnswers()) {
                ask(mediumQuestion);
            }
            //if gueesed righ, continue
            if (mediumQuestion.guessAnswer()) {
                player.setMoney(player.getMoney() + mediumQuestion.getValue());
                System.out.println("Good job, you reached " + player.getMoney() + "$");
            }
            //guessed wrong, game stops
            else {
                System.out.println("Sorry you lost, maybe next time, you will leave with " + money + "$");
                playAgain();
            }
            System.out.println("-----------------");

        }
        return player.getMoney();

    }

    public void playHardRound(int money) {
        System.out.println("Congratulations, you reached the second checkpoint ");
        for (HardQuestion hardQuestion : hardQuestions) {
            hardQuestion.printQuestion();
            if (!player.getRemoveAnswers()) {
                ask(hardQuestion);
            }
            //if gueesed righ, continue
            if (hardQuestion.guessAnswer()) {
                player.setMoney(player.getMoney() + hardQuestion.getValue());
                System.out.println("Good job, you reached " + player.getMoney() + "$");
            }
            //guessed wrong, game stops
            else {
                System.out.println("Sorry you lost, maybe next time, you will leave with " + money + "$");
                playAgain();
            }
            System.out.println("-----------------");

        }

    }


    public void playGame() {
        System.out.println("Welcome " + player.getName() + " to who want's to became a milionare");
        int money = playEasyRound();
        money = playMediumRound(money);
        playHardRound(money);
        System.out.println("Congratulations, you are a milionare now");
        playAgain();

    }

    public void playAgain() {
        System.out.println("Do you want to play again?  y/n");
        Scanner sc = new Scanner(System.in);
        String decision = sc.next();
        if (decision.equals("y")) {
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

}