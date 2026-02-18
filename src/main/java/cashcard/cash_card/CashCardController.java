package cashcard.cash_card;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// without it can't listen
//This tells Spring that this class is a Component of
//type RestController and capable of handling HTTP requests.
@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    //marks a method as a handler method
    @GetMapping("/{requestedId}")
    private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
        //@PathVariable makes Spring Web aware of the requestedId supplied in the HTTP request.
        // Now it’s available for us to use in our handler method.
        if (requestedId.equals(99L)) {
            CashCard cashCard = new CashCard(99L, 123.45);
            return ResponseEntity.ok(cashCard);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
