package com.example.basics.cryptoticker.model.data;

public class Crypto {

    private Data data;

    public class Data{

        private Cryptocurrency cryptocurrency;

        public Cryptocurrency getCryptocurrency() { return cryptocurrency; }
    }

    public class Cryptocurrency {

        private double low;
        private double high;
        private double ask;
        private double bid;
        private double last;

        public double getLow() { return low; }

        public double getHigh() { return high; }

        public double getAsk() { return ask; }

        public double getBid() { return bid; }

        public double getLast() { return last; }


    }

}
