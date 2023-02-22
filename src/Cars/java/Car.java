import java.util.List;

public record Car(Manufacturer manufacturer, boolean isAutomaticGear, Market market, String segment,
                  List<Dimension> dimensions) {

    public static void getFilteredMarketsOfCars(List<Car> cars, String brandName, int minTrunkCapacity, boolean automatedGear) {
        List <Car> filteredCars = cars.stream().filter(c -> c.isAutomaticGear == automatedGear &&
                        c.manufacturer.brand().matches(brandName) &&
                        c.dimensions.stream().anyMatch(t -> t.trunkCapacity() > minTrunkCapacity)).toList();

        if (filteredCars.size() != 0){
            filteredCars.stream().map(m -> m.market.countries().stream().map(country -> country.countryName() + "-" + country.countrySign()).toList()).forEach(System.out::println);
        } else System.out.println("There are no objects that meet conditions.");
    }
}