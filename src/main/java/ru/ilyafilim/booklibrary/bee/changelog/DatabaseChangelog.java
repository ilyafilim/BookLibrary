package ru.ilyafilim.booklibrary.bee.changelog;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "addHorror", author = "ilya.filim")
    public void insertHorror(DB db) {
        DBCollection myCollection = db.getCollection("genres");
        BasicDBObject doc = new BasicDBObject().append("name", "Horror");
        myCollection.insert(doc);
    }

    @ChangeSet(order = "002", id = "addDalton", author = "ilya.filim")
    public void insertRickDalton(DB db) {
        DBCollection myCollection = db.getCollection("authors");
        BasicDBObject doc = new BasicDBObject().append("name", "Rick Dalton");
        myCollection.insert(doc);
    }
}
