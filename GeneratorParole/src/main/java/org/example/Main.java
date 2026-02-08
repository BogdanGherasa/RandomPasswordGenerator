package org.example;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Generator de Parole Random ---");
        System.out.println("Introduceți lungimea parolei dorite:");
        int lungimeParola = sc.nextInt();
        String parola = generatePassword(lungimeParola);
        
        System.out.println("Parola generată: " + parola);
        
        sc.close();
    }

    public static String generatePassword(int length) {
        String LitereMare = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LitereMica = "abcdefghijklmnopqrstuvwxyz";
        String Cifre = "0123456789";
        String Speciale = "!@#$%^&*()_+";

        String ToateCaractere = LitereMare + LitereMica + Cifre + Speciale;

        StringBuilder Parola = new StringBuilder();

        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(ToateCaractere.length());
            char caracterExtras = ToateCaractere.charAt(index);
            Parola.append(caracterExtras);
        }
        return Parola.toString();
    }
}