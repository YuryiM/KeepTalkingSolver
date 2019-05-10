import java.util.*;

public class Bomb {
    private SerialNumber serial_number;
    private int n_batteries;
    private boolean has_parallel;
    private boolean frk;
    private boolean car;
    private int n_strikes;

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
        System.out.print("Enter the label: ");
        String response = keyboard.nextLine().toLowerCase();
        
        while(){
        	
        }
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

        return str;
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