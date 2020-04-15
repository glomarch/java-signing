
REM certificate signing request (CSR)

keytool -certreq -alias senderKeyPair -storetype PKCS12  -keystore sender_keystore.p12 -file -rfc -storepass changeit > sender_certificate.csr 
  