package DataManager;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import DatabaseAndTools.DataCredentials;
import DatabaseAndTools.MongoConnector;

public class UserManager {
	static MongoClient mongocon = MongoConnector.Connector();
	static MongoDatabase db = mongocon.getDatabase(DataCredentials.DB_Name);
	static //System.out.println("Credentials ::"+ credential); 
	MongoCollection<Document> DBCollection = db.getCollection("user"); 
	//MongoIterable<String> DBCollection = db.listCollectionNames();
	public static void InsertUser(String email, String group, String user, String pass) {
		Document ds = new Document("email", email)
				      .append("gender", group)
				      .append("username", user)
				      .append("password", pass);
		DBCollection.insertOne(ds);
		FindIterable<Document> iterateDoc = DBCollection.find();
		Iterator<Document> iterator = iterateDoc.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}		
	}
	public static boolean CheckLogin(String Newuser) {
		FindIterable<Document> iterateDoc = DBCollection.find();
		Iterator<Document> iterator = iterateDoc.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getString("username").trim().equals(Newuser))
				return false;
		}
		return true;
	}
}
