package challenge;

import java.util.LinkedHashSet;

public class Estacionamento {
    final int numberOtNumberOfParkingSpots = 10;
    final int seniorDriverAge = 55;
    final int legalAge = 18;

    LinkedHashSet< Carro > listOfParkedCars = new LinkedHashSet<>();

    public Estacionamento() {
    }

    private int getNumberOfParkingSpots() {
        return numberOtNumberOfParkingSpots;
    }

    private LinkedHashSet< Carro > getListOfParkedCars() {
        return listOfParkedCars;
    }

    private void setListOfParkedCars( LinkedHashSet< Carro > listOfParkedCars ) {
        this.listOfParkedCars = listOfParkedCars;
    }

    public void estacionar( Carro carro ) throws EstacionamentoException {
        boolean isOfLegalAge = carro.getMotorista().getIdade() > legalAge;

        if ( isOfLegalAge ) {
            boolean hasEmptySlot = getListOfParkedCars().size() < getNumberOfParkingSpots();

            if ( hasEmptySlot ) {
                getListOfParkedCars().add( carro );
            } else {
                boolean isNotParked = true;

                for ( Carro listedCar : getListOfParkedCars() ) {
                    boolean isSenior = listedCar.getMotorista().getIdade() >= seniorDriverAge;

                    if ( !isSenior ) {
                        getListOfParkedCars().remove( listedCar );
                        getListOfParkedCars().add( carro );
                        isNotParked = false;
                        break;
                    }
                }
                if ( isNotParked ) throw new EstacionamentoException( "The parking site has no available spots" );
            }
        } else {
            throw new EstacionamentoException( "The driver is a minor" );
        }
    }

    public int carrosEstacionados() {
        return getListOfParkedCars().size();
    }

    public boolean carroEstacionado( Carro carro ) {
        System.out.println(getListOfParkedCars());
        boolean isParked = getListOfParkedCars().contains( carro );

        if ( isParked ) {
            return true;
        } else {
            return false;
        }
    }
}
