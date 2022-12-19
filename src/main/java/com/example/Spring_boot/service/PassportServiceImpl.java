package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.repositories.PassportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Component
//@Transactional(readOnly = true)
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public List<Passport> getAllUsers() {
        return passportRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Passport user) {
        passportRepository.save(user);
    }

    @Override
    public Passport findById(long id) {
        return passportRepository.findUserById(id);
    }

    @Override
    @Transactional
    public void update(long id, Passport updateUser) {
        passportRepository.save(updateUser);
    }

    @Override
    @Transactional
    public void delete(long id) {
        passportRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Passport isExistById(Passport user) {
        return passportRepository.findUserById(user.getId());
    }
}
