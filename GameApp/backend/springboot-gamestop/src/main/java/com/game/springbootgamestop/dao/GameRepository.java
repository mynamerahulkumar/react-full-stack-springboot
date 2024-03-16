package com.game.springbootgamestop.dao;

import com.game.springbootgamestop.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface GameRepository extends JpaRepository<Game,Long> {

   Page<Game> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

   Page<Game> findByCategory(@RequestParam("category") String category,Pageable pageable);


}
