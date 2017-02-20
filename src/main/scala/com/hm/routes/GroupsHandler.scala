package com.hm.routes

import com.hm.connector.Mysqlclient
import spray.json.JsString
import spray.routing.HttpService
import spray.json._

/**
  * Created by vishnu on 2/17/17.
  */
trait GroupsHandler extends HttpService{



  /*
  *
  * Json Parameter = {"id":"1",
  * "gName":"demo",
  * "listOfUsers":["1","2","3"]
  * }


   }
  * */
  def createGroup =  post{
    entity(as[String])
    {
      body=>{
        val json=body.parseJson.asJsObject
        val id = json.getFields("id").head.asInstanceOf[JsString].value
        val gName=json.getFields("gName").head.asInstanceOf[JsString].value
        val listOfUsers=json.getFields("").head.asInstanceOf[JsString].value

      }
        complete("group created WIP")

    }
  }

//  def createGroupApi(gName:String,noOfParticipants:Int, listOfUsers:Array[Int])= {
//    val rs=Mysqlclient.executeQuery("insert into group values ("+1+",'"+gName+"','"++"')")
//    rs
//  }
def deleteToDo = post {
  entity(as[String]){
    body =>{
      val json = body.parseJson.asJsObject
      val todo_id = json.getFields("todo_id").head.asInstanceOf[JsString].value


      if(!deleteGroupTask(todo_id.toInt)){
        complete("delete successful")
      }
      else{
        complete("delete failed")
      }
    }
  }
}
  def deleteGroupTask(todo_id:Int) ={
    val rs = Mysqlclient.executeQuery("delete from todo where todo_id= '" + todo_id +"'")
    rs
  }

}
