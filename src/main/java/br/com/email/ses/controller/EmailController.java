package br.com.email.ses.controller;

import br.com.email.ses.Service.EmailService;
import br.com.email.ses.model.Email;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping
    public void enviarEmail(@RequestBody Email email) throws MessagingException {
        emailService.enviarEmail(email);
    }
}
