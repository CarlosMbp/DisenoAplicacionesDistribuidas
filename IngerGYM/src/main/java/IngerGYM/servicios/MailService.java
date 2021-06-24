package IngerGYM.servicios;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import IngerGYM.entidades.Message;



@Service
public class MailService {


    private static final String MAIL_SERVICE_URL = "http://internal-service:9000";

    public void sendMail(Message message) {
		
        
        HttpEntity<Message> httpEntity = new HttpEntity<>(message);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity res = restTemplate.postForEntity( MAIL_SERVICE_URL + "/sendEmail", httpEntity, ResponseEntity.class);

        if(res.getStatusCode() == HttpStatus.CREATED){
            System.out.println("Mail enviado correctamente");
        }else{
            System.out.println("Hubo un problema al mandar el mail");
        }


	}
}