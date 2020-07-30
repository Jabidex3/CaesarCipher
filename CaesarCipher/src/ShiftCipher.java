import java.util.Scanner;

public class ShiftCipher {
	
	public static String encryptText(String s, int shift) {
		int shiftNum;
		String encrypted = "";
		
		if(shift>26) {
			shiftNum = shift%26;
			//System.out.println(shiftNum);
		}
		else if(shift<-26) {
			shiftNum = (Math.abs(shift)%26)*-1;
			//System.out.println(shiftNum);
		}
		else {
			shiftNum = shift;
			//System.out.println(shiftNum);
		}
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>=65 && s.charAt(i)<=90 && shiftNum>0) {
				if(s.charAt(i)+shiftNum>90) {
					encrypted+= Character.toString(s.charAt(i)-26+shiftNum);
					//System.out.println("1");
				}
				else {
					encrypted+= Character.toString(s.charAt(i)+shiftNum);
					//System.out.println("2");
				}
				
			}
			else if(s.charAt(i)>=65 && s.charAt(i)<=90 && shiftNum<0) {
				if(s.charAt(i)+shiftNum>=65) {
					encrypted+= Character.toString(s.charAt(i)+shiftNum);
					//System.out.println("3");
				}
				else {
					encrypted+= Character.toString(s.charAt(i)+26+shiftNum);
					//System.out.println("4");
				}
				
			}
			else if(s.charAt(i)>=97 && s.charAt(i)<=122 && shiftNum>0) {
				if(s.charAt(i)+shiftNum>122) {
					encrypted+= Character.toString(s.charAt(i)-26+shiftNum);
					//System.out.println("5");
				}
				else {
					encrypted+= Character.toString(s.charAt(i)+shiftNum);
					//System.out.println("6");
				}
			}
			else if(s.charAt(i)>=97 && s.charAt(i)<=122 && shiftNum<0) {
				if(s.charAt(i)+shiftNum>=97) {
					encrypted+= Character.toString(s.charAt(i)+shiftNum);
					//System.out.println("7");
				}
				else {
					encrypted+= Character.toString(s.charAt(i)+26+shiftNum);
					//System.out.println("8");
				}
			}
			else {
				encrypted+= s.charAt(i);
				//System.out.println("9");
			}
			
		}
		
		return encrypted;
	}
	
	public static String decryptText(String s, int shift) {
		int shiftNum;
		String decrypted = "";
		
		if(shift>26) {
			shiftNum = shift%26;
			//System.out.println(shiftNum);
		}
		else if(shift<-26) {
			shiftNum = (Math.abs(shift)%26)*-1;
			//System.out.println(shiftNum);
		}
		else {
			shiftNum = shift;
			//System.out.println(shiftNum);
		}
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>=65 && s.charAt(i)<=90 && shiftNum>0) {
				if(s.charAt(i)-shiftNum>=65) {
					decrypted+= Character.toString(s.charAt(i)-shiftNum);
					
				}
				else {
					decrypted+= Character.toString(s.charAt(i)+26-shiftNum);
				}
				
			}
			else if(s.charAt(i)>=65 && s.charAt(i)<=90 && shiftNum<0) {
				if(s.charAt(i)-shiftNum<=90) {
					decrypted+= Character.toString(s.charAt(i)-shiftNum);
				}
				else {
					decrypted+= Character.toString(s.charAt(i)-26-shiftNum);
				}
				
			}
			else if(s.charAt(i)>=97 && s.charAt(i)<=122 && shiftNum>0) {
				if(s.charAt(i)-shiftNum>=97) {
					
					decrypted+= Character.toString(s.charAt(i)-shiftNum);
				}
				else {
					decrypted+= Character.toString(s.charAt(i)+26-shiftNum);
				}
			}
			else if(s.charAt(i)>=97 && s.charAt(i)<=122 && shiftNum<0) {
				if(s.charAt(i)-shiftNum<=122) {
					decrypted+= Character.toString(s.charAt(i)-shiftNum);
				}
				else {
					decrypted+= Character.toString(s.charAt(i)-26-shiftNum);
				}
			}
			else {
				decrypted+= s.charAt(i);
			}
			
		}
		
		return decrypted;
	}
	
	public static String sideBySideText(String str, String encryptedStr) {
		return "Text to be encrypted: " + str + "\nEncrypted Output: " + encryptedStr;
	}
	
	public static void main(String[] args) {
//		String testOne = "Hello, How are you doing today?";
//		String testTwo = "ALOHA, good MoRnIng...";
//		String testThree ="ABC123!";
//		
//		System.out.println(sideBySideText(testOne, encryptText(testOne, 5 )));
//		System.out.println(sideBySideText(testOne, encryptText(testOne, -5 )));
//		System.out.println(sideBySideText(testTwo, encryptText(testTwo, -34 )));
//		System.out.println(sideBySideText(testThree, encryptText(testThree, 0 )));
//		System.out.println(sideBySideText(testThree, encryptText(testThree, 32 )));
//		
//		System.out.println(decryptText("Czggj, Cjr vmz tjp yjdib ojyvt?",-5));
		
		while(true) {
			System.out.println("+-----------------------------------------------------+");
			System.out.println("|Welcome to the Caesar Cypher Encryptor and Decryptor!|");
			System.out.println("+-----------------------------------------------------+");
			System.out.println("1. Encrypt Text");
			System.out.println("2. Decrypt Text");
			System.out.println("3. Exit");
			System.out.println("-------------------------------------------------------");
			Scanner scan = new Scanner(System.in);
			try {
				int choice = Integer.parseInt(scan.nextLine());
				if(choice==1) {
					System.out.println("Please enter the text you wish to encrypt:");
					String text = scan.nextLine();
					
					while(true) {
						System.out.println("Please enter a shift number that will be used to alter the text[Remember it for decrypption!]:");
						try {
							int shiftChoice = Integer.parseInt(scan.nextLine());
							System.out.println("Your encrypted text is: "+  encryptText(text, shiftChoice ));
							break;
						}
						catch(Exception e) {
							System.out.println("You have not entered a number!");
						}
					}

				}
				else if(choice==2){
					System.out.println("Please enter the text you wish to decrypt:");
					String text = scan.nextLine();
					while(true) {
						System.out.println("Please enter the shift number used to encrypt the text:");
						try {
							int shiftChoice = Integer.parseInt(scan.nextLine());
							System.out.println("Your decrypted text is: "+  decryptText(text, shiftChoice));
							break;
						}
						catch(Exception e) {
							System.out.println("You have not entered a number!");
						}
					}
				}
				else if(choice ==3){
					break;
				}
			}
			catch(Exception e) {
				System.out.println("You have entered an invalid choice! Pick again!");
			}
			
			
		}
		
	}

}
