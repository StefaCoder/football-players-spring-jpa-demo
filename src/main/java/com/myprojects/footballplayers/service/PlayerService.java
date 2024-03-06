package com.myprojects.footballplayers.service;

import com.myprojects.footballplayers.model.Player;
import com.myprojects.footballplayers.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public Player savePlayer(Player player) throws DataAccessException {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long playerID, Player playerDetails){
        Player playerInfo = playerRepository.findById(playerID).orElseThrow(() -> new RuntimeException("Player not found"));

        if(playerDetails.getName() != null) {
            playerInfo.setName(playerDetails.getName());
        }

        if(playerDetails.getLastName() != null) {
            playerInfo.setLastName(playerDetails.getLastName());
        }

        if(playerDetails.getAge() != 0) {
            playerInfo.setAge(playerDetails.getAge());
        }

        if(playerDetails.getRole() != null) {
            playerInfo.setRole(playerDetails.getRole());
        }

        if(playerDetails.getValue() != null) {
            playerInfo.setValue(playerDetails.getValue());
        }

        return playerRepository.save(playerInfo);
    }

    public List<Player> getAllPlayers() throws DataAccessException{
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long playerID){
        return playerRepository.findById(playerID).orElseThrow(() -> new NoSuchElementException("Player not found"));
    }

    public void deletePlayerById(Long playerID){
        playerRepository.deleteById(playerID);
    }

    public void deleteAllPlayers(){
        playerRepository.deleteAll();
    }

}
