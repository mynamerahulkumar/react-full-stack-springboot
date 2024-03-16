package com.game.springbootgamestop.dao;

import com.game.springbootgamestop.entity.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository  extends JpaRepository<CheckOut,Long> {

  CheckOut  findByUserEmailAndGameId(String userEmail,Long gameId);
}
