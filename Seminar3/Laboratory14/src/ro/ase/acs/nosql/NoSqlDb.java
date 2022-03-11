package ro.ase.acs.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.acs.Database;

public class NoSqlDb implements Database {

    private MongoClient mongoClient;
    private MongoDatabase mongoDb;
    private static MongoCollection<Document> collection;

    @Override
    public void createDb() {
        createConnection();
        createEntity();
        insertData();
        readData();
        closeConnection();
    }

    @Override
    public void createConnection() {
        mongoClient = new MongoClient("localhost", 27017);
        mongoDb = mongoClient.getDatabase("test");
    }

    @Override
    public void createEntity() {
        if (mongoDb.getCollection("employees") != null) {
            mongoDb.getCollection("employees").drop();
        }
        mongoDb.createCollection("employees");
    }

    @Override
    public void insertData() {
        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);

        collection = mongoDb.getCollection("employees");
        collection.insertOne(employee1);

        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);
        collection.insertOne(employee2);
    }

    @Override
    public void readData() {
        FindIterable<Document> result = collection.find();
        for (Document doc : result) {
            System.out.println(doc);
        }
    }

    @Override
    public void closeConnection() {
        mongoClient = new MongoClient("localhost", 27017);
        mongoClient.close();
    }

}
