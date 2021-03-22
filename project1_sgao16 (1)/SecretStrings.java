/* Name: Shen Gao
 * Email: sgao16@u.rochester.edu
 * 02/24/21
 */
import java.util.Scanner;
public class SecretStrings {
public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		
		while (true) {
			String userText;// user's input 
			char tag1 = '<';
			char tag2 = 'r';
			char tag3 = '>';
			int count = 0;
			System.out.println("Enter something");
			userText = s.nextLine();
			if (!(userText.equals("q"))) { // in the situation that input is not "q"
				if (!(userText.contains("<r>"))) {
					System.out.println(userText);
				}
				else {// when the input contains at least one "<r>"
					for (int i = 0; i < userText.length(); i++) {// searching char one by one, to find "<r>" and count the number
						if ((userText.charAt(i) == tag1) && (userText.charAt(i+1) == tag2) && (userText.charAt(i+2) == tag3)) {
							count++;
						}
					}
					for (int j = 0; j < count; j++) {
						String tagPart = userText.substring((userText.indexOf("<r>")),(userText.indexOf("</r>")+4));//string between <r> and </r>
						String tagPart1 = userText.substring((userText.indexOf("<r>")),(userText.indexOf("</r>")+4));//duplication, so the tagpart could replace the original one later
						tagPart = tagPart.replace("<r>", "");
						tagPart = tagPart.replace("</r>", "");
						for (int k = 0; k < tagPart.length(); k++) {//searching char one by one in the range of tagpart
							char c = tagPart.charAt(k);
							if (Character.isLetterOrDigit(c)){
								tagPart = tagPart.replace(c, '*');
							}
						}
						userText = userText.replace(tagPart1, tagPart);	
					}
					System.out.println(userText);//after replacing the orignal userText, print the new one with "*"
				}
			} 
			else { // in the situation that input is "q", the process will be terminated
				break;	
			}
		}	
	}		
}



