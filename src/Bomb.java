import java.util.*;

public class Bomb {
    private SerialNumber serial_number;
    private int n_batteries;
    private boolean has_parallel;
    private boolean frk;
    private boolean car;
    private int n_strikes;
    private int passwordLetter = 0; 

    public Bomb(String sn, int bat){
        serial_number = new SerialNumber(sn);
        n_batteries = bat;
        has_parallel = false;
        frk = false;
        car = false;
        n_strikes = 0;
    }
    public Bomb(String sn, int bat, boolean frkLit, boolean carLit){
        serial_number = new SerialNumber(sn);
        n_batteries = bat;
        has_parallel = false;
        frk = frkLit;
        car = carLit;
        n_strikes = 0;
    }

    public Bomb(String sn, int bat, boolean para){
        serial_number = new SerialNumber(sn);
        n_batteries = bat;
        has_parallel = para;
        frk = false;
        car = false;
        n_strikes = 0;
    }

    public void strike(){
        n_strikes++;
    }

    public String wires(String wires){
        int numWires = wires.length();
        int lastSerialNumDigit = serial_number.digitString.charAt(serial_number.digitString.length() - 1) - '0';
        if(numWires == 3){
          if(!wires.contains("r")){
            return "Cut the second wire";
          }
          else if(wires.lastIndexOf('w') == numWires-1){
            return "Cut the last wire";
          }
          else if (wires.indexOf('b') != wires.lastIndexOf('b')){
            return "Cut the last blue wire";
          }
          else{
            return "Cut the last wire";
          }
        }
        else if(numWires == 4){
          int numRedWires = 0;
          int numBlueWires = 0;
          int numYellowWires = 0;
          
          for(int i = 0; i < numWires; i++){
            if(wires.charAt(i) == 'r'){
              numRedWires++;
            }
            else if (wires.charAt(i) == 'b'){
              numBlueWires++;
            }
            else if (wires.charAt(i) == 'y'){
              numYellowWires++;
            }
          }
          if(numRedWires > 1 && (lastSerialNumDigit % 2 == 1)){
        	System.out.println(lastSerialNumDigit);
            return "Cut the last red wire";
          }
          else if (wires.lastIndexOf('y') == wires.length()-1 && numRedWires == 0){
            return "Cut the first wire";
          }
          else if (numBlueWires == 1){
            return "Cut the first wire";
          }
          else if (numYellowWires > 1){
            return "Cut the last wire";
          }
          else{
            return "Cut the second wire";
          }
        }
        else if(numWires == 5){
          int numYellowWires = 0;
          int numBlackWires = 0;
          int numRedWires = 0;

          for(int i = 0; i < numWires; i++){
            if(wires.charAt(i) == 'y'){
              numYellowWires++;
            }
            else if (wires.charAt(i) == 'k'){
              numBlackWires++;
            }
            else if (wires.charAt(i) == 'r'){
              numRedWires++;
            }
          }
          if(wires.charAt(4) == 'k' && (lastSerialNumDigit % 2 == 1)){
            return "Cut the fourth wire";
          }
          else if (numRedWires == 1 && numYellowWires > 1){
            return "Cut the first wire";
          }
          else if (numBlackWires == 0){
            return "Cut the second wire";
          }
          else{
            return "Cut the first wire";
          }
        }
        else if(numWires == 6){
          int numYellowWires = 0;
          int numWhiteWires = 0;
          int numRedWires = 0;

          for(int i = 0; i < numWires; i++){
            if(wires.charAt(i) == 'y'){
              numYellowWires++;
            }
            else if (wires.charAt(i) == 'w'){
              numWhiteWires++;
            }
            else if (wires.charAt(i) == 'r'){
              numRedWires++;
            }
          }

          if(numYellowWires == 0 && (lastSerialNumDigit % 2 == 1)){
            return "Cut the third wire";
          }
          else if (numYellowWires == 1 && numWhiteWires > 1){
            return "Cut the fourth wire";
          }
          else if (numRedWires == 0){
            return "Cut the last wire";
          }
          else{
            return "Cut the fourth wire";
          }
        }
		return "Not a valid number of wires";
    }

