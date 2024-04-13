import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> quiz;
    private int maxScore;
    private int playerScore;
    private ArrayList<Flashcards> wrongQuestions;

    public Quiz() {
        quiz = new ArrayList<>();
        maxScore = quiz.size();
        playerScore = 0;
    }

    public ArrayList<Question> getQuiz() {
        ArrayList<Question> quizCopy = new ArrayList<>();
        for (Question q : quiz) {
            quiz.add(q);
        }
        return quizCopy;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private boolean isCorrectAnswer(String answer, Question ques) {
        if ((answer == "A" || answer == "a") && ques.getAnswerIndex() == 0) {
            return true;
        }
        if ((answer == "B" || answer == "b") && ques.getAnswerIndex() == 1) {
            return true;
        }
        if ((answer == "C" || answer == "c") && ques.getAnswerIndex() == 2) {
            return true;
        }
        if (((answer == "D" || answer == "d")) && ques.getAnswerIndex() == 3) {
            return true;
        }
        return false;
    }

    private String displayResults() {
        return String.format("You got %d/%d correct. Any questions you got incorrect will be availible for you to review" +
                "for review in main menu", playerScore, maxScore);

    }

    public void addQuestion(String question, String an1, String an2, String an3, String an4, int anIn) {
        Question newQuestion = new Question(question, an1, an2, an3, an4, anIn);
        quiz.add(newQuestion);
        maxScore = quiz.size();
    }

    public void takeQuiz() {
        Scanner keyboard = new Scanner(System.in);
        for (Question q:quiz){
            System.out.print(q + "\n");
            String userAnswer = validateAnswer(keyboard);
            if(isCorrectAnswer(userAnswer, q)){
                playerScore++;
            } else {
                ArrayList<String> answersCopy = q.getAnswers();
                wrongQuestions.add(new Flashcards(q.getQuestion(), answersCopy.get(q.getAnswerIndex())));
            }
        }
        keyboard.close();
        System.out.println(displayResults());
    }

    private String validateAnswer(Scanner keyboard){
        String answer;
        while(true){
            System.out.println("Enter your answer: ");
            answer = keyboard.nextLine();
            if (answer.isEmpty()){
                System.out.println("No input. Please enter in A, B, C, or D");
            } else if (answer.length() > 1){
                System.out.println("Answer more than one character. Please enter in A, B, C, or D");
            } else {
                if (answer.equals("A") || answer.equals("a")){
                    break;
                }
                if (answer.equals("B") || answer.equals("b")){
                    break;
                }
                if (answer.equals("C") || answer.equals("b")){
                    break;
                }
                if (answer.equals("D") || answer.equals("d")){
                    break;
                }
                System.out.println("Letter inputted not A, B, C, or D.");
            }

        }
        return answer;
    }
}