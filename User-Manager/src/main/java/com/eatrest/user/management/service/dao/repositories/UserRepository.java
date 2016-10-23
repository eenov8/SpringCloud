/**
 * 
 */
package com.eatrest.user.management.service.dao.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eatrest.user.management.service.dao.beans.User;

/**
 * @author Anurag Jain
 *
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public List<User> findByUsernameAndPassword(String username, String password);

}
