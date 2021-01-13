package co.soft.anonsms.controller;

import co.soft.anonsms.service.SmsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @GetMapping("/")
    public String defaultPage() {
        return "default";
    }

    @PostMapping("/")
    public String sendAnonymousSms(
            @RequestParam String toPhoneNumber,
            @RequestParam String messageText,
            @RequestParam String key,
            Model model
    ) throws IOException {
        smsService.sendAnonymousSms(toPhoneNumber, messageText, key);

        String response = null;

        String string = smsService.sendAnonymousSms(toPhoneNumber, messageText, key);

        if (string.contains("true")) {
            response = "Message sent to recipient";
            model.addAttribute("sent", response);
        } else if (string.contains("false") && !string.contains("Sorry, due to spammers URLs are disabled for free SMS")) {
            response = "Message not sent. You used more than 1 sms.";
            model.addAttribute("not_sent", response);
        } else if (string.contains("false") && string.contains("Sorry, due to spammers URLs are disabled for free SMS")) {
            response = "Please do not use spam urls!";
            model.addAttribute("spam_link", response);
        }

        return "default";

    }
}
