
import java.math.BigInteger;
import java.security.spec.ECPoint;

public class Curve1174Multiplication {
    public static final ECPoint curveGeneratorPoint = new ECPoint(new BigInteger("1582619097725911541954547006453739763381091388846394833492296309729998839514"), new BigInteger("3037538013604154504764115728651437646519513534305223422754827055689195992590"));
    public static ECPoint operate(ECPoint generatorPoint,BigInteger getPrivateKey){
        generatorPoint = (generatorPoint==null) ? curveGeneratorPoint : generatorPoint;
        ECPoint resultPoint = new ECPoint(new BigInteger("0"), new BigInteger("1"));
        BigInteger trackingValue = new BigInteger("0");
        for( ; getPrivateKey.subtract(trackingValue).compareTo(new BigInteger("32768")) >= 0 ; ){
            BigInteger keepingValue = new BigInteger("1");int counter;
            for(counter = 0; getPrivateKey.subtract(trackingValue).compareTo(keepingValue) > 0 ; counter+=1){
                keepingValue = keepingValue.multiply(new BigInteger("2"));
            }
            keepingValue = keepingValue.divide(new BigInteger("2"));counter-=1;
            ECPoint doublingValue = generatorPoint;
            for(short telltale=0;telltale<counter;telltale+=1){
                doublingValue = Curve1174Addition.operate(doublingValue, doublingValue);
            }
            resultPoint = Curve1174Addition.operate(resultPoint, doublingValue);
            trackingValue = trackingValue.add(keepingValue);
        }
        int leftOver = Integer.valueOf(getPrivateKey.subtract(trackingValue).toString());
        for(int telltale=0;telltale<leftOver;telltale+=1){
            resultPoint = Curve1174Addition.operate(resultPoint, generatorPoint);
        }
        return resultPoint;
    }
}
