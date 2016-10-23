/**
 * 
 */
package com.eatrest.office.inventory.management.service.dao.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eatrest.office.inventory.management.service.dao.beans.FullOffice;

/**
 * @author Anurag Jain
 *
 */

@Repository
public interface FullOfficeRepository extends MongoRepository<FullOffice, String> {

	public List<FullOffice> findByUsernameAndPassword(String username, String password);

}
