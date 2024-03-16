package com.game.springbootgamestop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "checkout")
@Data
public class CheckOut {
   public CheckOut(){

   }

    public CheckOut( String userEmail, String checkOutDate, String returnDate, Long gameId) {
        this.userEmail = userEmail;
        this.checkOutDate = checkOutDate;
        this.returnDate = returnDate;
        this.gameId = gameId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "checkout_date")
    private String checkOutDate;
    @Column(name = "return_date")
    private String returnDate;
    @Column(name = "game_id")
    private Long gameId;
}
