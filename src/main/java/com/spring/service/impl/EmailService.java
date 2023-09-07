package com.spring.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.spring.entitys.Account;
import com.spring.repository.IAccountRepository;
import com.spring.repository.IHoaDonChiTietRepository;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private IAccountRepository repo;
	@Autowired
	@Value("${email.path}")
	private String pathFolder;
	@Autowired
	private HashPassword hashPassword;
	@Autowired
	IHoaDonChiTietRepository hoaDonChiTietRepository;
	
	public void SendMailForget(String username ,String email) throws IOException, TemplateException {
		String pass = "";
		for(int i = 0 ; i < 6 ; i++) {
			Integer so = new Random().nextInt(9);
			pass+= so;
		}
		Account account = repo.getByUsername(username);
		account.setPassword(hashPassword.hash(pass));
		repo.save(account);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
		ZonedDateTime now = ZonedDateTime.now();
		String time = f.format(now);
		String to = email;
		String subject = "Cập nhật lại mật khẩu lúc " + time +" !";
		String emailContent = getEmailContent(username,pass);
		String body = emailContent ;
		MimeMessagePreparator messagePreparator = mimeMessage -> {
		    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		    messageHelper.setFrom("linhnkph24164@fpt.edu.vn");
		    messageHelper.setTo(to);
		    messageHelper.setSubject(subject);
		    messageHelper.setText(body, true);
		   
		};
		 mailSender.send(messagePreparator);
	}
//public void SendMailOrder(String username ,String email, HoaDon hoaDon) throws IOException, TemplateException {
//		
//
//		
//		String to = email;
//		String subject = "Hóa đơn #"+hoaDon.getIdHoaDon();
//		String emailContent = getEmailContentOrder(username, hoaDon);
//		String body = emailContent ;
//		MimeMessagePreparator messagePreparator = mimeMessage -> {
//		    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//		    messageHelper.setFrom("hanhnph24141@fpt.edu.vn");
//		    messageHelper.setTo(to);
//		    messageHelper.setSubject(subject);
//		    messageHelper.setText(body, true);
//		   
//		};
//		 mailSender.send(messagePreparator);
//			
//			
//
//		
//	}
	String getEmailContent(String  username , String passmoi) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("user", username);
        model.put("passmoi", passmoi);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        FileTemplateLoader templateLoader = new FileTemplateLoader(new File(pathFolder));
        cfg.setTemplateLoader(templateLoader);
        cfg.getTemplate("forgetmail.ftlh").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
//	String getEmailContentOrder(String  username , HoaDon hoaDon) throws IOException, TemplateException {
//        StringWriter stringWriter = new StringWriter();
//        Map<String, Object> model = new HashMap<>();
//        model.put("user", username);
//        model.put("hd", hoaDon);
//     
//      
//        List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietRepository.getAllById(hoaDon.getIdHoaDon());
//        model.put("hdct", hoaDonChiTiets);
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
//        FileTemplateLoader templateLoader = new FileTemplateLoader(new File(pathFolder));
//        cfg.setTemplateLoader(templateLoader);
//        cfg.getTemplate("orderemail.ftlh").process(model, stringWriter);
//        return stringWriter.getBuffer().toString();
//    }
}
