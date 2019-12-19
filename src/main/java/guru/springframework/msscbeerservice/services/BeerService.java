package guru.springframework.msscbeerservice.services;

import guru.sfg.brewery.model.BeerDTO;
import guru.sfg.brewery.model.BeerPagedList;
import guru.sfg.brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDTO getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeerById(UUID beerId, BeerDTO beerDTO);

    BeerDTO getByUpc(String upc);
}
