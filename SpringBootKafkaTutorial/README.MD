Codebase for [YouTube course](https://youtu.be/SqVfCyfCJqw?si=yTkykDxiSQ4cPjM0) for SpringBoot and Kafka tutorial.

# Running

Start Kafka broker following ([Kafka Quickstart guide](https://kafka.apache.org/quickstart)):
```
tar -xzf kafka_2.13-3.1.0.tgz
cd kafka_2.13-3.1.0
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

# Testing

# What I learned
- Kafka topic is a durable collection of events, replicated (between nodes) and partitioned, small or big.
- Comparing to RabbitMQ Kafka has better throughput, build-in partitioning, replication and fault-tolerance. It offers built-in stream processing.
- Broker is a VM running the Kafka process.
