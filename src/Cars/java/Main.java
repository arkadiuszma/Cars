import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        Properties variables = FileHandler.loadFile("criteriaVariables.properties");
        String brandToFilter = variables.getProperty("brandToFilter");
        int trunkCapacityFilter = Integer.parseInt(variables.getProperty("trunkCapacityFilter"));

        Country poland = new Country("Poland", 'P');
        Country germany = new Country("Germany", 'D');
        Country china = new Country("China", 'C');
        Country netherlands = new Country("Netherlands", 'N');
        Country southKorea = new Country("South Korea", 'K');
        Market business = new Market("business", List.of(poland, china, germany));
        Market cargo = new Market("cargo", List.of(netherlands, poland, southKorea, germany));
        Market transport = new Market("transport", List.of(southKorea, netherlands, germany));
        Market taxi = new Market("taxi", List.of(poland, china, southKorea, germany, netherlands));
        Market bus = new Market("bus", List.of(china, southKorea, netherlands));
        Dimension dimension1 = new Dimension(200, 4000, 250);
        Dimension dimension2 = new Dimension(150, 3500, 210);
        Dimension dimension3 = new Dimension(180, 3900, 230);
        Dimension dimension4 = new Dimension(220, 4500, 410);
        Dimension dimension5 = new Dimension(230, 4800, 600);
        Dimension dimension6 = new Dimension(210, 4200, 320);
        Dimension dimension7 = new Dimension(200, 4600, 430);
        Dimension dimension8 = new Dimension(190, 5000, 700);
        Dimension dimension9 = new Dimension(165, 3700, 220);
        Dimension dimension10 = new Dimension(205, 4100, 350);
        Manufacturer bmw = new Manufacturer("BMW", "E46");
        Manufacturer audi = new Manufacturer("Audi", "A3");
        Manufacturer skoda = new Manufacturer("Skoda", "Octavia");
        Manufacturer toyota = new Manufacturer("Toyota", "Corolla");
        Manufacturer nissan = new Manufacturer("Nissan", "Qashqai");
        Manufacturer chevrolet = new Manufacturer("Chevrolet", "Cruze");
        Manufacturer peugeot = new Manufacturer("Peugeot", "206");
        Manufacturer ford = new Manufacturer("Ford", "Mustang");
        Manufacturer fiat = new Manufacturer("Fiat", "Bravo II");
        Manufacturer hyundai = new Manufacturer("Hyundai", "i30");
        Car fiatBravo = new Car(fiat, false, cargo, "standard", List.of(dimension2, dimension4, dimension7));
        Car fordMustang = new Car(ford, true, business, "premium", List.of(dimension8, dimension6));
        Car hyundaiGetz = new Car(hyundai, false, transport, "standard", List.of(dimension3, dimension10));
        Car peugeot206 = new Car(peugeot, true, transport, "standard", List.of(dimension1, dimension9));
        Car chevroletCruze = new Car(chevrolet, true, bus, "medium", List.of(dimension5, dimension6));
        Car nissanQashqai = new Car(nissan, true, bus, "medium", List.of(dimension10, dimension4));
        Car toyotaCorolla = new Car(toyota, false, transport, "standard", List.of(dimension9, dimension3));
        Car skodaOctavia = new Car(skoda, false, business, "medium", List.of(dimension1, dimension7));
        Car audiA3 = new Car(audi, true, business, "premium", List.of(dimension3, dimension4));
        Car audiA3Manual = new Car(audi, false, business, "premium", List.of(dimension3, dimension4));
        Car audiA3Taxi = new Car(audi, true, taxi, "premium", List.of(dimension3, dimension9));
        Car bmwE46Taxi = new Car(bmw, true, taxi, "medium", List.of(dimension6, dimension7));
        Car bmwE46 = new Car(bmw, true, business, "medium", List.of(dimension6, dimension2));
        Car bmwE46Manual = new Car(bmw, false, business, "medium", List.of(dimension6, dimension2));
        Car peugeot206Automatic = new Car(peugeot, true, cargo, "standard", List.of(dimension8, dimension1));
        List<Car> cars = Arrays.asList(fiatBravo, fordMustang, hyundaiGetz, peugeot206Automatic, peugeot206, chevroletCruze, nissanQashqai, toyotaCorolla, skodaOctavia, audiA3, audiA3Manual, audiA3Taxi, bmwE46Manual, bmwE46, bmwE46Taxi);
        Car.getFilteredCars(cars, brandToFilter, trunkCapacityFilter);
    }
}
