<h1>First implementation of addition and scalar multiplication of Curve1174 in java</h1>
<br><br>
![#](https://www.johndcook.com/curve1174_plot.svg)<br><br>
<h2>What is ECPoint ?</h2>
2 Dimensional point which has x and y deepness not z<br>
You can create it like ->
ECPoint point = new ECPoint(x,y);<br>
Keep in mind x and y is in BigInteger such as BigInteger x = new BigInteger("114521154");
<h2>#Addition</h2>
ECPoint resultPoint = Curve1174Addition.operate(ECPoint point1,ECPoint point2);<br>
<h2>#Doubling</h2>
ECPoint resultPoint = Curve1174Addition.operate(ECPoint point,ECPoint point);
<h2>#Scalar Multiplication</h2>
ECPoint resultPoint = Curve1174Multiplication.operate( ECPoint generatorPoint , BigInteger someBigInteger );<br>
Takes 2 parameters.First parameter is generator point you can pass it null if you want to use generator point of eliptic curve 1174 . You can use this if you want to find public key from private key such as -> Curve1174Multiplication.operate( null , new BigInteger("25") );<br>
If you want to multiply something with point that you want to use on eliptic curve you can do something like below<br>
ECPoint resultPoint = Curve1174Multiplication.operate( ECPoint myECPoint , new BigInteger("106"));