    public String button(String text, String color){
    	Scanner keyboard = new Scanner(System.in);
	    color = color.toLowerCase();
	    text = text.toLowerCase();
        if(color.equals("b") && text.equals("abort")){
          System.out.println("Hold the button");
          System.out.print("Enter the color of the strip: ");
          String response = keyboard.nextLine().toLowerCase();
          return release(response);
        }
        else if(n_batteries > 1 && text.equals("detonate")){
          return "Press and immediately release";
        }
        else if (color.equals("w") && car){
          System.out.println("Hold the button");
          System.out.println("Enter the color of the strip: ");
          String response = keyboard.nextLine().toLowerCase();
          return release(response);
        }
        else if(n_batteries > 2 && frk){
          return "Press and immediately release";
        }
        else if(color.equals("y")){
	      System.out.println("Hold the button");
	      System.out.println("Enter the color of the strip: ");
	      String response = keyboard.nextLine().toLowerCase();
	      return release(response);
        }
        else if(color.equals("r") && text.equals("hold")){
          return "Press and immediately release";
        }
        else{
          System.out.println("Hold the button");
          System.out.println("Enter the color of the strip: ");
          String response = keyboard.nextLine().toLowerCase();
          return release(response);
        }
    }

    public String release(String color){
        if(color.equals("b")){
          return "Release when the countdown timer has a 4 in any position";
        }
        else if(color.equals("w")){
          return "Release when the countdown timer has a 1 in any position";
        }
        else if(color.equals("y")){
          return "Release when the countdown timer has a 5 in any position";
        }
        else{
          return "Release when the countdown timer has a 1 in any position";
        }
    }

    public String keypad(String[] keys){
    	//IS SMILEY SUPPOSED TO BE "SMILE"?
        String[][] symbols = {{"q", "at", "lambda", "koppa", "an", "h", "moon"},
                              {"eh", "q", "moon", "loop", "star", "h", "que"},
                              {"copy", "butt", "loop", "zhe", "hoe", "lambda", "star"},
                              {"6", "para", "b", "an", "zhe", "que", "smile"},
                              {"psi", "smile", "b", "c", "para", "ksi", "black"},
                              {"6", "eh", "neq", "ae", "psi", "i", "omega"}};
        String str = "Press in this order: ";
        int count = 0;
        for(int i = 0; i < symbols.length; i++){
          for(int k = 0; k < symbols[i].length; k++){
            if(symbols[i][k].equals(keys[0].toLowerCase()) || symbols[i][k].equals(keys[1].toLowerCase()) || symbols[i][k].equals(keys[2].toLowerCase()) || symbols[i][k].equals(keys[3].toLowerCase())){
              count++;
              str += symbols[i][k];
              if(count != 4) str += ",";
            }
          }
          if(count == 4){
            break;
          }
          else{
        	str = "Press in this order: ";
            count = 0;
          }
        }
        return str;
    }

