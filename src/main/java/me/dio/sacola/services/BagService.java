package me.dio.sacola.services;

import me.dio.sacola.controllers.dto.ItemDto;
import me.dio.sacola.models.Bag;
import me.dio.sacola.models.Item;

/**
 * BagService
 * Bag as product order
 */
public interface BagService {
    
    Item addItemToBag(ItemDto item);

    Bag seeBag(Long id);
    
    Bag closeBag(Long id, int forms);
}
