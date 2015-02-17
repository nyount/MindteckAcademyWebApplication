package com.mindteck.test;

import java.util.Scanner;

import com.mindteck.businesslayer.AcademyManager;
	
public class AcademyDriver {
	
	public static void main(String[] args) {
		int userInput = 0;
		boolean valid;
		boolean running = true;
		Scanner input = new Scanner(System.in);
		AcademyManager academyManager = new AcademyManager();
		
		academyManager.showWelcomeMessage();

		while (running) {
			
			valid = false;
			
			while (!valid) {
				academyManager.showMainMenu();
				try {
					userInput = input.nextInt();
					valid = true;
				}
				catch (Exception e) {
					System.out.println("That is not a valid option.");
					input.nextLine();
				}
			}
			
			switch (userInput) {
			case 1:
				academyManager.handleInstructor();
				break;
			case 2:
				academyManager.handleCourse();
				break;
			case 3:
				academyManager.handleGraduate();
				break;
			case 4:
				academyManager.handleAssignment();
				break;
			case 5:
				running = false;
				break;
			default:
				System.out.println("That is not a valid option.");
				break;
			}
		}
		
		academyManager.showGoodByeMessage();
		
	}

}