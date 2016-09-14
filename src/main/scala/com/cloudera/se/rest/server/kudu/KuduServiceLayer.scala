package com.cloudera.se.rest.server.kudu

import javax.ws.rs.core.MediaType
import javax.ws.rs.{QueryParam, _}
import org.apache.kudu.client.KuduPredicate
import scala.collection.mutable

@Path("rest")
class KuduServiceLayer {

  @GET
  @Path("hello")
  @Produces(Array(MediaType.TEXT_PLAIN))
  def hello(): String = {
    "Hello World"
  }

  @GET
  @Path("{tableName}/{column}/{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getRowbyKey (@PathParam("tableName") tableName:String, 
                   @PathParam("column") column:String, 
                   @PathParam("id") id:String): RowResult = {
  
    val table = KuduGlobalValues.kuduClient.openTable(tableName)
    val schema = table.getSchema
    val col = schema.getColumn(column)

    val scanner = kuduClient.newScannerBuilder(custTable).
      addPredicate(KuduPredicate.
      newComparisonPredicate(col, KuduPredicate.ComparisonOp.EQUAL, id)).
      build()

    var result:String = ""
    
    while (scanner.hasMoreRows) {
      val rows = scanner.nextRows()
      while (rows.hasNext) {
        val rowResult = rows.next()

        result = rowResult.toStringLongFormat()
      }
    }
    result
  }
}
