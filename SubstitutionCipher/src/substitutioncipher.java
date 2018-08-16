
public class substitutioncipher {
    static char encryptMap[]={'j','v','a','b','s','q','u','t','r','h','x','z','w','m',
                              'k','i','n','p','l','o','c','d','y','f','g','e'};
    
    public static int decryptMap(char c){
        for( int i=0 ; i<26 ;i++){
            if(c==encryptMap[i]){
                return i;
            }
        }
        return -1;
    }

    public static String encrypt(String msg){
        int DiffLowUpp = 'a'-'A';
        String result = "";
        
        for(int i=0 ; i<msg.length() ; i++){
            char c = msg.charAt(i);
            if(Character.isLetter(c)){
                if(Character.isUpperCase(c)){
                    c = (char) (c+DiffLowUpp);
                    c = encryptMap[c-97];
                    c = (char) (c-DiffLowUpp);
                }
                else{
                    c = encryptMap[c-97];
                }
            }
            result = result+c;
        }
        return result;
    }
    
    public static String decrypt(String msg){
        int DiffLowUpp = 'a' - 'A';
        String result = "";
        
        for ( int i=0 ; i<msg.length() ; i++){
            char c = msg.charAt(i);
            if(Character.isLetter(c)){
                if(Character.isUpperCase(c)){
                    c= (char) (c + DiffLowUpp);
                    c= (char) (97 + decryptMap(c));
                    c= (char) (c - DiffLowUpp);
                }
                else{
                    c= (char) (97 + decryptMap(c));
                }
            }
            result = result +c;
        }
        return result;
    }
    
    public static void main(String[] args) {
        String msg = "How You Doin?";
        String emsg = encrypt(msg);
        String dmsg = decrypt(emsg);
        
        System.out.println("Orignal message : "+msg);
        System.out.println("Encrypted message : "+emsg);
        System.out.println("Decrypted message : "+dmsg);
        
    }
    
}
