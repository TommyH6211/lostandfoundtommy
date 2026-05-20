package com.tommy.lostandfoundtommy.demo;

import com.tommy.lostandfoundtommy.model.Item;
import com.tommy.lostandfoundtommy.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class demoHome {

    @Bean
    CommandLineRunner loadData(ItemRepository itemRepository) {

        return args -> {

            itemRepository.save(
                    new Item(
                            "The Marrow Thieves",
                            "Pointless and annoying",
                            "LIII classroom",
                            "Not Retrieved"
                    )
            );

            itemRepository.save(
                    new Item(
                            "Andrew's AirPods",
                            "White AirPods Pro",
                            "Cafeteria",
                            "Retrieved"
                    )
            );

            itemRepository.save(
                    new Item(
                            "Water Bottle",
                            "Pink transparent",
                            "2nd floor new building",
                            "Not Retrieved"
                    )
            );
        };
    }
}