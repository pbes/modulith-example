package hu.pbes.blog.modulithexample.order.internal.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMapperConfiguration {

    @Bean
    public ModelMapper orderMapper() {
        return new ModelMapper();
    }

}
