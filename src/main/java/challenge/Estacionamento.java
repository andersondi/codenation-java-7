package challenge;

import java.util.HashMap;

public class Estacionamento {
    final int numberOtNumberOfParkingSpots = 10;
    HashMap< String, Carro > listOfParkedCars = new HashMap<>(  );

    public Estacionamento() {
    }

    private int getNumberOfParkingSpots() {
        return numberOtNumberOfParkingSpots;
    }

    private HashMap< String, Carro > getListOfParkedCars() {
        return listOfParkedCars;
    }

    private void setListOfParkedCars( HashMap< String, Carro > listOfParkedCars ) {
        this.listOfParkedCars = listOfParkedCars;
    }

    public void estacionar( Carro carro ) throws EstacionamentoException {
        if ( getListOfParkedCars().size() < getNumberOfParkingSpots() ) {
            getListOfParkedCars().put( carro.getPlaca(), carro );
        }/*else{
            throw new EstacionamentoException( "The limit of parking spots was exceeded" );
        }*/
    }

    public int carrosEstacionados() {
        return getListOfParkedCars().size();
    }

    public boolean carroEstacionado( Carro carro ) {
        if ( getListOfParkedCars().containsKey( carro.getPlaca() ) == true ){
            return true;
        }else{
            return false;
        }
    }
}
