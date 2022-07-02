package jinny.study.tdd.domain;

public class CardNumberValidator {

    public void setServer(String server) {

    }

    public CardValidity validate(String cardNumber) {
        // http 요청 코드 ...


        return CardValidity.VALID;
    }


}
