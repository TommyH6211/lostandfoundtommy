//demoHome initializes the portal at the beginning, when http://localhost:8080/

package com.tommy.lostandfoundtommy.demo;

//Import Spring Framework and repository things again
import com.tommy.lostandfoundtommy.model.Item;
import com.tommy.lostandfoundtommy.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class demoHome {

    //Establishing a startup task once the LostandfoundtommyApplication starts running
    @Bean
    CommandLineRunner loadData(ItemRepository itemRepository) {

        //Essentially, this is a pre-existing table
        return args -> {

            //Each item actually has parameter name hints so table gets filled
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