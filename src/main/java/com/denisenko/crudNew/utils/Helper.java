package com.denisenko.crudNew.utils;

import java.util.Scanner;

public class Helper {

    public static Scanner createScannerFromEntering(String enterString) {
        System.out.println(enterString);
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}
