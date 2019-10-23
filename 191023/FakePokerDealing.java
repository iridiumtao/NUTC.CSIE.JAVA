import java.util.Scanner;
import java.util.Arrays;

class FakePokerDealing{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		char[] symbols = {0x05, 0x04, 0x03, 0x06};
		char[] cards = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
		Integer[] poker = new Integer[52];
		for (Integer i = 0; i < 52; i++){
			poker[i] = i;
		}

		do{
			int random1, random2, tmp;
			for (int i = 0; i < 500; i++){
				random1 = (int)(Math.random()*52);
				random2 = (int)(Math.random()*52);
				tmp = poker[random2];
				poker[random2] = poker[random1];
				poker[random1] = tmp;
			}

			/*
			for (Integer i = 0; i < 52; i++){
				if (i % 13 == 0)
					System.out.printf("User[%s]: ",(i/13)+1);
				
				System.out.print(symbols[poker[i]%4]+""+cards[poker[i]/4]+" ");

				if (i % 13 == 12)
					System.out.println();
			}
			System.out.println("BEFORE AND AFTER");
			*/
			
			Integer[] user3 = new Integer[13];
			user3 = arraySort(getUserCards(poker, 3));

			Integer[] user1 = new Integer[13];
			user1 = arraySort(getUserCards(poker, 1));

			for (int i = 0; i < 3; i++){
				int temp;
				temp = user1[10+i];
				user1[10+i] = user3[i];
				user3[i] = temp;
			}

		
			for (Integer i = 0; i < 52; i++){
				if (i % 13 == 0)
					System.out.printf("User[%s]: ",(i/13)+1);

				switch((i / 13) + 1){
					case 1:
						System.out.print(symbols[user1[i]%4]+""+cards[user1[i]/4]+" ");
						break;
					case 2:
						System.out.print(symbols[poker[i]%4]+""+cards[poker[i]/4]+" ");
						break;
					case 3:
						System.out.print(symbols[user3[i-26]%4]+""+cards[user3[i-26]/4]+" ");
						break;
					case 4:
						System.out.print(symbols[poker[i]%4]+""+cards[poker[i]/4]+" ");
						break;
				}

				if (i % 13 == 12)
					System.out.println();
			}
			System.out.println("Again?(Y/N)");
		}while(scanner.next().charAt(0) == 'Y');
	}
	
	static Integer[] getUserCards(Integer[] poker, int user){
		Integer[] userCards = new Integer[13];

		for (int i = 13 * (user-1); i < 13 * (user-1) + 13; i++){		
			userCards[i-13*(user-1)] = poker[i];
		}
		return userCards;
	}

	static Integer[] arraySort(Integer[] array){
		Integer[] arraySort = Arrays.copyOf(array, array.length);
		int length = arraySort.length;
		int temp;

		for(int i=0;i<length;i++){
			for(int j=0;j<length-1;j++){
			   if(arraySort[j]>arraySort[j+1]){
				  temp = arraySort[j];
				  arraySort[j] = arraySort[j+1];
				  arraySort[j+1] = temp;
			   }

			}	
		}
		return arraySort;
	}
}
