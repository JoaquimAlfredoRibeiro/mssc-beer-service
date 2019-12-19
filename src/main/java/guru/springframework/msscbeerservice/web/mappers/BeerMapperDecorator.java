package guru.springframework.msscbeerservice.web.mappers;

import guru.sfg.brewery.model.BeerDTO;
import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.services.inventory.BeerInventoryService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper {

    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDTO beerToBeerDTOWithInventory(Beer beer) {
        BeerDTO beerDTO = mapper.beerToBeerDTO(beer);
        beerDTO.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));

        return beerDTO;
    }

    @Override
    public BeerDTO beerToBeerDTO(Beer beer) {
        return mapper.beerToBeerDTO(beer);
    }

    @Override
    public Beer beerDTOToBeer(BeerDTO beerDTO) {
        return mapper.beerDTOToBeer(beerDTO);
    }
}
