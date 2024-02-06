package com.devhb.springboot;

import com.devhb.springboot.entity.Wikimedia;
import com.devhb.springboot.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    @Autowired
    private WikimediaRepository wikimediaRepository;
    @KafkaListener(topics = "${spring.kafka.topic.name}",
                    groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received - > %s",eventMessage));
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEventData(eventMessage);
        wikimediaRepository.save(wikimedia);
    }
}
