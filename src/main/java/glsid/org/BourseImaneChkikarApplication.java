package glsid.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import glsid.org.Service.Jsoup.ServiceJSOUP;

@SpringBootApplication
@ImportResource("config.xml")
public class BourseImaneChkikarApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx= SpringApplication.run(BourseImaneChkikarApplication.class, args);
		/*ServiceJSOUP jsoupservice = ctx.getBean(ServiceJSOUP.class);
	    jsoupservice.listeSociete();    
		jsoupservice.listeOrdre();*/
      
	}
}
