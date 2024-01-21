Code for [Microservices and Distributed Systems course](https://app.amigoscode.com/p/microservices)

# What I learned

## Bootstrap with Maven

- Maven doesn't resolve the latest version of transitive dependency. The version closer to the root of the dependency
  tree will be used instead. It can be overwritten by specifying the version of dependency directly
  in `<dependencies>` (it moves the dependency closer to the root of the dependency tree).
  Alternatively, `<dependencyManagement>` section could be used to explicitly specify the transitive dependencies'
  versions.
- BOM (Bill of Materials) can be used as a parent POM (Project Object Model) to specify dependencies used in a
  project (`<dependencyManagement>` takes precedence over `<dependencies>` definitions).
- In multimodule Maven project, when root POM should be specified as parent, it's still possible
  to use BOM. Parent POM should include BOM as a `<type>pom</type>` `<scope>import</scope>` dependency. Submodules will
  inherit dependency management and their dependencies will be resolved according to BOM specified in parent
  POM's `<dependencyManagement>` section.

## Your First Microservice

## Microservice Communication via HTTP

- To make use of generated data from Spring Data JPA save, `save()` must be replaced with `saveAndFlush()`.

## Service Discovery with Eureka

- It's easy to start another Spring Boot application on different port by copying the configuration in Intellij and
  providing `--server.port` program argument.

## Open Feign

- Open Feign is a nice way of exposing unified API clients across Spring applications.

## Exercise

## Distributed Tracing

- Trace ID is constant through the entire communication since it's initiated (spans). Span ID is created and constant
  within a single service.
- Sleuth (from Spring Cloud) is a sufficient tool to set traceId and spanId for applications communicating with each
  other.
- Sleuth offers an out-of-the-box integration with Zipkin by adding a single dependency from Spring Cloud.

## Api Gateway With Spring Cloud Gateway

- There are multiple concerns because of which managed load balancers should be used on Production, like: TLS,
  Certificate Management, Authentication, High Availability, Logging, Caching, Path Based Routing etc.
- Load balancers should maintain health checks to determine if the target may accept traffic. Health checks should be
  implemented on application side to check, for example, if the database connection works fine.
- Spring Cloud Gateway allows to quickly spin up a simplified load balancer in Spring ecosystem.
- External traffic should not access services in private network directly. It should be done via a load balancer.

## Message Queues

- RabbitMQ can use message header instead of routing key to define a mapping between an exchange and a queue.
- For nameless exchange type, binding is defined to send message to a queue when routing key matches queue name.

## RabbitMQ

- It's possible to customize RabbitTemplate with a custom message converter (like customized Jackson ObjectMapper).

## Packaging Microservices to Runnable Jar

- Maven plugins added to parent POM are available in modules POMs.
- Maven pluginsManagement allows controlling plugin versions in modules' POMs. It also allows to define shared plugins'
  configurations.
- It's not enough to package SpringBoot application into a Jar to run it. `spring-boot-maven-plugin` is required.
  Executable Jars are created in the `repackage` goal.

## Packaging Jars to Docker Images

- Docker Daemon in Docker Host is an instance, with which Docker Client interacts to perform build, run, pull etc.
- SpringBoot Maven Plugin can generate Docker image (OCI image) from Jar file.
- For Docker image it's possible to specify a hash, to narrow particular version of the image.
- Maven Profiles allow to configure the build depending on the build environment. In this example, modules
  have `build-docker-image` profile, which causes `package` lifecycle to build and push Docker images after building Jar
  files.
- While publishing Docker container's port, when localhost is specified, port is open only for the Docker host, not
  outside: `-p 127.0.0.1:8080:8080`
- Docker containers share Docker host DNS configuration from `etc/resolv.conf`. It can be overwritten by providing DNS
  server after `--dns` flag. Multiple `--dns` properties may be provided.
- When docker network exists between containers, the communication between them requires using container name as URL.
- `docker compose pull` allows to refresh the current versions of images. `docker compose stop` stops container,
  comparing to `docker compose down`, which also removes them.

## Kubernetes AKA k8s

- etcd is a distributed Kubernetes key-value store, which keeps configuration and state of the Kubernetes cluster.
- Scheduler is watching for pods and assigns them to nodes basing on the available resources and other scheduling
  factors.
- Controller Manager manages the control loop. It controls other controllers (Deployments, StatefulSets), responsible to
  check the conditions and restore the desired state, when the current state is not desired (like Node
  Controller, which is responsible for creating a new node, when a node dies).
- Kubelet is an agent running on every node. Reports containers' state to API server.
- Container Runtime is responsible for pulling images, starting containers, stopping containers (for example
  containerd, Docker).
- KubeProxy is responsible for managing internal cluster networking.
- Pod is the smallest deployable unit in k8s. It contains of the main container, init container, side containers,
  volumes (used to exchange data between containers), and a network (to allow containers to communicate with each other
  using `localhost`). Pods have assigned IP address. Pods should never be created manually, controllers (like
  Deployment, StatefulSet) should be used to create them.
- Deployment creates ReplicaSets (containing pods) for each application version rollout. Once the new ReplicaSet is
  ready, the traffic is no longer forwarded to the old ReplicaSet.
- Service has a stable IP address, DNS name and port.
- Service discovery in k8s happens through Services.
- KubeProxy (running on each worker nodes) maintain network rules allowing communication to pods. Implements a
  controller that watches the API server for new Services and Endpoints. Creates IPVS (IP Virtual Server) rules that
  tell node to intercept traffic destined to the Service ClusterIP. Redirects traffic to Pods matching Service label
  selectors (main role).

## Deploying Postgres RabbitMQ and Zipkin to k8s

- IntelliJ Kubernetes Plugin (for Ultimate only) offers a convenient way to browse k8s resources, opening shell etc.
- StatefulSet is a controller, which has a stable IP and storage. In case of Deployment, pods are ephemeral.

## Refactoring Microservices for k8s

- `docker compose ps` allows listing running containers configured in docker-compose descriptor file.