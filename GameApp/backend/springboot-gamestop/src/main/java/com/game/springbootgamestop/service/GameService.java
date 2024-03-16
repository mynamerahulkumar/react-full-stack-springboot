package com.game.springbootgamestop.service;

import com.game.springbootgamestop.dao.CheckOutRepository;
import com.game.springbootgamestop.dao.GameRepository;
import com.game.springbootgamestop.entity.CheckOut;
import com.game.springbootgamestop.entity.Game;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class GameService {
    private GameRepository gameRepository;
    private CheckOutRepository checkOutRepository;

    public GameService(GameRepository gameRepository,CheckOutRepository checkOutRepository){
        this.gameRepository=gameRepository;
        this.checkOutRepository=checkOutRepository;
    }

    public Game checkoutGame(String userEmail,Long gameId) throws Exception {
        Optional<Game> game =gameRepository.findById(gameId);
        CheckOut validationCheckout=checkOutRepository.findByUserEmailAndGameId(userEmail, gameId);
        if(!game.isPresent() || validationCheckout!=null || game.get().getCopiesAvailable()<=0){
            throw  new Exception("Game does not exist or already checkout by user");

        }
        game.get().setCopiesAvailable(game.get().getCopiesAvailable()-1);
        gameRepository.save(game.get());
        CheckOut checkOut=new CheckOut(userEmail,
                LocalDate.now().toString(),
                LocalDate.now().plusDays(7).toString(),
                game.get().getId());
        checkOutRepository.save(checkOut);
        return game.get();
    }
}
