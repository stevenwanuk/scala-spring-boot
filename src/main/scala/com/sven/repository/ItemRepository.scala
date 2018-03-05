package com.sven.repository

import org.springframework.data.repository.CrudRepository
import com.sven.bean.Item
import org.springframework.data.jpa.repository.JpaRepository

trait ItemRepository extends JpaRepository[Item, Long] {
  
}