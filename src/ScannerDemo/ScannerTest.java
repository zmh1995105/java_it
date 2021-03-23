package ScannerDemo;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int h1 = sc.nextInt();
	int h2 = sc.nextInt();
	int h3 = sc.nextInt();

	int temph = h1 > h2 ? h1 : h2;
	int maxh = temph > h3 ? temph : h3;
	System.out.println("x:" + maxh);
	}
}
