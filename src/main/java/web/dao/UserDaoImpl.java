package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUserById(int id, User user) {
        User userById = getUserById(id);
        userById.setName(user.getName());
        userById.setLastName(user.getLastName());
        userById.setAge(user.getAge());
        entityManager.persist(userById);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
