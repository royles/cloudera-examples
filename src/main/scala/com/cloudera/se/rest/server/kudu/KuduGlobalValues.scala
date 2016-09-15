package com.cloudera.se.rest.server.kudu
import org.apache.kudu.client.KuduClient

object KuduGlobalValues {

  var tableName = "table"
  var kuduClient:KuduClient = null

  def init(kuduMaster:String,
           tableName:String): Unit = {

    println("kuduMaster:" + kuduMaster)
    println("TableName:" + tableName)

    kuduClient = new KuduClient.KuduClientBuilder(kuduMaster).build()
    this.tableName = tableName
  }
}
