package fyp.stockscreener;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-27T00:27:53")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, BigInteger> stockBGF;
    public static volatile SingularAttribute<Stock, String> stockSymbol;
    public static volatile SingularAttribute<Stock, String> stockName;
    public static volatile SingularAttribute<Stock, Float> stockLow;
    public static volatile SingularAttribute<Stock, Float> stockHigh;
    public static volatile SingularAttribute<Stock, BigInteger> stockDCF;
    public static volatile SingularAttribute<Stock, Float> stockPrev;
    public static volatile SingularAttribute<Stock, Float> stockGrowth;
    public static volatile SingularAttribute<Stock, Float> stockLast;
    public static volatile SingularAttribute<Stock, String> stockCode;
    public static volatile SingularAttribute<Stock, BigInteger> stockDEM;
    public static volatile SingularAttribute<Stock, BigInteger> stockGGM;

}