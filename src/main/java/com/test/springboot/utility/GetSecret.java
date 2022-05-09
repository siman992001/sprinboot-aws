package com.test.springboot.utility;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

public class GetSecret {
    public static void main(String[] args) {
        final String USAGE = "\n" +
                "Usage:\n" +
                "    <secretName> \n\n" +
                "Where:\n" +
                "    secretName - the name of the secret (for example, tutorials/MyFirstSecret). \n";


        if(args.length != 1){
            System.out.printf("%s", USAGE);
            System.exit(1);
        }

        String secretName = args[0];
        SecretsManagerClient secretsManagerClient = SecretsManagerClient.builder().region(Region.US_EAST_1).build();
        getSecretValue(secretsManagerClient, secretName);
        secretsManagerClient.close();
    }

    private static void getSecretValue(SecretsManagerClient secretsManagerClient, String secretName){
        try{
            String secretValue = "";
            GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder().secretId(secretName).build();
            GetSecretValueResponse getSecretValueResponse = secretsManagerClient.getSecretValue(getSecretValueRequest);
            secretValue = getSecretValueResponse.secretString();
            System.err.printf("**********Secret value for %s:%s %n", secretName, secretValue);
        }catch(SecretsManagerException sme){
            System.err.println(sme.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}
