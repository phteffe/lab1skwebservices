module org.example.consumer {
    requires org.example.service;
    uses org.example.service.CurrencyExchange;
    uses org.example.service.annotation.Currency;
}
