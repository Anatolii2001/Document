package com.example.Spring_boot.dao;

import com.example.Spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(int id, User updateUser) {
        User user = findById(id);
        user.setType(updateUser.getType());
        user.setCodeOfIssuingState(updateUser.getCodeOfIssuingState());
        user.setPassportNo(updateUser.getPassportNo());
        user.setSurname(updateUser.getSurname());
        user.setGivenNames(updateUser.getGivenNames());
        user.setNationality(updateUser.getNationality());
        user.setPersonalNo(updateUser.getPersonalNo());
        user.setDateOfBirth(updateUser.getDateOfBirth());
        user.setPlaceOfBirth(updateUser.getPlaceOfBirth());
        user.setSex(updateUser.getSex());
        user.setDateOfIssue(updateUser.getDateOfIssue());
        user.setDateOfExpiry(updateUser.getDateOfExpiry());
        user.setAuthority(updateUser.getAuthority());
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        User user = findById(id);
        entityManager.remove(user);
    }

//    @Override
//    public User isExistById(User user) {
//        if(entityManager.contains(user)) {
//            entityManager.remove(user);
//        } else {
//            entityManager.remove(entityManager.merge(user));
//        }
//        return user;
//    }
}
