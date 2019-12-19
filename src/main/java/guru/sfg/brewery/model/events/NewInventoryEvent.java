package guru.sfg.brewery.model.events;

import guru.sfg.brewery.model.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
