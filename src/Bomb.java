import java.util.*;

public class Bomb {
    private SerialNumber serial_number;
    private int n_batteries;
    private boolean has_parallel;
    private boolean frk;
    private boolean car;
    private int n_strikes;
    private int passwordLetter;

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
        n_strikes = 2;
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
        /*
        Solve a *Wires* module.
        Parameters
        ----------
        wires : str
            A string containing the code for the wire colours.
            **Colours :**
            - black : k
            - blue : b
            - red : r
            - white : w
            - yellow : y
            Therefore, a module containing three modules with white, blue, and
            black, would be input as "wbk".
        Returns
        -------
        to_cut : str
            The wire to cut, ordinal from left to right starting with one.
        */

        int numWires = wires.length();
        int lastSerialNumDigit = serial_number.digitString.charAt(serial_number.digitString.length() - 1) - '0';
        if(numWires == 3){
          //Returns which wire to cut
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
            //Counts number of red wires
            if(wires.charAt(i) == 'r'){
              numRedWires++;
            }
            //Counts number of blue wires
            else if (wires.charAt(i) == 'b'){
              numBlueWires++;
            }
            //Counts number of yellow wires
            else if (wires.charAt(i) == 'y'){
              numYellowWires++;
            }
          }
          //Returns which wire to cut
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
            //Counts number of yellow wires
            if(wires.charAt(i) == 'y'){
              numYellowWires++;
            }
            //Counts number of black wires
            else if (wires.charAt(i) == 'k'){
              numBlackWires++;
            }
            //Counts number of red wires
            else if (wires.charAt(i) == 'r'){
              numRedWires++;
            }
          }
          //Returns which wire to cut
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
            //Counts number of yellow wires
            if(wires.charAt(i) == 'y'){
              numYellowWires++;
            }
            //Counts number of white wires
            else if (wires.charAt(i) == 'w'){
              numWhiteWires++;
            }
            //Counts number of red wires
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
        /*
        Solve a *Button* module.
        Parameters
        ----------
        text : str
            The text on the button.
        colour : char
            The colour of the button.
            **Colours :**
            - blue : b
            - red : r
            - white : w
            - yellow : y
            - none : n
        Returns
        -------
        str
            Instruction for the diffuser
         */
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
        /*
        Determine the number at which to release the button if HOLD.
            Returns
            -------
            The number at which to release the button.
         */
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
            if(symbols[i][k].equals(keys[0]) || symbols[i][k].equals(keys[1]) || symbols[i][k].equals(keys[2]) || symbols[i][k].equals(keys[3])){
              count++;
              str += symbols[i][k];
              if(count != 4) str += ",";
            }
          }
          if(count == 4){
            break;
          }
          else{
            count = 0;
          }
        }
        return str;
    }

    public void simon(){
        /*
        Solve a *Simon Says* module.
        Run the solver, then input a colour every time.
        **Colours :**
        - blue : b
        - green : g
        - red : r
        - yellow : y
         */
        //Ask for input
        Scanner keyboard = new Scanner(System.in);
        boolean askingForInput = true;
        String colorTracker = "";
        System.out.print("Enter the color: ");
        String response = keyboard.nextLine();
        while(response.equals("b") || response.equals("g") || response.equals("r") || response.equals("y")){
          //Gets input for next loop
          if(!serial_number.has_vowel()){
            switch(response){
              case "r":
                if(n_strikes == 0){
                  System.out.println("Press the blue button");
                }
                else if(n_strikes == 1){
                  System.out.println("Press the yellow button");
                }
                else if (n_strikes == 2){
                  System.out.println("Press the green button");
                }
                break;
              case "b":
                if(n_strikes == 0){
                  System.out.println("Press the red button");
                }
                else if(n_strikes == 1){
                  System.out.println("Press the green button");
                }
                else if (n_strikes == 2){
                  System.out.println("Press the red button");
                }
                break;
              case "g":
                if(n_strikes == 0){
                  System.out.println("Press the yellow button");
                }
                else if(n_strikes == 1){
                  System.out.println("Press the blue button");
                }
                else if (n_strikes == 2){
                  System.out.println("Press the yellow button");
                }
                break;
              case "y":
                if(n_strikes == 0){
                  System.out.println("Press the green button");
                }
                else if(n_strikes == 1){
                  System.out.println("Press the red button");
                }
                else if (n_strikes == 2){
                  System.out.println("Press the blue button");
                }
                break;
            }
          }
          
          else if (serial_number.has_vowel()){ 
            switch(response){
              case "r":
                if(n_strikes == 0){
                  System.out.println("Press the blue button");
                }
                else if(n_strikes == 1){
                  System.out.println("Press the red button");
                }
                else if (n_strikes == 2){
                  System.out.println("Press the yellow button");
                }
              case "b":
                if(n_strikes == 0){
                  System.out.println("Press the yellow button");
                }
                else if(n_strikes == 1){
                  System.out.println("Press the blue button");
                }
                else if (n_strikes == 2){
                  System.out.println("Press the green button");
                }
              case "g":
                if(n_strikes == 0){
                  System.out.println("Press the green button");
                }
                else if(n_strikes == 1){
                  System.out.println("Press the yellow button");
                }
                else if (n_strikes == 2){
                  System.out.println("Press the blue button");
                }
              case "y":
                if(n_strikes == 0){
                  System.out.println("Press the red button");
                }
                else if(n_strikes == 1){
                  System.out.println("Press the green button");
                }
                else if (n_strikes == 2){
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
        /*
        Solve a *Who's on First* problem.
        Run the solver. On each iteration, input the letters on the display.
        The diffuser shall then relay the label of the appropriate button.
        The expert would then speak a list of the words, one at a time,
        until a match is found. The diffuser presses the matching button.
         */
    	Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the displayed word (Enter '0' to exit): ");
        //Button text
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
        /*
        Solve a *Memory* module.
        Run the solver. The diffuser should relay the number on the screen.
        The expert instructs with regards to the button to be pressed.
        Note that this can be either the label, or the position of the button.
        Once a button is pressed, the diffuser confirms its number and
        position, which is then input into the solver.
         */
    	
    	/* 
    	 * THE BUTTON POSITIONS CHANGE WITH EVERY STAGE
    	 */
    	Scanner keyboard = new Scanner(System.in);
    	int stage = 1;
    	int stageOneNumber = 0, stageTwoNumber = 0, stageThreeNumber = 0, stageFourNumber = 0;
    	while(stage < 6) {
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
					stage++;
					break;
				case 2:
					System.out.println("Press the button in the second position");
					System.out.print("Enter the number in the second position: ");
					stageOneNumber = keyboard.nextInt();
					stage++;
					break;
				case 3:
					System.out.println("Press the button in the third position");
					System.out.print("Enter the number in the third position: ");
					stageOneNumber = keyboard.nextInt();
					stage++;
					break;
				case 4:
					System.out.println("Press the button in the fourth position");
					System.out.print("Enter the number in the fourth position: ");
					stageOneNumber = keyboard.nextInt();
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
					stage++;
					break;
				case 2:
					System.out.println("Press the button labeled " + stageOneNumber);
					stageTwoNumber = stageOneNumber;
					stage++;
					break;
				case 3:
					System.out.println("Press the button in the first position");
					System.out.print("Enter the number in the first position: ");
					stageTwoNumber = keyboard.nextInt();
					stage++;
					break;
				case 4:
					System.out.println("Press the button labeled " + stageOneNumber);
					stageTwoNumber = stageOneNumber;
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
					stage++;
					break;
				case 2:
					System.out.println("Press the button labeled " + stageOneNumber);
					stageThreeNumber = stageOneNumber;
					stage++;
					break;
				case 3:
					System.out.println("Press the button in the third position");
					System.out.print("Enter the number in the third position: ");
					stageThreeNumber = keyboard.nextInt();
					stage++;
					break;
				case 4:
					System.out.println("Press the button labeled 4");
					stageThreeNumber = 4;
					stage++;
					break;
				}
			case 4:
				System.out.println("----------");
				System.out.println("STAGE FOUR");
				System.out.println("----------");
				switch(getDisplayNum()) {
				case 1:
					System.out.println("Press the button labeled " + stageOneNumber);
					stageFourNumber = stageOneNumber;
					stage++;
					break;
				case 2:
					System.out.println("Press the button in the first position");
					System.out.print("Enter the number in the first position: ");
					stageFourNumber = keyboard.nextInt();
					stage++;
					break;
				case 3:
					System.out.println("Press the button labeled " + stageTwoNumber);
					stageFourNumber = stageTwoNumber;
					stage++;
					break;
				case 4:
					System.out.println("Press the button labeled " + stageTwoNumber);
					stageFourNumber = stageTwoNumber;
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
        /*
        Solve a *Passwords* module.
        Run the solver. For each position, input all the possible letters
        which can be entered. The expert would obtain a shrinking list
        of possible passwords.
        Parameters
        ----------
        initial : str
            The initial sequence of letters.
         */
        String str = "";
        String[] validPasswords = {"about", "after", "again", "below", "could", "every", "first", "found", "great", "house", "large", "learn", "never", "other", "place", "plant", "point", "right", "small", "sound", "spell", "still", "study", "their", "there", "these", "thing", "think", "three", "water", "where", "which", "world", "would", "write"};
        ArrayList<String> newPossPasswords = new ArrayList<String>();
        passwordLetter = 0;
        Scanner keyboard = new Scanner(System.in);
        String currentLetters = initial;
        //Filters through first letters
        for(int i = 0; i < validPasswords.length; i++) {
        	if(containsLetter(initial, validPasswords[i])) {
        		newPossPasswords.add(validPasswords[i]);
        	}
        }
        for(String o: newPossPasswords) { System.out.print(o + " "); }
        System.out.println(); 
        passwordLetter++;
		System.out.print("Enter the possible letters for position " + (passwordLetter+1) +  " (Enter '0' to exit): ");
		System.out.println();
    	currentLetters = keyboard.nextLine().toLowerCase();
        //Goes through valid passwords
        while(newPossPasswords.size() > 1) {
        	int sizeArrList = newPossPasswords.size();
	    	for(int j = 0; j < sizeArrList; j++) {
	    		if(!containsLetter(currentLetters, newPossPasswords.get(j))) {
	    			newPossPasswords.remove(j);
	    			sizeArrList = newPossPasswords.size();
	    			j=0;
	    		}
	    	}
	    	passwordLetter++;
	    	for(String o: newPossPasswords) { System.out.print(o + " "); }
	    	System.out.println();
	    	if(newPossPasswords.size() > 1) {
	    		System.out.print("Enter the possible letters for position " + (passwordLetter+1) +  " (Enter '0' to exit): ");
		    	currentLetters = keyboard.nextLine().toLowerCase();
	    	}
	    	
        }
    	
        
        
        return str;
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
    	
    }
}