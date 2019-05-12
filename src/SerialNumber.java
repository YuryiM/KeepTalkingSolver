public class SerialNumber {
    private String number;
    private int digit;
    public String digitString;

    public SerialNumber(String sn){
        number = sn;
        digit = Integer.parseInt(number.replaceAll("\\D+",""));
        digitString = Integer.toString(digit);
    }

    public boolean has_vowel(){
    	String numberLower = number.toLowerCase();
    	for(int i = 0; i < number.length(); i++) {
    		if(numberLower.charAt(i) == 'a' || numberLower.charAt(i) == 'e' || numberLower.charAt(i) == 'i' || numberLower.charAt(i) == 'o' || numberLower.charAt(i) == 'u') {
    			return true;
    		}
    	}
        return false;
    }

    public boolean last_odd(){
        if(digit/10%2==1)
            return true;
        return false;
    }
}