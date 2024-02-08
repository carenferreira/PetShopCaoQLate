package cfs.petshop.caoqlate.model;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {
	public static void sendEmail(String smtpHost, int smtpPorta, String user, String senha, String from,
			String toAddress, String subject, String message) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName(smtpHost);
		email.setSmtpPort(smtpPorta);
		email.setAuthenticator(new DefaultAuthenticator(user, senha));
		email.setStartTLSRequired(true);
		email.setFrom(from);
		email.setSubject(subject);
		email.setMsg(message);
		email.addTo(toAddress);
		email.send();
	}
}
