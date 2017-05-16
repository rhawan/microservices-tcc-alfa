package br.alfa.sales.config;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	//yyyy-MM-dd'T'HH:mm:ss.SSSZZ
	
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		SimpleModule module = new SimpleModule();
		module.addSerializer(ZonedDateTime.class, new JsonSerializer<ZonedDateTime>() {

			@Override
			public void serialize(ZonedDateTime zonedDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
					throws IOException, JsonProcessingException {
				jsonGenerator.writeString(FORMATTER.format(zonedDateTime));
			}
		});
		objectMapper.registerModule(module);
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		converter.setObjectMapper(objectMapper);
		converters.add(converter);
		super.configureMessageConverters(converters);
	}
	
	/*@Bean
    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(objectMapper);
        converters.add(jsonConverter);
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }
	
	@Bean
	@Primary
	public ObjectMapper serializingObjectMapper() {
	    ObjectMapper objectMapper = new ObjectMapper();
	    JavaTimeModule javaTimeModule = new JavaTimeModule();
	    javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
	    javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
	    objectMapper.registerModule(javaTimeModule);
	    return objectMapper;
	}
	
	private class LocalDateSerializer extends JsonSerializer<LocalDate> {

		@Override
		public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
				throws IOException, JsonProcessingException {
			jsonGenerator.writeString(localDate.format(FORMATTER));
		}
	}
	
	private class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
		
	    @Override
	    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
	        return LocalDate.parse(jsonParser.getValueAsString(), FORMATTER);
	    }
	}*/

}
