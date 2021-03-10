/**
 * 
 */
package org.TA.TANFR.testcases;

import java.util.Scanner;

/**
 * @author Prabhudatta.C
 *
 */
public class Test {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = 0;
		String name = "";

		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Input your name");
				name = in.nextLine();
				int nameval = Integer.parseInt(name);
				System.out.println("You have reached maximum trials");
			} catch (Exception e) {
				break;
			}
		}

		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Input your year of graduation");
				a = in.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Input your year of graduation");
				a = in.nextInt();
				if (i == 4) {
					System.out.println("You have reached maximum trials");
				}
			}
		}
		System.out.println("My name is " + name + " and I'll graduate in " + a);

	}

}
