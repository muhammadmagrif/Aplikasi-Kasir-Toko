package xa.pos289.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomConfig implements WebMvcConfigurer {
	String mypath = "file:\\C:\\Users\\Muhammadmagrif\\xsisa\\xsisac\\pos289\\img\\users\\"; //Lokasi Upload File Laptop Pribadi
	//String mypath = "file:\\C:\\Users\\XSIS User\\xsisac\\pos289\\img\\"; //Lokasi Upload File Laptop Kantor
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations(mypath);
	}

}
