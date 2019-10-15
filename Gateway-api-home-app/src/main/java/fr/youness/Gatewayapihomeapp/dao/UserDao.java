package fr.youness.Gatewayapihomeapp.dao;

import fr.youness.Gatewayapihomeapp.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByIsActiveAndUsername(Boolean isActive, String username);
}
