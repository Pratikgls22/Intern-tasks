package org.example.springsecuritywithdb.service;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritywithdb.model.CustomStudentDetail;
import org.example.springsecuritywithdb.model.Student;
import org.example.springsecuritywithdb.repositry.StudentDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomStudentDetailService implements UserDetailsService {

    private final StudentDao studentDao;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Student daoById = this.studentDao.findByName(name);
        if(daoById==null){
            throw new UsernameNotFoundException("Not Found Student");
        }

        return new CustomStudentDetail(daoById);
    }
}
