package com.rpgobjects.nhlstatsbinding.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NHLDataTypes {

    static public class PlayerSummary {

        @SerializedName("assists")
        @Expose
        public Integer assists;
        @SerializedName("gamesPlayed")
        @Expose
        public Integer gamesPlayed;
        @SerializedName("gamesStarted")
        @Expose
        public Integer gamesStarted;
        @SerializedName("goals")
        @Expose
        public Integer goals;
        @SerializedName("goalsAgainst")
        @Expose
        public Integer goalsAgainst;
        @SerializedName("goalsAgainstAverage")
        @Expose
        public Double goalsAgainstAverage;
        @SerializedName("losses")
        @Expose
        public Integer losses;
        @SerializedName("otLosses")
        @Expose
        public Integer otLosses;
        @SerializedName("penaltyMinutes")
        @Expose
        public Integer penaltyMinutes;
        @SerializedName("playerFirstName")
        @Expose
        public String playerFirstName;
        @SerializedName("playerId")
        @Expose
        public Integer playerId;
        @SerializedName("playerLastName")
        @Expose
        public String playerLastName;
        @SerializedName("playerName")
        @Expose
        public String playerName;
        @SerializedName("playerPositionCode")
        @Expose
        public String playerPositionCode;
        @SerializedName("playerTeamsPlayedFor")
        @Expose
        public String playerTeamsPlayedFor;
        @SerializedName("points")
        @Expose
        public Integer points;
        @SerializedName("savePctg")
        @Expose
        public Double savePctg;
        @SerializedName("saves")
        @Expose
        public Integer saves;
        @SerializedName("seasonId")
        @Expose
        public Integer seasonId;
        @SerializedName("shotsAgainst")
        @Expose
        public Integer shotsAgainst;
        @SerializedName("shutouts")
        @Expose
        public Integer shutouts;
        @SerializedName("ties")
        @Expose
        public Integer ties;
        @SerializedName("timeOnIce")
        @Expose
        public Integer timeOnIce;
        @SerializedName("wins")
        @Expose
        public Integer wins;
    }

    public static class StatsSearchResult {
        @SerializedName("data")
        @Expose
        public List<PlayerSummary> playerList;

        @SerializedName("total")
        @Expose
        public Integer total;

        public String toJson() {
            return new Gson().toJson(this);
        }

        static public StatsSearchResult fromJson(String json) {
            return new Gson().fromJson(json,StatsSearchResult.class);
        }
    }


    public class Conference {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("link")
        @Expose
        public String link;

    }

    public class CurrentTeam {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("link")
        @Expose
        public String link;

    }

    public class Division {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("link")
        @Expose
        public String link;

    }

    public class Franchise {

        @SerializedName("franchiseId")
        @Expose
        public Integer franchiseId;
        @SerializedName("teamName")
        @Expose
        public String teamName;
        @SerializedName("link")
        @Expose
        public String link;

    }

    public class League {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("link")
        @Expose
        public String link;
        @SerializedName("id")
        @Expose
        public Integer id;

    }

    public class Player {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("fullName")
        @Expose
        public String fullName;
        @SerializedName("link")
        @Expose
        public String link;
        @SerializedName("firstName")
        @Expose
        public String firstName;
        @SerializedName("lastName")
        @Expose
        public String lastName;
        @SerializedName("primaryNumber")
        @Expose
        public String primaryNumber;
        @SerializedName("birthDate")
        @Expose
        public String birthDate;
        @SerializedName("currentAge")
        @Expose
        public Integer currentAge;
        @SerializedName("birthCity")
        @Expose
        public String birthCity;
        @SerializedName("birthStateProvince")
        @Expose
        public String birthStateProvince;
        @SerializedName("birthCountry")
        @Expose
        public String birthCountry;
        @SerializedName("nationality")
        @Expose
        public String nationality;
        @SerializedName("height")
        @Expose
        public String height;
        @SerializedName("weight")
        @Expose
        public Integer weight;
        @SerializedName("active")
        @Expose
        public Boolean active;
        @SerializedName("alternateCaptain")
        @Expose
        public Boolean alternateCaptain;
        @SerializedName("captain")
        @Expose
        public Boolean captain;
        @SerializedName("rookie")
        @Expose
        public Boolean rookie;
        @SerializedName("shootsCatches")
        @Expose
        public String shootsCatches;
        @SerializedName("rosterStatus")
        @Expose
        public String rosterStatus;
        @SerializedName("currentTeam")
        @Expose
        public CurrentTeam currentTeam;
        @SerializedName("primaryPosition")
        @Expose
        public PrimaryPosition primaryPosition;
        @SerializedName("stats")
        @Expose
        public List<Stat> stats = null;

    }

    public class PlayerResult {

        @SerializedName("copyright")
        @Expose
        public String copyright;
        @SerializedName("people")
        @Expose
        public List<Player> players = null;

        public Player getPlayer() {
            return  players.get(0);
        }
    }

    public class PrimaryPosition {

        @SerializedName("code")
        @Expose
        public String code;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("abbreviation")
        @Expose
        public String abbreviation;

    }

    public class Split {

        @SerializedName("season")
        @Expose
        public String season;
        @SerializedName("stat")
        @Expose
        public Stat_ stat;
        @SerializedName("team")
        @Expose
        public Team team;
        @SerializedName("league")
        @Expose
        public League league;
        @SerializedName("sequenceNumber")
        @Expose
        public Integer sequenceNumber;

    }

    public class Stat {

        @SerializedName("type")
        @Expose
        public Type type;
        @SerializedName("splits")
        @Expose
        public List<Split> splits = null;

    }

    public class Stat_ {

        @SerializedName("timeOnIce")
        @Expose
        public String timeOnIce;
        @SerializedName("shutouts")
        @Expose
        public Integer shutouts;
        @SerializedName("goalAgainstAverage")
        @Expose
        public Double goalAgainstAverage;
        @SerializedName("games")
        @Expose
        public Integer games;
        @SerializedName("goalsAgainst")
        @Expose
        public Integer goalsAgainst;
        @SerializedName("ties")
        @Expose
        public Integer ties;
        @SerializedName("wins")
        @Expose
        public Integer wins;
        @SerializedName("losses")
        @Expose
        public Integer losses;
        @SerializedName("saves")
        @Expose
        public Integer saves;
        @SerializedName("savePercentage")
        @Expose
        public Double savePercentage;
        @SerializedName("shotsAgainst")
        @Expose
        public Integer shotsAgainst;
        @SerializedName("ot")
        @Expose
        public Integer ot;
        @SerializedName("powerPlaySaves")
        @Expose
        public Integer powerPlaySaves;
        @SerializedName("shortHandedSaves")
        @Expose
        public Integer shortHandedSaves;
        @SerializedName("evenSaves")
        @Expose
        public Integer evenSaves;
        @SerializedName("shortHandedShots")
        @Expose
        public Integer shortHandedShots;
        @SerializedName("evenShots")
        @Expose
        public Integer evenShots;
        @SerializedName("powerPlayShots")
        @Expose
        public Integer powerPlayShots;
        @SerializedName("gamesStarted")
        @Expose
        public Integer gamesStarted;
        @SerializedName("powerPlaySavePercentage")
        @Expose
        public Double powerPlaySavePercentage;
        @SerializedName("shortHandedSavePercentage")
        @Expose
        public Double shortHandedSavePercentage;
        @SerializedName("evenStrengthSavePercentage")
        @Expose
        public Double evenStrengthSavePercentage;
        @SerializedName("timeOnIcePerGame")
        @Expose
        public String timeOnIcePerGame;

    }

    public class Team {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("link")
        @Expose
        public String link;
        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("venue")
        @Expose
        public Venue venue;
        @SerializedName("abbreviation")
        @Expose
        public String abbreviation;
        @SerializedName("teamName")
        @Expose
        public String teamName;
        @SerializedName("locationName")
        @Expose
        public String locationName;
        @SerializedName("firstYearOfPlay")
        @Expose
        public String firstYearOfPlay;
        @SerializedName("division")
        @Expose
        public Division division;
        @SerializedName("conference")
        @Expose
        public Conference conference;
        @SerializedName("franchise")
        @Expose
        public Franchise franchise;
        @SerializedName("shortName")
        @Expose
        public String shortName;
        @SerializedName("officialSiteUrl")
        @Expose
        public String officialSiteUrl;
        @SerializedName("franchiseId")
        @Expose
        public Integer franchiseId;
        @SerializedName("active")
        @Expose
        public Boolean active;

    }

    public class TimeZone {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("offset")
        @Expose
        public Integer offset;
        @SerializedName("tz")
        @Expose
        public String tz;

    }

    public class Type {

        @SerializedName("displayName")
        @Expose
        public String displayName;

    }

    public class Venue {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("link")
        @Expose
        public String link;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("timeZone")
        @Expose
        public TimeZone timeZone;

    }

}
