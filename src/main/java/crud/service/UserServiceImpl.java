package crud.service;

import crud.dao.UserDAO;
import crud.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }


    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDAO.editUser(user);
    }//04-Aug-2022 12:54:16.333 WARNING [Catalina-utility-1] org.apache.catalina.util.
    // SessionIdGeneratorBase.createSecureRandom Creation of SecureRandom instance
    // for session ID generation using [SHA1PRNG] took [324] milliseconds.

}
