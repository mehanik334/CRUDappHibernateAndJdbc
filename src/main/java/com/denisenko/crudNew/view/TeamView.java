package com.denisenko.crudNew.view;

import com.denisenko.crudNew.controller.TeamController;
import com.denisenko.crudNew.model.Team;

import java.util.Scanner;

import static com.denisenko.crudNew.utils.Helper.createScannerFromEntering;

public class TeamView {

    private TeamController teamController;

    public TeamView() {
        teamController = new TeamController();
    }

    public void showTeamView() {
        System.out.println("Select and enter the number that matches your choice");
        System.out.println("1 - show all teams");
        System.out.println("2 - get team");
        System.out.println("3 - delete team");
        System.out.println("4 - update team");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println(teamController.getAllTeams());
                case 2 -> showTeamOnView(createScannerFromEntering("Enter id team"));
                case 3 -> showDeletedTeam(createScannerFromEntering("Enter id team"));
                case 4 -> showUpdateTeam(createScannerFromEntering("Enter id and name team"));
                default -> System.out.println("Wrong entering");
            }
        }
    }

    private void showTeamOnView(Scanner scanner) {
        System.out.println(teamController.getByIdTeam(scanner.nextLong()));
    }

    private void showDeletedTeam(Scanner scanner) {
        if(teamController.deleteTeamById(scanner.nextLong()))
        System.out.println("Skill delete");
    }

    private void showUpdateTeam(Scanner scanner) {
        Team team = new Team(scanner.nextLong(),scanner.nextLine());
        System.out.println(teamController.updateTeam(team));
    }
}