    public void simon(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the color (Enter '0' to exit): ");
        String response = keyboard.nextLine();
        while(response.equals("b") || response.equals("g") || response.equals("r") || response.equals("y")){
	        if(serial_number.has_vowel()) {
	        	if(response.equals("r")) {
	        		if(n_strikes == 0) {
	        			System.out.println("Press the blue button");
	        		}
	        		else if(n_strikes == 1) {
	        			System.out.println("Press the yellow button");
	        		}
	        		else if(n_strikes == 2) {
	        			System.out.println("Press the green button");
	        		}
	        	}
	        	else if(response.equals("b")) {
	        		if(n_strikes == 0) {
	        			System.out.println("Press the red button");
	        		}
	        		else if(n_strikes == 1) {
	        			System.out.println("Press the green button");
	        		}
	        		else if(n_strikes == 2) {
	        			System.out.println("Press the red button");
	        		} 
	        	}
	        	else if(response.equals("g")) {
	        		if(n_strikes == 0) {
	        			System.out.println("Press the yellow button");
	        		}
	        		else if(n_strikes == 1) {
	        			System.out.println("Press the blue button");
	        		}
	        		else if(n_strikes == 2) {
	        			System.out.println("Press the yellow button");
	        		}
	        	}
	        	else if(response.equals("y")) {
	        		if(n_strikes == 0) {
	        			System.out.println("Press the green button");
	        		}
	        		else if(n_strikes == 1) {
	        			System.out.println("Press the red button");
	        		}
	        		else if(n_strikes == 2) {
	        			System.out.println("Press the blue button");
	        		}
	        	}
            }
            else if (!serial_number.has_vowel()){ 
            	if(response.equals("r")) {
	        		if(n_strikes == 0) {
	        			System.out.println("Press the blue button");
	        		}
	        		else if(n_strikes == 1) {
	        			System.out.println("Press the red button");
	        		}
	        		else if(n_strikes == 2) {
	        			System.out.println("Press the yellow button");
	        		}
	        	}
	        	else if(response.equals("b")) {
	        		if(n_strikes == 0) {
	        			System.out.println("Press the yellow button");
	        		}
	        		else if(n_strikes == 1) {
	        			System.out.println("Press the blue button");
	        		}
	        		else if(n_strikes == 2) {
	        			System.out.println("Press the green button");
	        		} 
	        	}
	        	else if(response.equals("g")) {
	        		if(n_strikes == 0) {
	        			System.out.println("Press the green button");
	        		}
	        		else if(n_strikes == 1) {
	        			System.out.println("Press the yellow button");
	        		}
	        		else if(n_strikes == 2) {
	        			System.out.println("Press the blue button");
	        		}
	        	}
	        	else if(response.equals("y")) {
	        		if(n_strikes == 0) {
	        			System.out.println("Press the red button");
	        		}
	        		else if(n_strikes == 1) {
	        			System.out.println("Press the green button");
	        		}
	        		else if(n_strikes == 2) {
	        			System.out.println("Press the red button");
	        		}
	        	}
            }
            System.out.println();
            System.out.print("Enter the color: ");
            response = keyboard.nextLine();
        }
        
        
    }

