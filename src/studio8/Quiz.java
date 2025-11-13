package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;

	/**
	 * Constructor
	 * @param questions
	 */
	public Quiz(Question[] questions) {
		this.questions = questions;
	}

	/**
	 * Prompts the user to answer, then returns a String containing their answer.
	 * @param in
	 * @return String answer
	 */
	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}

	/**
	 * Gets the number of points possible in the quiz.
	 * @return int number of total points
	 */
	public int getTotalPoints() {
		int total = 0;
		if (questions != null) {
			for (Question q : questions) {
				total += q.getPoints();
			}
		}
		return total;
	}

	/**
	 * Asks the user all question in the quiz, then prints out 
	 * the amount of points the user earned. This print statement
	 * should include "You earned ____ points"
	 * 
	 * @param in Scanner object to feed into getUserAnswer
	 */
	public void takeQuiz(Scanner in) {
		int earned = 0;
		if (questions != null) {
			for (Question q : questions) {
				q.displayPrompt();
				String answer = getUserAnswer(in);
				int pts = q.checkAnswer(answer);
				earned += pts;
				// Display points earned for this question
				System.out.println("You have earned " + pts + " points");
			}
		}
		// Final summary with total possible points
		System.out.println("You have earned " + earned + " points.");
	}


	public static void main(String[] args) {
		// Example quiz used for testing
		Question q = new Question("What number studio is this?", "8", 2);

		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);

		String[] choices2 = new String[] {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices2);

		Question[] questions = { q, multipleChoice, selectAll };
		Quiz studio8quiz = new Quiz(questions);

		System.out.println("Total points available: " + studio8quiz.getTotalPoints());
		Scanner in = new Scanner(System.in);
		studio8quiz.takeQuiz(in);
		in.close();
	}
}
