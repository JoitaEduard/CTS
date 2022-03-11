package ro.ase.acs.nosql;

import com.mongodb.MongoClient;

public class Close {

    public void close(MongoClient mongoClient) {
        mongoClient.close();
    }
}
