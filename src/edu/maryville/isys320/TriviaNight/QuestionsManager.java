package edu.maryville.isys320.TriviaNight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import org.apache.commons.collections4.list.LazyList;

public class QuestionsManager {
	public ArrayList<String> categories = new ArrayList<String>();
	public ArrayList<String> questions = new ArrayList<String>();;
	public ArrayList<String> answers = new ArrayList<String>();;
	
	public QuestionsManager(String categoryFolder) {
		File fldr = new File(categoryFolder);
		String[] files = fldr.list();
		
		Collections.addAll(categories,files);
		Collections.sort(categories);
		for (String fileName : categories) {
			File f = new File(categoryFolder + "/" + fileName);
			try {
				Scanner fs = new Scanner(f);
				while(fs.hasNextLine()) { // Assume Q, A, Blank Line triplets 
					questions.add(fs.nextLine());
					answers.add(fs.nextLine());
					fs.nextLine();
				}
				fs.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public String[] getCategories() {
		int size = categories.size();
		String truncateString;
/*		for(int i = 1; i < size; i++) {
			truncateString = categories.get(i);
			categories.remove(i);
			truncateString.substring(0, truncateString.lastIndexOf('.'));
			categories.add(truncateString);
		}*/
/*		for(int i = 0; i < categories.size(); i++) {
		categories[i].replaceAll(".txt", "");
		} */
		return categories.toArray(new String[categories.size()]);
	}
	
	public String[] getQuestions() {
		return questions.toArray(new String[questions.size()]);
	}
	
	public String[] getAnswers() {
		//	System.out.println(Arrays.toString(answers.toArray()));

		return answers.toArray(new String[answers.size()]);
	}

}
