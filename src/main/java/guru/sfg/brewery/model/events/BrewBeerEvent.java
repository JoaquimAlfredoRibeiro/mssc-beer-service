package guru.sfg.brewery.model.events;

import guru.sfg.brewery.model.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent{

    public BrewBeerEvent(BeerDTO beerDTO){
        super(beerDTO);
    }

}
