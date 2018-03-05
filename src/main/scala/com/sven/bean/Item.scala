package com.sven.bean

import scala.beans.BeanProperty

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.Table


@Entity
@Table(name = "item")
class Item {

  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id : Long = _;
  @BeanProperty
  var name : String = _;
  
  def Item(id: Long, name: String) = {
    this.id = id;
    this.name = name;
  }

}