    public void whos(){
    	Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the displayed word (Enter '0' to exit): ");
        
        String p1 = "Enter the text on the top left button: ";
        String p2 =	"Enter the text on the top right button: ";
        String p3 = "Enter the text on the middle left button: ";
        String p4 = "Enter the text on the middle right button: ";
        String p5 = "Enter the text on the bottom left button: ";
        String p6 = "Enter the text on the bottom right button: ";
        
        String response = keyboard.nextLine().toLowerCase();
        String[][] buttonPositions ={{"yes", p3},
                                     {"first", p2},
        						     {"display", p6},
        						     {"okay", p2},
        						     {"says", p6},
        						     {"nothing", p3},
        						     {"", p5},
                            	     {"blank", p4},
    					  		     {"no", p6},
                        		     {"led", p3},
					  			     {"lead", p6},
                    			     {"read", p4},
								     {"red", p4},
                				     {"reed", p5},
        						     {"leed", p5},
            					     {"hold on", p6},
    							     {"you", p4},
        						     {"you are", p6},
								     {"your", p4},
    							     {"you're", p4},
								     {"ur", p1},
								     {"there", p6},
							         {"they're", p5},
								     {"their", p4},
								     {"they are", p3},
								     {"see", p6},
								     {"c", p2},
								     {"cee", p6}};
        while(whosValidResponse(response)){
        	for(int i = 0; i < buttonPositions.length; i++) {
        		if(buttonPositions[i][0].equals(response)) {
        			System.out.println(buttonPositions[i][1]);
        			break;
        		}
        	}
        	String buttonText = keyboard.nextLine().toLowerCase();
        	System.out.println("Push the first button that appears in the list: ");
        	switch(buttonText) {
    		case "ready":
    			System.out.println("YES, OKAY, WHAT, MIDDLE, LEFT, PRESS, RIGHT, BLANK, READY, NO, FIRST, UHHH, NOTHING, WAIT");
    			break;
    		case "first":
    			System.out.println("LEFT, OKAY, YES, MIDDLE, NO, RIGHT, NOTHING, UHHH, WAIT, READY, BLANK, WHAT, PRESS, FIRST");
    			break;
    		case "no":
    			System.out.println("BLANK, UHHH, WAIT, FIRST, WHAT, READY, RIGHT, YES, NOTHING, LEFT, PRESS, OKAY, NO, MIDDLE");
    			break;
    		case "blank":	
    			System.out.println("WAIT, RIGHT, OKAY, MIDDLE, BLANK, PRESS, READY, NOTHING, NO, WHAT, LEFT, UHHH, YES, FIRST");
    			break;
    		case "nothing":	
    			System.out.println("UHHH, RIGHT, OKAY, MIDDLE, YES, BLANK, NO, PRESS, LEFT, WHAT, WAIT, FIRST, NOTHING, READY");
    			break;
    		case "yes":	
    			System.out.println("OKAY, RIGHT, UHHH, MIDDLE, FIRST, WHAT, PRESS, READY, NOTHING, YES, LEFT, BLANK, NO, WAIT");
    			break;
    		case "what":	
    			System.out.println("UHHH, WHAT, LEFT, NOTHING, READY, BLANK, MIDDLE, NO, OKAY, FIRST, WAIT, YES, PRESS, RIGHT");
    			break;
    		case "uhhh":	
    			System.out.println("READY, NOTHING, LEFT, WHAT, OKAY, YES, RIGHT, NO, PRESS, BLANK, UHHH, MIDDLE, WAIT, FIRST");
    			break;
    		case "left":	
    			System.out.println("RIGHT, LEFT, FIRST, NO, MIDDLE, YES, BLANK, WHAT, UHHH, WAIT, PRESS, READY, OKAY, NOTHING");
    			break;
    		case "right":	
    			System.out.println("YES, NOTHING, READY, PRESS, NO, WAIT, WHAT, RIGHT, MIDDLE, LEFT, UHHH, BLANK, OKAY, FIRST");
    			break;
    		case "middle":
    			System.out.println("BLANK, READY, OKAY, WHAT, NOTHING, PRESS, NO, WAIT, LEFT, MIDDLE, RIGHT, FIRST, UHHH, YES");
    			break;
    		case "okay":	
    			System.out.println("MIDDLE, NO, FIRST, YES, UHHH, NOTHING, WAIT, OKAY, LEFT, READY, BLANK, PRESS, WHAT, RIGHT");
    			break;
    		case "wait":	
    			System.out.println("UHHH, NO, BLANK, OKAY, YES, LEFT, FIRST, PRESS, WHAT, WAIT, NOTHING, READY, RIGHT, MIDDLE");
    			break;
    		case "press":
    			System.out.println("RIGHT, MIDDLE, YES, READY, PRESS, OKAY, NOTHING, UHHH, BLANK, LEFT, FIRST, WHAT, NO, WAIT");
    			break;
    		case "you":	
    			System.out.println("SURE, YOU ARE, YOUR, YOU'RE, NEXT, UH HUH, UR, HOLD, WHAT?, YOU, UH UH, LIKE, DONE, U");
    			break;
    		case "you are":	
    			System.out.println("YOUR, NEXT, LIKE, UH HUH, WHAT?, DONE, UH UH, HOLD, YOU, U, YOU'RE, SURE, UR, YOU ARE");
    			break;
    		case "your":
    			System.out.println("UH UH, YOU ARE, UH HUH, YOUR, NEXT, UR, SURE, U, YOU'RE, YOU, WHAT?, HOLD, LIKE, DONE");
    			break;
    		case "you're":	
    			System.out.println("YOU, YOU'RE, UR, NEXT, UH UH, YOU ARE, U, YOUR, WHAT?, UH HUH, SURE, DONE, LIKE, HOLD");
    			break;
    		case "ur":	
    			System.out.println("DONE, U, UR, UH HUH, WHAT?, SURE, YOUR, HOLD, YOU'RE, LIKE, NEXT, UH UH, YOU ARE, YOU");
    			break;
    		case "u":	
    			System.out.println("UH HUH, SURE, NEXT, WHAT?, YOU'RE, UR, UH UH, DONE, U, YOU, LIKE, HOLD, YOU ARE, YOUR");
    			break;
    		case "uh huh":
    			System.out.println("UH HUH, YOUR, YOU ARE, YOU, DONE, HOLD, UH UH, NEXT, SURE, LIKE, YOU'RE, UR, U, WHAT?");
    			break;
    		case "uh uh":	
    			System.out.println("UR, U, YOU ARE, YOU'RE, NEXT, UH UH, DONE, YOU, UH HUH, LIKE, YOUR, SURE, HOLD, WHAT?");
    			break;
    		case "what?":
    			System.out.println("YOU, HOLD, YOU'RE, YOUR, U, DONE, UH UH, LIKE, YOU ARE, UH HUH, UR, NEXT, WHAT?, SURE");
    			break;
    		case "done":	
    			System.out.println("SURE, UH HUH, NEXT, WHAT?, YOUR, UR, YOU'RE, HOLD, LIKE, YOU, U, YOU ARE, UH UH, DONE");
    			break;
    		case "next":
    			System.out.println("WHAT?, UH HUH, UH UH, YOUR, HOLD, SURE, NEXT, LIKE, DONE, YOU ARE, UR, YOU'RE, U, YOU");
    			break;
    		case "hold":
    			System.out.println("YOU ARE, U, DONE, UH UH, YOU, UR, SURE, WHAT?, YOU'RE, NEXT, HOLD, UH HUH, YOUR, LIKE");
    			break;
    		case "sure":	
    			System.out.println("YOU ARE, DONE, LIKE, YOU'RE, YOU, HOLD, UH HUH, UR, SURE, U, WHAT?, NEXT, YOUR, UH UH");
    			break;
    		case "like":
    			System.out.println("YOU'RE, NEXT, U, UR, HOLD, DONE, UH UH, WHAT?, UH HUH, YOU, LIKE, SURE, YOU ARE, YOUR");
    			break;
        	}
        	System.out.println("----------------------------------------------------");
        	System.out.print("Enter the displayed word (Enter '0' to exit): ");
        	response = keyboard.nextLine().toLowerCase();
        }
    }
    public boolean whosValidResponse(String word){
    	String[] validWords = {"yes", "first", "display", "okay", "says", "nothing", "", "blank", "no", "led", "lead", "read", "red", "reed", "leed", "hold on", "you", "you are", "your", "you're", "ur", "there", "they're", "their", "they are", "see", "c", "cee",};
    	for(int i = 0; i < validWords.length; i++){
    		if(validWords[i].equals(word)) {
    			return true;
    		}
    	}
    	return false;
    }

