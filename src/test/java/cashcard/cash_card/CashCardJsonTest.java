package cashcard.cash_card;

import cashcard.cash_card.CashCard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    void cashCardSerializationTest() throws IOException {

        CashCard cashCard = new CashCard(99L, 123.45);

        //It converts that object to JSON and runs several checks , compare with expected.json
        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");

        //It checks if there is a field named id and if that field is a number.
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);

        //It dives into the JSON, grabs the value of amount, and confirms it equals 123.45.
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
    }
}