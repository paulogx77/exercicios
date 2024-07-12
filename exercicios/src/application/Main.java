package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serão digitadas? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		Person[] person = new Person[n];
		
		for (int i = 0; i < person.length; i++) {
			System.out.println("Dados da " + (i + 1) + "a pessoa: ");
			
			System.out.print("Nome: ");
			String nome = sc.next();
			sc.nextLine();
			
			System.out.print("Idade: ");
			int idade = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Altura: ");
			double altura = sc.nextDouble();
			
			person[i] = new Person(nome, idade, altura);
		}
		System.out.println();
		
		double somaAltura = 0;
		for (int i = 0; i < person.length; i++) {
			somaAltura += person[i].getAltura();
		}
		double mediaAltura = somaAltura / person.length;
		System.out.printf("Altura média: %.2f%n", mediaAltura);
		
		
		int quantMenores16 = 0;
		for (int i = 0; i < person.length; i++) {
			if (person[i].getIdade() < 16) {
				quantMenores16 += 1;
			}
		}
			
		String[] menores16 = new String[quantMenores16];
		int index = 0;
		for (int x = 0; x <= quantMenores16; x++) {
			if (person[x].getIdade() < 16) {
				menores16[index] = person[x].getNome();
				index++;
			}
		}

		double percentMenores = ((double)quantMenores16 / person.length) * 100;
		System.out.println("Pessoas com menos de 16 anos: " + percentMenores + "%");
		
		for (int x = 0; x < menores16.length; x++) {
			System.out.println(menores16[x]);
		}
		
		sc.close();
		
		}
}
