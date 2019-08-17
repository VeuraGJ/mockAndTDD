package parking;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class InOrderParkingStrategyTest {
    private final static String PARKING_NAME_A = "AAA";
    private final static String CAR_NAME_A = "AAA";

	@Test
    public void testCreateReceipt_givenACarAndAParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 1, Write a test case on InOrderParkingStrategy.createReceipt()
	    * With using Mockito to mock the input parameter */
	    InOrderParkingStrategy inOrderParkingStrategy = new InOrderParkingStrategy();
	    ParkingLot  parkingLot = mock(ParkingLot.class);
	    when(parkingLot.getName()).thenReturn(PARKING_NAME_A);
	    Car car = mock(Car.class);
	    when(car.getName()).thenReturn(CAR_NAME_A);

	    Receipt receipt = inOrderParkingStrategy.createReceipt(parkingLot,car);
	    verify(car,times(1)).getName();

    }

    @Test
    public void testCreateNoSpaceReceipt_givenACar_thenGiveANoSpaceReceipt() {

        /* Exercise 1, Write a test case on InOrderParkingStrategy.createNoSpaceReceipt()
         * With using Mockito to mock the input parameter */

    }

    @Test
    public void testPark_givenNoAvailableParkingLot_thenCreateNoSpaceReceipt(){

	    /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for no available parking lot */


    }

    @Test
    public void testPark_givenThereIsOneParkingLotWithSpace_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot */

    }

    @Test
    public void testPark_givenThereIsOneFullParkingLot_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot but it is full */

    }

    @Test
    public void testPark_givenThereIsMultipleParkingLotAndFirstOneIsFull_thenCreateReceiptWithUnfullParkingLot(){

        /* Exercise 3: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for multiple parking lot situation */


    }


}
