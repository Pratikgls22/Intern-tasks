package KeyWord;

class City{
    String CityName;
    final int PinCode = 382415;

    void ChangePinCode(){
       // PinCode = 382418;
        System.out.println("don't change pincode");
    }
}
public class FinalKey {
    public static void main(String[] args) {
        City c = new City();
        c.ChangePinCode();
    }
}
