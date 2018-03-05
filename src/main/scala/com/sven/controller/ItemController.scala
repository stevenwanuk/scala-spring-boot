package com.sven.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model
import javax.annotation.PostConstruct
import scala.collection.mutable.ArrayBuffer
import com.sven.bean.Item
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import com.sven.repository.ItemRepository
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping(Array("/items"))
class ItemController (val itemRepository: ItemRepository){

  private var items = ArrayBuffer[Item]();

  @PostConstruct
  def init() {

  }

  @GetMapping()
  def list():  java.util.List[Item] = {
    itemRepository.findAll()
  }

  @GetMapping(Array("/{id}"))
  def list(@PathVariable id: Int): ResponseEntity[Item] = {
    val optional = itemRepository.findById(id);
    if (optional.isPresent()) {
      return ResponseEntity.ok(optional.get)
    } 
    return ResponseEntity.notFound().build();
  }
}