package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.FishesDAO;
import entity.Fishes;

public class Menu {

	private Scanner sc = new Scanner(System.in);
	
	private FishesDAO FishesDAO = new FishesDAO();
	
	private List<String> menuOptions = Arrays.asList("Display Fish", "Create Fish", "Delete Fish");
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = sc.nextLine();
			try {
				if (selection.equals("1")) {
					displayFish();
				} else if (selection.equals("2")) {
					createFish();
				} else if (selection.equals("3")) {
					deleteFish();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("\nPress Enter to Continue:___");
			sc.nextLine();
		} while (!selection.equals("-1"));
	}
	

	private void printMenu() {
		System.out.println("Select an Option: \n-----------------------");
		for (int i = 0; i < menuOptions.size(); i++) {
			System.out.println(i + 1 + "| " + menuOptions.get(i));
		}
	}
	
	private void displayFish() throws SQLException {
		List<Fishes> fish = FishesDAO.getFish();
		for (Fishes fishes : fish) {
			System.out.println(fishes.getFishId() + ": " + fishes.getName());
		}
	}
	
	private void createFish() throws SQLException {
		System.out.println("Enter a new Fish:");
		String fishName = sc.nextLine();
		FishesDAO.createFish(fishName);
	}
	
	private void deleteFish() throws SQLException {
	System.out.println("Enter the Fish ID you wish to delete:");
	int id = Integer.parseInt(sc.nextLine());
	FishesDAO.deleteFish(id);
	}
	
}
