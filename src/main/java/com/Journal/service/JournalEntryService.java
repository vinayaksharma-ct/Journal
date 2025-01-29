package com.Journal.service;

import com.Journal.entity.JournalEntry;
import com.Journal.entity.User;
import com.Journal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.findByUserName(userName);
            //        journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        }
        catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occured while saving the entry");
        }
//        try{
//            journalEntry.setDate(LocalDateTime.now());
//            journalEntryRepository.save(journalEntry);
//        }
//        catch(Exception e){
////            ErrorManager log = null;
//            throw new RuntimeException("An error occured while saving the entry");
//        }

    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(String id) {
        return journalEntryRepository.findById(id);
    }

    public void  deleteById(ObjectId id) {
         journalEntryRepository.deleteById(id);
    }

}