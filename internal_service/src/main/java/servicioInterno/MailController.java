package servicioInterno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	

    @Autowired
    private MailService mailService;

   

    @PostMapping("/sendEmail")
	public ResponseEntity<Void> addItem(@RequestBody Message message) {
		System.out.println("Send message: "+message.getMessageText()+" to "+message.getEmail());
		 mailService.sendMail("ingergymdad@gmail.com",message.getEmail(),message.getAsunto(),message.getMessageText());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
    
}
