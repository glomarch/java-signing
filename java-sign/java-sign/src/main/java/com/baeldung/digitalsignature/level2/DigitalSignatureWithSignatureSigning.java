package com.baeldung.digitalsignature.level2;

import com.baeldung.digitalsignature.Utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.Signature;

public class DigitalSignatureWithSignatureSigning {

    public static void main(String[] args) throws Exception {
    	
    	 String origFile = "test/test_in.pdf"
    			 //"test/resources/digitalsignature/message.txt"
    			 ;
    	 String sOutFile = "test/test_sig" 
    	     //"test/signatures/digital_signature_2"
    			 ;
    	 
        PrivateKey privateKey = Utils.getPrivateKey();

        Signature signature = Signature.getInstance(Utils.SIGNING_ALGORITHM);
        signature.initSign(privateKey);

       
        System.out.println("Reading message: in "  + origFile);
        byte[] messageBytes = Files.readAllBytes(Paths.get(origFile));

        signature.update(messageBytes);
        byte[] digitalSignature = signature.sign();

        
        Files.write(Paths.get(sOutFile), digitalSignature);
        System.out.println("signature written to " + sOutFile);
    }

}
