package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = getValidName(scanner);
        String mood = getValidMood(scanner);

        if (mood.contains("bad") || mood.contains("awful") || mood.contains("terrible") || mood.contains("horrible") || mood.contains("not great")) {
            System.out.println("Hello " + userName + "! I'm sorry to hear you're doing " + mood + " today.");
        } else {
            System.out.println("Hello " + userName + "! I'm glad you're doing " + mood + " today!");
        }

        if (mood.contains("bad") || mood.contains("awful") || mood.contains("terrible") || mood.contains("horrible") || mood.contains("not great")) {
            System.out.println("Well, let's play a game that will hopefully make you feel better!");
        } else {
            System.out.println("Let's play a game!");
        }

        System.out.println("I am going to try and guess your age by asking you a series of questions.");
        System.out.println("Please answer truthfully so that I can get it right!");

        guessAge();

        countToNumber(scanner);

        testProgrammingKnowledge(scanner);

        scanner.close();
    }

    private static String getValidName(Scanner scanner) {
        String name;
        while (true) {
            System.out.println("Hello user! Remind me again, what is your name?");
            name = scanner.nextLine();
            if (name.matches(".*\\d.*")) {
                System.out.println("That's a number silly, what is your name?");
            } else {
                break;
            }
        }
        return name;
    }

    private static String getValidMood(Scanner scanner) {
        String mood;
        while (true) {
            System.out.println("How are you doing today?");
            mood = scanner.nextLine().toLowerCase();
            if (mood.matches(".*\\d.*")) {
                System.out.println("That's a number silly, how are you doing today?");
            } else {
                break;
            }
        }
        return mood;
    }

    private static void guessAge() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int startAge = 0;
            int endAge = 10;
            boolean ageFound = false;

            while (endAge <= 120) {
                System.out.println("Are you between " + startAge + " and " + endAge + " years old? (yes/no)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("yes")) {
                    ageFound = true;
                    break;
                } else {
                    startAge += 10;
                    endAge += 10;
                }
            }

            if (ageFound) {
                while (startAge < endAge) {
                    int midAge = (startAge + endAge) / 2;
                    System.out.println("Are you between " + startAge + " and " + midAge + " years old? (yes/no)");
                    String response = scanner.nextLine();

                    if (response.equalsIgnoreCase("yes")) {
                        endAge = midAge;
                    } else {
                        startAge = midAge + 1;
                    }
                }
                System.out.println("Based on your answers, I guess your age is: " + startAge);
                break;
            } else {
                System.out.println("Oh come on, stop lying and do this truthfully this time.");
            }
        }
    }

    private static void countToNumber(Scanner scanner) {
        while (true) {
            System.out.println("Enter a number, and I will count to it:");

            int number;
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Counting to " + number + ":");
                for (int i = 1; i <= number; i++) {
                    System.out.println(i);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static void testProgrammingKnowledge(Scanner scanner) {
        boolean correct = false;
        while (!correct) {
            System.out.println("Let's test your programming knowledge!");
            System.out.println("Which of the following is not a Java primitive data type?");
            System.out.println("1. int");
            System.out.println("2. float");
            System.out.println("3. String");
            System.out.println("4. char");

            int answer;
            try {
                answer = scanner.nextInt();
                scanner.nextLine();

                if (answer == 3) {
                    System.out.println("Correct! 'String' is not a primitive data type.");
                    correct = true;
                } else {
                    System.out.println("Incorrect. Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
