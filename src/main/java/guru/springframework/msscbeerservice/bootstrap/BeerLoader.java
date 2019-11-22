package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){

            beerRepository.save(Beer.builder()
                    .beerName("Super Bock")
                    .beerStyle(BeerStyleEnum.BOCK)
                    .quantityToBrew(200)
                    .minOnHand(20)
                    .upc(123456789012L)
                    .price(new BigDecimal(0.75))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Sagres")
                    .beerStyle(BeerStyleEnum.LAGER)
                    .quantityToBrew(150)
                    .minOnHand(15)
                    .upc(123456789013L)
                    .price(new BigDecimal(0.65))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Cristal")
                    .beerStyle(BeerStyleEnum.WEISS)
                    .quantityToBrew(75)
                    .minOnHand(8)
                    .upc(123456789014L)
                    .price(new BigDecimal(1.30))
                    .build());
        }

        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
