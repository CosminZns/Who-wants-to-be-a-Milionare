package ro.jademy.milionare;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Cosmin", 0, false);
        //Easy Questions
        Answer answer = new Answer("cosmin", true);
        Answer answer1 = new Answer("maria", false);
        Answer answer2 = new Answer("elena", false);
        Answer answer3 = new Answer("andrei", false);
        ArrayList<Answer> firstQuestion = new ArrayList<Answer>();
        firstQuestion.add(answer);
        firstQuestion.add(answer1);
        firstQuestion.add(answer2);
        firstQuestion.add(answer3);

        Answer answer4 = new Answer("n am", true);
        Answer answer5 = new Answer("multi", false);
        Answer answer6 = new Answer("putini", false);
        Answer answer7 = new Answer("100 lei", false);
        ArrayList<Answer> secondQuestion = new ArrayList<Answer>();
        secondQuestion.add(answer4);
        secondQuestion.add(answer5);
        secondQuestion.add(answer6);
        secondQuestion.add(answer7);

        Answer answer8 = new Answer("azi", false);
        Answer answer9 = new Answer("maine", false);
        Answer answer10 = new Answer("ieri", false);
        Answer answer45 = new Answer("poimarti", true);
        ArrayList<Answer> thirdQuestion = new ArrayList<Answer>();
        thirdQuestion.add(answer8);
        thirdQuestion.add(answer9);
        thirdQuestion.add(answer10);
        thirdQuestion.add(answer45);


        EasyQuestion easyQuestion1 = new EasyQuestion("Cine e bossul?", firstQuestion, 100);
        EasyQuestion easyQuestion2 = new EasyQuestion("Cati bani am?", secondQuestion, 200);
        EasyQuestion easyQuestion3 = new EasyQuestion("Cand plec la mare?", thirdQuestion, 300);

        ArrayList<EasyQuestion> easyQuestions = new ArrayList<EasyQuestion>();
        easyQuestions.add(easyQuestion1);
        easyQuestions.add(easyQuestion2);
        easyQuestions.add(easyQuestion3);


        //Medium Questions
        Answer answer11 = new Answer("nimeni", true);
        Answer answer22 = new Answer("eu", false);
        Answer answer33 = new Answer("el", false);
        Answer answer44 = new Answer("cica creanga", false);
        ArrayList<Answer> firstQuestion1 = new ArrayList<Answer>();
        firstQuestion1.add(answer11);
        firstQuestion1.add(answer22);
        firstQuestion1.add(answer33);
        firstQuestion1.add(answer44);

        Answer answer55 = new Answer("mari sanse", false);
        Answer answer66 = new Answer("n as crede", true);
        Answer answer77 = new Answer("nu", false);
        Answer answer88 = new Answer("da ", false);
        ArrayList<Answer> secondQuestion1 = new ArrayList<Answer>();
        secondQuestion1.add(answer55);
        secondQuestion1.add(answer66);
        secondQuestion1.add(answer77);
        secondQuestion1.add(answer88);

        Answer answer90 = new Answer("greu de spus", false);
        Answer answer91 = new Answer("au dar nu il vezi", false);
        Answer answer92 = new Answer("de la soseste", false);
        Answer answer93 = new Answer("toate cele de mai sus", true);
        ArrayList<Answer> thirdQuestion1 = new ArrayList<Answer>();
        thirdQuestion1.add(answer90);
        thirdQuestion1.add(answer91);
        thirdQuestion1.add(answer92);
        thirdQuestion1.add(answer93);


        MediumQuestion mediumQuestion1 = new MediumQuestion("Cine a scris luceafarul?", firstQuestion1, 1000);
        MediumQuestion mediumQuestion2 = new MediumQuestion("Crezi ca ai baut lapte de la aceiasi vaca ?", secondQuestion1, 3000);
        MediumQuestion mediumQuestion3 = new MediumQuestion("De ce miros picioarele daca nu au nas ?", thirdQuestion1, 6000);

        ArrayList<MediumQuestion> mediumQuestions = new ArrayList<MediumQuestion>();
        mediumQuestions.add(mediumQuestion1);
        mediumQuestions.add(mediumQuestion2);
        mediumQuestions.add(mediumQuestion3);


        //Hard Questions
        Answer answer80 = new Answer("de sete", false);
        Answer answer81 = new Answer("de ciuda", true);
        Answer answer82 = new Answer("de nevoie", false);
        Answer answer83 = new Answer("degeaba", false);
        ArrayList<Answer> firstQuestion11 = new ArrayList<Answer>();
        firstQuestion11.add(answer80);
        firstQuestion11.add(answer81);
        firstQuestion11.add(answer82);
        firstQuestion11.add(answer83);

        Answer answer84 = new Answer("ai cotul mic", false);
        Answer answer85 = new Answer("ai limba mica", false);
        Answer answer86 = new Answer("n ai incercat inca", true);
        Answer answer87 = new Answer("niciuna dintre variantele de mai sus ", false);
        ArrayList<Answer> secondQuestion22 = new ArrayList<Answer>();
        secondQuestion22.add(answer84);
        secondQuestion22.add(answer85);
        secondQuestion22.add(answer86);
        secondQuestion22.add(answer87);

        Answer answer23 = new Answer("masina cu motor", false);
        Answer answer24 = new Answer("masina lu becali", true);
        Answer answer25 = new Answer("nu exista masini", false);
        Answer answer26 = new Answer("masina mea", false);
        ArrayList<Answer> thirdQuestion33 = new ArrayList<Answer>();
        thirdQuestion33.add(answer23);
        thirdQuestion33.add(answer24);
        thirdQuestion33.add(answer25);
        thirdQuestion33.add(answer26);


        HardQuestion hardQuestion1 = new HardQuestion("De ce beau oamenii apa?", firstQuestion11, 10000);
        HardQuestion hardQuestion2 = new HardQuestion("De ce nu poti sa iti atingi cotul cu limba?", secondQuestion22, 15000);
        HardQuestion hardQuestion3 = new HardQuestion("Care este masina care merge cel mai repede ?", thirdQuestion33, 30000);

        ArrayList<HardQuestion> hardQuestions = new ArrayList<HardQuestion>();
        hardQuestions.add(hardQuestion1);
        hardQuestions.add(hardQuestion2);
        hardQuestions.add(hardQuestion3);

        Game game = new Game(easyQuestions, player, mediumQuestions, hardQuestions);
        game.playGame();


    }
}
