package com.mongo.names;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class App {


	public static void main(String[] args)  {

		try {

			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

			// Now connect to your databases
			DB db = mongoClient.getDB( "test" );
			System.out.println("Connect to database successfully");

			DBCollection collectionObject = db.getCollection("mycol");
			System.out.println("Collection mycol selected successfully");

			BasicDBObject doc = new BasicDBObject("title", "MongoDB");
			doc.put("name", "*************");
			doc.put("DOB", 1111111);
			doc.put("Address", "****************");
			doc.put("Id", 15618);
			System.out.println("Document 1 inserted successfully");

			doc.put("name","**************");
			doc.put("Company ", "*********");
			doc.put("Address", "**********");
			doc.put("Apt No:", 111111);
			System.out.println("Document 2 inserted successfully");

			doc.put("name","************");
			doc.put("Company ", "***********");
			doc.put("Address", "*********");
			doc.put("Apt No:", 1111111111);
			collectionObject.insert(doc);
			System.out.println("Document 3 inserted successfully");

			/*Find and display 
			 * the result with names
			 * 
			 */
			BasicDBObject simpleQurey=new BasicDBObject();
			BasicDBObject field=new BasicDBObject();
			simpleQurey.put("Id", 111111);

			DBCursor cursorObject=collectionObject.find(simpleQurey);
			while(cursorObject.hasNext()){
				//BasicDBObject obj=new BasicDBObject();
				System.out.println(cursorObject.next().get("name"));

				/*Find and update a particular element 
				 * in the database with new value
				 */
				BasicDBObject simpleQurey1=new BasicDBObject();
				simpleQurey1.put("name", "!!!!!!!!!!!!!!!!!!!!");

				BasicDBObject newDocument=new BasicDBObject();
				newDocument.put("name", "!!!!!!!!!!!!!!!!!!!!");

				BasicDBObject updateObj=new BasicDBObject();
				updateObj.put("$set", newDocument);
				collectionObject.update(simpleQurey1, updateObj);


			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}


