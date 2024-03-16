package com.game.springbootgamestop.dao;

import com.game.springbootgamestop.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewRepository extends JpaRepository<Review,Long> {
  Page<Review> findByGameId(@RequestParam("game_id") Long gameId, Pageable pageable);

}
