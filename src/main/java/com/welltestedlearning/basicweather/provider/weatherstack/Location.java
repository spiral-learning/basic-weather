package com.welltestedlearning.basicweather.provider.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

    private String country;
    private String lat;
    private String localtime;
    @JsonProperty("localtime_epoch")
    private long localtimeEpoch;
    private String lon;
    private String name;
    private String region;
    @JsonProperty("timezone_id")
    private String timezoneId;
    @JsonProperty("utc_offset")
    private String utcOffset;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public long getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    public void setLocaltimeEpoch(long localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }
}
