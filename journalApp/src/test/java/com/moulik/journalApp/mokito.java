package com.moulik.journalApp;


import com.moulik.journalApp.service.UserDetailsServiceImpl;
import com.moulik.journalApp.model.User;
import com.moulik.journalApp.repository.Userrepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static  org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
////    public class mokito { {
//        @InjectMocks
//        private UserDetailsServiceImpl userDetailsService;
//
//        @Mock
//        private Userrepo;
//
//        @BeforeEach
//        void setUp(){
//            MockitoAnnotations.initMocks(this);
//        }
//        @Disabled
//        @Test
//        void loadUserByUsernameTest(){
//            when(Userrepo.fineByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("inrinrick").roles(new ArrayList<>()).build());
//            UserDetails user = userDetailsService.loadUserByUsername("ram");
//            Assertions.assertNotNull(user);
//        }
//    }
//}
