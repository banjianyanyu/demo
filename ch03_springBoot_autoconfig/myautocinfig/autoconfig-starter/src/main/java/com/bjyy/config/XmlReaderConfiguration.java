package com.bjyy.config;

import com.bjyy.XmlReaderTest;
import com.bjyy.XmlReaderTestImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Aurora
 * @date 2026年01月01日 12:32
 */
@Configuration
@ConditionalOnClass({XmlReaderTest.class})
@EnableConfigurationProperties({XmlReaderProperites.class})
public class XmlReaderConfiguration {

    XmlReaderProperites xmlReaderProperites;
    public XmlReaderConfiguration(XmlReaderProperites xmlReaderProperites) {
        this.xmlReaderProperites = xmlReaderProperites;
    }
    @Bean
    public XmlReaderTest xmlReader(){
        XmlReaderTestImpl xmlReaderTest =new XmlReaderTestImpl();
        xmlReaderTest.setSize(xmlReaderProperites.getSize());
        xmlReaderTest.setXml(xmlReaderProperites.getXml());
        xmlReaderTest.setPath(xmlReaderProperites.getPath());
        return xmlReaderTest;
    }
}
