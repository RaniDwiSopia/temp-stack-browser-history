package com.github.affandes.kuliah.pm;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private final LinkedList<String> history;
    public Main() {
        this.history = new LinkedList<>();
    }
            public void browser(String website) {
                history.addFirst(website);
                System.out.println("Browsing: " + website);
            }

            public void back() {
                if (history.size() > 1) {
                    history.removeFirst();
                    System.out.println("Back to: " + history.getFirst());
                } else if (history.size() == 1) {
                    System.out.println("No previous websites. Currently at: " + history.getFirst());
                } else {
                    System.out.println("History is empty.");
                }
            }

            public void view() {
                if (history.isEmpty()) {
                    System.out.println("No browsing history.");
                } else {
                    System.out.println("Browsing History (most recent first):");
                    for (String site : history) {
                        System.out.println(site);
                    }
                }
            }

            public static void main(String[] args) {
                Main browser = new Main();
                Scanner scanner = new Scanner(System.in);
                String command;

                System.out.println("Browser History Simulation");
                System.out.println("Commands: view, browse <website>, back, exit");

                while (true) {
                    System.out.print("Enter command: ");
                    command = scanner.nextLine();

                    if (command.equals("view")) {
                        browser.view();
                    } else if (command.startsWith("browse ")) {
                        String website = command.substring(7);
                        browser.browser(website);
                    } else if (command.equals("back")) {
                        browser.back();
                    } else if (command.equals("exit")) {
                        break;
                    } else {
                        System.out.println("Unknown command. Please try again.");
                    }
                }

                scanner.close();
            }
        }

