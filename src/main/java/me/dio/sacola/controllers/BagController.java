package me.dio.sacola.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.dio.sacola.controllers.dto.ItemDto;
import me.dio.sacola.models.Bag;
import me.dio.sacola.models.Item;
import me.dio.sacola.services.BagService;

@Api(value="/ifood-devweek/bags")
@RestController
@RequestMapping("/ifood-devweek/bags")
@RequiredArgsConstructor
public class BagController {
 
    private final BagService bagService;

    @PostMapping
    public Item addItemToBag(@RequestBody ItemDto itemDto){
        return bagService.addItemToBag(itemDto);
    }

    @GetMapping("/{id}")
    public Bag seeBag(@PathVariable("id") Long id) {
        return bagService.seeBag(id);
    }

    @PatchMapping("/closeBag/{idBag}")
    public Bag closeBag(
        @PathVariable("idBag") Long idBag, 
        @RequestParam("formPayment") int formsPayment) 
        {
        return bagService.closeBag(idBag, formsPayment);
    }    

}
