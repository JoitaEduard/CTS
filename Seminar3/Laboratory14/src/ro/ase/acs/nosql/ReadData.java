package ro.ase.acs.nosql;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ReadData {
    public void readData(MongoCollection<Document> collection) {
        FindIterable<Document> result = collection.find();
        for (Document doc : result) {
            System.out.println(doc);
        }
    }
}
