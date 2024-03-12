package com.myprojects.footballplayers.controller;

import com.myprojects.footballplayers.model.Player;
import com.myprojects.footballplayers.repository.PlayerRepository;
import com.myprojects.footballplayers.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:${CROSS_ORIGIN_URL}")
@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerService playerService;

    /*
    * @RequestMapping(value="/player", method = RequestMethod.POST) could be used instead of @PostMapping("/player")
    * */
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/player")
    public Player createPlayer(@RequestBody Player player){
        return playerService.savePlayer(player);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/player/{playerID}")
    public Player updatePlayerDetails(@PathVariable(value = "playerID") Long playerID, @RequestBody Player playerDetails){
        return playerService.updatePlayer(playerID, playerDetails);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/player")
    public List<Player> retrieveAllPlayers(){
        return playerService.getAllPlayers();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/player/{playerID}")
    public Player retrievePlayerById(@PathVariable(value = "playerID") Long playerID){
        return playerService.getPlayerById(playerID);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/player/name")
    public List<Player> retrievePlayerByName(@RequestParam(required = true) String name){
        return playerRepository.findByName(name);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/player/lastname")
    public Player retrievePlayerByLastName(@RequestParam(required = true) String lastName){
        return playerRepository.findByLastName(lastName);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/player/age")
    public List<Player> retrievePlayerByAge(@RequestParam(required = true) int age){
        return playerRepository.findByAge(age);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/player/{playerID}")
    public void delPlayerById(@PathVariable(value = "playerID") Long playerID){
        playerService.deletePlayerById(playerID);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/player")
    public void delAllPlayers(){
        playerService.deleteAllPlayers();
    }

}
