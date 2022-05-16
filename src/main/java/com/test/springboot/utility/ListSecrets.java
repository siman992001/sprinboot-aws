package com.test.springboot.utility;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.ListSecretsResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretListEntry;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

import java.util.List;

public class ListSecrets {
    public static void main(String[] args) {
        SecretsManagerClient secretsManagerClient = SecretsManagerClient.builder().region(Region.US_EAST_1).build();
        listSecrets(secretsManagerClient);
        secretsManagerClient.close();
    }

    private static void listSecrets(SecretsManagerClient secretsManagerClient){
        try{
            ListSecretsResponse listSecretsResponse = secretsManagerClient.listSecrets();
            List<SecretListEntry> listSecrets = listSecretsResponse.secretList();
            for(SecretListEntry secretListEntry: listSecrets){
                System.out.printf("%s:%s%n", secretListEntry.name(), secretListEntry.description());
            }
        }catch(SecretsManagerException sme){
            System.err.printf(sme.awsErrorDetails().errorMessage());
            System.exit(1);
        }

    }
}
