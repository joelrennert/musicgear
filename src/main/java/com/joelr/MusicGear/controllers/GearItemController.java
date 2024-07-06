package com.joelr.MusicGear.controllers;

import com.joelr.MusicGear.dao.JdbcGearItemDao;
import com.joelr.MusicGear.exception.DaoException;
import com.joelr.MusicGear.model.GearItem;

import com.joelr.MusicGear.service.GearItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/musicgear")
public class GearItemController {

    @Autowired
    private GearItemService gearItemService;
    @Autowired
    private JdbcGearItemDao gearItemDao;

    public GearItemController(JdbcGearItemDao jdbcGearItemDao){
        this.gearItemDao = jdbcGearItemDao;
    }

    // Get gear items by name or type
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<GearItem> list(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String type){
        return gearItemService.getGearItemsByNameOrType(name, type);
    }

    // Get single gear item by id
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public GearItem get(@PathVariable int id){
        return gearItemService.getGearItemById(id);
    }

    // Add gear item
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public GearItem add(@Valid @RequestBody GearItem gearItem) {
        try {
            return gearItemService.addGearItem(gearItem);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gear Item not found");
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public GearItem updateGearItem(@PathVariable int id, @RequestBody GearItem gearItem) {
        try {
            return gearItemService.updateGearItem(id, gearItem);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gear Item not found");
        }
    }

    // Update gear item's type or description
//    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
//    public GearItem updateGearItemNameOrType(@RequestBody GearItem gearItem,
//                                             @RequestParam(defaultValue = "") String type,
//                                             @RequestParam(defaultValue = "") String description,
//                                             @PathVariable int id) {
//        try {
//            return gearItemService.updateGearItemTypeOrDescription(gearItem, gearItem.getType(), gearItem.getDescription(), id);
//        } catch (DaoException e){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gear Item not found");
//        }
//    }

    // Remove gear item
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeGearItem(@PathVariable int id){
        try {
            gearItemService.removeGearItem(id);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
