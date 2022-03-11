package ro.ase.acs.nosql;

import com.mongodb.client.MongoDatabase;

public class CreateEntity {
    public void createEntity(MongoDatabase mongoDb) {
        if (mongoDb.getCollection("employees") != null) {
            mongoDb.getCollection("employees").drop();
        }
        mongoDb.createCollection("employees");
    }
}
