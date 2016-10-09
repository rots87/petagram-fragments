package com.leonetardo.petagram;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityContacto extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        FloatingActionButton estrella = (FloatingActionButton) findViewById(R.id.btnEstrella);
        estrella.setVisibility(View.INVISIBLE);
    }

    public void enviarComentario(View v){
        Button btnComentario = (Button) findViewById(R.id.btnEnviarComentario);
        btnComentario.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /*
                Properties props = new Properties();

                // Nombre del host de correo, es smtp.gmail.com
                props.setProperty("mail.smtp.host", "smtp.gmail.com");

                // TLS si está disponible
                props.setProperty("mail.smtp.starttls.enable", "true");

                // Puerto de gmail para envio de correos
                props.setProperty("mail.smtp.port","587");

                // Nombre del usuario
                props.setProperty("mail.smtp.user", "eeee@gmail.com");

                // Si requiere o no usuario y password para conectarse.
                props.setProperty("mail.smtp.auth", "true");

                Session session = Session.getDefaultInstance(props);
                session.setDebug(true);

                MimeMessage message = new MimeMessage(session);
                */
                try {
                    EditText tvNombre      = (EditText) findViewById(R.id.tvNombre);
                    EditText tvEmail       = (EditText) findViewById(R.id.tvEmail);
                    EditText tvDescripcion = (EditText) findViewById(R.id.tvDescripcion);

                    String nombre      = tvNombre.getText().toString();
                    String email       = tvEmail.getText().toString();
                    String descripcion = tvDescripcion.getText().toString();

                    /*
                    // Quien envia el correo
                    message.setFrom(new InternetAddress("eeee@gmail.com"));

                    // A quien va dirigido
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

                    message.setSubject("Mensaje Envidado por " + nombre + "desde App Petagram");
                    message.setText(descripcion);

                    Transport t = session.getTransport("smtp");

                    t.connect("eeee@gmail.com","84848484848");

                    t.sendMessage(message,message.getAllRecipients());

                    t.close();
                    */

                    Toast.makeText(
                            ActivityContacto.this,
                            "Email enviado a " + email, Toast.LENGTH_LONG
                    ).show();
                } catch (Exception e) {
                    Toast.makeText(
                            ActivityContacto.this,
                            "Los accesos no están bien configurados como para enviar el email",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });
    }
}