    public void memory(){
    	Scanner keyboard = new Scanner(System.in);
    	int stageOneNumber = 0, stageTwoNumber = 0, stageThreeNumber = 0, stageFourNumber = 0;
    	int stageOnePos = 0, stageTwoPos = 0, stageThreePos = 0, stageFourPos = 0;
    	for(int stage = 1; stage < 6; stage++) {
    		switch(stage) {
			case 1:
				System.out.println("----------");
				System.out.println("STAGE ONE");
				System.out.println("----------");
				switch(getDisplayNum()) {
				case 1:
					System.out.println("Press the button in the second position");
					System.out.print("Enter the number in the second position: ");
					stageOneNumber = keyboard.nextInt();
					stageOnePos = 2;
					stage++;
					break;
				case 2:
					System.out.println("Press the button in the second position");
					System.out.print("Enter the number in the second position: ");
					stageOneNumber = keyboard.nextInt();
					stageOnePos = 2;
					stage++;
					break;
				case 3:
					System.out.println("Press the button in the third position");
					System.out.print("Enter the number in the third position: ");
					stageOneNumber = keyboard.nextInt();
					stageOnePos = 3;
					stage++;
					break;
				case 4:
					System.out.println("Press the button in the fourth position");
					System.out.print("Enter the number in the fourth position: ");
					stageOneNumber = keyboard.nextInt();
					stageOnePos = 4;
					stage++;
					break;
				}
			case 2:
				System.out.println("---------");
				System.out.println("STAGE TWO");
				System.out.println("---------");
				switch(getDisplayNum()) {
				case 1:
					System.out.println("Press the button labeled 4");
					stageTwoNumber = 4;
					System.out.print("What position is it in? (Use numbers): ");
					stageTwoPos = keyboard.nextInt();
					stage++;
					break;
				case 2:
					System.out.println("Press the button in position " + stageOnePos);
					System.out.print("Enter the number in the position: ");
					stageTwoNumber = keyboard.nextInt();
					stageTwoPos = stageOnePos;
					stage++;
					break;
				case 3:
					System.out.println("Press the button in the first position");
					System.out.print("Enter the number in the first position: ");
					stageTwoNumber = keyboard.nextInt();
					stageTwoPos = 1;
					stage++;
					break;
				case 4:
					System.out.println("Press the button in position " + stageOnePos);
					System.out.print("Enter the number in the position: ");
					stageTwoNumber = keyboard.nextInt();
					stageTwoPos = stageOnePos;
					stage++;
					break;
				}
			case 3:
				System.out.println("-----------");
				System.out.println("STAGE THREE");
				System.out.println("-----------");
				switch(getDisplayNum()) {
				case 1:
					System.out.println("Press the button labeled " + stageTwoNumber);
					stageThreeNumber = stageTwoNumber;
					System.out.print("What position is it in? (Use numbers): ");
					stageThreePos = keyboard.nextInt();
					stage++;
					break;
				case 2:
					System.out.println("Press the button labeled " + stageOneNumber);
					stageThreeNumber = stageOneNumber;
					System.out.print("What position is it in? (Use numbers): ");
					stageThreePos = keyboard.nextInt();
					stage++;
					break;
				case 3:
					System.out.println("Press the button in the third position");
					stageThreePos = 3;
					System.out.print("Enter the number in the third position: ");
					stageThreeNumber = keyboard.nextInt();
					stage++;
					break;
				case 4:
					System.out.println("Press the button labeled 4");
					stageThreeNumber = 4;
					System.out.print("What position is it in? (Use numbers): ");
					stageThreePos = keyboard.nextInt();
					stage++;
					break;
				}
			case 4:
				System.out.println("----------");
				System.out.println("STAGE FOUR");
				System.out.println("----------");
				switch(getDisplayNum()) {
				case 1:
					System.out.println("Press the button in position " + stageOnePos);
					stageFourPos = stageOnePos;
					System.out.print("Enter the number in the position: ");
					stageFourNumber = keyboard.nextInt();
					stage++;
					break;
				case 2:
					System.out.println("Press the button in the first position");
					stageFourPos = 1;
					System.out.print("Enter the number in the first position: ");
					stageFourNumber = keyboard.nextInt();
					stage++;
					break;
				case 3:
					System.out.println("Press the button in position " + stageTwoPos);
					stageFourPos = stageTwoPos;
					System.out.print("Enter the number in the position: ");
					stageFourNumber = keyboard.nextInt();
					stage++;
					break;
				case 4:
					System.out.println("Press the button in position " + stageTwoPos);
					stageFourPos = stageTwoPos;
					System.out.print("Enter the number in the position: ");
					stageFourNumber = keyboard.nextInt();
					stage++;
					break;
				}
			case 5:
				System.out.println("-----------");
				System.out.println("STAGE FIVE");
				System.out.println("-----------");
				switch(getDisplayNum()) {
				case 1:
					System.out.println("Press the button labeled " + stageOneNumber);
					stage++;
					break;
				case 2:
					System.out.println("Press the button labeled " + stageTwoNumber);
					stage++;
					break;
				case 3:
					System.out.println("Press the button labeled " + stageFourNumber);
					stage++;
					break;
				case 4:
					System.out.println("Press the button labeled " + stageThreeNumber);
					stage++;
					break;
				}
    		}
    		
    	}	
    }
    private int getDisplayNum() {

    	Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the number displayed: ");
		System.out.println();
		return keyboard.nextInt();
	}

