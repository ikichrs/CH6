package com.binar.challenge4.controller;

import com.binar.challenge4.firebase.FirebaseEntity;
import com.binar.challenge4.firebase.FirebaseMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@Service
public class FirebaseController {
    private final FirebaseMessageService firebaseService;

    public FirebaseController(FirebaseMessageService firebaseService){
        this.firebaseService = firebaseService;
    }

    @RequestMapping("/notif")
    @ResponseBody
    public String sendNotification(@RequestBody FirebaseEntity note,
                                   @RequestParam String token)  {

        return firebaseService.sendNotification(note);
    }
}
