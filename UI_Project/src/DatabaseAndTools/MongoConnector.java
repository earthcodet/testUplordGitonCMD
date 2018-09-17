package DatabaseAndTools;

import java.util.Arrays;
import java.util.Iterator;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public interface MongoConnector {
	public static MongoClient Connector() {
		try {	
			//MongoClient c = new MongoClient(new ServerAddress(UserManagement.DB_Host,UserManagement.DB_Port), Arrays.asList(MongoCredential.createCredential(UserManagement.DB_User, UserManagement.DB_Name, UserManagement.DB_Pass".toCharArray())));
			MongoClient c = new MongoClient(new MongoClientURI("mongodb://"+DataCredentials.DB_User+":"+DataCredentials.DB_Pass+"@"+DataCredentials.DB_Host+".mlab.com:"+DataCredentials.DB_Port+"/"+DataCredentials.DB_Name));
			System.out.println("Connection success");
			return c;
		} 
		catch(Exception eX) {
			System.err.println("Connection error");
			eX.printStackTrace();
		}
		return null;
	}
}