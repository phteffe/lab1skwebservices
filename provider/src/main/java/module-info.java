import org.example.provider.DollarConverter;
import org.example.provider.EurConverter;
import org.example.provider.SterlingConverter;
import org.example.service.CurrencyExchange;


module org.example.provider {
    requires org.example.service;
    exports org.example.provider;
    provides CurrencyExchange with DollarConverter,EurConverter,SterlingConverter;
}
