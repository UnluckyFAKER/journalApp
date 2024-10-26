package com.moulik.journalApp.scheduler;

import com.moulik.journalApp.Appcache.AppCache;
import com.moulik.journalApp.Enum.Enum;
import com.moulik.journalApp.model.Journalentry;
import com.moulik.journalApp.model.User;
import com.moulik.journalApp.repository.UserRepoImpl;
import com.moulik.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class Userscheduler {
    @Autowired
    private UserRepoImpl userRepo;
    @Autowired
    private AppCache appCache;;
    @Autowired
    EmailService emailService;
//    @Scheduled(cron="0 21 * * 0")
//    public void featchUserandSendemail() {
//        // find the user whose have corrct emails
//        List<User> users= userRepo.getSA();
//        for(User user:users){
//            // fetch the journal entry of the right user to a list
//            List<Journalentry> journalentries= user.getGGEZ();
//            // store the context of the list whichs journal is after 7 days
//            List<Enum.Sentiment> sentiments = journalentries.stream()
//                    // collect the content of the enum Sentiment
//                    .filter(x -> x.getDate() != null && x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS)))
//                    .map(x -> x.getSentiment()) // Keep as Sentiment enum
//                    .collect(Collectors.toList());
//            // logic
//            Map<Enum.Sentiment, Integer> sentimentCount = new HashMap<>();
//            for (Enum.Sentiment sentiment : sentiments) {
//                if (sentiment != null) {
//                    sentimentCount.put(sentiment, sentimentCount.getOrDefault(sentiment, 0) + 1);
//                }
//            }
//
//            // Determine the most frequent sentiment with tie-breaking
//            Enum.Sentiment mostFrequentSentiment = null;
//            int maxCount = 0;
//
//            for (Map.Entry<Enum.Sentiment, Integer> entry : sentimentCount.entrySet()) {
//                // Update most frequent sentiment or keep the first in case of a tie
//                if (entry.getValue() > maxCount) {
//                    maxCount = entry.getValue();
//                    mostFrequentSentiment = entry.getKey();
//                } else if (entry.getValue() == maxCount && mostFrequentSentiment == null) {
//                    // If we have a tie and haven't set a sentiment yet, set the current one
//                    mostFrequentSentiment = entry.getKey();
//                }
//            }
//
//            // Send email if a most frequent sentiment is determined
//            if (mostFrequentSentiment != null) {
//                emailService.sendMail(user.getEmail(),
//                        "This is your current mood according to your journal",
//                        mostFrequentSentiment.toString());
//            }
//        }
//    }



    @Scheduled(cron="0 */15 * * * *")
   public void clearCache() {
       appCache.inin();
    }

}
