package com.test.springboot.utility;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretRequest;
import software.amazon.awssdk.services.secretsmanager.model.CreateSecretResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

public class CreateSecret {
    public static void main(String[] args) {
        final String USAGE = "\n" + "Usage:\n" + "    <secretName> <secretValue> \n\n" + "Where:\n" + "    secretName - the name of the secret (for example, tutorials/MyFirstSecret). \n" + "    secretValue - the secret value. \n";
        if (args.length != 2) {
            System.out.printf("%s", USAGE);
            System.exit(1);
        }

        String secretName = args[0];
        String secretValue = args[1];

        Region region = Region.US_EAST_1;

        SecretsManagerClient secretClient = SecretsManagerClient.builder().region(region).build();
        String secretArn = createSecret(secretClient, secretName, secretValue);
        System.out.printf("New Secret ARN: %s%n", secretArn);
        secretClient.close();
    }

    private static String createSecret(SecretsManagerClient secretClient, String secretName, String secretValue) {
        String secretArn = "";

        try{
            CreateSecretRequest secretRequest = CreateSecretRequest.builder().name(secretName).description("This secret was created by the AWS Secret Manager Java API").secretString(secretValue).build();
            CreateSecretResponse secretResponse = secretClient.createSecret(secretRequest);
            return secretResponse.arn();
        }catch(SecretsManagerException sme){
            System.err.println(sme.awsErrorDetails().errorMessage());
            System.exit(1);
        }

        return secretArn;
    }
}
