package chap01;

import java.util.Scanner;

public class ex {

	public static void main(String[] args) {

		// 3자리의 양의 정숫값
		Scanner random = new Scanner(System.in);

		int number;

		while (true) {
			try {
				System.out.printf("세 자리의 정수값 : ");
				number = random.nextInt();
				if (100 <= number && number <= 999) {
					break;
				} else {
					continue;
				}
			} catch (Exception e) {
				continue;
			}
		}

		System.out.println("입력한 값은 " + number + " 입니다.");
	}

}
