package org.mydotey.kbear.meta;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.mydotey.kbear.Util;
import org.mydotey.kbear.meta.Cluster;
import org.mydotey.kbear.meta.ConsumerGroup;
import org.mydotey.kbear.meta.FetchClustersRequest;
import org.mydotey.kbear.meta.FetchClustersResponse;
import org.mydotey.kbear.meta.FetchConsumerGroupsRequest;
import org.mydotey.kbear.meta.FetchConsumerGroupsResponse;
import org.mydotey.kbear.meta.FetchTopicsRequest;
import org.mydotey.kbear.meta.FetchTopicsResponse;
import org.mydotey.kbear.meta.Topic;
import org.mydotey.kbear.meta.repository.ClusterRepository;
import org.mydotey.kbear.meta.repository.ConsumerGroupRepository;
import org.mydotey.kbear.meta.repository.TopicRepository;
import org.mydotey.kbear.service.ResponseStatus;
import org.mydotey.rpc.ack.Acks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author koqizhao
 *
 * Sep 21, 2018
 */
@Singleton
@Named()
public class DefaultMetaService implements MetaService {

    private static Logger _logger = LoggerFactory.getLogger(DefaultMetaService.class);

    @Inject
    private ClusterRepository _clusterRepository;

    @Inject
    private TopicRepository _topicRepository;

    @Inject
    private ConsumerGroupRepository _consumerGroupRepository;

    @Override
    public FetchClustersResponse fetchClusters(FetchClustersRequest request) {
        FetchClustersResponse.Builder builder = FetchClustersResponse.newBuilder();
        ResponseStatus.Builder statusBuilder = ResponseStatus.newBuilder();
        try {
            boolean isEmpty = request == null || request.getClusterIdsList().isEmpty();
            List<Cluster> clusters;
            if (isEmpty) {
                clusters = _clusterRepository.getAll();
                statusBuilder.setAck(Acks.SUCCESS);
            } else {
                clusters = _clusterRepository.getRecords(request.getClusterIdsList());
                statusBuilder.setAck(
                        clusters.size() == request.getClusterIdsList().size() ? Acks.SUCCESS : Acks.PARTIAL_FAIL);
            }
            return builder.addAllClusters(clusters).setStatus(statusBuilder.build()).build();
        } catch (Exception e) {
            Util.handleServiceException(statusBuilder, e, _logger);
            return builder.setStatus(statusBuilder.build()).build();
        }
    }

    @Override
    public FetchTopicsResponse fetchTopics(FetchTopicsRequest request) {
        FetchTopicsResponse.Builder builder = FetchTopicsResponse.newBuilder();
        ResponseStatus.Builder statusBuilder = ResponseStatus.newBuilder();
        try {
            boolean isEmpty = request == null || request.getTopicIdsList().isEmpty();
            List<Topic> topics;
            if (isEmpty) {
                topics = _topicRepository.getAll();
                statusBuilder.setAck(Acks.SUCCESS);
            } else {
                topics = _topicRepository.getRecords(request.getTopicIdsList());
                statusBuilder
                        .setAck(topics.size() == request.getTopicIdsList().size() ? Acks.SUCCESS : Acks.PARTIAL_FAIL);
            }
            return builder.addAllTopics(topics).setStatus(statusBuilder.build()).build();
        } catch (Exception e) {
            Util.handleServiceException(statusBuilder, e, _logger);
            return builder.setStatus(statusBuilder.build()).build();
        }
    }

    @Override
    public FetchConsumerGroupsResponse fetchConsumerGroups(FetchConsumerGroupsRequest request) {
        FetchConsumerGroupsResponse.Builder builder = FetchConsumerGroupsResponse.newBuilder();
        ResponseStatus.Builder statusBuilder = ResponseStatus.newBuilder();
        try {
            boolean isEmpty = request == null || request.getConsumerGroupIdsList().isEmpty();
            List<ConsumerGroup> consumerGroups;
            if (isEmpty) {
                consumerGroups = _consumerGroupRepository.getAll();
                statusBuilder.setAck(Acks.SUCCESS);
            } else {
                consumerGroups = _consumerGroupRepository.getRecords(request.getConsumerGroupIdsList());
                statusBuilder.setAck(consumerGroups.size() == request.getConsumerGroupIdsList().size() ? Acks.SUCCESS
                        : Acks.PARTIAL_FAIL);
            }
            return builder.addAllConsumerGroups(consumerGroups).setStatus(statusBuilder.build()).build();
        } catch (Exception e) {
            Util.handleServiceException(statusBuilder, e, _logger);
            return builder.setStatus(statusBuilder.build()).build();
        }
    }

}
