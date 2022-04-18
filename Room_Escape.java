package Room_Escape;

import java.util.*;
public class Room_Escape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fCipher = sc.nextLine();
        String cCipher = sc.nextLine();
        int cN = sc.nextInt();
        int M = sc.nextInt();

        String ciphers = getCaesar(cCipher, cN);

        String key = getFence(fCipher);

        String ans = getAnswer(key, ciphers, cN, M);

//        System.out.println(Upper(fCipher));
//        System.out.println(Upper(cCipher));

        System.out.println(ans);
    }


    /* --- Fence Cipher --- */

    public static String getFence(String cipher) {
        cipher = Upper(cipher);

        int n = cipher.charAt(cipher.length() - 1) - '0';
        cipher = cipher.substring(0, cipher.length() - 1);

        StringBuilder fence = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < cipher.length(); j += n) {
                fence.append(cipher.charAt(j));
            }
        }

        return fence.toString();
    }


    /* --- Caesar Cipher --- */

    public static String getCaesar(String cipher, int n) {
        cipher = Upper(cipher);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + n) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + n) % 26 + 'a');
            }
            sb.append(c);
        }
        return sb.toString();
    }


    /* --- Vigenere cipher --- */

    public static String getAnswer(String key, String cipher, int n, int M) {
        cipher = Upper(cipher);
        key = Upper(key);

        StringBuilder sb = new StringBuilder();
        key = key.substring(0, M);
        int keyIdx = 0;
        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + key.charAt(keyIdx) - 'A') % 26 + 'A');
                keyIdx = (keyIdx + 1) % key.length();
            } else if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + key.charAt(keyIdx) - 'a') % 26 + 'a');
                keyIdx = (keyIdx + 1) % key.length();
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String Upper(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
