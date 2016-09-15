package com.cloudera.se.rest.server.kudu

import javax.ws.rs.core.MediaType
import javax.ws.rs.{QueryParam, _}
import org.apache.kudu.client.KuduPredicate
import scala.collection.mutable

@Path("/kudu")
class KuduServiceLayer {

  @GET
  @Path("/version")
  @Produces(Array(MediaType.TEXT_PLAIN))
  def version(): String = {
    "Print Version"
  }
  
  @GET
  @Path("/listTables")
  @Produces(Array(MediaType.TEXT_PLAIN))
  def listTables(): String = {
    "List Tables"
  }
  
  @GET
  @Path("/schema/{tableId}")
  @Produces(Array(MediaType.TEXT_PLAIN))
  def tableSchema(): String = {
    "Table xyz schema is"
  }    

/**
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
  **/
  
}
