package guru.springframework.msscbeerservice.web.mappers;

import guru.sfg.brewery.model.BeerDTO;
import guru.springframework.msscbeerservice.domain.Beer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);

    BeerDTO beerToBeerDTOWithInventory(Beer beer);

    Beer beerDTOToBeer(BeerDTO beerDTO);
}
