package com.moulik.journalApp.controler;

import com.moulik.journalApp.model.User;
import com.moulik.journalApp.model.Journalentry;
import com.moulik.journalApp.service.JournalService;
import com.moulik.journalApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class journalentrytest {
    @Autowired
    private JournalService js;
    @Autowired
    private UserService us;
// get your journals using username
    @GetMapping
    public ResponseEntity<?> getJournalentriesByuserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        // create a user class to store the value of body by username
        User user = us.findByUsername(userName);
        // add all journal values to user
        List<Journalentry> all= user.getGGEZ();
        if(all!= null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
//    @GetMapping("/id/{myid}")
//    public ResponseEntity<Journalentry> getJournalEntryById(@PathVariable String myid) {
//        // Get the authenticated user's username
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName = authentication.getName();
//
//        // Fetch the user from the database
//        User user = us.findByUsername(userName);
//
//        // Check if the user owns the journal entry with the given ID
//        Optional<Journalentry> collect = user.getGGEZ().stream()
//                .filter(entry -> entry.getId().equals(myid))
//                .findFirst();
//        if (!collect.isEmpty()) {
//            Optional<Journalentry> journalEntry = js.findbyid(myid);
//            if (journalEntry.isPresent()) {
//                return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
//            }
//
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PostMapping
    public ResponseEntity<Journalentry> creteentry(@RequestBody Journalentry ggez) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();
            js.saveentry(ggez,userName);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/id/{jett}")
    public ResponseEntity<?> deletebyid(@PathVariable String jett) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        js.deletebyId(jett,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("id/{jett}")
    public ResponseEntity<Journalentry> change(@PathVariable String jett
            , @RequestBody Journalentry myentry) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = us.findByUsername(userName);
        Optional<Journalentry> collect = user.getGGEZ().stream()
                .filter(entry -> entry.getId().equals(jett))
                .findFirst();
        if (!collect.isEmpty()) {
            Optional<Journalentry> journalEntry = js.findbyid(jett);
            if (journalEntry.isPresent()) {
                // create a object of Journalentry named old to store old value
                Journalentry old = journalEntry.get();
                // set the text if not null
                old.setText(myentry.getText() != null && !myentry.getText().equals("") ? myentry.getText() : old.getText());
                // set the context if not null
                old.setContext(myentry.getContext() != null && !myentry.getContext().equals("") ? myentry.getContext() : old.getContext());
                // save the entry
                js.saveentry(old);
                return new ResponseEntity<>(old, HttpStatus.OK);
            }

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
