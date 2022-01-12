package com.denisenko.crudNew.view;

import com.denisenko.crudNew.controller.DeveloperController;
import com.denisenko.crudNew.controller.TeamController;
import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.model.Team;

import java.util.Scanner;

import static com.denisenko.crudNew.utils.Helper.createScannerFromEntering;

public class DeveloperView {

    private DeveloperController developerController;
    private TeamController teamController;
    public DeveloperView() {
        developerController = new DeveloperController();
    }

    public void showDeveloperView() {
        System.out.println("Select and enter the number that matches your choice");
        System.out.println("1 - show all developer");
        System.out.println("2 - get developer");
        System.out.println("3 - delete developer");
        System.out.println("4 - update developer");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println(developerController.getAllDevelopers());
                case 2 -> showDeveloperOnView(createScannerFromEntering("Enter id developer"));
                case 3 -> showDeletedDeveloper(createScannerFromEntering("Enter id developer"));
                case 4 -> showUpdateDeveloper(createScannerFromEntering("Enter id , first name,last name and team id developer"));
                default -> System.out.println("Wrong entering");
            }
        }
    }

    private void showDeveloperOnView(Scanner scanner) {
        System.out.println(developerController.getByIdDeveloper(scanner.nextLong()));
    }

    private void showDeletedDeveloper(Scanner scanner) {
        if(developerController.deleteDeveloperById(scanner.nextLong()))
        System.out.println("Developer delete");
    }

    private void showUpdateDeveloper(Scanner scanner) {
        teamController = new TeamController();
        Developer developer = new Developer(scanner.nextLong(),scanner.nextLine(), scanner.nextLine(),teamController.getByIdTeam(scanner.nextLong()));
        System.out.println(developerController.updateDeveloper(developer));
    }
}
