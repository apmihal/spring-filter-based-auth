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
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
