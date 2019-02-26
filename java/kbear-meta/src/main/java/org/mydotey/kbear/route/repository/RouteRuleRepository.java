package org.mydotey.kbear.route.repository;

import java.util.List;

import org.mydotey.kbear.meta.ConsumerGroupId;
import org.mydotey.kbear.repository.Repository;
import org.mydotey.kbear.route.RouteRule;

/**
 * @author koqizhao
 *
 * Nov 13, 2018
 */
public interface RouteRuleRepository extends Repository<String, RouteRule> {

    List<RouteRule> getRecords(String topicId);

    List<RouteRule> getRecords(ConsumerGroupId consumerGroupId);

}
