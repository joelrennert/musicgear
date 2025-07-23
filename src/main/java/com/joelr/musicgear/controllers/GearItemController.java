package com.joelr.musicgear.controllers;

import com.joelr.musicgear.exception.DaoException;
import com.joelr.musicgear.model.GearItem;
import com.joelr.musicgear.service.GearItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/musicgear")
public class GearItemController {

    private final GearItemService gearItemService;

    public GearItemController(GearItemService gearItemService) {
        this.gearItemService = gearItemService;
    }

    @GetMapping("")
    public List<GearItem> list(@RequestParam(defaultValue = "") String name,
                               @RequestParam(defaultValue = "") String type) {
        return gearItemService.getGearItemsByNameOrType(name, type);
    }

    @GetMapping("/{id}")
    public GearItem get(@PathVariable int id) {
        GearItem gearItem = gearItemService.getGearItemById(id);
        if (gearItem == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gear item not found");
        }
        return gearItem;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public GearItem add(@Valid @RequestBody GearItem gearItem) {
        try {
            return gearItemService.addGearItem(gearItem);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error adding gear item", e);
        }
    }

    @PutMapping("/{id}")
    public GearItem update(@PathVariable int id, @Valid @RequestBody GearItem gearItem) {
        try {
            GearItem updated = gearItemService.updateGearItem(id, gearItem);
            if (updated == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gear item not found");
            }
            return updated;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error updating gear item", e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable int id) {
        try {
            gearItemService.removeGearItem(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting gear item", e);
        }
    }
}