package com.example.basics.cryptoticker.data.model;

public class Cryptocurrency {

    private Double ask;
    private Double bid;
    private Double last;
    private Double high;
    private Double low;
    private Open open;
    private Averages averages;
    private Double volume;
    private Changes changes;
    private Double volumePercent;
    private Integer timestamp;
    private String displayTimestamp;
    private Boolean success;
    private String time;

    public Double getAsk() { return ask; }
    public void setAsk(Double ask) { this.ask = ask; }
    public Double getBid() { return bid; }
    public void setBid(Double bid) { this.bid = bid; }
    public Double getLast() { return last; }
    public void setLast(Double last) { this.last = last; }
    public Double getHigh() { return high; }
    public void setHigh(Double high) { this.high = high; }
    public Double getLow() {return  low;}
    public void setLow(Double low) { this.low = low; }
    public Open getOpen() { return open; }
    public void setOpen(Open open) { this.open = open; }
    public Averages getAverages() { return averages; }
    public void setAverages(Averages averages) { this.averages = averages; }
    public Double getVolume() { return volume; }
    public void setVolume(Double volume) { this.volume = volume; }
    public Changes getChanges() { return changes; }
    public void setChanges(Changes changes) { this.changes = changes; }
    public Double getVolumePercent() { return volumePercent; }
    public void setVolumePercent(Double volumePercent) { this.volumePercent = volumePercent; }
    public Integer getTimestamp() { return timestamp; }
    public void setTimestamp(Integer timestamp) { this.timestamp = timestamp; }
    public String getDisplayTimestamp() { return displayTimestamp; }
    public void setDisplayTimestamp(String displayTimestamp) { this.displayTimestamp = displayTimestamp; }
    public Boolean getSuccess() { return success; }
    public void setSuccess(Boolean success) { this.success = success; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public class Averages {

        private Double day;
        private Double week;
        private Double month;
        public Double getDay() { return day; }
        public void setDay(Double day) { this.day = day; }
        public Double getWeek() { return week; }
        public void setWeek(Double week) { this.week = week; }
        public Double getMonth() { return month; }
        public void setMonth(Double month) { this.month = month; }
    }
    public class Changes {

        private Percent percent;
        private Price price;

        public Percent getPercent() { return percent; }
        public void setPercent(Percent percent) { this.percent = percent; }
        public Price getPrice() { return price; }
        public void setPrice(Price price) { this.price = price; }

        public class Percent {

            private Double hour;
            private Double day;
            private Double week;
            private Double month;
            private Double month3;
            private Double month6;
            private Double year;

            public Double getHour() { return hour; }
            public void setHour(Double hour) { this.hour = hour; }
            public Double getDay() { return day; }
            public void setDay(Double day) { this.day = day; }
            public Double getWeek() { return week; }
            public void setWeek(Double week) { this.week = week; }
            public Double getMonth() { return month; }
            public void setMonth(Double month) { this.month = month; }
            public Double getMonth3() { return month3; }
            public void setMonth3(Double month3) { this.month3 = month3; }
            public Double getMonth6() { return month6; }
            public void setMonth6(Double month6) { this.month6 = month6; }
            public Double getYear() { return year; }
            public void setYear(Double year) { this.year = year; }

        }

        public class Price {

            private Double hour;
            private Double day;
            private Double week;
            private Double month;
            private Double month3;
            private Double month6;
            private Double year;

            public Double getHour() { return hour; }
            public void setHour(Double hour) { this.hour = hour; }
            public Double getDay() { return day; }
            public void setDay(Double day) { this.day = day; }
            public Double getWeek() { return week; }
            public void setWeek(Double week) { this.week = week; }
            public Double getMonth() { return month; }
            public void setMonth(Double month) { this.month = month; }
            public Double getMonth3() { return month3; }
            public void setMonth3(Double month3) { this.month3 = month3; }
            public Double getMonth6() { return month6; }
            public void setMonth6(Double month6) { this.month6 = month6; }
            public Double getYear() { return year; }
            public void setYear(Double year) { this.year = year; }
        }

    }
    public class Open {

        private Double hour;
        private Double day;
        private Double week;
        private Double month;
        private Double month3;
        private Double month6;
        private Double year;

        public Double getHour() { return hour; }
        public void setHour(Double hour) { this.hour = hour; }
        public Double getDay() { return day; }
        public void setDay(Double day) { this.day = day; }
        public Double getWeek() { return week; }
        public void setWeek(Double week) { this.week = week; }
        public Double getMonth() { return month; }
        public void setMonth(Double month) { this.month = month; }
        public Double getMonth3() { return month3; }
        public void setMonth3(Double month3) { this.month3 = month3; }
        public Double getMonth6() { return month6; }
        public void setMonth6(Double month6) { this.month6 = month6; }
        public Double getYear() { return year; }
        public void setYear(Double year) { this.year = year; }
    }

}


