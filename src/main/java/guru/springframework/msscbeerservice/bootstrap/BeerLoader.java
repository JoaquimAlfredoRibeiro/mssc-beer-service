package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

//@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0123456789012";
    public static final String BEER_2_UPC = "0123456789013";
    public static final String BEER_3_UPC = "0123456789014";

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
