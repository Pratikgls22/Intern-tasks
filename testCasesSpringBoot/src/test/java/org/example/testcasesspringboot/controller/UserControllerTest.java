package org.example.testcasesspringboot.controller;

import org.example.testcasesspringboot.model.User;
import org.example.testcasesspringboot.service.UserService;
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

class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Test
    void create() {
        //Request
        User mockUser = new User();

        //Mock
        mockUser.setId(3l);
        mockUser.setName("trup");
        mockUser.setCity("a'bad");
        mockUser.setPhone("7894561230");

        //Mocking
        when(userService.create(mockUser)).thenReturn(mockUser);

        //Test
        User user = userController.create(mockUser);

        //Assertion
        verify(userService, times(1)).create(user);
        assertEquals(mockUser,user);
    }

    @Test
    void search() {
        //Request
        List<User> mockUserList = new ArrayList<>();

        //Mock
        mockUserList.add(new User(1l,"trup","a'bad","7894561230"));

        //Mocking
        when(userService.search()).thenReturn(mockUserList);

        //Test
        List<User> users = userController.search();

        //Assertion
        verify(userService,times(1)).search();
        assertEquals(mockUserList,users);

    }

    @Test
    void searchId() {
        //Request
        Long mockId = 1l;

        //Mock
        User mockUser = new User(1l,"asdgj","hghj","3245647890");

        //Mocking
        when(userService.searchId(mockId)).thenReturn(mockUser);

        //Test
        User user = userController.searchId(mockId);

        //Assertion
        verify(userService,times(1)).searchId(mockId);
        assertEquals(mockUser,user);
    }

    @Test
    void delete() {
        //Request
        Long mockId = 2l;

        //Mock


        //Mocking
        doNothing().when(userService).delete(mockId);

        //Test
        userController.delete(mockId);

        //Assertion
        verify(userService,times(1)).delete(mockId);
    }

    @Test
    void update() {
        //Request
        Long mockId = 3l;

        //Mock
        User mockUser = new User(3L,"pratik","ANKN","7989466325");

        //Mocking
        when(userService.update(mockId, mockUser)).thenReturn(mockUser);

        //Test
        User user = userController.update(mockId,mockUser);

        //Assertion
        verify(userService,times(1)).update(mockId,mockUser);
        assertEquals(mockUser,user);
//        assertEquals("hgsjd",user.getName());  // when you want to only one value
    }
}