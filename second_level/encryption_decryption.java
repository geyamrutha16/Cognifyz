package second_level;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class encryption_decryption {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the file name or path: ");
            String fileName = br.readLine();
            System.out.println("Enter 'E' for encryption or 'D' for decryption: ");
            String mode = br.readLine();

            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            Cipher desCipher;
            desCipher = Cipher.getInstance("DES");

            FileInputStream fis = new FileInputStream(fileName);
            byte[] inputBytes = new byte[(int) fis.available()];
            fis.read(inputBytes);

            if (mode.equalsIgnoreCase("E")) {
                desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            } else if (mode.equalsIgnoreCase("D")) {
                desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            } else {
                System.out.println("Invalid mode. Please enter 'E' or 'D'.");
                fis.close();
                return;
            }
            //"C:\Users\india\OneDrive\Documents\hello.txt"
            byte[] outputBytes = desCipher.doFinal(inputBytes);

            String outputFileName;
            if (mode.equalsIgnoreCase("E")) {
                outputFileName = "encrypted_" + fileName;
            } else {
                outputFileName = "decrypted_" + fileName;
            }

            FileOutputStream fos = new FileOutputStream(outputFileName);
            fos.write(outputBytes);

            fis.close();
            fos.close();

            System.out.println("File " + fileName + " has been " + mode.toLowerCase() + "ed and saved to " + outputFileName + ".");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
