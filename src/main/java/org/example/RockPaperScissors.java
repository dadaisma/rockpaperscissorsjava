package org.example;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        int wins = 0;
        int losses = 0;

        // Game loop
        while (true) {
            System.out.println("Bienvenido a Rock Paper Scissors!");
            System.out.println("Ingrese 'rock', 'paper', o 'scissors' (escribir 'adios' para salir):");

            String playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals("adios")) {
                break;
            }

            if (!isValidMove(playerMove, choices)) {
                System.out.println("Movimiento inválido. Inténtalo nuevamente.");
                continue;
            }

            int computerMoveIndex = random.nextInt(choices.length);
            String computerMove = choices[computerMoveIndex];

            System.out.println("Tu elección: " + playerMove);
            System.out.println("PC Tony el Magico: " + computerMove);

            String result = determineWinner(playerMove, computerMove);
            System.out.println(result);

            if (result.equals("¡Has ganado! W o W!!!")) {
                wins++;
            } else if (result.equals("¡Oh no! Has perdido.")) {
                losses++;
            }
        }

        System.out.println("¡Gracias por jugar y divertirte!");
        System.out.println("Victorias: " + wins);
        System.out.println("Derrotas: " + losses);
    }

    public static boolean isValidMove(String move, String[] validMoves) {
        for (String validMove : validMoves) {
            if (move.equals(validMove)) {
                return true;
            }
        }
        return false;
    }

    public static String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "TELEPATIA - Empate. Nadie gana.";
        } else if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
                (playerMove.equals("paper") && computerMove.equals("rock")) ||
                (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "¡Has ganado! W o W!!!";
        } else {
            return "¡Oh no! Has perdido.";
        }
    }
}
