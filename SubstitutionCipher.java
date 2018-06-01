import java.util.*;
import java.io.*;

public class SubstitutionCipher implements ciphers{
    
    public static String getNewKey(){
        String temp = "";
        int[] indexesTaken = new int[26];
        int index = (int)(Math.random() * 26);
        int lastIndex = 0;
        for(int i = 0; i < 26; i++){
            index = (int)(Math.random() * 26);
            for(int j = 0; j < i; j++){
                while(index == lastIndex || index == indexesTaken[j]){
                    index = (int)(Math.random() * 26);
                    j = 0;
                }
            }
            temp += alpha.substring(index, index + 1);
            lastIndex = index;
            indexesTaken[i] = index;
        }
        return temp;
    }
    
    public static String encrypt(String text, String key){
        String return_str = "";
        int index = 0;
        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);
            for(int k = 0; k < alpha.length(); k++){
                if(temp == alpha.charAt(k)){
                    index = k;
                }
            }
            return_str += key.charAt(index);
        }
        return return_str;
    }
    
    public static String decrypt(String text){
        int[] analysis = new int[26];
        int index_of_highest = 0;
        String ORDER = "etaoinshrdlcumwfgypbvkjxqz";
        ORDER = ORDER.toUpperCase();
        String DECRYPT_STRING = "";
        String return_str = "";
        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);
            for(int k = 0; k < alpha.length(); k++){
                if(temp == alpha.charAt(k)){
                    analysis[k] += 1;
                }
            }
        }
        
        String temp_count = "";
        
        for(int counter = 0; counter < analysis.length; counter++){
            index_of_highest = getHighestIndex(analysis);
            char temp = alpha.charAt(index_of_highest);
            DECRYPT_STRING += temp;
            analysis[index_of_highest] = -1;
        }
        
        int index = 0;
        for(int i = 0; i < text.length(); i++){
            char temp = text.charAt(i);
            for(int k = 0; k < DECRYPT_STRING.length(); k++){
                if(temp == DECRYPT_STRING.charAt(k)){
                    index = k;
                }
            }
            return_str += ORDER.charAt(index);
        }
        
        return return_str;
    }
    
    public static int getHighestIndex(int[] analysis){
        int current = analysis[0];
        int return_int = 0;
        for(int i = 0; i < analysis.length; i++){
            if(analysis[i] > current){
                return_int = i;
                current = analysis[i];
            }
        }
        return return_int;
    }
}