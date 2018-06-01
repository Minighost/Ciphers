public class EnigmaCipher{
    public static String encrypt(String text){
        String rotorA = "MAQTEVNBFSPJHUZLYCIOKWXGDR";
        String rotorB = "LKYZBFUXCJGNDETIRPHASOQMVW";
        String rotorC = "LZQFNJYMVORWSUABHPKDXITCEG";
        String plugboard = "YTUAFDZVIOWSQMNHERBXCGLPKJ";
        String reflector = "AFGOJBTDMSKCNWUIZXHVPRLQEY";
        String[] keys = {rotorA, rotorB, rotorC, reflector, plugboard};
        
        String temp = SubstitutionCipher.encrypt(text, plugboard);
        for(int i = 0; i < keys.length; i++){
            temp = SubstitutionCipher.encrypt(temp, keys[i]);
        }
        return temp;
    }
}