    public String passwords(String initial){
    	Scanner keyboard = new Scanner(System.in);
    	String currentLetters = initial;
        String[] validPasswords = {"about", "after", "again", "below", "could", "every", "first", "found", "great", "house", "large", "learn", "never", "other", "place", "plant", "point", "right", "small", "sound", "spell", "still", "study", "their", "there", "these", "thing", "think", "three", "water", "where", "which", "world", "would", "write"};
        ArrayList<String> newPossPasswords = new ArrayList<String>();
        
        for(String i: validPasswords) { newPossPasswords.add(i); }

        while(newPossPasswords.size() > 1 && !currentLetters.equals("0")) {
        	int sizeArrList = newPossPasswords.size();
	    	for(int j = 0; j < sizeArrList; j++) {
	    		if(!containsLetter(currentLetters, newPossPasswords.get(j))) {
	    			newPossPasswords.remove(j);
	    			sizeArrList = newPossPasswords.size();
	    			j=0;
	    		}
	    	}
	    	if(!containsLetter(currentLetters, newPossPasswords.get(0))) {
	        	newPossPasswords.remove(0); 
	        }
	    	if(newPossPasswords.size() > 1) {
	    		passwordLetter++;
	    		System.out.print("Possible words: ");
		    	for(String o: newPossPasswords) { System.out.print(o + " "); }
		    	System.out.println();
	    		System.out.print("Enter the possible letters for position " + (passwordLetter+1) +  " (Enter '0' to exit): ");
		    	currentLetters = keyboard.nextLine().toLowerCase();
	    	}
	    	
        }
        return newPossPasswords.get(0);
    }
    
