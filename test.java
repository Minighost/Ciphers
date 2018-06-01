import java.util.*;
import java.io.*;

public class test{
    public static void main2 (String args[]) throws Exception{
        String base = "";
        File text = new File("C:\\Users\\maest\\Desktop\\excerpt_TDTW.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(text));
        
        String st;
        while ((st = br.readLine()) != null){
            base += st;
        }
        
        base = base.replace(" ", "");
        base = base.replace(".", "");
        base = base.replace(",", "");
        base = base.replace("\"", "");
        base = base.replace(":", "");
        base = base.replace("-", "");
        base = base.toUpperCase();
        
        
       
        System.out.print("\f");
        String key = "PWIBJMNXZFSDQUAGKLYVRHCTOE";
        String e = SubstitutionCipher.encrypt(base, key);
        String d = SubstitutionCipher.decrypt(e);
        
        //System.out.println(ciphers.alpha);
        //System.out.println(key);
        System.out.println(base);
        System.out.println(e);
        System.out.println(d);
    }
    
    public static void main1 (String args[]){
        String base = "HELLOTHISISATEST";
        
        String encrypt = CaesarCipher.encrypt(base, 4);
        String decrypt = CaesarCipher.decrypt(encrypt, 4);
        
        System.out.print("\f");
        System.out.println(encrypt);
        System.out.println(decrypt);
    }
    
    public static void main3 (String args[]){
        String base = "HELLOTHISISATEST";
        
        String encrypt = EnigmaCipher.encrypt(base);
        
        System.out.print("\f");
        System.out.println(base);
        System.out.println(encrypt);
    }
}