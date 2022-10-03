package me.dio.sacola.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.controllers.dto.ItemDto;
import me.dio.sacola.enums.FormsPayment;
import me.dio.sacola.models.Bag;
import me.dio.sacola.models.Item;
import me.dio.sacola.models.Restaurant;
import me.dio.sacola.repositories.BagRepository;
import me.dio.sacola.repositories.ItemRepository;
import me.dio.sacola.repositories.ProductRepository;
import me.dio.sacola.services.BagService;

@Service
@RequiredArgsConstructor
public class BagServiceImpl implements BagService{
    
    private final BagRepository bagRepository;
    private final ItemRepository itemRepository;
    private final ProductRepository productRepository;

    /**
     * Add items
     */
    @Override
    public Item addItemToBag(ItemDto itemDto) {
         Bag bag = seeBag(itemDto.getBagId());

         if(bag.isClosedBag()){
            throw new RuntimeException("This bag is closed!");
         }

         Item itemParseInserted = Item.builder()
            .quantity(itemDto.getQuantity())
            .bag(bag)
            .product(
                productRepository.findById(itemDto.getProductId())
                .orElseThrow(() -> {
                    throw new RuntimeException("This product not exists!");
                }
        ))
        .build();

        List<Item> itemsBag = bag.getItems();

        if(itemsBag.isEmpty()) {
            itemsBag.add(itemParseInserted);
        }else{
            Restaurant actualRestaurant = itemsBag.get(0).getProduct().getRestaurant();
            Restaurant restaurantAddItems = itemParseInserted.getProduct().getRestaurant();

            if(actualRestaurant.equals(restaurantAddItems)){
                itemsBag.add(itemParseInserted);
            }else {
                throw new RuntimeException("Restaurant does not match. Close de bag or clear");
            }
        }
        
        List<Double> priceItems = new ArrayList<>();
        for(Item itemBag : itemsBag) {
            double totalItemPrice =
                itemBag.getProduct().getUnitPrice() * itemBag.getQuantity();
                priceItems.add(totalItemPrice);
        }

        double totalPriceBag = priceItems.stream()
        .mapToDouble(totalPriceWhichItem -> totalPriceWhichItem)
        .sum();

        bag.setTotalPrice(totalPriceBag);
        bagRepository.save(bag);
        return itemRepository.save(itemParseInserted);
    }

    /**
     * Get bag
     */
    @Override
    public Bag seeBag(Long id) {
        return bagRepository.findById(id)
                            .orElseThrow(() -> {
                                throw new RuntimeException("Inexistent bag");
            }
        );
    }

    /**
     * Close bag
     */
    @Override
    public Bag closeBag(Long id, int forms) {
        
        Bag bag = seeBag(id);
        
        if(bag.getItems().isEmpty()){
            throw new RuntimeException("Add products");
        }

        FormsPayment form = 
        forms == 0 ? FormsPayment.MONEY : FormsPayment.CREDIT_CARD;

        bag.setFormsPayment(form);
        bag.setClosedBag(true);

        return bagRepository.save(bag);
    }
    
}
