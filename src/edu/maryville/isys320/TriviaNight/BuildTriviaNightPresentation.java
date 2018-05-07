package edu.maryville.isys320.TriviaNight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildTriviaNightPresentation {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = "E:\\Users\\Brian\\Documents\\GitHub\\trivia-night-creator-bwilliams8\\TriviaNight.pptx";
		SlideShowBuilder builder = new SlideShowBuilder();
		QuestionsManager qm = new QuestionsManager("data");
		
		Boolean gameType = null;
		Scanner console = new Scanner(System.in);
		
		String[] categories = qm.getCategories();
		String[] questions = qm.getQuestions();
		String[] answers = qm.getAnswers();
		
		if (categories.length != 10) {
			System.out.println("Please ensure that there are exactly ten categories.");
			System.exit(-1);
		}
		
		if (questions.length != 100) {
			System.out.println("Please ensure that each category has exactly ten questions.");
			System.exit(-1);
		}
		
		if (answers.length != 100) {
			System.out.println("Please ensure that each question has an answer.");
			System.exit(-1);
		}

		while (gameType == null) {
		System.out.println("Would you like your trivia game to be Category Set or Round Number?");
		System.out.println("Type 1 for Category Set or 2 for Round Number.");
		int gameInput = console.nextInt();
		if (gameInput == 1) {
				gameType = true;
				break;
		} else if (gameInput == 2) {
			gameType = false;
			break;
		} else {
			System.out.println("Please choose between Category Set and Round Number.");
		}
		}
		
		
		builder.buildSlideShow(qm.getCategories(), qm.getQuestions(), qm.getAnswers(), fileName, gameType);
//		builder.printSlideShowInfo("Sample.pptx");
		console.close();
	}
	
}
