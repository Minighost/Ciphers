public class CaesarCipher implements ciphers{
    public static int getNewKey(){
        int temp = 0;
        temp = (int)(Math.random() * 26);
        return temp;
    }
    
    public static String encrypt(String text, int key){
        String return_str = "";
        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);
            int ascii_text = (int)(temp);
            if(ascii_text + key > 90){
                int remaining = ascii_text + key - 90 - 1;
                ascii_text = 65 + remaining;
            } else {
                ascii_text += key;
            }
            return_str += (char)(ascii_text);
        }
        return return_str;
    }
    
    public static String decrypt(String eText, int key){
        char[] array = new char[eText.length()];
        String return_str = "";
        for(int i = 0; i < eText.length(); i++){
            char temp = eText.charAt(i);
            int reg_text = (int)(temp);
            if(reg_text - key < 65){
                int remaining = reg_text - key + 65 + 1;
                reg_text = 90 - remaining;
            } else {
                reg_text -= key;
            }
            return_str += (char)(reg_text);
        }
        return return_str;
    }
}