    public boolean containsLetter(String initial, String word) {
    	for(int i = 0; i < initial.length(); i++) {
    		if(word.charAt(passwordLetter) == initial.charAt(i)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void sequences(){
        /*
        Solve a *Wire Sequences* module.
        Run the solver. For each step, enter the colour of the wire, and its
        connection. The solver prints the decision for each wire.
        **Colours :**
        - blue : b
        - black : k
        - red : r
         */
    	Scanner keyboard = new Scanner(System.in);
    	int redCount = 0, blueCount = 0, blackCount = 0;
    	System.out.println("---------------------------------------------------------");
    	System.out.println("Press enter to skip the wire, '0' to exit to menu");
		System.out.println("Enter the color followed by the letter connection");
		System.out.println("Ex. \"rc\" or \"bb\"");
    	System.out.println("---------------------------------------------------------");
		for(int i = 1; i <= 12; i++) {
			System.out.println("Enter the color and letter wire " + i + " is connected to");
			String wire_connection = keyboard.nextLine().toLowerCase();
			//Determines wire number
			if(wire_connection.equals("")) {
				continue;
			}
			else if(wire_connection.equals("0")) {
				break;
			}
			else if((wire_connection.charAt(0) == 'r' || wire_connection.charAt(0) == 'b' || wire_connection.charAt(0) == 'k') && ((wire_connection.charAt(1) == 'a' || wire_connection.charAt(1) == 'b' || wire_connection.charAt(1) == 'c'))){
				switch(wire_connection.charAt(0)) {
    			case 'r':
    				redCount++;
    				System.out.println(toCut(redCount, wire_connection.charAt(1), 'r'));
    				break;
    			case 'b':
    				blueCount++;
    				System.out.println(toCut(blueCount, wire_connection.charAt(1), 'b'));
    				break;
    			case 'k':
    				blackCount++;
    				System.out.println(toCut(blackCount, wire_connection.charAt(1), 'k'));
    			}
			}
			else {
				System.out.println("Not a valid response");
				i--;
			}
			
			System.out.println("---------------------------------------------------------");
		}
    	
    }
    
   private String toCut(int wireCount, char wireConnection, char wireColor) {
	   String cut = "Cut the wire";
	   switch(wireColor) {
		case 'r':
			switch(wireCount) {
			case 1:
				if(wireConnection == 'c') { return cut; }
				break;
			case 2:
				if(wireConnection == 'b') { return cut; }
				break;
			case 3:
				if(wireConnection == 'a') { return cut; }
				break;
			case 4:
				if(wireConnection == 'a' || wireConnection == 'c') { return cut; }
				break;
			case 5:
				if(wireConnection == 'b') { return cut; }
				break;
			case 6:
				if(wireConnection == 'a' || wireConnection == 'c') { return cut; }
				break;
			case 7:
				if(wireConnection == 'a' || wireConnection == 'b' || wireConnection == 'c') { return cut; }
				break;
			case 8:
				if(wireConnection == 'a' || wireConnection == 'b') { return cut; }
				break;
			case 9:
				if(wireConnection == 'b') { return cut; }
				break;
			}
			break;
		case 'b':
			switch(wireCount) {
			case 1:
				if(wireConnection == 'b') { return cut; }
				break;
			case 2:
				if(wireConnection == 'a' || wireConnection == 'c') { return cut; }
				break;
			case 3:
				if(wireConnection == 'b') { return cut; }
				break;
			case 4:
				if(wireConnection == 'a') { return cut; }
				break;
			case 5:
				if(wireConnection == 'b') { return cut; }
				break;
			case 6:
				if(wireConnection == 'b' || wireConnection == 'c') { return cut; }
				break;
			case 7:
				if(wireConnection == 'c') { return cut; }
				break;
			case 8:
				if(wireConnection == 'a' || wireConnection == 'c') { return cut; }
				break;
			case 9:
				if(wireConnection == 'a') { return cut; }
				break;
			}
			break;
		case 'k':
			switch(wireCount) {
			case 1:
				if(wireConnection == 'a' || wireConnection == 'b' || wireConnection == 'c') { return cut; }
				break;
			case 2:
				if(wireConnection == 'a' || wireConnection == 'c') { return cut; }
				break;
			case 3:
				if(wireConnection == 'b') { return cut; }
				break;
			case 4:
				if(wireConnection == 'a' || wireConnection == 'c') { return cut; }
				break;
			case 5:
				if(wireConnection == 'b') { return cut; }
				break;
			case 6:
				if(wireConnection == 'b' || wireConnection == 'c') { return cut; }
				break;
			case 7:
				if(wireConnection == 'a' || wireConnection == 'b') { return cut; }
				break;
			case 8:
				if(wireConnection == 'c') { return cut; }
				break;
			case 9:
				if(wireConnection == 'c') { return cut; }
				break;
			}
			
			break;
		}
	   return "Do not cut the wire";
   }
}