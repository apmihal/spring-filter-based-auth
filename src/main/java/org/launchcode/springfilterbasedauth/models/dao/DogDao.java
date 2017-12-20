package org.launchcode.springfilterbasedauth.models.dao;


import org.launchcode.springfilterbasedauth.models.Dog;
import org.launchcode.springfilterbasedauth.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Transactional
@Repository
public interface DogDao extends CrudRepository<Dog, Integer> {

    User findByName(String username);
    List<Dog> findByUsers(User user);

}