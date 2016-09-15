package com.cloudera.se.rest.server.kudu
import org.apache.kudu.client.KuduClient

object KuduGlobalValues {

  var kuduClient:KuduClient = null

  def init(kuduMaster:String): Unit = {
    println("kuduMaster:" + kuduMaster)
    kuduClient = new KuduClient.KuduClientBuilder(kuduMaster).build()
  }
}
