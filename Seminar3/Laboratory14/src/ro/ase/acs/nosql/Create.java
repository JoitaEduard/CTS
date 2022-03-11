package ro.ase.acs.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Create {
    private MongoClient mongoClient = null;

    public MongoDatabase create() {
        mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        return mongoDatabase;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
