package ro.jademy.milionare;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    static String host = "jdbc:mysql://localhost:3306/milionaregame";
    static String uName = "cosmin";
    static String uPass = "";
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

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


        Question easyQuestion1 = new Question("Cine e bossul?", firstQuestion, 100, "easy");
        Question easyQuestion2 = new Question("Cati bani am?", secondQuestion, 200, "easy");
        Question easyQuestion3 = new Question("Cand plec la mare?", thirdQuestion, 300, "easy");


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


        Question mediumQuestion1 = new Question("Cine a scris luceafarul?", firstQuestion1, 1000, "medium");
        Question mediumQuestion2 = new Question("Crezi ca ai baut lapte de la aceiasi vaca ?", secondQuestion1, 3000, "medium");
        Question mediumQuestion3 = new Question("De ce miros picioarele daca nu au nas ?", thirdQuestion1, 6000, "medium");


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


        Question hardQuestion1 = new Question("De ce beau oamenii apa?", firstQuestion11, 10000, "hard");
        Question hardQuestion2 = new Question("De ce nu poti sa iti atingi cotul cu limba?", secondQuestion22, 15000, "hard");
        Question hardQuestion3 = new Question("Care este masina care merge cel mai repede ?", thirdQuestion33, 30000, "hard");


        ArrayList<Question> easyQuestions = new ArrayList<Question>();
        easyQuestions.add(easyQuestion1);
        easyQuestions.add(easyQuestion2);
        easyQuestions.add(easyQuestion3);


        ArrayList<Question> mediumQuestions = new ArrayList<Question>();
        mediumQuestions.add(mediumQuestion1);
        mediumQuestions.add(mediumQuestion2);
        mediumQuestions.add(mediumQuestion3);


        ArrayList<Question> hardQuestions = new ArrayList<Question>();
        hardQuestions.add(hardQuestion1);
        hardQuestions.add(hardQuestion2);
        hardQuestions.add(hardQuestion3);

        //Interne
        ArrayList<ArrayList<Question>> questions = new ArrayList<ArrayList<Question>>();
        questions.add(easyQuestions);
        questions.add(mediumQuestions);
        questions.add(hardQuestions);



        //Din BAZA DE DATE
        ArrayList<ArrayList<Question>> da = new ArrayList<ArrayList<Question>>();
        da.add(createQuestions("easy"));
        da.add(createQuestions("medium"));
        da.add(createQuestions("hard"));



        Game game = new Game(questions, player);
        game.playGame();

    }

    public static Question createQuestion(String dificulty, ArrayList<Answer> answers, int id) throws SQLException {
        Question question = null;
        String sql = "select * from question where dificulty=? and id_question=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, dificulty);
        stat.setInt(2, id);
        ResultSet rs = stat.executeQuery();
        while (rs.next()) {
            question = new Question(rs.getString("question"), answers, rs.getInt("value"), rs.getString("dificulty"));
        }
        return question;
    }

    public static ArrayList<Answer> createAnswers(int id) throws SQLException {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        String sql = "SELECT answer.answer,answer.dificulty,answer.is_corect FROM question inner JOIN answer_question ON question.id_question =answer_question.id_question inner join answer on answer_question.id_answer=answer.id_answer where question.id_question=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1, id);
        ResultSet rs = stat.executeQuery();
        while (rs.next()) {
            Answer answer = new Answer(rs.getString("answer"), rs.getBoolean("is_corect"));
            answers.add(answer);
        }
        return answers;
    }

    public static ArrayList<Integer> questionsIdList() throws SQLException {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        String sql = "select id_question from question";
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            ids.add(rs.getInt("id_question"));
        }
        return ids;
    }

    public static ArrayList<Question> createQuestions(String dificulty) throws SQLException {
        ArrayList<Integer> idList = questionsIdList();
        ArrayList<Question> questions = new ArrayList<Question>();
        for (int i = 1; i <= idList.size(); i++) {
            questions.add(createQuestion(dificulty, createAnswers(i), i));
        }
        return questions;
    }


}
