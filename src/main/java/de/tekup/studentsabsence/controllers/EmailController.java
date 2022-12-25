package de.tekup.studentsabsence.controllers;
import de.tekup.studentsabsence.entities.Email;
import de.tekup.studentsabsence.entities.Response;
import de.tekup.studentsabsence.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMailSimple")
    public Response sendMailSimple(@RequestBody Email mail) {
        return emailService.sendEmail(mail);
    }
}

