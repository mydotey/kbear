package org.mydotey.kbear.client;

import org.mydotey.kbear.meta.ConsumerGroupId;

/**
 * @author koqizhao
 *
 * Dec 19, 2018
 */
public interface KafkaMetaManager extends AutoCloseable {

    KafkaMetaHolder getMetaHolder();

    void registerProducer(String topicId, Runnable onChange);

    void unregisterProducer(String topicId);

    void registerConsumer(ConsumerGroupId consumerGroupId, Runnable onChange);

    void unregisterConsumer(ConsumerGroupId consumerGroupId);

}
