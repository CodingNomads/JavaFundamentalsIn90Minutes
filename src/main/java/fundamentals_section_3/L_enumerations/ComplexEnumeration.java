package main.java.fundamentals_section_3.L_enumerations;

/**
 * Created by ryandesmond - https://codingnomads.co
 */

/*
Example Usage (in some other file):

    ComplexEnumeration recentSpreadDataEnum = ComplexEnumeration.GETRECENTSPREADDATA;


 */

public enum ComplexEnumeration {

    GETSERVERTIME("/0/public/Time", "GET", 0),
    GETASSETINFO("/0/public/Assets", "GET", 0),
    GETTRADABLEASSETPAIRS("/0/public/AssetPairs", "GET", 0),
    GETTICKERINFORMATION("/0/public/Ticker", "GET", 0),
    GETOHLCDATA("/0/public/OHLC", "GET", 0),
    GETORDERBOOK("/0/public/Depth", "GET", 0),
    GETRECENTTRADES("/0/public/Trades", "GET", 0),
    GETRECENTSPREADDATA("/0/public/Spread","GET", 0),
    GETACCOUNTBALANCE("/0/private/Balance", "POST", 1),
    GETTRADEBALANCE("/0/private/TradeBalance", "POST", 1);

    private String endPoint;
    private String requestType;
    private final int callAmount;
    private String fullURL;
    private final String domain = "https://api.kraken.com";

    public String getEndPoint() {
        return endPoint;
    }

    public String getDomain() {
        return domain;
    }

    public String getFullURL() {
        return fullURL;
    }

    public void updateEndpoint(String queryParams){
        this.endPoint = this.endPoint + queryParams;
        this.fullURL = this.fullURL + queryParams;
    }

    ComplexEnumeration(String endPoint, String requestType, int callAmount) {
        this.endPoint = endPoint;
        this.requestType = requestType;
        this.callAmount = callAmount;
        this.fullURL = domain + endPoint;
    }

    ComplexEnumeration(String endPoint, String requestType, int callAmount, String pair) {
        this.endPoint = endPoint + pair;
        this.callAmount = callAmount;
        this.fullURL = domain + endPoint + pair;
    }

    public int getCallAmount() {
        return callAmount;
    }

}

