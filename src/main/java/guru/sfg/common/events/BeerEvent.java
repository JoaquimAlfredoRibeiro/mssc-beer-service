package guru.sfg.common.events;

import guru.springframework.msscbeerservice.web.model.BeerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -9007670986171948834L;

    private BeerDTO beerDTO;

}
