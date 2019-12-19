package guru.springframework.msscbeerservice.bootstrap;

import guru.sfg.brewery.model.BeerStyleEnum;
import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
       if(beerRepository.count() == 0)
       {
           loadBeerObjects();
       }
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){

            beerRepository.save(Beer.builder()
                    .beerName("Super Bock")
                    .beerStyle(BeerStyleEnum.BOCK.name())
                    .quantityToBrew(200)
                    .minOnHand(20)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal(0.75))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Sagres")
                    .beerStyle(BeerStyleEnum.LAGER.name())
                    .quantityToBrew(150)
                    .minOnHand(15)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal(0.65))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Cristal")
                    .beerStyle(BeerStyleEnum.WEISS.name())
                    .quantityToBrew(75)
                    .minOnHand(8)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal(1.30))
                    .build());
        }

        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
