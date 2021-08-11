package com.xxxxxxxxx.zzzzzzzzz.secrets;

import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import software.amazon.awssdk.auth.credentials.WebIdentityTokenFileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@SuppressWarnings("rawtypes")
@Repository
public class SecretsManager {

	/**
	 * Constructor
	 */
    public SecretsManager() {
    	super();
    }
    

    public Object getSecretsLocal(Class cls, String secretRegion, String secretName) {
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public Object getSecrets(Class cls, String secretRegion, String secretName) {
    	
    	Gson gson = new Gson();
    	SecretsManagerClient secretsManagerClient =	
    			SecretsManagerClient.builder().
    			credentialsProvider(WebIdentityTokenFileCredentialsProvider.create()).
    			region(Region.of(secretRegion)).build();
    	GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder().secretId(secretName).build();      	
    	GetSecretValueResponse getSecretValueResponse = secretsManagerClient.getSecretValue(getSecretValueRequest);    	   	
    	return gson.fromJson(getSecretValueResponse.secretString(), cls);	
    }

	
}