import java.util.List;

public record Car(Manufacturer manufacturer, boolean isAutomaticGear, Market market, String segment,
                  List<Dimension> dimensions) {

    public static void getFilteredCars(List<Car> cars, String brandName, int minTrunkCapacity) {
        cars.stream().filter(c -> c.isAutomaticGear&&
                        c.manufacturer.brand().matches(brandName) &&
                        c.dimensions.stream().anyMatch(t -> t.trunkCapacity() > minTrunkCapacity))
                .map(m -> m.market.countries().stream().map(country -> country.countryName() + "-" + country.countrySign()).toList()).forEach(System.out::println);
    }
}