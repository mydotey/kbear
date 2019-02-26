package org.mydotey.kbear.meta.repository;

import org.mydotey.kbear.meta.Cluster;
import org.mydotey.kbear.repository.Repository;

/**
 * @author koqizhao
 *
 * Nov 13, 2018
 */
public interface ClusterRepository extends Repository<String, Cluster> {

    String KEY_BOOTSTRAP_SERVERS = "bootstrap.servers";
    String KEY_ZOOKEEPER_CONNECT = "zookeeper.connect";

}
