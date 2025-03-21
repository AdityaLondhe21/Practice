package mongoDemo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

public class MongoDBOperations {

	public static void main(String[] args) {
		System.out.println("MongoDb Operations demo");
		
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("demodb");
		
		MongoCollection<Document> collection = database.getCollection("Employee");
		
//		FindIterable<Document> i = collection.find();
//		
//		for(Document d:i) {
//			System.out.println(d);
//			System.out.println(d.toJson());
//		}
					//Insert
					//1
//		Document doc = new Document();
//		doc.append("name", "Pooja");
//		doc.append("age", 33);
//		doc.append("salary", 60000);
//		doc.append("designation", "Programmer");
//		collection.insertOne(doc);
					//2
//		collection.insertOne(new Document().append("name", "Suman").append("age", 49).append("salary", 120000).append("designation", "Manager"));
					//3 ( Many )
//		List<Document>empList = new ArrayList<Document>();
//		empList.add(new Document().append("name", "Raju").append("age", 39).append("salary", 120000).append("designation", "Programmer"));
//		empList.add(new Document().append("name", "Manuj").append("age", 34).append("salary", 140000).append("designation", "Clerk"));
//		empList.add(new Document().append("name", "Sanju").append("age", 63).append("salary", 55000).append("designation", "Tester"));
//		collection.insertMany(empList);
		
					//Projection - removing unwanted fields
//		Bson projection1 = Projections.excludeId();
//		Bson projection2 = Projections.exclude("_id","age","salary");
		
					//Filtering
//		Bson filter = Filters.eq("designation","Programmer");
		
					//Sorting
//		Bson asort = Sorts.ascending("salary","age");
//		Bson dsort = Sorts.descending("age");

//		FindIterable<Document> i = collection.find(filter).projection(projection1).sort(dsort);
//		for(Document d:i) {
//			System.out.println(d.toJson());
//		}
		
					//Update
//		Bson filter = Filters.lte("age", 35);
//		Bson update = Updates.set("designation", "Manager");
//		collection.updateOne(filter, update);
		
					//Delete
//		collection.deleteOne(filter);
		
		System.out.println("Successfully did the operation on Mongo DB");
		mongoClient.close();
	}

}
