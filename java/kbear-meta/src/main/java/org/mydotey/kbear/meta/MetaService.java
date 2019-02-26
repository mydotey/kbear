package org.mydotey.kbear.meta;

import org.mydotey.kbear.meta.FetchClustersRequest;
import org.mydotey.kbear.meta.FetchClustersResponse;
import org.mydotey.kbear.meta.FetchConsumerGroupsRequest;
import org.mydotey.kbear.meta.FetchConsumerGroupsResponse;
import org.mydotey.kbear.meta.FetchTopicsRequest;
import org.mydotey.kbear.meta.FetchTopicsResponse;

public interface MetaService {

    FetchClustersResponse fetchClusters(FetchClustersRequest request);

    FetchTopicsResponse fetchTopics(FetchTopicsRequest request);

    FetchConsumerGroupsResponse fetchConsumerGroups(FetchConsumerGroupsRequest request);

}
