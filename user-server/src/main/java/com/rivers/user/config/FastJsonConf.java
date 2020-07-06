//package com.rivers.user.config;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//
//@EnableWebMvc
//@Configuration
//public class FastJsonConf implements WebMvcConfigurer {
//
//    /**
//     * 修改自定义消息转换器
//     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(0, new ProtobufHttpMessageConverter());
//    }
//
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
////        converters.add(0, new ProtobufJsonFormatHttpMessageConverter());
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        List<MediaType> supportedMediaTypes = new ArrayList<>();
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
//        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
//        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XML);
//        supportedMediaTypes.add(MediaType.IMAGE_GIF);
//        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
//        supportedMediaTypes.add(MediaType.IMAGE_PNG);
//        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
//        supportedMediaTypes.add(MediaType.TEXT_HTML);
//        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
//        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
//        supportedMediaTypes.add(MediaType.TEXT_XML);
//        converter.setSupportedMediaTypes(supportedMediaTypes);
//        //创建配置类
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setDateFormat("yyyy-MM-dd");
//        //修改配置返回内容的过滤
//        //WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
//        //WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
//        //DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
//        //WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
//        //WriteMapNullValue：是否输出值为null的字段,默认为false
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullBooleanAsFalse,
//                SerializerFeature.IgnoreNonFieldGetter,
//                SerializerFeature.PrettyFormat
//        );
//        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
//        converter.setFastJsonConfig(fastJsonConfig);
//        converters.add(converter);
//    }
//
//    //    @Bean
////    @Primary
////    RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
////        RestTemplate restTemplate = new RestTemplate();
////        restTemplate.getMessageConverters().add(hmc);
////        return restTemplate;
////    }
////
////    @Bean
////    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
////        return new ProtobufHttpMessageConverter();
////    }
////
////    /**
////     * protobuf 反序列化
////     *
////     * @param converter
////     * @return
////     */
////    @Bean
////    RestTemplate restTemplate(ProtobufHttpMessageConverter converter) {
////        return new RestTemplate(Collections.singletonList(converter));
////    }
//
//}
