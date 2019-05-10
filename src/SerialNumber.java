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
        if(number.toLowerCase().matches("[aeiou]"))
            return true;
        return false;
    }

    public boolean last_odd(){
        if(digit/10%2==1)
            return true;
        return false;
    }
}