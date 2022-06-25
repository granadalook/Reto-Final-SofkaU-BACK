package co.com.sofkau.appagilismo.usuario.utilidades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnviarMail {

    private static final Logger log = LoggerFactory.getLogger(EnviarMail.class);
    @Autowired
    private JavaMailSender enviarMail;

    public void enviarEmail(String email, String asunto, String cuerpoDelMensaje){

        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setFrom("ciendecilantro.agile@gmail.com");
        mensaje.setTo(email);
        mensaje.setText(cuerpoDelMensaje);
        mensaje.setSubject(asunto);
        enviarMail.send(mensaje);

        log.info("Mensaje enviado satisfactoriamente");
    }
}
