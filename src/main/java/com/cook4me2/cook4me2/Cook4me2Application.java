package com.cook4me2.cook4me2;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.api.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;

@SpringBootApplication
public class Cook4me2Application {


	public static void main(String[] args) throws IOException {
	    // TODO(Developer):
	    //  1. Before running this sample,
	    //  set up Application Default Credentials as described in
	    //  https://cloud.google.com/docs/authentication/external/set-up-adc
	    //  2. Replace the project variable below.
	    //  3. Make sure you have the necessary permission to list storage buckets
	    //  "storage.buckets.list"
	    String projectId = "cook4me2-6edde";
	    authenticateImplicitWithAdc(projectId);
	    FirebaseApp.initializeApp();
		SpringApplication.run(Cook4me2Application.class, args);
	  }

	  // When interacting with Google Cloud Client libraries, the library can auto-detect the
	  // credentials to use.
	  public static void authenticateImplicitWithAdc(String project) throws IOException {

	    // *NOTE*: Replace the client created below with the client required for your application.
	    // Note that the credentials are not specified when constructing the client.
	    // Hence, the client library will look for credentials using ADC.
	    //
	    // Initialize client that will be used to send requests. This client only needs to be created
	    // once, and can be reused for multiple requests.
	    Storage storage = StorageOptions.newBuilder().setProjectId(project).build().getService();

	    System.out.println("Buckets:");
	    com.google.api.gax.paging.Page<Bucket> buckets = storage.list();
	    for (Bucket bucket : buckets.iterateAll()) {
	      System.out.println(bucket.toString());
	    }
	    System.out.println("Listed all storage buckets.");
		
	  }

}
