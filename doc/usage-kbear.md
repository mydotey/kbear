# KBear Enterprise Kafka Solution

## Monitoring

### Deploy Prometheus

[配置参考](../tools/kafka/monitoring/prometheus/prometheus.yml)

[部署脚本参考](../tools/kafka/monitoring/prometheus/deploy-prometheus.sh)

多个集群可共用1个Prometheus。

### Deploy Graphana

[部署脚本参考](../tools/kafka/monitoring/grafana/deploy-grafana.sh)

多个Prometheus可共用1个Graphana。

### Deploy Kafka Exporter

[部署脚本参考](../tools/kafka/monitoring/monitoring/kafka-exporter/deploy-kafka-exporter.sh)

1个Cluster，部署且只能部署在1台机器上。注意根据实际情况，修改 [start.sh](../tools/kafka/monitoring/monitoring/kafka-exporter/start.sh) 里的kafka.server参数。

### Deploy Kafka JMX Exporter

[部署脚本参考](../tools/kafka/monitoring/kafka-jmx-exporter/deploy-kafka-jmx-exporter.sh)

1个Cluster，每个Broker都要部署。

### 导入 Kafka Dashboard

有5个dashboard，在目录 [kafka-dashboards](../tools/kafka/monitoring/grafana/kafka-dashboards/1.0) 下。

## Multi-Cluster

### CRRL (Cluster Route Rule Language)

[配置示例](../java/kbear-meta/src/test/resources)

- clusters.yaml
- topics.yaml
- consumer-groups.yaml
- route-rules.yaml

### KBear Meta Service

项目：[kbear-meta](../java/kbear-meta)

使用说明：[kbear meta service](kbear-meta-service.md)

### KBear Client

项目：[kbear-client](../java/kbear-client)

使用说明：[kbear client](kbear-client.md)
