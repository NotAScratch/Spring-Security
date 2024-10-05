package com.example.fullstack.event;

import com.example.fullstack.entities.User;
import com.example.fullstack.services.VerificationTokenService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{
    private final VerificationTokenService tokenService;
    private final JavaMailSender mailSender;
    private User user;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        user = event.getUser();
        String vToken = UUID.randomUUID().toString();
        tokenService.saveVerificationTokenForUser(user, vToken);
        String url = event.getConformationUrl() + "/registration/verifyEmail?token="  + vToken;
        try {
            sendVerificationMail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public  void sendVerificationMail(String url) throws MessagingException, UnsupportedOperationException, UnsupportedEncodingException {
        String subject = "Email Verification";
        String senderName = "User Verification Service";
        String message = "To confirm your e-mail address, please click the link below:\n" + url;
        String mailContent = "" +
                "<html>" +
                "<body>" +
                "<h1>Registration Confirmation" + user.getFirstname() +"</h1>" +
                "<p>To confirm your e-mail address, please click the link below:</p>" +
                "<a href=\"" + url + "\">Confirm Email</a></body></html>";
        emailMessage( subject, senderName, mailContent, mailSender, user);

    }

    private void emailMessage(String subject, String senderName, String mailContent, JavaMailSender mailSender, User theUser)
            throws MessagingException, UnsupportedOperationException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("samirsen66@gmail.com", senderName);
        messageHelper.setTo(theUser.getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }
}
