package lazybrary.unit.units;

import lazybrary.unit.exception.UnitConverterException;

public enum Temperature {

    CELSIUS("celsius", "c", 1),
    FAHRENHEIT("fahrenheit", "f", (CELSIUS.value * 1.8) + 32),
    KELVIN("kelvin", "k", CELSIUS.value + 273.15);

    private final String lowerCase;

    private final String symbol;

    private final double value;

    Temperature(String lowerCase, String symbol, double value) {
        this.lowerCase = lowerCase;
        this.symbol = symbol;
        this.value = value;
    }

    public static Temperature of(String unit){
        // try to find by Unit name or Symbol
        for (Temperature l : values()){
            if (l.lowerCase.equalsIgnoreCase(unit) || l.symbol.equalsIgnoreCase(unit)){
                return l;
            }
        }

        throw new UnitConverterException("Unsupported temperature unit of: " + unit);
    }

    // TODO modify
    public double convertTo(Temperature toUnit, double value) {
        return -1;
    }
}
