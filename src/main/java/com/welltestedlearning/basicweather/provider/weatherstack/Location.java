
package com.welltestedlearning.basicweather.provider.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@SuppressWarnings("unused")
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

}
