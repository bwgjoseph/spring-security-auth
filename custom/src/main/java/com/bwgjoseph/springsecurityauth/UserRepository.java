/**
 * 
 */
package com.bwgjoseph.springsecurityauth;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Joseph Gan
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	Optional<User> findUserByUsername(String username);
}
