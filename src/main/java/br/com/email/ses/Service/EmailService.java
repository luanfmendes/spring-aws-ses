package br.com.email.ses.Service;

import br.com.email.ses.model.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private JavaMailSender javaMailSender;

    public void enviarEmail(Email email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mineMessageHelper = new MimeMessageHelper(message, true);

        mineMessageHelper.setFrom(email.getFrom());
        mineMessageHelper.setTo(email.getTo());
        mineMessageHelper.setSubject(email.getSubject());
        mineMessageHelper.setText(email.getText());

        javaMailSender.send(message);

    }
}
