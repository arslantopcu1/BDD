package az.kapitalbank.e2e;

import java.io.File;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "az.kapitalbank.e2e.*" })
@EnableAspectJAutoProxy
public class AppConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
		p.setLocation(getResourceFile());
		return p;
	}
	
	 @Bean	
	 public AspectsConfiguration aspectsConfiguration(){
		 return new AspectsConfiguration();
	 }

	private static Resource getResourceFile() {
		ClassLoader classLoader = AppConfiguration.class.getClassLoader();
		File file = new File(classLoader.getResource("config.properties").getFile());
		Resource resource = new FileSystemResource(file);
		return resource;
	}

}
