git clone <url>

mvn package

java -cp target/KuduRestServer.jar com.cloudera.se.rest.server.kudu.KuduRestServer 8055 <kudu master>:8051

KuduRestService <port> <Kudu Master>

<port>        - The port that the Rest Server will start on
<Kudu Master> - The location of the Kudu Master Server

