package com.baeldung.digitalsignature.level2;

import com.baeldung.digitalsignature.Utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignatureWithSignatureVerifying {

    public static void main(String[] args) throws Exception {
    	
    	String origFile=
    			"test/test_in.pdf"
    			;
    	
    	String sigFile = 
    			"test/test_sig"
    			//"target/digital_signature_2"
    			;

	
        PublicKey publicKey = Utils.getPublicKey();

        byte[] sig = Files.readAllBytes(Paths.get(sigFile));

        Signature signature = Signature.getInstance(Utils.SIGNING_ALGORITHM);
        signature.initVerify(publicKey);

        byte[] messageBytes = Files.readAllBytes(Paths.get(origFile));

        signature.update(messageBytes);

        boolean isCorrect = signature.verify(sig);
        System.out.println("Signature " + (isCorrect ? "correct" : "incorrect"));
    }
}
