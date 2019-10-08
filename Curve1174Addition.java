
import java.math.BigInteger;
import java.security.spec.ECPoint;

public class Curve1174Addition{
    public static final BigInteger dConstant = new BigInteger("-1174");
    public static final BigInteger pConstant = new BigInteger("3618502788666131106986593281521497120414687020801267626233049500247285301239");
    public static ECPoint operate(ECPoint point1,ECPoint point2){
        ECPoint resultPoint;
        
        BigInteger resultX = (((point1.getAffineX().multiply(point2.getAffineY())).add(point2.getAffineX().multiply(point1.getAffineY()))).multiply(((new BigInteger("1")).add((dConstant).multiply(point1.getAffineX().multiply(point2.getAffineX().multiply(point1.getAffineY().multiply(point2.getAffineY())))))).modInverse(pConstant))).mod(pConstant);
        BigInteger resultY = (((point1.getAffineY().multiply(point2.getAffineY())).subtract(point2.getAffineX().multiply(point1.getAffineX()))).multiply(((new BigInteger("1")).subtract((dConstant).multiply(point1.getAffineX().multiply(point2.getAffineX().multiply(point1.getAffineY().multiply(point2.getAffineY())))))).modInverse(pConstant))).mod(pConstant);

        resultPoint = new ECPoint(resultX, resultY);
        return resultPoint;
    }
}