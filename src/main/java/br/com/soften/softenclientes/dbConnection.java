package br.com.soften.softenclientes;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class dbConnection {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("ClienteDB");
            System.out.println("Connected to database: " + database.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}