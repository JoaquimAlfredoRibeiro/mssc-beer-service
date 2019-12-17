package guru.sfg.common.events;

import guru.springframework.msscbeerservice.web.model.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent{

    public BrewBeerEvent(BeerDTO beerDTO){
        super(beerDTO);
    }

}
