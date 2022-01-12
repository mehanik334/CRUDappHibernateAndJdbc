package com.denisenko.crudNew.view;

import com.denisenko.crudNew.controller.SkillController;
import com.denisenko.crudNew.model.Skill;

import java.util.Scanner;

import static com.denisenko.crudNew.utils.Helper.createScannerFromEntering;

public class SkillView {

    private SkillController skillController;

    public SkillView() {
        skillController = new SkillController();
    }

    public void showSkillView() {
        System.out.println("Select and enter the number that matches your choice");
        System.out.println("1 - show all skills");
        System.out.println("2 - get skill");
        System.out.println("3 - delete skill");
        System.out.println("4 - update skill");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println(skillController.getAllSkills());
                case 2 -> showSkillOnView(createScannerFromEntering("Enter id skill"));
                case 3 -> showDeletedSkill(createScannerFromEntering("Enter id skill"));
                case 4 -> showUpdateSkill(createScannerFromEntering("Enter id and name skill"));
                default -> System.out.println("Wrong entering");
            }
        }
    }

    private void showSkillOnView(Scanner scanner) {
        System.out.println(skillController.getByIdSkill(scanner.nextLong()));
    }

    private void showDeletedSkill(Scanner scanner) {
        if(skillController.deleteSkillById(scanner.nextLong()))
        System.out.println("Skill delete");
    }

    private void showUpdateSkill(Scanner scanner) {
        Skill skill = new Skill(scanner.nextLong(),scanner.nextLine());
        System.out.println(skillController.updateSkill(skill));
    }

}
