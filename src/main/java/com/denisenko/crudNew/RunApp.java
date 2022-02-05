package com.denisenko.crudNew;


import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.repository.DeveloperRepository;
import com.denisenko.crudNew.repository.SkillRepository;
import com.denisenko.crudNew.repository.TeamRepository;
import com.denisenko.crudNew.repository.hibernate.HibernateDeveloperRepository;
import com.denisenko.crudNew.repository.hibernate.HibernateSkillRepository;
import com.denisenko.crudNew.repository.hibernate.HibernateTeamRepository;
import com.denisenko.crudNew.view.DeveloperView;
import com.denisenko.crudNew.view.SkillView;
import com.denisenko.crudNew.view.TeamView;

import java.util.Scanner;

public class RunApp {
    public static void main(String[] args) {
        System.out.println("Select and enter the number that matches your choice");
        System.out.println("1 - work with developer");
        System.out.println("2 - work with skill");
        System.out.println("3 - work with team");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    DeveloperView developerView = new DeveloperView();
                    developerView.showDeveloperView();
                }
                case 2 -> {
                    SkillView skillView = new SkillView();
                    skillView.showSkillView();
                }
                case 3 -> {
                    TeamView teamView = new TeamView();
                    teamView.showTeamView();
                }
                default -> {
                    System.out.println("Wrong entering");
                }
            }
        }

    }
}
