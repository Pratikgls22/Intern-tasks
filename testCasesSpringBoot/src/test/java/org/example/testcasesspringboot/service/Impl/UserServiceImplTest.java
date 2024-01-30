package org.example.testcasesspringboot.service.Impl;

import org.example.testcasesspringboot.model.User;
import org.example.testcasesspringboot.repositry.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void create() {
        //Request
        User mockUser = new User();

        //Mock
        mockUser.setId(1L);
        mockUser.setName("pratik");
        mockUser.setCity("a'bad");
        mockUser.setPhone("7894561230");

        //Mocking
        when(userDao.save(mockUser)).thenReturn(mockUser);

        //Test
        User user = userService.create(mockUser);

        //Assertion
        verify(userDao,times(1)).save(mockUser);
        assertEquals(mockUser,user);
    }

    @Test
    void search() {
        //Request
        List<User> mockserList = new ArrayList<>();

        //Mock
        mockserList.add(new User(1L,"pratik","ajbj","3216549870"));

        //Mocking
        when(userDao.findAll()).thenReturn(mockserList);

        //Test
        List<User> userList = userService.search();

        //Assertion
        verify(userDao,times(1)).findAll();
        assertEquals(userList,mockserList);
    }

    @Test
    void searchId() {
        //Request
        Long mockId = 2L;

        //Mock
        User mockUser = new User(2L,"zfgj","jgugb","4656489756");

        //Mocking
        when(userDao.findById(mockId)).thenReturn(Optional.of(mockUser));

        //Test
        User user = userService.searchId(mockId);

        //Assertion
        verify(userDao,times(1)).findById(mockId);
        assertEquals(mockUser,user);
    }

    @Test
    void delete() {
        //Request
        Long mockId = 3L;

        //Mock
        User mockUser = new User(3L,"osgj","jhgj","654498787");

        //Mocking
        when(userDao.findById(mockId)).thenReturn(Optional.of(mockUser));
        doNothing().when(userDao).delete(mockUser);

        //Test
         userService.delete(mockId);

        //Assertion
        verify(userDao,times(1)).delete(mockUser);
    }

    @Test
    void update() {
        //Request
        Long mockId = 1L;
        User mockUser = new User(1L,"aefsad","afs","7894561230");

        //Mock
        User dbUser = new User(1L,"sdhb","hvkd","7894561230");

        //Mocking
        when(userDao.findById(mockId)).thenReturn(Optional.of(dbUser));
        when(userDao.save(dbUser)).then(i->i.getArgument(0));

        //Test
        User user =userService.update(mockId,mockUser);

        //Assertion
        verify(userDao,times(1)).findById(mockId);
        verify(userDao,times(1)).save(dbUser);
        assertEquals(dbUser,user);
    }
}