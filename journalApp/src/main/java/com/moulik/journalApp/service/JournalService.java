package com.moulik.journalApp.service;

import com.moulik.journalApp.model.User;
import com.moulik.journalApp.model.Journalentry;
import com.moulik.journalApp.repository.journalRepo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {
// we cannot use autowire in pojo class
//    @Autowired
//    journalentry Jentry;

    @Autowired
    private journalRepo journalrepo;
    @Autowired
    private UserService us;
    public void saveentry(Journalentry je, String userName){
       // journalentry.setDate(LocalDateTime.now());
        // creat an user object and link with username
            je.setDate(LocalDateTime.now());
            User user = us.findByUsername(userName);


        // save the journal entry
            Journalentry Save = journalrepo.save(je);
            //add this entry tor user
            user.getGGEZ().add(Save);
            // return the entry to eser repo
            us.saveentry(user);



    }
    public void saveentry(Journalentry je){
//        je.setDate(LocalDateTime.now());
        journalrepo.save(je);


    }

    public List<Journalentry> getAll(){
        return journalrepo.findAll();
    }
    public Optional<Journalentry> findbyid(String myid){
        return journalrepo.findById(myid);
    }
    public void deletebyId(String myid ,String userName){
        try {
            User user = us.findByUsername(userName);
            // remove the user from database checking UserName and userID
            boolean remove =user.getGGEZ().removeIf(x -> x.getId().equals(myid));
            // save the change in user database\
            if(remove) {
                us.saveentry(user);
                journalrepo.deleteById(myid);
            }

        } catch (Exception e) {
            System.out.println("Exception");
            throw new RuntimeException("Invalid",e);
        }
    }

}
