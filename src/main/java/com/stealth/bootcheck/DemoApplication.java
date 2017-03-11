package com.stealth.bootcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.stealth.model.XmlBean;

@SpringBootApplication
@ComponentScan(basePackages="com.stealth")
@ImportResource("classpath:addconfig.xml")
public class DemoApplication {

	@Bean
	RedisConnectionFactory connectionFactory(){
		JedisConnectionFactory jedisConnection=new JedisConnectionFactory();
		jedisConnection.setHostName("10.0.0.191");
		jedisConnection.setPassword("");
		return jedisConnection; 
	}
//	@Bean
//    public ViewResolver viewResolver()
//    {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
	@Bean
	RedisSerializer<Object> serializer(){
		return new GenericJackson2JsonRedisSerializer();
	}
	
	@Bean
	RedisTemplate<String, Object> template(RedisConnectionFactory connectionFactory,RedisSerializer<Object> serializer){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setDefaultSerializer(serializer);
		return redisTemplate;
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext cap=SpringApplication.run(DemoApplication.class, args);
		XmlBean xb=(XmlBean)cap.getBean(XmlBean.class);
		System.out.println(xb.getXmlId()+" "+xb.getXmlName());
	}
}
