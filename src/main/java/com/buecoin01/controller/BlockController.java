package com.buecoin01.controller;

import com.buecoin01.Repositories.BlockRepository;
import com.buecoin01.model.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
public class BlockController {

    @Autowired
    private BlockRepository blockRepository;

    @RequestMapping(value = "/block/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id) {
        Optional<Block> block = blockRepository.findById( id );
        return new ResponseEntity <>( block, HttpStatus.OK );

    }

    @RequestMapping(value = "/blocks", method = RequestMethod.GET)
    public ResponseEntity <Iterable <Block>> getAllUsers() {
        Iterable <Block> allBlocks = blockRepository.findAll();
        return new ResponseEntity <>( allBlocks, HttpStatus.OK );

    }

    @RequestMapping(path = "/addBlock", method = RequestMethod.POST)
    public ResponseEntity <?> create(@RequestBody Block block) {
        blockRepository.save(block);
        return new ResponseEntity <>( block, HttpStatus.CREATED );
    }

    @RequestMapping(path = "/deleteBlock", method = RequestMethod.DELETE)
    public ResponseEntity <Block> deleteBlock(@RequestBody Block block) {
        blockRepository.delete(block );
        return new ResponseEntity <>( HttpStatus.OK );
    }

    @RequestMapping(path = "/updateBlock", method = RequestMethod.PUT)
    public ResponseEntity <Block> updateBlock(@RequestBody Block block) {
        blockRepository.save(block);
        return new ResponseEntity <>( HttpStatus.OK );
    }


}

