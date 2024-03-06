package com.myprojects.footballplayers.repository;

import com.myprojects.footballplayers.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByName(String name);
    Player findByLastName(String lastName);
    List<Player> findByAge(int age);
}
