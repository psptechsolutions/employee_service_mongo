/*
 * package com.employee.service;
 * 
 * import java.util.Objects;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.mongodb.core.MongoOperations; import
 * org.springframework.data.mongodb.core.query.Update; import
 * org.springframework.stereotype.Service;
 * 
 * import com.employee.model.DatabaseSequence;
 * 
 * @Service public class SequenceGeneratorService { private MongoOperations
 * mongoOperations;
 * 
 * @Autowired public SequenceGeneratorService(MongoOperations mongoOperations) {
 * this.mongoOperations = mongoOperations; }
 * 
 * public long generateSequence(String seqName) {
 * 
 * try { DatabaseSequence counter =
 * mongoOperations.findAndModify(query(where("_id").is(seqName)), new
 * Update().inc("seq", 1), options().returnNew(true).upsert(true),
 * DatabaseSequence.class);
 * 
 * // Process the result as needed } catch (Exception e) { // Handle exceptions
 * (e.g., log, throw, or handle accordingly) e.printStackTrace(); }
 * 
 * } }
 */